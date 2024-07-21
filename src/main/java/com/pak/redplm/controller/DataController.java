package com.pak.redplm.controller;

import com.pak.redplm.entity.SWAssembly;
import com.pak.redplm.service.AssemblyService;
import com.pak.redplm.service.ExcelService;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class DataController {
    private ExcelService excelService;
    private AssemblyService assemblyService;

    public DataController() {
        this.excelService = new ExcelService();
        this.assemblyService = new AssemblyService();
    }

    public void importData(String filePath) throws IOException, SQLException {
        List<SWAssembly> assemblyList = excelService.readExcelFile(filePath);
        assemblyService.saveAssemblies(assemblyList);
    }

    public static void main(String[] args) {
        DataController controller = new DataController();
        try {
            controller.importData("path/to/your/excel/file.xlsx");
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }
}
