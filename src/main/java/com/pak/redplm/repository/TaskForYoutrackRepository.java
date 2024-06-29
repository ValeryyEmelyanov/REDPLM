package com.pak.redplm.repository;

import com.pak.redplm.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/* User Flow: CRUD
                Работа с тасками
 */

public interface TaskForYoutrackRepository extends JpaRepository<TaskForYoutrack, Long> {

    //Find
    Optional<TaskForYoutrack> findById (Long id);
    Optional<TaskForYoutrack> findByDescription (String description);
    Optional<TaskForYoutrack> findByStatus(String status);
    Optional<TaskForYoutrack> findByPriority (String priority);
    List<TaskForYoutrack> findByIdBetween(Long startId, Long endId);

    //Delete
    void deleteById (Long id);
    void deleteByDescription (String description);
}

