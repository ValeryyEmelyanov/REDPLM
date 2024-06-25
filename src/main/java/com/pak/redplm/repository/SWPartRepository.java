package com.pak.redplm.repository;

import com.pak.redplm.entity.SWPart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface SWPartRepository extends JpaRepository<SWPart, Long> {

    Optional<SWPart> findById (Long id);
    Optional<SWPart> findByDecimalNumber (String decimalNumber);
    SWPart findByName (String name);

    // Деталь должна возвращать сборки в которые она входит

}
