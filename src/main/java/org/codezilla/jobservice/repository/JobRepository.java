package org.codezilla.jobservice.repository;

import org.codezilla.jobservice.models.order.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepository extends JpaRepository<Job, Long> {
}
