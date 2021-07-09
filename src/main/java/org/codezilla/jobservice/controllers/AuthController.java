package org.codezilla.jobservice.controllers;

import org.codezilla.jobservice.models.ERole;
import org.codezilla.jobservice.models.Role;
import org.codezilla.jobservice.models.User;
import org.codezilla.jobservice.repository.RoleRepository;
import org.codezilla.jobservice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
import java.util.Collections;

@Controller
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleRepository roleRepository;

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("userForm", new User());
        model.addAttribute("client", Collections.singleton(roleRepository.findByName(ERole.ROLE_CLIENT).get()));
        model.addAttribute("executor", Collections.singleton(roleRepository.findByName(ERole.ROLE_EXECUTOR).get()));

        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(@ModelAttribute("userForm") User userForm, BindingResult results, Model model, HttpServletRequest request) {

        if (request.getParameter("role").equals("Заказчик")){
            userForm.setRoles(Collections.singleton(roleRepository.findByName(ERole.ROLE_CLIENT).get()));
        } else {
            userForm.setRoles(Collections.singleton(roleRepository.findByName(ERole.ROLE_EXECUTOR).get()));
        }

        if (results.hasErrors()) {
            System.out.println(results);
            return "registration";
        }

        if (userForm.getUsername().equals("anonymousUser")){
            model.addAttribute("userAnonymousError", "Логин anonymousUser запрешен");
            return "registration";
        }

        if (!userForm.getPassword().equals(userForm.getPasswordConfirm())) {
            model.addAttribute("passwordError", "Пароли не совпадают");
            System.out.println("Пароли не совпадают");
            return "registration";
        }

        if (userService.saveUser(userForm)) {
            return "redirect:/";
        } else {
            model.addAttribute("usernameError", "Пользователь с таким именем уже существует");
            System.out.println("Пользователь с таким именем уже существует");
            return "registration";
        }


    }
}
