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

//    @PostMapping("/scan")
//    public String scanDirectory(@RequestParam("directory") String directoryPath, Model model) {
//        File directory = new File(directoryPath);
//        List<File> solidWorksFiles = new ArrayList<>();
//        scanDirectory(directory, solidWorksFiles);
//        model.addAttribute("solidWorksFiles", solidWorksFiles);
//        return "scanResult";
//    }
//
//    private void scanDirectory(File directory, List<File> solidWorksFiles) {
//        if (directory.isDirectory()) {
//            File[] directoryFiles = directory.listFiles();
//            if (directoryFiles != null){
//            for (File file : directoryFiles) {
//                if (file.isDirectory()) {
//                    scanDirectory(file, solidWorksFiles);
//                } else
//                    if (file.getName().endsWith(".sldprt") || file.getName().endsWith(".sldasm") || file.getName().endsWith(".slddrw")) {
//                        solidWorksFiles.add(file);
//                    }
//                }
//            }
//        }
//    }

    public static void main(String[] args) {
        ArrayList<File> fileList = new ArrayList<>();
        scanDirectory(new File("C:\\Users\\Emelyanov\\Desktop"),  fileList);
        for (File file: fileList){
            System.out.println("____");
            System.out.println(file.getAbsolutePath());
        }
    }

    private static void scanDirectory(File rootFile, List<File> fileList) {
        if (rootFile.isDirectory()) {
            System.out.println("searching at: " + rootFile.getAbsolutePath());
            File[] directoryFiles = rootFile.listFiles();
            if (directoryFiles != null) {
                for (File file : directoryFiles) {
                    if (file.isDirectory()) {
                        scanDirectory(file, fileList);
                    } else
                        if (file.getPath().endsWith(".SLDPRT")) {
                        fileList.add(file);
                    }
                }
            }
        }
    }

}
