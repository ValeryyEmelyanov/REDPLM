package com.pak.redplm.controller;

import com.pak.redplm.entity.enumClasses.EUserRole;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

    /*  У одного пользователя, работающего *конструктором есть возможность зайти под ролью *сборщика
    Прописывается индивидуально, связано с отпусками, больничными и перераспределением человекочасов
    в случае горящих сроков */

@Controller
public class MainController {

    @GetMapping("/login")
    public String login(){
        return "customLogin";
    }

    @GetMapping("/")
    public String getRoleSelectionPage(Model model){
        EUserRole[] roles = EUserRole.values();
        model.addAttribute("roles", roles);
        return "rolePages/selectionRolePage";
    }

    @GetMapping("/startPage")
    public String selectPage(@RequestParam("role") EUserRole role, Model model) {
        String pageName = "rolePages/" + role.name().toLowerCase() + "Page";
        return pageName;
    }
}