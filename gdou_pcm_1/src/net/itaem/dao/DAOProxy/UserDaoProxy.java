package net.itaem.dao.DAOProxy;

import java.sql.SQLException;

import net.itaem.dao.DAOImpl.UserDaoImpl;
import net.itaem.dao.IDAO.UserDao;
import net.itaem.tool.DataBaseConnection;
/*
 * 代理实现类，代理实现接口UserDao，对User表的各种操作。
 * @author zaopeng
 */
public class UserDaoProxy implements UserDao {
    private DataBaseConnection daConnection=null;
    private UserDao userDaoImpl=null;
    public UserDaoProxy(){
    	this.daConnection=new DataBaseConnection();
    	this.userDaoImpl=new UserDaoImpl(daConnection.getConnection());
    }
	public boolean insertUsermessage(String username, String password,
			String mail, String truename, String id_card, String phone, int shortphone) {
		boolean b=false;
		b=this.userDaoImpl.insertUsermessage(username, password, mail, truename,
				id_card, phone, shortphone);
		return b;
	}

	public boolean ishaveusername(String username) {
		boolean b=false;
		b=this.userDaoImpl.ishaveusername(username);
		return b;
	}

	public boolean ishavemail(String mail) {
		boolean b=false;
		b=this.userDaoImpl.ishavemail(mail);
		return b;
	}

	public boolean isEnter(String role,String username, String password) {
		boolean b=false;
		b=this.userDaoImpl.isEnter(role,username, password);
		return b;
	}

	public boolean revokeCreateNoteLisi(String usename) throws Exception {
		boolean b=false;
		b=this.userDaoImpl.revokeCreateNoteLisi(usename);
		return b;
	}

	public boolean revokeGetTicketLisi(String username) throws Exception {
		boolean b=false;
		b=this.userDaoImpl.revokeGetTicketLisi(username);
		return b;
	}
	public String getPassword(String username) {
		
		return this.userDaoImpl.getPassword(username);
	}
	public boolean insertTeam(String team_username, String team_password,
			String team_name) throws Exception {
		boolean b=false;
		b=this.userDaoImpl.insertTeam(team_username, team_password, team_name);
		return b;
	}
	public boolean changePassword(String role, String name, String oldPasswrd,
			String newPassword){
		boolean b=false;
		b=this.userDaoImpl.changePassword(role, name, oldPasswrd, newPassword);
		return b;
	}
	public int getTicketLisi(String user_name) throws SQLException {
		return this.userDaoImpl.getTicketLisi(user_name);
	}
	public int getNoteLisi(String user_name) throws SQLException {
		return this.userDaoImpl.getNoteLisi(user_name);
	}
	public int getUserid(String username) {
		
		return this.userDaoImpl.getUserid(username);
	}
	public String getEmail(String username) {
		return this.userDaoImpl.getEmail(username);
	}
    
}
