package org.codezilla.jobservice.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.codezilla.jobservice.models.order.Job;
import org.codezilla.jobservice.models.order.Service;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity(name = "proposals")
@Data
@NoArgsConstructor
public class Proposals {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String text;

    private LocalDateTime sendDateTime;

    @ManyToOne(fetch = FetchType.EAGER)
    private User senderUser;

    @ManyToOne(fetch = FetchType.EAGER)
    private Job job;
}
