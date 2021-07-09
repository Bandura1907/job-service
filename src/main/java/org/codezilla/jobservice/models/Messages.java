package org.codezilla.jobservice.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "messages")
@Data
@NoArgsConstructor
public class Messages {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String text;
    private LocalDateTime dateTime;

    @ManyToOne(fetch = FetchType.EAGER)
    private User senderUser;

    @ManyToOne(fetch = FetchType.EAGER)
    private User receiverUser;
}
