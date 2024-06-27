package com.pak.redplm.repository;

import com.pak.redplm.entity.PurchasedProduct;
import com.pak.redplm.entity.SWPart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/* User Flow: CRUD

 */

public interface PurchasedProductRepository extends JpaRepository<PurchasedProduct, Long> {

    //Find
    Optional<PurchasedProduct> findById (Long id);
    Optional<PurchasedProduct> findByDecimalNumber (String decimalNumber);
    Optional<PurchasedProduct> findByName (String name);
    List<PurchasedProduct> findByIdBetween(Long startId, Long endId);

    //Delete
    void deleteByDecimalNumber (String decimalNumber);
    void deleteById (Long id);
    void deleteByName (String name);

}
