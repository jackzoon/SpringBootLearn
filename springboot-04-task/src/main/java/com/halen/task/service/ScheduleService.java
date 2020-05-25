package com.halen.task.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * Created By Halen 2020/5/25 9:19
 */
@Service
public class ScheduleService {

//    @Scheduled(cron = "0 * * * * MON-SAT")
    @Scheduled(cron = "0,1,2,3,4 * * * * MON-SAT")
    public void hello() {
        System.out.println("hello........");
    }

}
