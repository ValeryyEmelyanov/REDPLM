package com.pak.redplm.controller;

import com.pak.redplm.entity.UserEntity;
import com.pak.redplm.entity.enumClasses.EUserDepartment;
import com.pak.redplm.entity.enumClasses.EUserRole;
import com.pak.redplm.service.UserEntityService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller

public class RegistrationController {
    UserEntityService userService;

    @GetMapping("/registration")
    public String registration(Model model){
        model.addAttribute("departments", EUserDepartment.values());
        model.addAttribute("roles", EUserRole.values());
        return "registration";
    }

    @PostMapping("/registration")
    public String registration(@ModelAttribute("userEntity") UserEntity userEntity, Model model){
        userService.saveUser(userEntity);
        return "redirect:/login";
    }
}
