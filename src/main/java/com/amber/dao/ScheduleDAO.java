package com.amber.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import com.amber.Details;

public class ScheduleDAO {

	DAOConenction connection;

	public ScheduleDAO() {
		connection = new DAOConenction();
	}

	public void getSchedule() throws Exception {

		Connection con = connection.getConnection();
		String query = "select Name,Work from dailydetails";
		Statement stmt = con.createStatement();
		ResultSet result = stmt.executeQuery(query);
		List oldTask = new LinkedList();
		while (result.next()) {
			String name = result.getString(1);
			String work = result.getString(2);
			Details details = new Details(name, work);
			oldTask.add(details);
		}
		getTodayTask(oldTask);
	}

	public void getTodayTask(List oldTask) throws Exception {
		List newTask = new LinkedList();
		for (int i = 1; i <= oldTask.size(); i++) {
			Details detail = (Details) oldTask.get(i-1);
			String name = detail.getName();

			if (i == oldTask.size()) {
				// Last Row Update to first row
				String updateQuery = "UPDATE dailydetails SET Name=? where Workid=?";
				Connection con = connection.getConnection();
				PreparedStatement ps = con.prepareStatement(updateQuery);
				ps.setString(1, name);
				ps.setInt(2, 1);
				ps.executeUpdate();
			} else {
				String updateQuery = "UPDATE dailydetails SET Name=? where Workid=?";
				Connection con = connection.getConnection();
				PreparedStatement ps = con.prepareStatement(updateQuery);
				int move = i+1;
				ps.setString(1, name);
				ps.setInt(2, move);
				ps.executeUpdate();
			}
		}
	}
	
	public List getScheduleToSend()throws Exception{
		Connection con = connection.getConnection();
		String query = "select Name,Work from dailydetails";
		Statement stmt = con.createStatement();
		ResultSet result = stmt.executeQuery(query);
		List newTask = new LinkedList();
		while (result.next()) {
			String name = result.getString(1);
			String work = result.getString(2);
			Details details = new Details(name, work);
			newTask.add(details);
		}
		return newTask;
	}
}
