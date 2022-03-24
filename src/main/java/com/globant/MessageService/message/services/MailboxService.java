package com.globant.MessageService.message.services;

import com.globant.MessageService.auth.repositories.UserRepository;
import com.globant.MessageService.message.entities.Label;
import com.globant.MessageService.message.entities.Message;
import com.globant.MessageService.message.repositories.LabelRepository;
import com.globant.MessageService.message.repositories.MessageRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class MailboxService {


    private final MessageRepository messageRepository;
    private final UserRepository userRepository;
    private final LabelRepository labelRepository;

    public Message getMessageById(long messageId) {
        return messageRepository.getMessageById(messageId);
    }

    private String getUsernameSession() {
        String username;
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        username = userDetails.getUsername();
        return username;
    }

    public List<Message> getReceivedMessages() {

        String username = this.getUsernameSession();

        if (userRepository.existsByUsername(username)) {
            List<Message> primaryReceptorMessages = messageRepository.getMessagesByPrimaryReceptor(username);
            List<Message> carbonCopyMessages = messageRepository.getMessagesByCarbonCopy(username);
            List<Message> blindCarbonCopy = messageRepository.getMessagesByBlindCarbonCopy(username);
            List<Message> messageList = new ArrayList<>();
            messageList.addAll(primaryReceptorMessages);
            messageList.addAll(carbonCopyMessages);
            messageList.addAll(blindCarbonCopy);
            return messageList;
        }

        throw new RuntimeException("User doesn't exist");
    }

    public List<Message> getSentMessages() {

        String username = this.getUsernameSession();
        if (userRepository.existsByUsername(username)) {
            return messageRepository.getMessagesBySender(username);
        }
        throw new RuntimeException("User doesn't exist");
    }

    public void sendMessage(Message message) {
        if (!userRepository.existsByUsername(message.getPrimaryReceptor())) {
            throw new IllegalStateException("Username in Primary Receptor doesn't exist");
        }
        if (message.getCarbonCopy() != null) {
            if (!userRepository.existsByUsername(message.getCarbonCopy())) {
                throw new IllegalStateException("Username in Carbon Copy doesn't exist");
            }
        }
        if (message.getBlindCarbonCopy() != null) {
            if (!userRepository.existsByUsername(message.getBlindCarbonCopy())) {
                throw new IllegalStateException("Username in Blind Carbon Copy doesn't exist");
            }
        }
        String username = this.getUsernameSession();
        if (userRepository.existsByUsername(username)) {
            message.setSender(username);
            messageRepository.save(message);
        } else {
            throw new RuntimeException("User doesn't exist");
        }
    }

    public void createLabel(Label label) {
        System.out.println(5);
        String username = this.getUsernameSession();
        if (userRepository.existsByUsername(username)) {
            label.setCreatedBy(username);
            labelRepository.save(label);
        }
    }

    public void addLabel(Long message, String label) {

        Message msg = messageRepository.getMessageById(message);
        System.out.println(msg);
        if (labelRepository.findByName(label) != null) {
            msg.getLabels().add(labelRepository.findByName(label));
        } else {
            Label l = new Label(label);
            this.createLabel(l);
            msg.getLabels().add(l);
        }
        messageRepository.save(msg);
    }

    public List<Label> getLabels() {
        String username = this.getUsernameSession();
        return labelRepository.getLabelsByCreatedBy(username);
    }

    public List<Message> getMessagesByLabels(String label) {
        Label l = labelRepository.findByName(label);
        return messageRepository.getMessagesByLabels(l);
    }


}
