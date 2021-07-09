package org.codezilla.jobservice.models.order;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.codezilla.jobservice.models.User;
import org.codezilla.jobservice.models.category.FirstCategory;
import org.codezilla.jobservice.models.category.SecondCategory;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "service")
@Data
@NoArgsConstructor
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private Double price;
    private LocalDateTime dateTime;

    private String photosUrl;

    @ManyToOne(fetch = FetchType.EAGER)
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    private FirstCategory firstCategory;

    @ManyToOne(fetch = FetchType.EAGER)
    private SecondCategory secondCategory;

}
