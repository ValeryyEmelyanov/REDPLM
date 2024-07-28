package com.pak.redplm.controller;

import com.pak.redplm.entity.SWDrawing;
import org.apache.poi.ss.usermodel.Drawing;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
@RequestMapping("/drawing")
public class SWDrawingController {

    @GetMapping("/form")
    public String getDrawingAddForm(Model model) {
        model.addAttribute("drawing", new SWDrawing());
        return "formForAddDrawing";
    }

    @PostMapping("/add")
    public String addDrawing(SWDrawing drawing) {
        // Логика для сохранения чертежа
        return "redirect:/drawing/list";
    }

    @GetMapping("/list")
    public String listDrawings(Model model) {
        // Логика для получения всех чертежей
        model.addAttribute("drawings", new ArrayList<SWDrawing>());
        return "listAllDrawings";
    }
}