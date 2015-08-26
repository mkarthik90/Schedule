package com.scheduler;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class TestScheduler {

	public static void main(String[] args)throws SchedulerException {

		JobDetail job = JobBuilder.newJob(MyQuartzJob.class).build();//mention the Job Class Name here
			       
			   
			                //create schedule builder
			  CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule("0 0/1 * 1/1 * ? *");
			   
			                //create trigger which the schedule Builder
			  Trigger trigger = TriggerBuilder
			    .newTrigger()
			    .withSchedule(scheduleBuilder)
			    .build();
			   
			        //create scheduler 
			     Scheduler scheduler = new StdSchedulerFactory().getScheduler();
			 
			        // start your scheduler
			     scheduler.start();
			      
			        // let the scheduler call the Job using trigger
			     scheduler.scheduleJob(job, trigger);
			     System.out.println("Exit");
	}

}
