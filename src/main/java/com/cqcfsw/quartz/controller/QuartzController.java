package com.cqcfsw.quartz.controller;

import com.cqcfsw.quartz.service.api.QuartzService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author baofengxueque
 * @create 2020-06-04-10:13
 */
@RestController
public class QuartzController {

    @Resource
    private QuartzService quartzService;

    /**
     * 新增任务
     */
    @GetMapping("/insert")
    public String insertTask(String jName, String jGroup, String tName, String tGroup, String cron) {
        quartzService.addJob(jName, jGroup, tName, tGroup, cron);

        return "添加成功！";
    }

    /**
     * 暂停任务
     */
    @GetMapping("/pause")
    public String pauseTask(String jName, String jGroup) {
        quartzService.pauseJob(jName, jGroup);
        return "暂停成功！";
    }

    /**
     * 继续任务
     */
    @GetMapping("/resume")
    public String resumeTask(String jName, String jGroup) {
        quartzService.resumeJob(jName, jGroup);
        return "继续成功！";
    }

    /**
     * 删除任务
     */
    @GetMapping("/delete")
    public String deleteTask(String jName, String jGroup) {
        quartzService.deleteJob(jName, jGroup);
        return "删除成功！";
    }
}
