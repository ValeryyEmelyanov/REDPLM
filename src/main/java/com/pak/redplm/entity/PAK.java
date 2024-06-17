package com.pak.redplm.entity;

import jakarta.persistence.*;
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

    private String name;

    private LocalDateTime assemblyStartDate;

    private LocalDateTime assemblyEndDate;

    private BigDecimal cost;

    //Одная сборка RED.000 - является ПАКом
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "swAssembly_id")
    private SWAssembly swAssembly;
}
