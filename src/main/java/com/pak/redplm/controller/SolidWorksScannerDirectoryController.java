package com.pak.redplm.controller;

import com.pak.redplm.entity.SWAssembly;
import com.pak.redplm.service.ExcelService;
import com.pak.redplm.service.SolidWorksFileService;
import com.pak.redplm.service.SolidWorksFileService.HierarchicalFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
//@RequestMapping("/engineer")
public class SolidWorksScannerDirectoryController {

    @Autowired
    private SolidWorksFileService solidWorksFileService;

    @Autowired
    private ExcelService excelService;

    @GetMapping("/scanPage")
    public String showScanPage() {
        return "scanDirectoryPages/scanDirectoryRequest";
    }

    @PostMapping("/scan")
    public String scanDirectory(@RequestParam("directory") String directoryPath, Model model) {
        try {
            List<HierarchicalFile> solidWorksFiles = solidWorksFileService.scanDirectory(directoryPath);
            model.addAttribute("solidWorksFiles", solidWorksFiles);
            return "scanDirectoryPages/scanDirectoryResult";
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
            return "scanDirectoryPages/scanExelFileStructure";
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
            return "scanDirectoryPages/saveScanResult";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "error";
        }
    }

    @GetMapping("/manual_structure")
    public String showManualStructurePage() {
        return "scanDirectoryPages/manualCreateStructure";
    }


    @GetMapping("/create")
    public String create() {
        return "scanDirectoryPages/createNewProjectPage";
    }

    @PostMapping("/scanResult")
    public List<SWAssembly> scanFile(@RequestParam("file") MultipartFile file) {
        try {
            return excelService.readExcelFile(String.valueOf(file));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

//    @PostMapping("/saveToDatabase")
//    public void saveToDatabase(@RequestBody List<SWAssembly> assemblies) {
//        excelService.saveAssemblies(assemblies);
//    }

}
