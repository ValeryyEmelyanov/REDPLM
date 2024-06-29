package com.pak.redplm.repository;

import com.pak.redplm.entity.PurchasedProduct;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/* User Flow: CRUD

 */

public interface PurchasedProductRepository extends JpaRepository<PurchasedProduct, Long> {

    //Find
    Optional<PurchasedProduct> findById (Long id);
    Optional<PurchasedProduct> findByPurchaseCode (String purchaseCode);
    Optional<PurchasedProduct> findByName (String name);
    List<PurchasedProduct> findByIdBetween(Long startId, Long endId);

    //Delete
    void deleteById (Long id);
    void deleteByName (String name);
    void deleteByPurchaseCode (String purchaseCode);

}

