package com.globant.MessageService.message.repositories;

import com.globant.MessageService.message.entities.Label;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface LabelRepository extends JpaRepository<Label, Long> {

    List<Label> getLabelsByCreatedBy(String createdBy);

    Label findByName(String name);
}
