package com.pak.redplm.entity;

import com.pak.redplm.entity.enumClasses.ERole;
import jakarta.persistence.*;
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

//    @NotEmpty(message = "First name cannot be empty")
    private String name;

//    @NotEmpty(message = "Last name cannot be empty")
//    private String lastname;

//    @NotEmpty(message = "Email cannot be empty")
//    @Email(message = "Email should be valid")
    private String email;

//    @NotEmpty(message = "Password cannot be empty")
    private String password;

//    @Enumerated(EnumType.STRING)
//    @Column(name = "user_department")
//    private EUserDepartment userDepartment;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private ERole role = ERole.USER_ROLE;

//    @ManyToMany(mappedBy = "assignedTo")
//    private List<TaskForYoutrack> tasks;
}
