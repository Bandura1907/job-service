package org.codezilla.jobservice.services;

import org.codezilla.jobservice.models.category.FirstCategory;
import org.codezilla.jobservice.repository.FirstCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FirstCategoryService {

    @Autowired
    private FirstCategoryRepository firstCategoryRepository;

    public List<FirstCategory> findAll() {
        return firstCategoryRepository.findAll();
    }

    public FirstCategory findById(Long id) {
        return firstCategoryRepository.findById(id).get();
    }
}
