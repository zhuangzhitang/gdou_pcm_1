package net.itaem.dao.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.itaem.dao.IDAO.TeamMsgDAO;
import net.itaem.po.Team;
import net.itaem.tool.ExceptionRecordTool;
import net.itaem.vo.ShowTeamVO;

public class TeamMsgDAOImpl implements TeamMsgDAO {
	private Connection conn ;
	public TeamMsgDAOImpl(Connection conn){
		this.conn = conn ;
	}
	public Team getTeamMsgById(int team_id)  {
		Team team = null ;
		String sql = "select * from teammsg where team_id = ?" ;
		PreparedStatement pst = null ;
		ResultSet rs = null ;
		try{
			pst = conn.prepareStatement(sql) ;
			pst.setInt(1, team_id) ;
			rs = pst.executeQuery() ;
			while(rs.next()){
				team = new Team() ;
				team.setTeamId(rs.getInt("team_id")) ;
				team.setTeamImage(rs.getString("team_image")) ;
				team.setTeamIntroduce(rs.getString("team_introduce")) ;
				team.setTeamName(rs.getString("team_name"));
				team.setTeamPassword(rs.getString("taem_passwrod")) ;
				team.setTeamUserName(rs.getString("team_username")) ;
				team.setTeamMessage(rs.getString("team_ticketmessage")) ;
			}
		}catch(Exception e){
			ExceptionRecordTool.writeExceptionRecord(e);
			e.printStackTrace();
		}finally{
			if(rs!=null){
				try {
					rs.close() ;
				} catch (SQLException e) {
					ExceptionRecordTool.writeExceptionRecord(e);
					e.printStackTrace();
				}
				rs = null ; 
			}
			if(pst != null){
				try {
					pst.close();
				} catch (SQLException e) {
					ExceptionRecordTool.writeExceptionRecord(e);
					e.printStackTrace();
				}
				pst = null ;
			}
		}
		return team ;
	}

	public List<ShowTeamVO> getAllTeamShow(){
		List<ShowTeamVO> teamvos = new ArrayList<ShowTeamVO>() ;
		String sql = "select * from teammsg" ;
		PreparedStatement pst = null ;
		ResultSet rs = null ;
		try{
			pst = conn.prepareStatement(sql) ;
			rs = pst.executeQuery() ;
			while(rs.next()){
				ShowTeamVO teamvo = new ShowTeamVO() ;
				teamvo.setId(rs.getInt("team_id")) ;
				teamvo.setImage(rs.getString("team_image")) ;
				teamvo.setTeamMsg(rs.getString("team_ticketmessage")) ;
				teamvos.add(teamvo) ;
			}
		}catch(Exception e){
			ExceptionRecordTool.writeExceptionRecord(e);
			e.printStackTrace();
		}finally{
			if(rs!=null){
				try {
					rs.close() ;
				} catch (SQLException e) {
					ExceptionRecordTool.writeExceptionRecord(e);
					e.printStackTrace();
				}
				rs = null ; 
			}
			if(pst != null){
				try {
					pst.close();
				} catch (SQLException e) {
					ExceptionRecordTool.writeExceptionRecord(e);
					e.printStackTrace();	ExceptionRecordTool.writeExceptionRecord(e);
					e.printStackTrace();
				}
				pst = null ;
			}
		}
		return teamvos;
	}

	public boolean UpdateTeamMsg(int team_id,String imqge,String ticketmsg,String introduce) {
		boolean flag = false ; 
		String sql = "update teammsg set team_image=?,team_ticketmessage=?,team_introduce=? where team_id = ?" ;
		PreparedStatement pst = null ;
		try{
			pst =conn.prepareStatement(sql) ;
			pst.setString(1,imqge) ;
			pst.setString(2,ticketmsg ) ;
			pst.setString(3,introduce) ;
			pst.setInt(4,team_id ) ;
			pst.executeUpdate() ;
			flag = true ;
		}catch(Exception e){
			ExceptionRecordTool.writeExceptionRecord(e);
			e.printStackTrace();
		}finally{
			if(pst!=null){
				try {
					pst.close() ;
				} catch (SQLException e) {
					ExceptionRecordTool.writeExceptionRecord(e);
					e.printStackTrace();
				}
				pst = null ;
			}
		}
		return flag;
	}
	public int getTeamid(String username){
		int i=0;
		String sql = "select team_id from teammsg where team_username=?" ;
		PreparedStatement pst = null ;
		ResultSet rs = null ;
		try{
			pst = conn.prepareStatement(sql) ;
			pst.setString(1,username) ;
			rs = pst.executeQuery() ;
			while(rs.next()){
				i=rs.getInt(1);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(rs!=null){
				try {
					rs.close() ;
				} catch (SQLException e) {
					e.printStackTrace();
				}
				rs = null ; 
			}
			if(pst != null){
				try {
					pst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				pst = null ;
			}
		}
		return i;
	}
	public String getTeamName(String username){
		String name=null;
		String sql = "select team_name from teammsg where team_username=?" ;
		PreparedStatement pst = null ;
		ResultSet rs = null ;
		try{
			pst = conn.prepareStatement(sql) ;
			pst.setString(1,username) ;
			rs = pst.executeQuery() ;
			while(rs.next()){
				name=rs.getString(1);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(rs!=null){
				try {
					rs.close() ;
				} catch (SQLException e) {
					e.printStackTrace();
				}
				rs = null ; 
			}
			if(pst != null){
				try {
					pst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				pst = null ;
			}
		}
		return name;
	}
}
