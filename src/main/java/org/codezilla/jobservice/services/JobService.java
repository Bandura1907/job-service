package org.codezilla.jobservice.services;

import org.codezilla.jobservice.models.order.Job;
import org.springframework.data.domain.Page;

public interface JobService {

    Page<Job> findPaginated(int pageNo, int pageSize);
}
