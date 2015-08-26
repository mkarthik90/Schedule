package com.scheduler;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.email.SendEmail;

public class MyQuartzJob implements Job {

	public void execute(JobExecutionContext context) throws JobExecutionException {
		/*DailySchedule dailySchedule = new DailySchedule();
		dailySchedule.generateDailySchedule();*/
		SendEmail email = new SendEmail();
		email.testing();
	}
}
