package com.cqcfsw.quartz.QuartzJob;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDateTime;

/**
 * @author baofengxueque
 * @create 2020-06-03-10:10
 */
//@Configuration
public class SimpleJob {
    @Scheduled(cron = "0/5 * * * * ?")
    public void run(){
        //任务
        System.out.println(LocalDateTime.now());
    }
}
