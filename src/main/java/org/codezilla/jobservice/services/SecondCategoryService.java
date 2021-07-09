package org.codezilla.jobservice.services;

import org.codezilla.jobservice.models.category.SecondCategory;
import org.codezilla.jobservice.repository.SecondCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SecondCategoryService {

    @Autowired
    private SecondCategoryRepository secondCategoryRepository;

    public List<SecondCategory> findAll() {
        return secondCategoryRepository.findAll();
    }

    public SecondCategory findById(Long id) {
        return secondCategoryRepository.findById(id).get();
    }
}
