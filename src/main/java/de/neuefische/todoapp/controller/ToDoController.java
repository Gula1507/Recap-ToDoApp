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

}
