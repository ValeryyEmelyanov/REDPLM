package com.pak.redplm.controller;

import com.pak.redplm.entity.SWAssembly;
import com.pak.redplm.entity.SWPart;
import com.pak.redplm.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/directory")
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
        fileService.createPakFolder(pakName, "D:/REDPLM/REDPLM/Library/");
    }

    @PostMapping("/update")
    public void updatePak(@RequestParam String pakName,
                          @RequestBody List<SWPart> swPartList,
                          @RequestBody List<SWAssembly> swAssemblyList)
    {
        fileService.updateExcelSummary(pakName, "/D:/REDPLM/REDPLM/Library/", swPartList, swAssemblyList);
    }

    @PostMapping("/replace")
    public void replaceDetail(@RequestParam String pakName,
                              @RequestParam String detailName,
                              @RequestParam String newDetailPath)
    {
        fileService.replaceDetail(pakName, "D:/REDPLM/REDPLM/Library/", detailName, newDetailPath);
    }
}
