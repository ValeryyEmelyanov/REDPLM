package com.pak.redplm.repository;

import com.pak.redplm.entity.PAK;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/* User Flow: CRUD
              Основная задача класса, при добавлении сущности - генерация задач с учетом наличия детайлей на складе
 */

public interface PAKRepository extends JpaRepository<PAK, Long> {
    //Find
    Optional<PAK> findById (Long id);
    Optional<PAK> findByName (String name);
    List<PAK> findByIdBetween(Long startId, Long endId);

    //Delete
    void deleteById (Long id);
    void deleteByName (String name);
}
