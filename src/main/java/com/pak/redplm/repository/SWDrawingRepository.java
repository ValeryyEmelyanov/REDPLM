package com.pak.redplm.repository;

import com.pak.redplm.entity.SWDrawing;
import com.pak.redplm.entity.SWPart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/* User Flow: CRUD

 */

public interface SWDrawingRepository extends JpaRepository<SWDrawing, Long> {

    //Find
    Optional<SWDrawing> findById (Long id);
    Optional<SWDrawing> findByDecimalNumber (String decimalNumber);
    Optional<SWDrawing> findByName (String name);
    List<SWDrawing> findByIdBetween(Long startId, Long endId);

    //Delete
    void deleteByDecimalNumber (String decimalNumber);
    void deleteById (Long id);
    void deleteByName (String name);

}
