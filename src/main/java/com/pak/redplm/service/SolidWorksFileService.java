package com.pak.redplm.service;

import com.pak.redplm.entity.SWPart;
import com.pak.redplm.repository.SWPartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class SolidWorksFileService {

    @Autowired
    private SWPartRepository swPartRepository;

    public List<HierarchicalFile> scanDirectory(String directoryPath) {
        File directory = new File(directoryPath);
        List<HierarchicalFile> solidWorksFiles = new ArrayList<>();
        if (directory.exists() && directory.isDirectory()) {
            scanDirectory(directory, solidWorksFiles, 0);
        } else {
            throw new IllegalArgumentException("Invalid directory: " + directoryPath);
        }
        return solidWorksFiles;
    }

    public String scanDirectoryTree(String directoryPath) {
        File directory = new File(directoryPath);
        StringBuilder treeHtml = new StringBuilder();
        if (directory.exists() && directory.isDirectory()) {
            buildTreeHtml(directory, treeHtml, 0);
        } else {
            throw new IllegalArgumentException("Invalid directory: " + directoryPath);
        }
        return treeHtml.toString();
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
