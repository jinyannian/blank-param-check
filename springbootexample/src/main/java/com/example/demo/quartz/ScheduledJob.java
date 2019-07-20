package com.example.demo.quartz;

import com.example.demo.utils.CronUtil;
import org.quartz.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ScheduledJob implements Job {
    private Logger logger = LoggerFactory.getLogger(ScheduledJob.class);

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        JobDetail jobDetail = jobExecutionContext.getJobDetail();
        String jobName = jobDetail.getKey().getName();
        String flag = CronUtil.getFlagByJobName(jobName);
        logger.info(flag);
    }
}
