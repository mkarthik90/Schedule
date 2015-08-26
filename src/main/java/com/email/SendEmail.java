package com.email;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.sendgrid.SendGrid;


public class SendEmail {

	/**
	 * @param args
	 */
	
	public void sendEmailToAll(String name,String task){
		
		SendGrid sendgrid = new SendGrid("mkarthik90", "Amber@123");
	    SendGrid.Email email = new SendGrid.Email();
	    String girishEmail = "rgirish1994@gmail.com";
	    String prashannaEmail = "prashanna.raghavan@gmail.com";
	    String[] myEmail={"mkarthik90@gmail.com","t.mohann56@gmail.com"};
	    
	    if(name.equalsIgnoreCase("girish"))
	    email.addTo(girishEmail);
	    else if(name.equalsIgnoreCase("prashana"))
	    	email.addTo(prashannaEmail);
	    else if(name.equalsIgnoreCase("manoj"))
	    	email.addTo("rmanojcit@gmail.com");
	    else if(name.equalsIgnoreCase("prashanth"))
	    	email.addTo("Prasanthpriyanesan@gmail.com");
	    else{
	    	email.addTo(myEmail);
	    }
	    email.setFrom("mkarthik90@gmail.com");
	    DateFormat df = new SimpleDateFormat("dd/MM/yy");
	    Date dateobj = new Date();
	    String todaysDate = df.format(dateobj);
	    email.setSubject(todaysDate+" Task of the DAY is "+task);
	    email.setText("Task of the DAY is "+task);	    
	 try{
		SendGrid.Response response = sendgrid.send(email);
	    System.out.println("Email Sent");
	 }
	 catch(Exception ex){
		 ex.printStackTrace();
	 }
	
		
	}
	
	public void testing(){
		SendGrid sendgrid = new SendGrid("mkarthik90", "Amber@123");
	    SendGrid.Email email = new SendGrid.Email();
	    	email.addTo("mkarthik90@gmail.com");
	    
	    email.setFrom("mkarthik90@gmail.com");
	    DateFormat df = new SimpleDateFormat("dd/MM/yy");
	    Date dateobj = new Date();
	    String todaysDate = df.format(dateobj);
	    email.setSubject(todaysDate+" Task of the DAY is ");
	    email.setText("Task of the DAY is ");	    
	 try{
		SendGrid.Response response = sendgrid.send(email);
	    System.out.println("Email Sent");
	 }
	 catch(Exception ex){
		 ex.printStackTrace();
	 }
	
		
	
	}
	
	public static void main(String[] args) {}

}
