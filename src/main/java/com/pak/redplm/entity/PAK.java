package com.pak.redplm.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

    /* User Flow: Является одной собранной, оттестированной стойкой, сущность для формирования бизнес логики продукта
    для обозначения временных промежутков и стадии завершения
    Соответсвует глобальной сборке SWAssembly RED.1
     */

@Entity
@Data
@Table(name = "PAK")
public class PAK {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @NotEmpty(message = "Name cannot be empty")
    private String name;

    @NotNull(message = "Assembly start date cannot be null")
    @Future(message = "date should be in the future")
    private LocalDateTime assemblyStartDate;

    @NotNull(message = "Assembly end date cannot be null")
    @Future(message = "date should be in the future")
    private LocalDateTime assemblyEndDate;

    @Positive (message = "cost cannot be negative")
    private BigDecimal cost;

    //Одная сборка RED.000 - является ПАКом
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "swAssembly_id")
    private SWAssembly swAssembly;
}
