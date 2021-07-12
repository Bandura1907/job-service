package org.codezilla.jobservice.controllers.account;

import org.codezilla.jobservice.models.User;
import org.codezilla.jobservice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;
import java.util.UUID;

@Controller
@RequestMapping("/account")
@PreAuthorize("hasRole('ROLE_CLIENT') or hasRole('ROLE_EXECUTOR')")
public class AccountDetailController {

    @Autowired
    private UserService userService;

    @GetMapping("/profile")
    public String getProfile(Model model) {
        model.addAttribute("roleList", Arrays.asList("Заказчик", "Исполнитель"));
        return "account/profile-user";
    }


    @PostMapping("/save")
    public String save(User user, @RequestParam("file") MultipartFile file) throws IOException {
        if (Objects.equals(file.getOriginalFilename(), "")){
            userService.save(user);
            return "redirect:/account/profile";
        }

        File deleteAva = new File("src/main/resources/static/avatars/" + user.getPhoto());
        if (deleteAva.exists()) {
            deleteAva.delete();
            user.setPhoto(null);
        }


        System.out.println(file.getOriginalFilename());
        File uploadDir = new File("src/main/resources/static/avatars");
        if (!uploadDir.exists())
            uploadDir.mkdir();

        String uuidFile = UUID.randomUUID().toString();
        String resultFilename = uuidFile + "." + file.getOriginalFilename();
        String absolutePath = new File("src/main/resources/static/avatars").getAbsolutePath();
        file.transferTo(new File(absolutePath + "\\avatars" + resultFilename));
        user.setPhoto("avatars" + resultFilename);

        userService.save(user);

        return "redirect:/account/profile";
    }


    @ModelAttribute("user")
    public User user() {

        return userService.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
    }
}
