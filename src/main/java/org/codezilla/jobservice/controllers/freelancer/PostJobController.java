package org.codezilla.jobservice.controllers.freelancer;

import org.codezilla.jobservice.models.User;
import org.codezilla.jobservice.models.category.FirstCategory;
import org.codezilla.jobservice.models.category.SecondCategory;
import org.codezilla.jobservice.models.order.Job;
import org.codezilla.jobservice.services.FirstCategoryService;
import org.codezilla.jobservice.services.JobServiceImpl;
import org.codezilla.jobservice.services.SecondCategoryService;
import org.codezilla.jobservice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@PreAuthorize("hasRole('ROLE_EXECUTOR')")
@RequestMapping("/freelancer")
public class PostJobController {
    @Autowired
    private UserService userService;

    @Autowired
    private FirstCategoryService firstCategoryService;

    @Autowired
    private SecondCategoryService secondCategoryService;

    @Autowired
    private JobServiceImpl jobService;

    @GetMapping("/post-job")
    public String postJob(Model model) {
        model.addAttribute("job", new Job());
        return "freelancer/post-job";
    }

    @GetMapping("/job-manage")
    public String jobManage() {

        return "freelancer/job-manage";
    }

    @GetMapping("/job-delete/{id}")
    public String jobDelete(@PathVariable Long id) {
        Job job = jobService.findById(id);
        if (job.getUser().equals(user())){
            jobService.deleteById(id);
        }
        return "redirect:/freelancer/job-manage";
    }

    @GetMapping("/job-edit/{id}")
    public ModelAndView jobEdit(@PathVariable long id) {
        ModelAndView mav = new ModelAndView("freelancer/edit-job");
        Job job = jobService.findById(id);
        if (job.getUser().equals(user())){
            mav.addObject("job", job);
        }

        return mav;
    }



    @PostMapping("/post-job-save")
    public String postJobSave(@ModelAttribute("job") Job job) {
        job.setUser(user());
        job.setDateTime(LocalDateTime.now());
        jobService.save(job);
        return "redirect:/freelancer/job-manage";
    }


    @ModelAttribute("user")
    public User user() {
        return userService.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
    }

    @ModelAttribute("firstCategoryList")
    public List<FirstCategory> firstCategoryList() {
        return firstCategoryService.findAll();
    }

    @ModelAttribute("secondCategoryList")
    public List<SecondCategory> secondCategoryList() {
        return secondCategoryService.findAll();
    }
}
