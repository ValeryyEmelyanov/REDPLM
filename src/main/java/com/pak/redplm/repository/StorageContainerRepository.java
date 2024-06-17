package com.pak.redplm.repository;

import com.pak.redplm.entity.StorageContainer;
import org.springframework.data.jpa.repository.JpaRepository;

/* User Flow: CRUD
              связь с тасками
 */

public interface StorageContainerRepository extends JpaRepository<StorageContainer, Long> {
}
