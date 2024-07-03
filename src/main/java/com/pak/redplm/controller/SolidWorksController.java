package com.pak.redplm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Controller
public class SolidWorksController {

    @GetMapping("/scanPage")
    public String showScanPage() {
        return "scan";
    }

    @PostMapping("/scan")
    public String scanDirectory(@RequestParam("directory") String directoryPath, Model model) {
        File directory = new File(directoryPath);
        List<String> solidWorksFiles = new ArrayList<>();
        scanDirectory(directory, solidWorksFiles);
        model.addAttribute("solidWorksFiles", solidWorksFiles);
        return "scanResult";
    }

    private void scanDirectory(File directory, List<String> solidWorksFiles) {
        if (directory.isDirectory()) {
            for (File file : directory.listFiles()) {
                if (file.isDirectory()) {
                    scanDirectory(file, solidWorksFiles);
                } else if (file.getName().endsWith(".sldprt") || file.getName().endsWith(".sldasm") || file.getName().endsWith(".slddrw")) {
                    solidWorksFiles.add(file.getAbsolutePath());
                }
            }
        }
    }
}
