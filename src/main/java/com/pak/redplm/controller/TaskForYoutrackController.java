package com.pak.redplm.controller;


import com.pak.redplm.entity.TaskForYoutrack;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
@RequestMapping("/task")
public class TaskForYoutrackController {

    @GetMapping("/form")
    public String getTaskAddForm(Model model) {
        model.addAttribute("task", new TaskForYoutrack());
        return "formForAddTask";
    }

    @PostMapping("/add")
    public String addTask(TaskForYoutrack taskForYoutrack) {
        // Логика для сохранения задачи
        return "redirect:/task/list";
    }

    @GetMapping("/list")
    public String listTasks(Model model) {
        // Логика для получения всех задач
        model.addAttribute("tasks", new ArrayList<TaskForYoutrack>());
        return "listAllTasks";
    }
}