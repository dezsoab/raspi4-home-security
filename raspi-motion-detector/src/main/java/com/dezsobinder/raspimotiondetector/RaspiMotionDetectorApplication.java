package com.dezsobinder.raspimotiondetector;

import com.dezsobinder.raspimotiondetector.observer.SecurityObserver;
import com.pi4j.util.Console;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RaspiMotionDetectorApplication {

    private static SecurityObserver observer;
    @Autowired
    private SecurityObserver observerPlaceholder;

    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(RaspiMotionDetectorApplication.class, args);
        observer.observe();
        new Console().waitForExit();
    }

    @PostConstruct
    private void initObserver() {
        observer = this.observerPlaceholder;
    }
}
