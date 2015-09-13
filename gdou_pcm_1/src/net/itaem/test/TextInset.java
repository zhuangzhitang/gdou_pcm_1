package net.itaem.test;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import net.itaem.po.Ticket;
import net.itaem.tool.DataBaseConnection;

public class TextInset {

	/**
	 * @param args
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws SQLException {
	   Ticket t=new Ticket();
	   t.setCarId(1);
		t.setUserId(1);
		t.setGocatLacation("haihai");
		t.setTicketNum(1);
		t.setTruename("zaopeng");
		t.setIdcard("172");
		t.setPhone("718");
		t.setShortphone(12123);
	   System.out.println(new TextInset().dd(t));
	}
	public boolean dd(Ticket ticket) throws SQLException{
		Connection conn=new DataBaseConnection().getConnection();
		   Statement sta=conn.createStatement();
		   String sql="Insert into ticket(user_id,car_id,gocar_lacation,ticket_num,"+
	               "true_name,id_card,phone,short_phone) values('"+ticket.getUserId()+"','"+ticket.getCarId()+
	               "','"+ticket.getGocatLacation()+"','"+ticket.getTicketNum()+"','"+ticket.getTruename()+"','"+
				ticket.getIdcard()+"','"+ticket.getPhone()+"','"+ticket.getShortphone()+"')";
		   int i=sta.executeUpdate(sql);
		   if(i==1){
			   return true;
		   }
		   else{
			   return false;
		   }
	}

}
