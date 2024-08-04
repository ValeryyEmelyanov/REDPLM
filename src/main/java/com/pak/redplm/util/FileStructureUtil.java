package com.pak.redplm.util;

import java.io.File;

public class FileStructureUtil {
    public static void createDirectoryStructure(String rootDir) {
        String[] directories = {
                rootDir + "/Library/LibraryDetails",
                rootDir + "/Library/LibraryInstructions",
                rootDir + "/Library/LibraryAssemblies",
                rootDir + "/Library/LibraryDrawings",
                rootDir + "/Library/LibraryPAK",
                rootDir + "/Library/LibraryPurchasedProduct",
                rootDir + "/Library/LibraryStorageContainer",
                rootDir + "/Library/LibraryPart",
                rootDir + "/Library/LibraryTaskForYoutrack"

        };

        for (String dir : directories) {
            File directory = new File(dir);
            if (!directory.exists()) {
                directory.mkdirs();
            }
        }
    }
}