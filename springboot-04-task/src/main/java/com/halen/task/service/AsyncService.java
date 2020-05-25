package com.halen.task.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * Created By Halen 2020/5/25 9:12
 */
@Service
public class AsyncService {

    @Async
    public void hello() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("处理数据中....");
    }

}
