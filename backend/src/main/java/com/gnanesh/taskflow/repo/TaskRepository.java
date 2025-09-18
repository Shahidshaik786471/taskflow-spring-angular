package com.gnanesh.taskflow.repo;
import com.gnanesh.taskflow.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
public interface TaskRepository extends JpaRepository<Task, Long> {}
