package com.dezsobinder.raspimotionapi.service;

import com.dezsobinder.raspimotionapi.entity.MotionEvent;
import com.dezsobinder.raspimotionapi.repository.MotionEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MotionEventServiceImpl implements MotionEventService {
    @Autowired
    private MotionEventRepository repository;

    @Override
    public List<MotionEvent> getAllEvents() {
        return repository.findAll(Sort.by("id").descending());
    }

    @Override
    public List<MotionEvent> getEventsWithLimit(int page, int limit) {
        Pageable pageable = PageRequest.of(page, limit, Sort.by("id").descending());
        return repository.findAll(pageable).getContent();
    }
}
