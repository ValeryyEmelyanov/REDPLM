package com.pak.redplm.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

    /* User Flow: Контейнер имеет собственный идентификатор для налаживания работы склада-сборки
    Создан для сборки и транспортировки деталей
    Может содержать один или несколько SWPart или SWAssembly.
     */

@Entity
@Data
@Table(name = "Container")
public class StorageContainer {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany
    @JoinTable(
            name = "container_product",
            joinColumns = @JoinColumn(name = "container_id"),
            inverseJoinColumns = @JoinColumn(name = "part_id"))
    private List<SWPart> swParts;

    @ManyToMany
    @JoinTable(
            name = "container_assemblies",
            joinColumns = @JoinColumn(name = "container_id"),
            inverseJoinColumns = @JoinColumn(name = "assembly_id"))
    private List<SWAssembly> swAssemblies;

    @ManyToMany
    @JoinTable(
            name = "container_purchased_product",
            joinColumns = @JoinColumn(name = "container_id"),
            inverseJoinColumns = @JoinColumn(name = "purchased_product_id"))
    private List<PurchasedProduct> purchasedProducts;

    @ManyToOne
    @JoinColumn(name = "container_assigned")
    private UserEntity assignedTo;
}


