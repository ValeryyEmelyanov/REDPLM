package com.pak.redplm.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "Drawing")
public class SWDrawing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String title;

    //Децемальный номер чертежа
    private String decimalNumber;

    @OneToOne(mappedBy = "swDrawing")
    private SWAssembly swAssembly;

    @OneToOne(mappedBy = "swDrawing")
    private SWPart swPart;
}
