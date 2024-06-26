package com.pak.redplm.repository;

import com.pak.redplm.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/* User Flow: CRUD
 */

public interface UserEntityRepository extends JpaRepository<UserEntity, Long> {

    //Find
    Optional<UserEntity> findById (Long id);
    Optional<UserEntity> findByFirstname (String firstname);
    Optional<UserEntity> findByLastname (String lastname);
    Optional<UserEntity> findByEmail (String email);
    List<UserEntity> findByIdBetween(Long startId, Long endId);

    //Delete
    void deleteById (Long id);
    void deleteByFirstname (String firstname);
    void deleteByLastname (String lastname);
    void deleteByEmail (String email);

}
