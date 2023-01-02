package com.dezsobinder.raspimotionapi.controller;

import com.dezsobinder.raspimotionapi.entity.MotionEvent;
import com.dezsobinder.raspimotionapi.service.MotionEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin
public class MotionEventController {
    @Autowired
    private MotionEventService service;

    @GetMapping("/all")
    public List<MotionEvent> getAllEvents() {
        return service.getAllEvents();
    }

    @GetMapping("/pageable")
    public List<MotionEvent> getEventsWithLimit(@RequestParam(value = "page", defaultValue = "0") int page,
                                                @RequestParam(value = "limit", defaultValue = "5") int limit) {
        return service.getEventsWithLimit(page, limit);
    }
}
