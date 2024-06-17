package com.pak.redplm.repository;

import com.pak.redplm.entity.PAK;
import org.springframework.data.jpa.repository.JpaRepository;

/* User Flow: CRUD
              Основная задача класса, при добавлении сущности - генерация задач с учетом наличия детайлей на складе
 */

public interface PAKRepository extends JpaRepository<PAK, Long> {
}