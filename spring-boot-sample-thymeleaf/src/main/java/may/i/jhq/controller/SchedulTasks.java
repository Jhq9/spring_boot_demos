package may.i.jhq.controller;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by jinhuaquan on 2017/6/21.
 */
@Component
public class SchedulTasks {

    @Scheduled(fixedRate = 5000)
    public void reportTime(){
        System.out.println("Current Time is "+System.currentTimeMillis());
    }

}
