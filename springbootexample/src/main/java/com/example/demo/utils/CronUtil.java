package com.example.demo.utils;

public class CronUtil {

    /**
     * 创建cron表达式
     * @param month
     * @param day
     * @param hour
     * @param minute
     * @return
     */
    public static String createCron(String year, String month, String day, String hour, String minute, String second){
        return second + " " + minute + " " + hour + " " + day + " " + month + " ? " + year;
    }

    /**
     * 创建cron表达式
     * @param dateStr 2019-01-10 09:36:00
     * @return
     */
    public static String createCron(String dateStr){
        String year = dateStr.substring(0,4);
        String month = dateStr.substring(5,7);
        String day = dateStr.substring(8,10);
        String hour = dateStr.substring(11,13);
        String minute = dateStr.substring(14,16);
        String second = dateStr.substring(17,dateStr.length());
        return createCron(year, month, day, hour, minute, second);
    }
    /**
     * 获取时间表达式
     * @param cron "00 03 05 30 12 ? 2019"
     * @return ????-12-30 05:03:00
     */
    public static String getDateStr(String cron){
        return getYear(cron)+"-"+getMonth(cron)+"-"+getDay(cron)+" "+getHour(cron)+":"+getMinute(cron)+":"+getSecond(cron);
    }
    public static String getYear(String cron){
        return cron.substring(17, cron.length());
    }
    public static String getMonth(String cron){
        return cron.substring(12, 14);
    }
    public static String getDay(String cron){
        return cron.substring(9, 11);
    }
    public static String getHour(String cron){
        return cron.substring(6, 8);
    }
    public static String getMinute(String cron){
        return cron.substring(3, 5);
    }
    public static String getSecond(String cron){
        return cron.substring(0, 2);
    }
    public static void main(String[] args) {
        String cron = "44 36 09 10 01 ? 2019";
        String dateStr = "2019-01-10 09:36:44";
        System.out.println(getYear(cron));
        System.out.println(getMonth(cron));
        System.out.println(getDay(cron));
        System.out.println(getHour(cron));
        System.out.println(getMinute(cron));
        System.out.println(getDateStr(cron));
        System.out.println(createCron(dateStr));
    }

    public static String getJobName(String flag){
        return "job_name_"+flag;
    }
    public static String getTriggerName(String flag){
        return "trigger_name_"+flag;
    }
    public static String getGroupName(String flag){
        return "group_name_"+flag;
    }
    public static String getFlagByJobName(String jobName){
        return jobName.replace("job_name_","").trim();
    }
    public static String getFlagByTriggerName(String triggerName){
        return triggerName.replace("trigger_name_","").trim();
    }
    public static String getFlagByGroupName(String groupName){
        return groupName.replace("group_name_","").trim();
    }
}
