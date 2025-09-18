package com.gnanesh.taskflow.controller;
import com.gnanesh.taskflow.entity.Task;
import com.gnanesh.taskflow.repo.TaskRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/tasks")
@CrossOrigin(origins="*")
public class TaskController {
  private final TaskRepository repo;
  public TaskController(TaskRepository repo){this.repo=repo;}
  @GetMapping public List<Task> all(){ return repo.findAll(); }
  @PostMapping public Task create(@RequestBody Task t){ return repo.save(t); }
  @PutMapping("/{id}") public Task update(@PathVariable Long id, @RequestBody Task t){
    t = new Task(t.getTitle(), t.getStatus(), t.getAssignee());
    // naive update for brevity
    t = repo.save(t);
    return t;
  }
  @DeleteMapping("/{id}") public void delete(@PathVariable Long id){ repo.deleteById(id); }
}
