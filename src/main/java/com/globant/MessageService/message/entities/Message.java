package com.globant.MessageService.message.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Message {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String subject;
    private String body;
    private String attachment;
    @Column(nullable = false)
    private String sender;
    @Column(nullable = false)
    private String primaryReceptor;
    private String carbonCopy;
    private String blindCarbonCopy;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "message_label",
            joinColumns = @JoinColumn(name = "message_id"),
            inverseJoinColumns = @JoinColumn(name = "label_id"))
    private Set<Label> labels = new HashSet<>();

}
