package org.codezilla.jobservice.controllers;

import org.codezilla.jobservice.models.User;
import org.codezilla.jobservice.models.order.Job;
import org.codezilla.jobservice.models.order.Service;
import org.codezilla.jobservice.services.JobServiceImpl;
import org.codezilla.jobservice.services.OrderServiceImpl;
import org.codezilla.jobservice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import javax.transaction.Transactional;
import java.util.List;

@Controller
public class IndexController {

    @Autowired
    private JobServiceImpl jobService;
    @Autowired
    private UserService userService;
    @Autowired
    private OrderServiceImpl orderService;

    @GetMapping("/")
    public String getIndex() {
        return "index";
    }

    @GetMapping("/job-detail/{id}")
    public String jobDetail(@PathVariable long id, Model model) {
        model.addAttribute("jobDetail", jobService.findById(id));
        return "job-detail";
    }

    @GetMapping("/job-list")
    public String jobList(Model model) {
        return findPaginated(1, model);

    }

    @GetMapping("/chat")
    public String chat() {
        return "chat";
    }

    @GetMapping("/service-list")
    public String serviceList(Model model) {
        return findServicePaginated(1, model);
    }

    @GetMapping("/job-list/page/{pageNo}")
    public String findPaginated(@PathVariable int pageNo, Model model) {
        int pageSize = 5;

        Page<Job> page = jobService.findPaginated(pageNo, pageSize);
        List<Job> listJobs = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());

        model.addAttribute("listJobs", listJobs);

        return "job-list";
    }

    @GetMapping("/service-list/page/{pageNo}")
    public String findServicePaginated(@PathVariable int pageNo, Model model) {
        int pageSize = 5;

        Page<Service> page = orderService.findPaginated(pageNo, pageSize);
        List<Service> listServices = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());

        model.addAttribute("listServices", listServices);

        return "service-list";
    }

    @GetMapping("/resume-detail/{id}")
    public String resumeDetail(@PathVariable long id, Model model) {
        model.addAttribute("findUser", userService.findUserById(id));

        return "resume-detail";
    }


    @ModelAttribute("user")
    public User user() {
        return userService.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
    }


}
