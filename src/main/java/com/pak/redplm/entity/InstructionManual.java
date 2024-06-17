package com.pak.redplm.entity;

import jakarta.persistence.*;
import lombok.Data;

    /* User Flow: Инструкция по сборке узла, децемальный номер соответсвует узлу, с припиской Д1
    Инструкция является *предварительно PDF файлом (возможно ссылкой на базу знаний YouTrack.
    Выдается сборщику в интерфейс.
    Инструкцией обладают только сборки.
        */

@Entity
@Data
@Table(name = "Instruction")
public class InstructionManual {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String content;

    private String decimalNumber;

    @OneToOne
    @JoinColumn(name = "swAssembly_id")
    private SWAssembly swAssembly;
}
