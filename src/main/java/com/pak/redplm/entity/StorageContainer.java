package com.pak.redplm.entity;

import jakarta.persistence.*;
import java.util.List;

//Складской контейнер
public class StorageContainer {

    // Идентификатор контейнера
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Детали входящие в контейнер
    @ManyToMany //replace with identifier?
    private List<SWPart> components;

    // Детали входящие в контейнер
    @ManyToMany //replace with identifier?
    private List<SWAssembly> assemblies;

    // Выполняющий персонал
    @ManyToOne
    private UserEntity assignedTo;

    // Определиться по данным, передаваемым в таску трека
}


