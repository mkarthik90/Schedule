package com.amber;

import java.util.List;

import com.amber.dao.ScheduleDAO;
import com.email.SendEmail;

public class DailySchedule {

	/**
	 * @param args
	 */
	public  static void main(String[] arr) {
		// TODO Auto-generated method stub
		//A -> Vegetables + Rice
		//B -> Sambar
		//C -> Cleaning
		//D -> Free
		//E -> Free
		
		ScheduleDAO dao = new ScheduleDAO();
		try{
		dao.getSchedule();
		List toSend = dao.getScheduleToSend();
		SendEmail emailSender = new SendEmail();
		
		for(int i=0;i<toSend.size();i++){
			Details detail = (Details)toSend.get(i);
			emailSender.sendEmailToAll(detail.getName(), detail.getWork());
		}
		
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		
		
	}

}
