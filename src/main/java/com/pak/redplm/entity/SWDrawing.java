package com.pak.redplm.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Entity
@Data
@Table(name = "Drawing")
public class SWDrawing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Name cannot be empty")
    private String name;

    @NotEmpty(message = "Title cannot be empty")
    private String title;

    //Децемальный номер чертежа
    @Pattern(regexp = "^RED\\..*", message = "Decimal number must start with 'RED.'")
    private String decimalNumber;

    @OneToOne(mappedBy = "swDrawing")
    private SWAssembly swAssembly;

    @OneToOne(mappedBy = "swDrawing")
    private SWPart swPart;
}
