package org.codezilla.jobservice.repository;

import org.codezilla.jobservice.models.category.FirstCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FirstCategoryRepository extends JpaRepository<FirstCategory, Long> {
}
