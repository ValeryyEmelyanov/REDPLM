package com.pak.redplm.controller;

import com.pak.redplm.entity.enumClasses.EPAKType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class PakController {

    @GetMapping("/pak/add")
    public String showAddPakForm(Model model) {
        List<EPAKType> pakTypes = Arrays.asList(EPAKType.values());
        model.addAttribute("pakTypes", pakTypes);
        return "workWithPAK/formForAddPAK";
    }


}