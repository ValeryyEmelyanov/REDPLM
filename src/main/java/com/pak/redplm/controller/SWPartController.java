package com.pak.redplm.controller;

import com.pak.redplm.entity.SWPart;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
@RequestMapping("/swpart")
public class SWPartController {

    @GetMapping("/form")
    public String getSWPartAddForm(Model model) {
        model.addAttribute("swPart", new SWPart());
        return "workWithSolidWorksPart/formForAddSWPart"; // Путь к форме добавления детали
    }

    @PostMapping("/add")
    public String addSWPart(SWPart swPart) {
        // Логика для сохранения SWPart (например, swPartService.save(swPart))
        return "redirect:/swpart/listAllParts"; // Перенаправление на страницу списка деталей
    }

    @GetMapping("/listAllParts")
    public String listAllParts(Model model) {
        // Логика для получения всех деталей (например, List<SWPart> parts = swPartService.findAll())
        model.addAttribute("parts", new ArrayList<SWPart>());
        return "workWithSolidWorksPart/listAllParts";
    }
}
