package com.pak.redplm;

import com.pak.redplm.service.ExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ApplicationInitializer implements CommandLineRunner {

    @Autowired
    private ExcelService excelService;

    @Override
    public void run(String... args) throws Exception {
        excelService.initializeDirectoryStructure();
    }
}