package org.codezilla.jobservice.models.order;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.codezilla.jobservice.models.Proposals;
import org.codezilla.jobservice.models.User;
import org.codezilla.jobservice.models.category.FirstCategory;
import org.codezilla.jobservice.models.category.SecondCategory;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity(name = "job")
@Data
@NoArgsConstructor
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(length = 2500)
    private String description;
    private Double price;
    private LocalDateTime dateTime;


    @ManyToOne(fetch = FetchType.EAGER)
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    private FirstCategory firstCategory;

    @ManyToOne(fetch = FetchType.EAGER)
    private SecondCategory secondCategory;

    @OneToMany(mappedBy = "job", cascade = CascadeType.ALL)
    private List<Proposals> jobProposalsList;
}
