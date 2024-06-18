package com.pak.redplm.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

/* User Flow: Отображает изделия, не входящее в производство собственными мощностями организации
     */

@Entity
@Data
@Table(name = "Purchased Product")
public class PurchasedProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Name cannot be empty")
    private String name;

    @NotEmpty(message = "Purchase code cannot be empty")
    private String purchaseCode;

    @NotNull(message = "Quantity in stock cannot be null")
    @Min(value = 0, message = "Quantity in stock cannot be negative")
    private Integer quantityInStock;

    @ManyToMany(mappedBy = "purchasedParts")
    private List<SWAssembly> swAssemblys;
}