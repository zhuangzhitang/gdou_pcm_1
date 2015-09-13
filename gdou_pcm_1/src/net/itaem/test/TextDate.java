package net.itaem.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import net.itaem.tool.DataBaseConnection;

public class TextDate {


	public static void main(String[] args) throws SQLException, ParseException {
		Connection conn=new DataBaseConnection().getConnection();
		String sql="select ticket_time from car_number where ticket_date=?";
		PreparedStatement pre=conn.prepareStatement(sql);
		SimpleDateFormat mat=new SimpleDateFormat("yyyy-mm-dd");
		java.util.Date date=mat.parse("2014-04-21");
		Calendar cal=Calendar.getInstance();
		cal.set(2014,04,21);
		cal.add(Calendar.MONTH,-1);
		java.util.Date date_cal=cal.getTime();
		System.out.println(new java.util.Date());
		System.out.println(date);
		System.out.println(date_cal);
		pre.setDate(1,new java.sql.Date(date_cal.getTime()));
        ResultSet res=pre.executeQuery();
        while(res.next()){
        	System.out.println(res.getString(1));
        }
	}

}
