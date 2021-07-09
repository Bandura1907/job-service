package org.codezilla.jobservice.services;

import org.codezilla.jobservice.models.order.Job;
import org.codezilla.jobservice.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService{

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

    @Override
    public Page<org.codezilla.jobservice.models.order.Service> findPaginated(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
        return this.repository.findAll(pageable);
    }
}
