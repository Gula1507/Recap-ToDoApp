package de.neuefische.todoapp.service;

import de.neuefische.todoapp.model.ToDo;
import de.neuefische.todoapp.model.ToDoDTO;
import de.neuefische.todoapp.repository.ToDoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ToDoService {
    private final ToDoRepository toDoRepository;
    private final IdService idService;

    public List<ToDo> findAll() {
       return toDoRepository.findAll();
    }

    public ToDo save(ToDoDTO newToDoDTO) {
        ToDo newToDo=new ToDo(newToDoDTO.description(),
                newToDoDTO.status(),
        idService.generateRandomId());
        toDoRepository.save(newToDo);
        return newToDo;
    }
}
