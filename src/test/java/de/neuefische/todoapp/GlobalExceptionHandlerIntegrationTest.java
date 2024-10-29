package de.neuefische.todoapp;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
class GlobalExceptionHandlerIntegrationTest {
    @Autowired
    private MockMvc mvc;

    @Test
    void handleNoSuchElementException_WhenDeleteAndIdNotExist_ReturnCustomMessageFromToDoService() throws Exception {
        mvc.perform(MockMvcRequestBuilders.delete("/api/todo/151"))
                .andExpect(MockMvcResultMatchers.status().isNotFound())
                .andExpect(MockMvcResultMatchers.content().json("""
                         {
                                              "text": "There is no ToDo to delete with id: 151"
                                          }
                        """
                ));
    }

    @Test
    void handleNoSuchElementException_WhenGetAndIdNotExist_ReturnCustomMessageFromToDoService() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/api/todo/888"))
                .andExpect(MockMvcResultMatchers.status().isNotFound())
                .andExpect(MockMvcResultMatchers.content().json("""
                         {
                                              "text": "Can´t get ToDo because id not exist. Id: 888"
                                          }
                        """
                ));
    }
}