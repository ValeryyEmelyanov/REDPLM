package com.pak.redplm.entity;

import com.pak.redplm.entity.enumClasses.EPriorityLevel;
import com.pak.redplm.entity.enumClasses.ETaskStatus;
import jakarta.persistence.*;

import java.time.LocalDateTime;

public class TaskForYoutrack {
    // Идентификатор сбокри. RED....
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    @Enumerated(EnumType.STRING)
    private ETaskStatus status;
    @Enumerated(EnumType.STRING)
    private EPriorityLevel priority;
    @ManyToOne
    private UserEntity assignedTo;
    private LocalDateTime createdDate;
    private LocalDateTime deadline;
}
