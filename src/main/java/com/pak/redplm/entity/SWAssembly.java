package com.pak.redplm.entity;

import com.pak.redplm.entity.enumClasses.EAssemblyStatus;
import jakarta.persistence.*;
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

    private String name;

    private Integer quantityInStock;

    private String decimalNumber;

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
    private Duration estimatedTime;

    //Спецификация генерируется из входящих узлов или выкачивается с документации
    private String specification;

    @Enumerated(EnumType.STRING)
    private EAssemblyStatus status;
}
