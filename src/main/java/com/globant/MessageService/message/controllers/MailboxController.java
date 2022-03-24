package com.globant.MessageService.message.controllers;

import com.globant.MessageService.message.entities.Label;
import com.globant.MessageService.message.entities.Message;
import com.globant.MessageService.message.services.MailboxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/mailbox")
public class MailboxController {

    @Autowired
    MailboxService mailboxService;

    @PostMapping(path = "/newMessage")
    public String newMessage(@RequestBody Message message) {
        mailboxService.sendMessage(message);
        return "Your Message was sent successfully";
    }

    @GetMapping(path = "/receivedMessages")
    public List<Message> receivedMessages() {

        return mailboxService.getReceivedMessages();
    }

    @GetMapping(path = "/sentMessages")
    public List<Message> sentMessages() {

        return mailboxService.getSentMessages();
    }

    @PostMapping(path = "/createLabel")
    public String newMessage(@RequestBody Label label) {
        mailboxService.createLabel(label);
        return "Your Label was created successfully";
    }

    @GetMapping(path = "/getLabels")
    public List<Label> getLabels() {

        return mailboxService.getLabels();
    }

    @GetMapping(path = "/receivedMessages/{id}/addLabel/{label}")
    public void addLabel(@PathVariable("id") Long message, @PathVariable("label") String label) {
        mailboxService.addLabel(message, label);
    }

    @GetMapping(path = "/receivedMessages/labelFilter/{label}")
    public List<Message> getMessagesByLabels(@PathVariable("label") String label) {

        return mailboxService.getMessagesByLabels(label);
    }

}
