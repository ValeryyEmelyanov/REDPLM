package com.pak.redplm.controller;

import com.pak.redplm.entity.SWAssembly;
import com.pak.redplm.service.AssemblyService;
import com.pak.redplm.service.ExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@Controller
public class DataController {
    private ExcelService excelService;
    private AssemblyService assemblyService;

    @Autowired
    public DataController(AssemblyService assemblyService) {
        this.assemblyService = assemblyService;
    }

    public void importData(String filePath) throws IOException, SQLException {
        List<SWAssembly> assemblyList = excelService.readExcelFile(filePath);
        assemblyService.saveAssemblies(assemblyList);
    }
}
