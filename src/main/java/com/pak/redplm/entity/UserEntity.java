package com.pak.redplm.entity;

import com.pak.redplm.entity.enumClasses.EUserDepartment;
import com.pak.redplm.entity.enumClasses.EUserRole;
import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Data
@Table(name="Users")

public class UserEntity {
    /* User Flow: Роли пользователей соответствующие отделам

     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstname;

    private String lastname;

    private String email;

    private String password;

    @Enumerated(EnumType.STRING)
    private EUserDepartment userDepartment;

    @Enumerated(EnumType.STRING)
    private EUserRole User_role;

    @ManyToMany(mappedBy = "assignedTo")
    private List<TaskForYoutrack> tasks;
}
