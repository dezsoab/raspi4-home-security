# raspi4-home-security
Home security application to detect and document movement events in the apartment.


![image](https://user-images.githubusercontent.com/75616496/210272576-dedb4333-fa6e-47b2-832a-5fa1f2be1cc8.png)

 ## How does the system work
 
First we initialize connection with the Raspberry Pi
 
      2023-01-02T19:33:08.336Z  INFO 8944 --- [           main] c.p.p.impl.DefaultRuntimePlatforms       : adding platform to managed platform map               [id=raspberrypi; name=RaspberryPi Platform; priority=5; class=com.pi4j.plugin.raspberrypi.platform.RaspberryPiPlatform]
 
BL412 PIR Sensor is used on RPI4 GPIO pins to detect motion. When the flowing current in the circuit changes, we know that motion event is detected and we save the event into the database.
 
![IMG_8717](https://user-images.githubusercontent.com/75616496/210273018-3a6f1fef-b218-44ef-8130-7166bcabaa66.jpg)

      
      Hibernate: insert into motion_event (date) values (?)

      2023-01-02T19:33:19.268Z  INFO 8944 --- [       Thread-1] c.d.r.service.MotionEventServiceImpl     : Event #329 is saved to the DB @2023-01-02             19:33:19.175
    
REST endpoint is then used to serve the collected data which is fetched on the client to display the data in the browser.
