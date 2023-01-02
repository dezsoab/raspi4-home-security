package com.dezsobinder.raspimotiondetector.observer;

import com.dezsobinder.raspimotiondetector.service.MotionEventService;
import com.pi4j.Pi4J;
import com.pi4j.context.Context;
import com.pi4j.io.gpio.digital.DigitalInput;
import com.pi4j.io.gpio.digital.PullResistance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SecurityObserver {
    @Autowired
    private MotionEventService motionEventService;

    public void observe() {
        Context pi4j = Pi4J.newAutoContext();

        var sensorConfig = DigitalInput.newConfigBuilder(pi4j)
                .id("Sensor")
                .name("BL412 PIR Sensor")
                .address(27)
                .pull(PullResistance.PULL_DOWN)
                .provider("pigpio-digital-input");
        var sensor = pi4j.create(sensorConfig);

        saveEventOnMotion(sensor);
    }

    private void saveEventOnMotion(DigitalInput sensor) {
        sensor.addListener(e -> {
            if (e.state().isHigh()) {
                motionEventService.saveEvent();
            }
        });
    }
}
