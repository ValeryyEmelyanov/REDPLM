package com.pak.redplm.repository;

import com.pak.redplm.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/* User Flow: CRUD
 */

public interface UserEntityRepository extends JpaRepository<UserEntity, Long> {
}

