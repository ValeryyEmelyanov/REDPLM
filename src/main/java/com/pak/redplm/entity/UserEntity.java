package com.pak.redplm.entity;

import com.pak.redplm.entity.enumClasses.EUserRole;
import jakarta.persistence.*;
import lombok.Data;
@Entity
@Data
@Table(name="userEntity")

public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String password;
    private EUserRole role = EUserRole.ROLE_USER;
}
