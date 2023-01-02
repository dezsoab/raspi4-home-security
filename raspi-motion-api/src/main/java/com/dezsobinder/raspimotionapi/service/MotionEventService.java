package com.dezsobinder.raspimotionapi.service;

import com.dezsobinder.raspimotionapi.entity.MotionEvent;

import java.util.List;

public interface MotionEventService {
    List<MotionEvent> getAllEvents();

    List<MotionEvent> getEventsWithLimit(int page, int limit);
}
