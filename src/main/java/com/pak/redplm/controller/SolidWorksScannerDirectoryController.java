package com.pak.redplm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Controller
public class SolidWorksScannerDirectoryController {

    @GetMapping("/scanPage")
    public String showScanPage() {
        return "scannerDirectoryRequest";
    }

    @PostMapping("/scan")
    public String scanDirectory(@RequestParam("directory") String directoryPath, Model model) {
        File directory = new File(directoryPath);
        List<HierarchicalFile> solidWorksFiles = new ArrayList<>();
        if (directory.exists() && directory.isDirectory()) {
            scanDirectory(directory, solidWorksFiles, 0);
        } else {
            model.addAttribute("error", "The provided directory does not exist or is not a directory: " + directoryPath);
            return "error";
        }

        model.addAttribute("solidWorksFiles", solidWorksFiles);
        return "scanDirectoryResult";
    }

    @PostMapping("/scanTree")
    public String scanDirectoryTree(@RequestParam("directory") String directoryPath, Model model) {
        File directory = new File(directoryPath);
        StringBuilder treeHtml = new StringBuilder();
        if (directory.exists() && directory.isDirectory()) {
            buildTreeHtml(directory, treeHtml, 0);
        } else {
            model.addAttribute("error", "The provided directory does not exist or is not a directory: " + directoryPath);
            return "error";
        }

        model.addAttribute("treeHtml", treeHtml.toString());
        return "scanDirectoryTreeResult";
    }

    private void scanDirectory(File directory, List<HierarchicalFile> solidWorksFiles, int level) {
        if (directory.isDirectory()) {
            solidWorksFiles.add(new HierarchicalFile(directory.getName(), level, true));

            File[] directoryFiles = directory.listFiles();
            if (directoryFiles != null) {
                for (File file : directoryFiles) {
                    if (file.isDirectory()) {
                        scanDirectory(file, solidWorksFiles, level + 1);
                    } else {
                        if (file.getName().endsWith(".SLDPRT") || file.getName().endsWith(".SLDASM") || file.getName().endsWith(".SLDDRW")) {
                            String fileNameWithoutExtension = file.getName().replaceFirst("[.][^.]+$", "").replaceAll("^\\.+", "");
                            solidWorksFiles.add(new HierarchicalFile(fileNameWithoutExtension, level + 1, false));
                        }
                    }
                }
            }
        }
    }

    private void buildTreeHtml(File directory, StringBuilder treeHtml, int level) {
        if (directory.isDirectory()) {
            treeHtml.append("<li><span>").append(directory.getName()).append("</span>");
            File[] directoryFiles = directory.listFiles();
            if (directoryFiles != null) {
                treeHtml.append("<ul>");
                for (File file : directoryFiles) {
                    if (file.isDirectory()) {
                        buildTreeHtml(file, treeHtml, level + 1);
                    } else {
                        if (file.getName().endsWith(".SLDPRT") || file.getName().endsWith(".SLDASM") || file.getName().endsWith(".SLDDRW")) {
                            String fileNameWithoutExtension = file.getName().replaceFirst("[.][^.]+$", "").replaceAll("^\\.+", "");
                            treeHtml.append("<li><span>").append(fileNameWithoutExtension).append("</span></li>");
                        }
                    }
                }
                treeHtml.append("</ul>");
            }
            treeHtml.append("</li>");
        }
    }

    public static class HierarchicalFile {
        private final String name;
        private final int level;
        private final boolean isDirectory;

        public HierarchicalFile(String name, int level, boolean isDirectory) {
            this.name = name;
            this.level = level;
            this.isDirectory = isDirectory;
        }

        public String getName() {
            return name;
        }

        public int getLevel() {
            return level;
        }

        public boolean isDirectory() {
            return isDirectory;
        }
    }
}