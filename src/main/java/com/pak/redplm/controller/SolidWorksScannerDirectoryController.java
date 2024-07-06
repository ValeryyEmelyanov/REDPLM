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

    private void scanDirectory(File directory, List<HierarchicalFile> solidWorksFiles, int level) {
        if (directory.isDirectory()) {
            // Создаем элемент для текущей директории с учетом уровня вложенности
            String indentedDirectoryName = " ".repeat(level * 3) + directory.getName();
            solidWorksFiles.add(new HierarchicalFile(indentedDirectoryName, level, true));

            // Сканируем файлы и поддиректории внутри текущей директории
            File[] directoryFiles = directory.listFiles();
            if (directoryFiles != null) {
                for (File file : directoryFiles) {
                    if (file.isDirectory()) {
                        // Рекурсивно сканируем поддиректории с увеличением уровня вложенности
                        scanDirectory(file, solidWorksFiles, level + 1);
                    } else {
                        // Добавляем только файлы SolidWorks с учетом уровня вложенности
                        if (file.getName().endsWith(".SLDPRT") || file.getName().endsWith(".sldasm") || file.getName().endsWith(".slddrw")) {
                            String indentedFileName = " ".repeat(level * 3 + 3) + file.getName().replaceFirst("[.][^.]+$", "").replaceAll("^\\.+", "");
                            solidWorksFiles.add(new HierarchicalFile(indentedFileName, level + 1, false));
                        }
                    }
                }
            }
        }
    }

    // Вспомогательный класс для хранения имени файла/директории и уровня вложенности
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