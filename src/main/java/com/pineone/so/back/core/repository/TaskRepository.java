package com.pineone.so.back.core.repository;

import com.pineone.so.back.core.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by existmaster on 2015. 9. 10..
 */
public interface TaskRepository extends JpaRepository<Task, Integer> {
}
