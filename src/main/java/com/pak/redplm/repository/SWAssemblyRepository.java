package com.pak.redplm.repository;

import com.pak.redplm.entity.SWAssembly;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SWAssemblyRepository extends JpaRepository<SWAssembly, Long> {

    //Find
    Optional<SWAssembly> findById (Long id);
    Optional<SWAssembly> findByDecimalNumber (String decimalNumber);
    Optional<SWAssembly> findByName (String name);
    List<SWAssembly> findByIdBetween(Long startId, Long endId);

    //Delete
    void deleteByDecimalNumber (String decimalNumber);
    void deleteById (Long id);
    void deleteByName (String name);

}