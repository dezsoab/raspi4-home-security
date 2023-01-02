package com.dezsobinder.raspimotiondetector.repository;

import com.dezsobinder.raspimotiondetector.entity.MotionEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MotionEventRepository extends JpaRepository<MotionEvent, Long> {
}
