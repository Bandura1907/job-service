package org.codezilla.jobservice.models.category;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.codezilla.jobservice.models.User;
import org.codezilla.jobservice.models.order.Job;
import org.codezilla.jobservice.models.order.Service;

import javax.persistence.*;
import java.util.List;

@Entity(name = "secondCategory")
@Data
@NoArgsConstructor
public class SecondCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String secondName;

    @ManyToOne(fetch = FetchType.EAGER)
    private FirstCategory firstCategory;


    @OneToMany(mappedBy = "secondCategory", cascade = CascadeType.ALL)
    private List<Service> serviceList;

    @OneToMany(mappedBy = "secondCategory", cascade = CascadeType.ALL)
    private List<Job> jobList;
}
