package com.pak.redplm.controller;

import com.pak.redplm.entity.SWPart;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/swpart")
public class SWPartController {

// Добавление детали
    // Возвращение формы пользователю
    @GetMapping("/form")
    public String getDoctorAddForm(){
        return "swpart/swpart-add-form";
    }

    // Получение детали из заполненной формы:
    @PostMapping("/add")
    public String addSWPart(SWPart swPart){
        return "redirect:/swpart/form";
    }

//Получение детали по:
//    @GetMapping("/{id}")
//    public String getSWPartById()
}
