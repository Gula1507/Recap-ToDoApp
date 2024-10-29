package de.neuefische.todoapp.controller;

import de.neuefische.todoapp.model.ToDo;
import de.neuefische.todoapp.model.ToDoDTO;
import de.neuefische.todoapp.service.ToDoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/todo")
@RestController
@RequiredArgsConstructor
public class ToDoController {
    private final ToDoService toDoService;

    @GetMapping
    public List<ToDo> findAll() {
        return toDoService.findAll();
    }

    @PostMapping
    public ToDo saveToDo(@RequestBody ToDoDTO newToDoDTO) {
        return toDoService.save(newToDoDTO);}

    @GetMapping("/{id}")
    public ToDo getToDoById(@PathVariable String id) {
        return toDoService.getToDoById(id);
    }

//    public ResponseEntity<?> getToDoById(@PathVariable String id) {
//        try {
//            ToDo toDo = toDoService.getToDoById(id);
//            return ResponseEntity.ok(toDo);
//        } catch (NoSuchElementException ex) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND)
//                    .body("Error: There is no ToDo with id: " + id);
//        }
//    }

    @PutMapping("/{id}")
    public ToDo updateToDoById(@PathVariable String id, @RequestBody ToDoDTO newToDoDTO) {
        return toDoService.updateToDoById(id, newToDoDTO);
    }

    @DeleteMapping("/{id}")
    public boolean deleteToDoById(@PathVariable String id) {
        return toDoService.deleteToDoById(id);
    }
}
