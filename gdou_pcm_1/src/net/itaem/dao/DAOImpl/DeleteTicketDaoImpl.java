package net.itaem.dao.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import net.itaem.dao.IDAO.DeleteTicketDao;
/*
 *  接口DeleteTicketDao的实现类，输入订单的id,删除订单即退票操作。
 *  @author zaopeng
 */
public class DeleteTicketDaoImpl implements DeleteTicketDao {
    private Connection conn;
    public DeleteTicketDaoImpl(Connection conn){
    	this.conn=conn; 
    }
	public boolean deleteTicket(int ticket_id) {
		boolean b=false;
		PreparedStatement pre=null;
		int i=0;
		boolean c=this.addTicket(ticket_id);
		String sql="delete from ticket where ticket_id=?";
		try {
			pre=conn.prepareStatement(sql);
			pre.setInt(1,ticket_id);
			i=pre.executeUpdate();
			//boolean c=this.addTicket(ticket_id);
			if(i==1&&c){
				b=true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			if(pre!=null){
				try {
					pre.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				pre=null;
			}
					}
		return b;
	}
   private boolean addTicket(int ticket_id) {
	   boolean b=false;
	   PreparedStatement pre=null;
	   ResultSet res=null;
	   int car_id=0;
	   int ticket_num=0;
	   String sql="select * from ticket where ticket_id=?";
	   try {
		pre=conn.prepareStatement(sql);
		pre.setInt(1,ticket_id);
		res=pre.executeQuery();
		if(res.next()){
			car_id=res.getInt(3);
			ticket_num=res.getInt(5);
			System.out.println(car_id);
			System.out.println(ticket_num);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	   int i=0;
	   PreparedStatement pre1=null;
	   String sql1="update car_number set ticket_except=ticket_except+? where car_id=?";
	   try {
		pre1=conn.prepareStatement(sql1);
		pre1.setInt(2,car_id);
		pre1.setInt(1,ticket_num);
		i=pre1.executeUpdate();
		if(i==1){
			b=true;
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	   
	   return b;
   }
}
