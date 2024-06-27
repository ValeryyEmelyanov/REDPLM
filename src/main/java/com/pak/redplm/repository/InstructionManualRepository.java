package com.pak.redplm.repository;

import com.pak.redplm.entity.InstructionManual;
import com.pak.redplm.entity.SWPart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface InstructionManualRepository extends JpaRepository<InstructionManual, Long> {

    //Find
    Optional<InstructionManual> findById (Long id);
    Optional<InstructionManual> findByDecimalNumber (String decimalNumber);
    Optional<InstructionManual> findByName (String name);
    List<InstructionManual> findByIdBetween(Long startId, Long endId);

    //Delete
    void deleteByDecimalNumber (String decimalNumber);
    void deleteById (Long id);
    void deleteByName (String name);

}
