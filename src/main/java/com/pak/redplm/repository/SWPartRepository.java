package com.pak.redplm.repository;

import com.pak.redplm.entity.SWPart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface SWPartRepository extends JpaRepository<SWPart, Long> {


    //Find
    Optional<SWPart> findById (Long id);
    Optional<SWPart> findByDecimalNumber (String decimalNumber);
    Optional<SWPart> findByName (String name);
    List<SWPart> findByIdBetween(Long startId, Long endId);

    //Delete
    void deleteByDecimalNumber (String decimalNumber);
    void deleteById (Long id);
    void deleteByName (String name);

    // Check existence by name
    boolean existsByName(String name);


    // Деталь должна возвращать сборки в которые она входит

}
