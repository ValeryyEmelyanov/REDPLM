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
        return "selectionPage";
    }

    @GetMapping("/startPage")
    public String selectPage(@RequestParam("role") EUserRole role, Model model) {
        // Преобразуем имя роли в строку с именем шаблона
        String pageName = role.name().toLowerCase() + "Page";
        // Проверка на существование шаблона может быть добавлена здесь
        return pageName;
    }
}