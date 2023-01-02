package com.dezsobinder.raspimotionapi.repository;

import com.dezsobinder.raspimotionapi.entity.MotionEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MotionEventRepository extends JpaRepository<MotionEvent, Long> {
}
