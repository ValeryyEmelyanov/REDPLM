package com.pak.redplm.entity;

import com.pak.redplm.entity.enumClasses.EUserDepartment;
import com.pak.redplm.entity.enumClasses.EUserRole;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import java.util.List;

/* User Flow: Роли пользователей соответствующие отделам
 */

@Entity
@Data
@Table(name="Users")

public class UserEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "First name cannot be empty")
    private String firstname;

    @NotEmpty(message = "Last name cannot be empty")
    private String lastname;

    @NotEmpty(message = "Email cannot be empty")
    @Email(message = "Email should be valid")
    private String email;

    @NotEmpty(message = "Password cannot be empty")
    private String password;

    @Enumerated(EnumType.STRING)
    private EUserDepartment userDepartment;

    @Enumerated(EnumType.STRING)
    private EUserRole User_role;

    @ManyToMany(mappedBy = "assignedTo")
    private List<TaskForYoutrack> tasks;
}
