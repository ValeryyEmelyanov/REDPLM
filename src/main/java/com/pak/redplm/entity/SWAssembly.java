package com.pak.redplm.entity;

import com.pak.redplm.entity.enumClasses.AssemblyStatus;
import jakarta.persistence.*;

import java.time.Duration;
import java.util.List;

//Складской контейнер
public class SWAssembly {

    // Идентификатор сбокри. RED....
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //Децемальник
    private String decemalNumber;

    //Детали, входящие в сборку
    @OneToMany
    private List<SWPart> components;

    //Подсборки
    @OneToMany
    private List<SWAssembly> assemblies;

    //Расчетное время сборки
    private Duration estimatedTime;

    //Ссылка, документ с инструкцией
    private String instructions;

    //Спецификация
    private String specification;

    //SWDrawing
    private String swDrawing;

    //Статус сборки
    @Enumerated(EnumType.STRING)
    private AssemblyStatus status;
}
