package com.pak.redplm.repository;

import com.pak.redplm.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    //Find
    Optional<UserEntity> findById (Long id);
    Optional<UserEntity> findByFirstname (String firstname);
    Optional<UserEntity> findByLastname (String lastname);
    Optional<UserEntity> findByEmail (String email);
    List<UserEntity> findByIdBetween(Long startId, Long endId);

    //Delete
    void deleteById (Long id);
    void deleteByEmail (String email);

    boolean existsByEmail(String email);
}
