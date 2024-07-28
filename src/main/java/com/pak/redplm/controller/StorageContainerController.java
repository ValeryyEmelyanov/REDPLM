package com.pak.redplm.controller;

import com.pak.redplm.entity.StorageContainer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.awt.*;
import java.util.ArrayList;

@Controller
@RequestMapping("/container")
public class StorageContainerController {

    @GetMapping("/form")
    public String getContainerAddForm(Model model) {
    model.addAttribute("container", new StorageContainer());
        return "formForAddContainer";
    }

    @PostMapping("/add")
    public String addContainer(StorageContainer storageContainer) {
        // Логика для сохранения контейнера
        return "redirect:/container/list";
    }

    @GetMapping("/list")
    public String listContainers(Model model) {
        // Логика для получения всех контейнеров
        model.addAttribute("containers", new ArrayList<StorageContainer>());
        return "listAllContainers";
    }
}
