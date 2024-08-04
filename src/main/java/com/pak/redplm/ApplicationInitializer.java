package com.pak.redplm;

import com.pak.redplm.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ApplicationInitializer implements CommandLineRunner {

    @Autowired
    private FileService fileService;

    @Override
    public void run(String... args) throws Exception {
        fileService.initializeDirectoryStructure();
    }
}