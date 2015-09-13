package net.itaem.dao.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;



import net.itaem.dao.IDAO.DeleteTeamDao;
/*
 * �ӿ�DeleteTeamDaoImpl��ʵ���ࡣ
 * @author zaopeng
 */
public class DeleteTeamDaoImpl implements DeleteTeamDao {
   private Connection conn;
   public DeleteTeamDaoImpl(Connection conn){
	   this.conn=conn;
   }
   public boolean deleteTeam(String name){
	   boolean b=false;
	   int i=0;
	   String sql="delete ticket,car_number,teammsg from ticket,car_number,teammsg where teammsg.team_id=car_number.team_id and ticket.car_id=car_number.car_id and teammsg.team_name=?";
	  // DELETE ����֤,������Ϣ,������Ϣ FROM ����֤, ������Ϣ, ������Ϣ WHERE ����֤.id = ������Ϣ.book_id AND ����֤.id = ������Ϣ.book_id AND ����֤.id = X 
	   PreparedStatement pre=null;
	   try {
		pre=conn.prepareStatement(sql);
		pre.setString(1,name);
		i=pre.executeUpdate();
		if(i>0){
			b=true;
		}
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	  
	   
	   return b;
	   
   }
}
