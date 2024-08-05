package com.pak.redplm.service;

import com.pak.redplm.entity.*;
import com.pak.redplm.entity.enumClasses.EAssemblyStatus;
import com.pak.redplm.repository.SWAssemblyRepository;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.System.out;
import static org.apache.poi.ss.usermodel.CellType.*;

@Service
public class ExcelService {

    @Autowired
    private SWAssemblyRepository swAssemblyRepository;

    public void createSampleExcelFile(String filePath) throws IOException {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Sample Sheet");

        // Создание заголовка
        Row headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("Header 1");
        headerRow.createCell(1).setCellValue("Header 2");

        // Создание примера данных
        Row row = sheet.createRow(1);
        row.createCell(0).setCellValue("Value 1");
        row.createCell(1).setCellValue("Value 2");

        // Запись в файл
        try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
            workbook.write(fileOut);
        }
        workbook.close();
    }

    public static String getCellText (Cell cell){

        String result = "";

        // Alternatively, get the value and format it yourself
        switch (cell.getCellType()) {
            case STRING:
                result = (cell.getRichStringCellValue().getString());
                break;
            case NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    result = String.valueOf((cell.getDateCellValue()));
                } else {
                    result = String.valueOf((cell.getNumericCellValue()));
                }
                break;
            case BOOLEAN:
                result = String.valueOf((cell.getBooleanCellValue()));
                break;
            case FORMULA:
                result = (cell.getCellFormula()).toString();
                break;
            case BLANK:
                System.out.println();
                break;
            default:
                break;
        }
        return result;
    }

    public List<SWAssembly> readExcelFile(String file) throws IOException {
        List<SWAssembly> assemblyList = new ArrayList<>();
        Workbook workbook = new XSSFWorkbook(Arrays.toString(file.getBytes()));
        Sheet sheet = workbook.getSheetAt(0);

        for (Row row : sheet) {
            SWAssembly assembly = new SWAssembly();
            assembly.setName(row.getCell(0).getStringCellValue());
            assembly.setLevel((int) row.getCell(1).getNumericCellValue());
            assembly.setQuantityInStock((int) row.getCell(2).getNumericCellValue());
            assembly.setDecimalNumber(row.getCell(3).getStringCellValue());

            // Placeholder methods to get related entities
            assembly.setComponents(getComponentsFromRow(row));
            assembly.setAssemblies(getAssembliesFromRow(row));
            assembly.setPurchasedParts(getPurchasedPartsFromRow(row));

            assembly.setInstruction(getInstructionFromRow(row));
            assembly.setSwDrawing(getDrawingFromRow(row));

            assembly.setEstimatedTime(Duration.parse(row.getCell(4).getStringCellValue()));
            assembly.setSpecification(row.getCell(5).getStringCellValue());
            assembly.setStatus(EAssemblyStatus.valueOf(row.getCell(6).getStringCellValue()));

            assemblyList.add(assembly);
        }

        workbook.close();
        return assemblyList;
    }

    private List<SWPart> getComponentsFromRow(Row row) {
        return new ArrayList<>();
    }

    private List<SWAssembly> getAssembliesFromRow(Row row) {
        return new ArrayList<>();
    }

    private List<PurchasedProduct> getPurchasedPartsFromRow(Row row) {
        return new ArrayList<>();
    }

    private InstructionManual getInstructionFromRow(Row row) {
        return new InstructionManual();
    }

    private SWDrawing getDrawingFromRow(Row row) {
        return new SWDrawing();
    }

}