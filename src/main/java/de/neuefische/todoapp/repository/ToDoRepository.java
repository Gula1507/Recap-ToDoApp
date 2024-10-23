package de.neuefische.todoapp.repository;

import de.neuefische.todoapp.model.ToDo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ToDoRepository extends MongoRepository<ToDo, String> {
}
