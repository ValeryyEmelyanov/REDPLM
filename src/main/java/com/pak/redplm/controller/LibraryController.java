package com.pak.redplm.controller;

import com.pak.redplm.entity.SWPart;
import com.pak.redplm.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/library")
public class LibraryController {

    @Autowired
    private LibraryService libraryService;

    @PostMapping("/add")
    public void addDetail(@RequestBody SWPart swPart) {
        libraryService.addDetail(swPart.getName());
    }

//    @PostMapping("/update")
//    public void updateDetail(@RequestBody DetailDTO detail) {
//        libraryService.updateDetail(detail.getName(), detail.getPath());
//    }

    @PostMapping("/delete")
    public void deleteDetail(@RequestParam String name) {
        libraryService.deleteDetail(name);
    }
}