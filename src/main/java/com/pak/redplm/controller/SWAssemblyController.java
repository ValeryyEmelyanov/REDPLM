package com.pak.redplm.controller;


import com.pak.redplm.entity.SWAssembly;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@RequestMapping("/assembly")
public class SWAssemblyController {

    @GetMapping("/form")
    public String getAssemblyAddForm(Model model) {
        model.addAttribute("assembly", new SWAssembly());
        return "formForAddAssembly";
    }

    @PostMapping("/add")
    public String addAssembly(SWAssembly swAssembly) {
        // Логика для сохранения сборки
        return "redirect:/assembly/list";
    }

    @GetMapping("/list")
    public String listAssemblies(Model model) {
        // Логика для получения всех сборок
        model.addAttribute("assemblies", new ArrayList<SWAssembly>());
        return "listAllAssemblies";
    }
}

