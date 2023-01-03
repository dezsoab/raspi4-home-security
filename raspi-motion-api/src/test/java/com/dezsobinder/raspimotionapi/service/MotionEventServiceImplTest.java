package com.dezsobinder.raspimotionapi.service;

import com.dezsobinder.raspimotionapi.entity.MotionEvent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MotionEventServiceImplTest {
    @MockBean
    private MotionEventService motionEventService;

    private List<MotionEvent> events;

    @BeforeEach
    void setUp() {
        MotionEvent event1 = MotionEvent.builder()
                .id(1L)
                .date(Timestamp.valueOf(LocalDateTime.now()))
                .build();

        MotionEvent event2 = MotionEvent.builder()
                .id(2L)
                .date(Timestamp.valueOf(LocalDateTime.now()))
                .build();

        events = List.of(event1, event2);
    }

    @Test
    @DisplayName("Fetch all events")
    void fetchesAllEvents() {
        Mockito.when(motionEventService.getAllEvents()).thenReturn(events);
        assertEquals(2, motionEventService.getAllEvents().size());
    }

    @Test
    @DisplayName("Get motion events by requested page / limit")
    void getEventsWithLimit() {
        int page = 0;
        int limit = 1;
        Mockito.when(motionEventService.getEventsWithLimit(page, limit)).thenReturn(events.subList(page, page + limit));
        assertEquals(1, motionEventService.getEventsWithLimit(page, limit).size());
    }
}
