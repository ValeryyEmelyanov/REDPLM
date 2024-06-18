package com.pak.redplm.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
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

    @NotEmpty(message = "Name cannot be empty")
    private String name;

    @NotEmpty(message = "Content cannot be empty")
    private String content;

    @Pattern(regexp = "^RED\\..*", message = "Decimal number must start with 'RED.'")
    private String decimalNumber;

    @OneToOne
    @JoinColumn(name = "swAssembly_id")
    private SWAssembly swAssembly;
}
