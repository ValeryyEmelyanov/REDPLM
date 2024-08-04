package com.pak.redplm.controller;

import com.pak.redplm.entity.SWAssembly;
import com.pak.redplm.entity.SWPart;
import com.pak.redplm.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pak")
public class FileController {


    @Autowired
    private FileService fileService;

    @GetMapping("/initialize")
    public String initializeDirectories() {
        fileService.initializeDirectoryStructure();
        return "Directory structure initialized successfully";
    }

    @PostMapping("/create")
    public void createPak(@RequestParam String pakName) {
        fileService.createPakFolder(pakName, "/path/to/your/directory");
    }

    @PostMapping("/update")
    public void updatePak(@RequestParam String pakName, @RequestBody List<SWPart> swPartList, @RequestBody List<SWAssembly> swAssemblyList) {
        fileService.updateExcelSummary(pakName, "/path/to/your/directory", swPartList, swAssemblyList);
    }

    @PostMapping("/replace")
    public void replaceDetail(@RequestParam String pakName, @RequestParam String detailName, @RequestParam String newDetailPath) {
        fileService.replaceDetail(pakName, "/path/to/your/directory", detailName, newDetailPath);
    }
}
