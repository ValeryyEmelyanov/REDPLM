package com.pak.redplm.repository;

import com.pak.redplm.entity.InstructionManual;
import org.springframework.data.jpa.repository.JpaRepository;

    /* User Flow: CRUD
                  В дополнениях нужно мочь выгрузить рисунок в интерфейс, с возможностью рисовать на нем,
                  с учетом внесенных кривых обновленный PDF отправить обратной связью КБ
        */

public interface InstructionManualRepository extends JpaRepository<InstructionManual, Long> {



}
