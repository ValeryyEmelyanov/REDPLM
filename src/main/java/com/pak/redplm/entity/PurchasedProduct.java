package com.pak.redplm.entity;

import jakarta.persistence.*;
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

    private String name;

    private String purchaseCode;

    private Integer quantityInStock;

    @ManyToMany(mappedBy = "purchasedParts")
    private List<SWAssembly> swAssemblys;
}