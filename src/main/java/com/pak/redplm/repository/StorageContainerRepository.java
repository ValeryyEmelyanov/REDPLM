package com.pak.redplm.repository;

import com.pak.redplm.entity.SWAssembly;
import com.pak.redplm.entity.StorageContainer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface StorageContainerRepository extends JpaRepository<StorageContainer, Long> {

    //Find
    Optional<StorageContainer> findById (Long id);
    Optional<StorageContainer> findByDecimalNumber (String decimalNumber);
    Optional<StorageContainer> findByName (String name);
    List<StorageContainer> findByIdBetween(Long startId, Long endId);

    //Delete
    void deleteByDecimalNumber (String storageContainer);
    void deleteById (Long id);
    void deleteByName (String name);

}
