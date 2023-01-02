package com.dezsobinder.raspimotiondetector.service;

import com.dezsobinder.raspimotiondetector.entity.MotionEvent;
import com.dezsobinder.raspimotiondetector.repository.MotionEventRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MotionEventServiceImpl implements MotionEventService {
    @Autowired
    private MotionEventRepository repository;
    private final Logger logger = LoggerFactory.getLogger(MotionEventServiceImpl.class);

    @Override
    public void saveEvent() {
        MotionEvent event = MotionEvent.builder().build();
        MotionEvent motionEvent = repository.save(event);
        String infoText = String.format("Event #%s is saved to the DB @%s", motionEvent.getId(), motionEvent.getDate());
        logger.info(infoText);
    }
}
