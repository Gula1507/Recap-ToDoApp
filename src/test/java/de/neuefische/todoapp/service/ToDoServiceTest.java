package de.neuefische.todoapp.service;

import de.neuefische.todoapp.model.ToDo;
import de.neuefische.todoapp.model.ToDoDTO;
import de.neuefische.todoapp.repository.ToDoRepository;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ToDoServiceTest {
    ToDoRepository mockRepo = mock(ToDoRepository.class);
    IdService mockIdService = mock(IdService.class);
    ToDoService toDoService = new ToDoService(mockRepo, mockIdService);

    @Test
    void findAll_shouldReturnEmptyList() {
        //GIVEN
        List<ToDo> expected = List.of();
        when(mockRepo.findAll()).thenReturn(List.of());
        //WHEN
        List<ToDo> actual = toDoService.findAll();
        //THEN
        assertEquals(expected, actual);
        verify(mockRepo).findAll();
    }

    @Test
    void save_shouldReturnEmptyToDo_whenToDoDTOEmpty() {
        //GIVEN
        ToDoDTO newToDoDTO = new ToDoDTO(null, null);
        ToDo expected = new ToDo(null, null, "123");
        //WHEN
        when(mockRepo.save(expected)).thenReturn(expected);
        when(mockIdService.generateRandomId()).thenReturn("123");
        //THEN
        assertEquals(expected, toDoService.save(newToDoDTO));
        verify(mockRepo).save(expected);
        verify(mockIdService).generateRandomId();

    }

    @Test
    void deleteToDoById_shouldReturnTrue_whenCalledWithValidId() {
        //GIVEN
        String id = "1";
        when(mockRepo.existsById(id)).thenReturn(true);
        //THEN
        assertTrue(toDoService.deleteToDoById(id));
        verify(mockRepo).deleteById(id);
        verify(mockRepo).existsById(id);
    }

}