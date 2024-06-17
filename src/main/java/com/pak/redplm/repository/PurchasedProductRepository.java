package com.pak.redplm.repository;

import com.pak.redplm.entity.PurchasedProduct;
import org.springframework.data.jpa.repository.JpaRepository;

/* User Flow: CRUD

 */

public interface PurchasedProductRepository extends JpaRepository<PurchasedProduct, Long> {
}
