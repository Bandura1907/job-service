package org.codezilla.jobservice.repository;

import org.codezilla.jobservice.models.category.SecondCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SecondCategoryRepository extends JpaRepository<SecondCategory, Long> {
}
