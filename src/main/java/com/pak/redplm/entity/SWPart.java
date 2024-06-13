package com.pak.redplm.entity;

import com.pak.redplm.entity.enumClasses.AssemblyStatus;
import jakarta.persistence.*;


public class SWPart {

    // Идентификатор сбокри. RED....
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //Децемальник
    private String decemalNumber;

    //SWDrawing
    private String swDrawing;

    //Статус сборки
    @Enumerated(EnumType.STRING)
    private AssemblyStatus status;
}
