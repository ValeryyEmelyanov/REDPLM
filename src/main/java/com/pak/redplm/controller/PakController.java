package com.pak.redplm.controller;

import com.pak.redplm.entity.PAK;
import com.pak.redplm.entity.enumClasses.EPAKType;
import com.pak.redplm.service.ExcelService;
import com.pak.redplm.service.PAKService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/pak")
public class PakController {

    private static final Logger logger = LoggerFactory.getLogger(PakController.class);

    @Autowired
    private ExcelService excelService;

    @Autowired
    private PAKService pakService;

    @GetMapping("/add")
    public String showAddPakForm(Model model) {
        List<EPAKType> pakTypes = Arrays.asList(EPAKType.values());
        model.addAttribute("pakTypes", pakTypes);
        return "workWithPAK/formForAddPAK";
    }

    @PostMapping("/add")
    public String handleFormSubmission(@RequestParam("name") String name,
                                       @RequestParam("pakType") String pakType,
                                       Model model) {
        logger.info("Начало обработки формы добавления ПАК.");
        logger.debug("Полученные параметры: name={}, pakType={}", name, pakType);

        try {
            // Убедитесь, что name корректно для использования в пути
            if (name == null || name.trim().isEmpty()) {
                logger.error("Название ПАК не может быть пустым.");
                throw new IllegalArgumentException("Название ПАК не может быть пустым.");
            }

            // Построение пути с использованием Paths.get
            Path dirPath = Paths.get("D:/REDPLM/REDPLM/Library/LibraryPAK", name.trim());
            Files.createDirectories(dirPath);
            logger.info("Создана директория: {}", dirPath);

            // Создание Excel файла
            Path excelFilePath = dirPath.resolve("data.xlsx");
            excelService.createSampleExcelFile(excelFilePath.toString());
            logger.info("Создан Excel файл: {}", excelFilePath);

            // Создание объекта PAK и сохранение в базу данных
            PAK pak = new PAK();
            pak.setName(name);
            pak.setPakType(EPAKType.valueOf(pakType));
            pakService.savePak(pak);
            logger.info("PAK успешно сохранен: {}", pak);

            // Подготовка данных для отображения
            model.addAttribute("parts", Arrays.asList(name));
            logger.info("Данные успешно подготовлены для отображения.");
            return "workWithPAK/createPAKResult";
        } catch (IOException e) {
            logger.error("Не удалось создать директорию или файл.", e);
            model.addAttribute("error", "Не удалось создать директорию или файл: " + e.getMessage());
            return "workWithPAK/createPAKResult";
        } catch (IllegalArgumentException e) {
            logger.error("Неверное имя ПАК: {}", e.getMessage());
            model.addAttribute("error", "Неверное имя ПАК: " + e.getMessage());
            return "workWithPAK/createPAKResult";
        }
    }
}