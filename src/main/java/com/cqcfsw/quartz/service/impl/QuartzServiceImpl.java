package com.cqcfsw.quartz.service.impl;

import com.cqcfsw.quartz.QuartzJob.QuartzDemo;
import com.cqcfsw.quartz.service.api.QuartzService;
import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.TriggerBuilder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
/**
 * @author baofengxueque
 * @create 2020-06-04-10:08
 */
@Service
public class QuartzServiceImpl implements QuartzService {

    @Resource
    private Scheduler scheduler;

    /**
     * 新增一个定时任务
     * @param jName 任务名称
     * @param jGroup 任务组
     * @param tName 触发器名称
     * @param tGroup 触发器组
     * @param cron cron表达式
     */
    @Override
    public void addJob(String jName, String jGroup, String tName, String tGroup, String cron) {
        try {
            JobDetail jobDetail = JobBuilder.newJob(QuartzDemo.class)
                    .withIdentity(jName, jGroup)
                    .build();
            CronTrigger trigger = TriggerBuilder.newTrigger()
                    .withIdentity(tName, tGroup)
                    .startNow()
                    .withSchedule(CronScheduleBuilder.cronSchedule(cron))
                    .build();
            scheduler.start();
            scheduler.scheduleJob(jobDetail, trigger);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 暂停定时任务
     * @param jName 任务名
     * @param jGroup 任务组
     */
    @Override
    public void pauseJob(String jName, String jGroup) {
        try {
            scheduler.pauseJob(JobKey.jobKey(jName, jGroup));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 继续定时任务
     * @param jName 任务名
     * @param jGroup 任务组
     */
    @Override
    public void resumeJob(String jName, String jGroup) {
        try {
            scheduler.resumeJob(JobKey.jobKey(jName, jGroup));
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    /**
     * 删除定时任务
     * @param jName 任务名
     * @param jGroup 任务组
     */
    @Override
    public void deleteJob(String jName, String jGroup) {
        try {
            scheduler.deleteJob(JobKey.jobKey(jName, jGroup));
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }
}
