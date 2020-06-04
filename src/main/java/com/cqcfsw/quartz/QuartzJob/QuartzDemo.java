package com.cqcfsw.quartz.QuartzJob;

import com.cqcfsw.quartz.service.UserService;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import javax.annotation.Resource;
import java.time.LocalDateTime;

/**
 * @author baofengxueque
 * @create 2020-06-03-11:09
 */
@DisallowConcurrentExecution //禁止并发
public class QuartzDemo implements Job {
    @Resource
    private UserService userService;

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
       /* try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        System.out.println(LocalDateTime.now());
        this.userService.addUser();
    }
}
