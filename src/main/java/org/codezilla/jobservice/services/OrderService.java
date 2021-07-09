package org.codezilla.jobservice.services;

import org.codezilla.jobservice.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private ServiceRepository repository;

    public org.codezilla.jobservice.models.order.Service findById(long id) {
        return repository.findById(id).get();
    }

    public List<org.codezilla.jobservice.models.order.Service> findAll() {
        return repository.findAll();
    }

    public void save(org.codezilla.jobservice.models.order.Service service) {
        repository.save(service);
    }

    public void deleteById(long id) {
        repository.deleteById(id);
    }
}
