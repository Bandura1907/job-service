package org.codezilla.jobservice.controllers.client;

import org.codezilla.jobservice.models.User;
import org.codezilla.jobservice.models.category.FirstCategory;
import org.codezilla.jobservice.models.category.SecondCategory;
import org.codezilla.jobservice.models.order.Job;
import org.codezilla.jobservice.models.order.Service;
import org.codezilla.jobservice.services.FirstCategoryService;
import org.codezilla.jobservice.services.OrderService;
import org.codezilla.jobservice.services.SecondCategoryService;
import org.codezilla.jobservice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@PreAuthorize("hasRole('ROLE_CLIENT')")
@RequestMapping("/client")
public class ClientController {
    @Autowired
    private UserService userService;
    @Autowired
    private FirstCategoryService firstCategoryService;
    @Autowired
    private SecondCategoryService secondCategoryService;
    @Autowired
    private OrderService orderService;


    @GetMapping("/post-order")
    public String postOrder(Model model) {
        model.addAttribute("service", new Service());
        return "client/post-order";
    }

    @GetMapping("/order-manage")
    public String orderManage() {

        return "client/order-manage";
    }

    @GetMapping("/order-edit/{id}")
    public ModelAndView editOrder(@PathVariable long id) {
        ModelAndView mav = new ModelAndView("client/edit-order");
        Service service = orderService.findById(id);
        if (service.getUser().equals(user())){
            mav.addObject("service", service);
        }


        return mav;
    }

    @GetMapping("/order-delete/{id}")
    public String orderDelete(@PathVariable Long id) {
        Service service = orderService.findById(id);
        if (service.getUser().equals(user())){
            orderService.deleteById(id);
        }
        return "redirect:/client/order-manage";
    }

    @PostMapping("/post-order-save")
    public String postMappingOrder(@ModelAttribute("service") Service service) {
        service.setDateTime(LocalDateTime.now());
        service.setUser(user());
        orderService.save(service);

        return "redirect:/client/order-manage";
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
