package org.codezilla.jobservice.repository;

import org.codezilla.jobservice.models.Proposals;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProposalsRepository extends JpaRepository<Proposals, Long> {
}
