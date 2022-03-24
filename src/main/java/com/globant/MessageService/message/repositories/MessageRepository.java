package com.globant.MessageService.message.repositories;

import com.globant.MessageService.message.entities.Label;
import com.globant.MessageService.message.entities.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {

    List<Message> getMessagesBySender(String sender);

    Message getMessageById(Long id);

    List<Message> getMessagesByPrimaryReceptor(String primaryReceptor);

    List<Message> getMessagesByCarbonCopy(String carbonCopy);

    List<Message> getMessagesByBlindCarbonCopy(String blindCarbonCopy);

    List<Message> getMessagesByLabels(Label label);

}
