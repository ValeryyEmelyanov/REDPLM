package com.pak.redplm.entity;

import com.pak.redplm.entity.enumClasses.EPriorityLevel;
import com.pak.redplm.entity.enumClasses.ETaskStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.util.List;

import java.time.LocalDateTime;

    /* User Flow: Задача, устанавливаемая в YouTrack параметры задачи должны совпадать.
    Задачи по сборке генерируются в backlog по отвественным отделам
    Изменяемый статус задачи
         */

@Entity
@Data
@Table(name = "Tasks")
public class TaskForYoutrack {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Title cannot be empty")
    private String title;

    @NotEmpty(message = "Description cannot be empty")
    private String description;

    @Enumerated(EnumType.STRING)
    private ETaskStatus status;

    @Enumerated(EnumType.STRING)
    private EPriorityLevel priority;

    @ManyToOne
    @JoinColumn(name = "pak_id")
    private PAK pak;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "swAssembly_id")
    private SWAssembly swAssembly;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "swPart_id")
    private SWPart swPart;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "container_id")
    private StorageContainer storageContainer;

    @ManyToMany
    @JoinTable(
            name = "task_users",
            joinColumns = @JoinColumn(name = "task_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<UserEntity> assignedTo;

    @ManyToMany
    @JoinTable(
            name = "task_purchased_products",
            joinColumns = @JoinColumn(name = "task_id"),
            inverseJoinColumns = @JoinColumn(name = "purchased_product_id"))
    private List<PurchasedProduct> purchasedProducts;

    @ManyToMany
    @JoinTable(
            name = "task_sw_assemblies",
            joinColumns = @JoinColumn(name = "task_id"),
            inverseJoinColumns = @JoinColumn(name = "sw_assembly_id"))
    private List<SWAssembly> swAssemblies;

    @ManyToMany
    @JoinTable(
            name = "task_sw_parts",
            joinColumns = @JoinColumn(name = "task_id"),
            inverseJoinColumns = @JoinColumn(name = "sw_part_id"))
    private List<SWPart> swParts;

    @NotNull(message = "Created date cannot be null")
    private LocalDateTime createdDate;

    @NotNull(message = "Deadline cannot be null")
    private LocalDateTime deadline;

}
