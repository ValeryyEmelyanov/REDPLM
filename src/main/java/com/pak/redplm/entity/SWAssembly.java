package com.pak.redplm.entity;

import com.pak.redplm.entity.enumClasses.EAssemblyStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import java.time.Duration;
import java.util.List;

/* User Flow: сборочная единица стойки
 */

@Entity
@Data
@Table(name = "Assembly")
public class SWAssembly {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Name cannot be empty")
    private String name;

    @NotNull(message = "Quantity in stock cannot be null")
    @Min(value = 0, message = "Quantity in stock cannot be negative")
    private Integer quantityInStock;

    @Pattern(regexp = "^RED\\..*", message = "Decimal number must start with 'RED.'")
    private String decimalNumber;

    //  Уйти от связей MtM через промежуточную таблицу (аналогичную той, которая создается автоматически
    //При необходимости фиксации дополнительных полей, к примеру, время заведения в БД

    //Входящие детали
    @ManyToMany
    @JoinTable(
            name = "assembly_components",
            joinColumns = @JoinColumn(name = "assembly_id"),
            inverseJoinColumns = @JoinColumn(name = "part_id"))
    private List<SWPart> components;

    //Входящие подсборки
    @ManyToMany
    @JoinTable(
            name = "assembly_subassemblies",
            joinColumns = @JoinColumn(name = "assembly_id"),
            inverseJoinColumns = @JoinColumn(name = "subassembly_id"))
    private List<SWAssembly> assemblies;

    //Входящие покупные изделия
    @ManyToMany
    @JoinTable(
            name = "assembly_purchased_components",
            joinColumns = @JoinColumn(name = "assembly_id"),
            inverseJoinColumns = @JoinColumn(name = "purchased_id"))
    private List<PurchasedProduct> purchasedParts;

    // Ссылка, документ с инструкцией
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "instruction_id")
    private InstructionManual instruction;

    // SWDrawing
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "drawing_id")
    private SWDrawing swDrawing;

    //Расчетное время сборки
    @NotEmpty(message = "time field must be filled in")
    private Duration estimatedTime;

    //Спецификация генерируется из входящих узлов или выкачивается с документации
    private String specification;

    @Enumerated(EnumType.STRING)
    private EAssemblyStatus status;
}
