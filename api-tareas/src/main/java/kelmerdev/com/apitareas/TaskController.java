package kelmerdev.com.apitareas;

import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskRepository taskRepository;

    public TaskController(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }

    @PostMapping
    public Task create(@RequestBody Task task){
        task.setCreatedAt(LocalDateTime.now());
        return taskRepository.save(task);
    }

    @GetMapping
    public List<Task> getAll(){
        return taskRepository.findAll();
    }


    @PatchMapping("/{id}")
    public Task markAsCompleted(@PathVariable Long id){
        Optional<Task> updatedTask = taskRepository.findById(id);
        if (updatedTask.isPresent()){
            Task task = updatedTask.get();
            task.setStatus(Status.COMPLETED);
            return taskRepository.save(task);
        }
        return null;
    }



    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        taskRepository.deleteById(id);
    }
}
