package com.dezsobinder.raspimotionapi.controller;

import com.dezsobinder.raspimotionapi.entity.MotionEvent;
import com.dezsobinder.raspimotionapi.service.MotionEventService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(MotionEventController.class)
class MotionEventControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MotionEventService motionEventService;

    private MotionEvent motionEvent;

    @BeforeEach
    void setUp() {
        motionEvent = MotionEvent.builder()
                .id(1L)
                .date(Timestamp.valueOf(LocalDateTime.of(2023, 1, 3, 12, 0)))
                .build();
    }

    @Test
    void getAllEvents() throws Exception {
        Mockito.when(motionEventService.getAllEvents()).thenReturn(List.of(motionEvent));
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/all")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id").value(motionEvent.getId()));
    }

    @Test
    void getEventsWithLimit() throws Exception {
        Mockito.when(motionEventService.getEventsWithLimit(0, 1)).thenReturn(List.of(motionEvent));
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/pageable?page=0&limit=1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id").value(motionEvent.getId()));
    }
}
