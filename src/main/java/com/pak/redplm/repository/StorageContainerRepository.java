package com.pak.redplm.repository;

import com.pak.redplm.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface StorageContainerRepository extends JpaRepository<StorageContainer, Long> {

    //Find
    Optional<StorageContainer> findById (Long id);
    Optional<StorageContainer> findByName (String name);
    List<StorageContainer> findByIdBetween(Long startId, Long endId);

    //Delete
    void deleteById (Long id);
    void deleteByName (String name);

}
