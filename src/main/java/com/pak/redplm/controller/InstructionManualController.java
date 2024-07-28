package com.pak.redplm.controller;

import com.pak.redplm.entity.InstructionManual;
import org.aspectj.apache.bcel.generic.Instruction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
@RequestMapping("/instruction")
public class InstructionManualController {

    @GetMapping("/form")
    public String getInstructionAddForm(Model model) {
        model.addAttribute("instruction", new InstructionManual());
        return "formForAddInstruction";
    }

    @PostMapping("/add")
    public String addInstruction(InstructionManual instructionManual) {
        // Логика для сохранения инструкции
        return "redirect:/instruction/list";
    }

    @GetMapping("/list")
    public String listInstructions(Model model) {
        // Логика для получения всех инструкций
        model.addAttribute("instructions", new ArrayList<InstructionManual>());
        return "listAllInstructions";
    }
}
