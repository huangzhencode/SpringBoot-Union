package com.java.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * @author huangzhen
 * @create 2020-03-21 21:22
 */
@Service
public class ScheduleService {

    @Scheduled(cron = "1-59 * * * * ?")
    public void schedule(){
        System.out.println("schedule..............");
    }
}
