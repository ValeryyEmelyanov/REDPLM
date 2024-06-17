package com.pak.redplm.repository;

import com.pak.redplm.entity.SWPart;
import org.springframework.data.jpa.repository.JpaRepository;

/* User Flow: CRUD
                Прсомотр в окне интерфейса сборщика
 */

public interface SWPartRepository extends JpaRepository<SWPart, Long> {
}
