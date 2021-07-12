package org.codezilla.jobservice.services;

import org.codezilla.jobservice.models.order.Job;
import org.codezilla.jobservice.models.order.Service;
import org.springframework.data.domain.Page;

public interface OrderService {
    Page<Service> findPaginated(int pageNo, int pageSize);
}
