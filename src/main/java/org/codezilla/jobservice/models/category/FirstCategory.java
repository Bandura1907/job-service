package org.codezilla.jobservice.models.category;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.codezilla.jobservice.models.order.Job;
import org.codezilla.jobservice.models.order.Service;

import javax.persistence.*;
import java.util.List;

@Entity(name = "firstCategory")
@Data
@NoArgsConstructor
public class FirstCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    @OneToMany(mappedBy = "firstCategory", cascade = CascadeType.ALL)
    private List<SecondCategory> secondCategoryList;

    @OneToMany(mappedBy = "firstCategory", cascade = CascadeType.ALL)
    private List<Service> serviceList;

    @OneToMany(mappedBy = "firstCategory", cascade = CascadeType.ALL)
    private List<Job> jobList;
}
