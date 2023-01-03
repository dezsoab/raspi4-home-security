package com.dezsobinder.raspimotionapi.repository;

import com.dezsobinder.raspimotionapi.entity.MotionEvent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class MotionEventRepositoryTest {
    @Autowired
    private MotionEventRepository motionEventRepository;
    @Autowired
    private TestEntityManager entityManager;

    private MotionEvent persist;

    @BeforeEach
    void setUp() {
        MotionEvent motionEvent = MotionEvent.builder()
                .date(Timestamp.valueOf(LocalDateTime.of(2023, 1, 3, 12, 0)))
                .build();

        persist = entityManager.persist(motionEvent);
    }

    @Test
    @DisplayName("When find by id then return motion event")
    void findById() {
        MotionEvent event = motionEventRepository.findById(persist.getId()).get();
        assertEquals(persist.getDate(), event.getDate());
    }
}
