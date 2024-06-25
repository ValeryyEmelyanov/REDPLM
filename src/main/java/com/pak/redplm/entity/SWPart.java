package com.pak.redplm.entity;

import com.pak.redplm.entity.enumClasses.EProductionMethod;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.util.List;

/* User Flow: единичная деталь, параметры должны совпадать с 1С
 */

@Entity
@Data
@Table(name = "Parts")
public class SWPart {

    // Идентификатор сбокри
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Quantity in stock cannot be null")
    @Min(value = 0, message = "Quantity in stock cannot be negative")
    private Integer quantityInStock;

    //Децемальный номер - Альтернативный составной ключ
    @Pattern(regexp = "^RED\\..*", message = "Decimal number must start with 'RED.'")
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
