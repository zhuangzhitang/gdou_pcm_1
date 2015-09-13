package net.itaem.dao.DAOProxy;

import java.util.List;

import net.itaem.dao.DAOImpl.TeamMsgDAOImpl;
import net.itaem.dao.IDAO.TeamMsgDAO;
import net.itaem.po.Team;
import net.itaem.tool.DataBaseConnection;
import net.itaem.tool.ExceptionRecordTool;
import net.itaem.vo.ShowTeamVO;

public class TeamMsgDAOProxy implements TeamMsgDAO {
	private DataBaseConnection dbc ;
	private TeamMsgDAOImpl dao ;
	
	public TeamMsgDAOProxy(){
		dbc = new DataBaseConnection() ;
		dao = new TeamMsgDAOImpl(dbc.getConnection()) ;
	}
	public Team getTeamMsgById(int team_id)  {
		Team team = null ;
		try{
			team = dao.getTeamMsgById(team_id) ;
		}catch(Exception e){
			ExceptionRecordTool.writeExceptionRecord(e);
			e.printStackTrace();
		}
		return team;
	}

	public List<ShowTeamVO> getAllTeamShow() {
		List<ShowTeamVO> teamvos = null ;
		try{
			teamvos = dao.getAllTeamShow() ;
		}catch(Exception e){
			ExceptionRecordTool.writeExceptionRecord(e);
			e.printStackTrace();
		}
		return teamvos;
	}

	public boolean UpdateTeamMsg(int team_id, String image, String ticketmsg,
			String introduce)  {
		boolean flag = false ;
		try{
			flag = dao.UpdateTeamMsg(team_id, image, ticketmsg, introduce) ;
		}catch(Exception e){
			ExceptionRecordTool.writeExceptionRecord(e);
			e.printStackTrace();
		}
		return flag;
	}
	public int getTeamid(String username) {
		
		return dao.getTeamid(username);
	}
	public String getTeamName(String username) {
		
		return this.dao.getTeamName(username);
	}

}
