package org.mudskipper.example.quartz;

import org.mudskipper.example.utils.CronUtil;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Component;

@Component
public class SchedulerAllJob {
    @Autowired
    private SchedulerFactoryBean schedulerFactoryBean;

    public void scheduleJobs(String flag,String cron) throws SchedulerException {
        Scheduler scheduler = schedulerFactoryBean.getScheduler();
        String jobName = CronUtil.getJobName(flag);
        String triggerName = CronUtil.getTriggerName(flag);
        String groupName = CronUtil.getGroupName(flag);
        schedulerJob1(scheduler, jobName, triggerName, groupName, cron);
    }

    public void stop() throws SchedulerException {
        Scheduler scheduler = schedulerFactoryBean.getScheduler();
        scheduler.clear();
    }

    public void modifyJob(String flag, String cron) throws SchedulerException {
        String jobName = CronUtil.getJobName(flag);
        String triggerName = CronUtil.getTriggerName(flag);
        String groupName = CronUtil.getGroupName(flag);
        Scheduler scheduler = schedulerFactoryBean.getScheduler();
        TriggerKey triggerKey = new TriggerKey(triggerName, groupName);
        CronTrigger cronTrigger = (CronTrigger) scheduler.getTrigger(triggerKey);
        String oldCron = cronTrigger.getCronExpression();
        if (! oldCron.equals(cron)){
            reomveJob(flag);
            scheduleJobs(flag,cron);
        }
    }

    public void reomveJob(String flag) throws SchedulerException {
        String jobName = CronUtil.getJobName(flag);
        String triggerName = CronUtil.getTriggerName(flag);
        String groupName = CronUtil.getGroupName(flag);
        Scheduler scheduler = schedulerFactoryBean.getScheduler();
        TriggerKey triggerKey = new TriggerKey(triggerName, groupName);
        scheduler.pauseTrigger(triggerKey);
        scheduler.unscheduleJob(triggerKey);
        JobKey jobKey = new JobKey(jobName);
        scheduler.deleteJob(jobKey);
    }

    private void schedulerJob1(Scheduler scheduler, String jobName, String triggerName, String groupName, String cron) throws SchedulerException {
        JobDetail jobDetail = JobBuilder.newJob(ScheduledJob.class).withIdentity(jobName, groupName).build();
        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(cron);
        CronTrigger cronTrigger = TriggerBuilder.newTrigger().withIdentity(triggerName, groupName) .withSchedule(scheduleBuilder).build();
        scheduler.scheduleJob(jobDetail,cronTrigger);
    }
}
