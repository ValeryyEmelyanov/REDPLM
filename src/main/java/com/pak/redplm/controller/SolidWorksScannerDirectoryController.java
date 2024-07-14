package com.pak.redplm.controller;

import com.pak.redplm.service.SolidWorksFileService;
import com.pak.redplm.service.SolidWorksFileService.HierarchicalFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class SolidWorksScannerDirectoryController {

    @Autowired
    private SolidWorksFileService solidWorksFileService;

    @GetMapping("/scanPage")
    public String showScanPage() {
        return "scannerDirectoryRequest";
    }

    @PostMapping("/scan")
    public String scanDirectory(@RequestParam("directory") String directoryPath, Model model) {
        try {
            List<HierarchicalFile> solidWorksFiles = solidWorksFileService.scanDirectory(directoryPath);
            model.addAttribute("solidWorksFiles", solidWorksFiles);
            return "scanDirectoryResult";
        } catch (IllegalArgumentException e) {
            model.addAttribute("error", e.getMessage());
            return "error";
        }
    }

    @PostMapping("/scanTree")
    public String scanDirectoryTree(@RequestParam("directory") String directoryPath, Model model) {
        try {
            String treeHtml = solidWorksFileService.scanDirectoryTree(directoryPath);
            model.addAttribute("treeHtml", treeHtml);
            return "scanDirectoryTreeResult";
        } catch (IllegalArgumentException e) {
            model.addAttribute("error", e.getMessage());
            return "error";
        }
    }

    @PostMapping("/saveToDatabase")
    public String saveToDatabase(@RequestParam List<String> fileNames, @RequestParam List<Integer> fileLevels, Model model) {
        // Логика сохранения данных в базу данных
        try {
            solidWorksFileService.saveFilesToDatabase(fileNames, fileLevels);
            model.addAttribute("parts", fileNames);
            return "saveResult";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "error";
        }
    }

    @GetMapping("/create")
    public String create() {
        return "create";
    }
}
