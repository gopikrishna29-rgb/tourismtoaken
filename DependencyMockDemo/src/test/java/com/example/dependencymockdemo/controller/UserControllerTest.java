
package com.example.dependencymockdemo.controller;

import com.example.dependencymockdemo.model.User;
import com.example.dependencymockdemo.service.UserService;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@WebMvcTest(UserController.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private UserService userService;

    @Test
    public void testGetUser() throws Exception {

        User mockUser = new User(
            1,
            "Gopi",
            "gopi@gmail.com"
        );

        when(userService.getUserById(1))
            .thenReturn(mockUser);

        mockMvc.perform(get("/users/1"))

            .andExpect(status().isOk())

            .andExpect(jsonPath("$.id").value(1))
            .andExpect(jsonPath("$.name").value("Gopi"))
            .andExpect(jsonPath("$.email").value("gopi@gmail.com"));

        verify(userService).getUserById(1);
    }
}
