package com.pak.redplm.repository;

import com.pak.redplm.entity.TaskForYoutrack;
import org.springframework.data.jpa.repository.JpaRepository;

/* User Flow: CRUD
                Работа с тасками
 */

public interface TaskForYoutrackRepository extends JpaRepository<TaskForYoutrack, Long> {
}
