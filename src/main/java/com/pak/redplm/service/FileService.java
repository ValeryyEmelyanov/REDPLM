package com.pak.redplm.service;

import com.pak.redplm.entity.SWAssembly;
import com.pak.redplm.entity.SWPart;
import com.pak.redplm.util.FileStructureUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FileService {

    private static final Logger logger = LoggerFactory.getLogger(FileService.class);
    private final String rootDir = "D:/REDPLM/REDPLM";

    public void initializeDirectoryStructure(){
        try {
            FileStructureUtil.createDirectoryStructure(rootDir);
            logger.info("Directory structure initialized successfully");
        } catch (Exception e) {
            logger.error("Error creating directory structure", e);
            throw new RuntimeException("Error creating directory structure");
        }
    }

    public void createPakFolder(String pakName, String basePath) {
        // Логика создания папки для ПАК
    }

    public void updateExcelSummary(String pakName, String basePath, List<SWPart> swPartList, List<SWAssembly> swAssemblyList) {
        // Логика обновления Excel файла
    }

    public void replaceDetail(String pakName, String basePath, String detailName, String newDetailPath) {
        // Логика замены детали
    }
}
