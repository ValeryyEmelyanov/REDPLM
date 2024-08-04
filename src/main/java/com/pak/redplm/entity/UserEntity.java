package com.pak.redplm.entity;

import com.pak.redplm.entity.enumClasses.ERole;
import com.pak.redplm.entity.enumClasses.EUserDepartment;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Entity
@Getter
@Setter
@Table(name = "UserEntity")
@AllArgsConstructor
@NoArgsConstructor
@ToString
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
    @Column(name = "user_department")
    private EUserDepartment userDepartment;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private ERole role = ERole.USER_ROLE;
}
