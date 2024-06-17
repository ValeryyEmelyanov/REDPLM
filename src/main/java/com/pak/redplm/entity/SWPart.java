package com.pak.redplm.entity;

import com.pak.redplm.entity.enumClasses.EProductionMethod;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "Parts")
public class SWPart {
    /* User Flow: единичная деталь, параметры должны совпадать с 1С
         */

    // Идентификатор сбокри
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer quantityInStock;

    //Децемальный номер - Альтернативный составной ключ
    private String decimalNumber;

    //Наименование детали
    private String name;

    // Чертеж
    @OneToOne
    @JoinColumn(name = "drawing_id")
    private SWDrawing swDrawing;

    //Вхождение в сборку
    @ManyToMany(mappedBy = "components")
    private List<SWAssembly> swAssemblies;

    //Статус сборки
    @Enumerated(EnumType.STRING)
    private EProductionMethod status;
}
