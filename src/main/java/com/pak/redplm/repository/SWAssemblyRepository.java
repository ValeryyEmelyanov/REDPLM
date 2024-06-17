package com.pak.redplm.repository;

import com.pak.redplm.entity.SWAssembly;
import org.springframework.data.jpa.repository.JpaRepository;

/* User Flow: CRUD
                Выполнение задач  по таскам
                Зависимость от версии ПАКа
                Просмотр в окне в интерфейсе сборщика
 */

public interface SWAssemblyRepository extends JpaRepository<SWAssembly, Long> {
}