package de.neuefische.todoapp.service;

import de.neuefische.todoapp.model.ToDo;
import de.neuefische.todoapp.model.ToDoDTO;
import de.neuefische.todoapp.repository.ToDoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class ToDoService {
    private final ToDoRepository toDoRepository;
    private final IdService idService;

    public List<ToDo> findAll() {
        return toDoRepository.findAll();
    }

    public ToDo save(ToDoDTO newToDoDTO) {
        ToDo newToDo = new ToDo(newToDoDTO.description(),
                newToDoDTO.status(),
                idService.generateRandomId());
        toDoRepository.save(newToDo);
        return newToDo;
    }

    public ToDo getToDoById(String id) {
        return toDoRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("There is no ToDo with id: " + id));
    }

    public ToDo updateToDoById(String id, ToDoDTO newToDoDTO) {
        if (toDoRepository.existsById(id)) {
            ToDo updatedToDo = new ToDo(newToDoDTO.description(),
                    newToDoDTO.status(), id);
            toDoRepository.save(updatedToDo);
            return getToDoById(id);
        } else {
            throw new NoSuchElementException("There is no ToDo with id: " + id);
        }
    }

    public boolean deleteToDoById(String id) {
        if (toDoRepository.existsById(id)) {
            toDoRepository.deleteById(id);
            return true;
        } else {
            throw new NoSuchElementException("There is no ToDo with id: " + id);

        }
    }
}
