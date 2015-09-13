package net.itaem.dao.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;



import net.itaem.dao.IDAO.DeleteTeamDao;
/*
 * 接口DeleteTeamDaoImpl的实现类。
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
	  // DELETE 借书证,读者信息,借书信息 FROM 借书证, 读者信息, 借书信息 WHERE 借书证.id = 读者信息.book_id AND 借书证.id = 借书信息.book_id AND 借书证.id = X 
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
