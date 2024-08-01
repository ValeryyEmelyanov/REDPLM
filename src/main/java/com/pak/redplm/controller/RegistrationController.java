package com.pak.redplm.controller;

import com.pak.redplm.entity.UserEntity;
import com.pak.redplm.entity.enumClasses.EUserDepartment;
import com.pak.redplm.entity.enumClasses.ERole;
import com.pak.redplm.service.UserService;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller

public class RegistrationController {
    private final UserService userService;

    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/registration")
    public String registration(@NotNull Model model) {
        model.addAttribute("userEntity", new UserEntity());
        model.addAttribute("departments", EUserDepartment.values());
        model.addAttribute("roles", ERole.values());
        return "registration";
    }

    @PostMapping("/registration")
    public String registration(@ModelAttribute("userEntity") UserEntity userEntity, Model model){
        userService.saveUser(userEntity);
        return "redirect:/login";
    }
}
