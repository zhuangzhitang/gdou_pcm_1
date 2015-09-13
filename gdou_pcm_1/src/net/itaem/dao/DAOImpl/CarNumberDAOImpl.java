package net.itaem.dao.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.itaem.dao.IDAO.CarNumberDAO;
import net.itaem.po.CarNumber;
import net.itaem.tool.ExceptionRecordTool;
import net.itaem.vo.ShowDingPiaoMsgVO;

public class CarNumberDAOImpl implements CarNumberDAO {
	private Connection conn = null ;
	public CarNumberDAOImpl(Connection conn){
	    this.conn = conn ;
	}
	public boolean createCarNum(CarNumber carnum) {
		boolean flag = false ;
		String sql = "insert into car_number(team_id,ticket_no,ticket_from,ticket_to,ticket_time,ticket_date,ticket_name,ticket_price,ticket_except)values(?,?,?,?,?,?,?,?,?) ";
		PreparedStatement pst = null ;
		try{
			pst = conn.prepareStatement(sql) ;
			pst.setInt(1,carnum.getTeamId());
			pst.setInt(2,carnum.getTicketNo()) ;
			pst.setString(3,carnum.getTicketFrom()) ;
			pst.setString(4,carnum.getTicketTo()) ;
			pst.setString(5,carnum.getTicketTime()) ;
			pst.setDate(6,new java.sql.Date(carnum.getTicketDate().getTime())) ;
			pst.setString(7,carnum.getTeamName());
			pst.setFloat(8,carnum.getTicketPrice()) ;
			pst.setInt(9, carnum.getTicketExcept()) ;
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

	public List<CarNumber> showCarNumList(int team_id){
		List<CarNumber> carNumbers = new ArrayList<CarNumber>() ;
		String sql = "select * from car_number where team_id=?" ;
		PreparedStatement pst = null ;
		ResultSet rs = null ;
		try{
			pst = conn.prepareStatement(sql) ;
			pst.setInt(1, team_id) ;
			rs = pst.executeQuery() ;
			while(rs.next()){
				CarNumber carnum = new CarNumber() ;
				carnum.setCarId(rs.getInt("car_id")) ;
				carnum.setTeamId(rs.getInt("team_id")) ;
				carnum.setTicketNo(rs.getInt("ticket_no")) ;
				carnum.setTicketFrom(rs.getString("ticket_from")) ;
				carnum.setTicketTo(rs.getString("ticket_to")) ;
				carnum.setTicketTime(rs.getString("ticket_time")) ;
				carnum.setTicketDate(rs.getDate("ticket_date")) ;
				carnum.setTeamName(rs.getString("ticket_name")) ;
				carnum.setTicketPrice(rs.getFloat("ticket_price")) ;
				carnum.setTicketExcept(rs.getInt("ticket_price")) ;
				carnum.setTicketType(rs.getInt("ticket_type"));
				carNumbers.add(carnum) ;
			}
		}catch(Exception e){
			try {
				throw e ;
			} catch (Exception e1) {
				ExceptionRecordTool.writeExceptionRecord(e);
				e.printStackTrace();
			}
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
		return carNumbers;
	}

	public List<ShowDingPiaoMsgVO> showDPList(int car_id) {
		List<ShowDingPiaoMsgVO> dingdangMsg = new ArrayList<ShowDingPiaoMsgVO>() ;
		String sql = "select * from user_ticket_view where car_id = ?" ;
		PreparedStatement pst = null ;
		ResultSet rs = null ;
		try{
			pst = conn.prepareStatement(sql) ;
			pst.setInt(1, car_id) ;
			rs = pst.executeQuery() ;
			while(rs.next()){
				ShowDingPiaoMsgVO msg = new ShowDingPiaoMsgVO() ;
				msg.setUser_id(rs.getInt("user_id"));
				msg.setName(rs.getString("true_name")) ;
				msg.setIdcard(rs.getString("id_card")) ;
				msg.setPhone(rs.getString("phone")) ;
				msg.setShortphone(rs.getInt("short_phone")) ;
				msg.setTicket_num(rs.getInt("ticket_num")) ;
				msg.setCar_id(rs.getInt("car_id")) ;
				dingdangMsg.add(msg) ;
			}
		}catch(Exception e){
			ExceptionRecordTool.writeExceptionRecord(e);
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
			if(pst!=null){
				try {
					pst.close() ;
				} catch (SQLException e) {
				
					e.printStackTrace();
				}
				pst = null ;
			}
		}
		return dingdangMsg;
	}
	public String getUserNamebyId(int userId) {
		String userName = null ;
		String sql = "select user_name from user where user_id = ? " ;
		PreparedStatement pst = null ;
		ResultSet rs = null ;
		try{
			pst = conn.prepareStatement(sql) ;
			pst.setInt(1, userId) ;
			rs = pst.executeQuery() ;
		    if(rs.next()){
		    	userName = rs.getString(1);
		    }
		}catch(Exception e){
			e.printStackTrace() ;
		}finally{
			if(rs!=null){
				try {
					rs.close() ;
				} catch (SQLException e) {
					e.printStackTrace();
				}
				rs = null ;
			}
			if(pst!=null){
				try {
					pst.close() ;
				} catch (SQLException e) {	
					e.printStackTrace();
				}
				pst = null ;
			}
		}
		return userName;
	}
	
	public boolean deleteCheci(int car_id) {
		boolean flag = false ; 
		String sql = "update car_number set ticket_type = 0 where car_id = ?" ; 
		PreparedStatement pst = null ;
		try{
			pst = conn.prepareStatement(sql) ;
			pst.setInt(1, car_id) ;
			pst.executeUpdate() ;
			flag = true ;
		}catch(Exception e){
			e.printStackTrace() ;
		}finally{
			if(pst !=null){
				try {
					pst.close() ;
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
			}
		}
		return flag;
	}
	public int getTicketNumbyCarId(int car_id) {
		int  ticket_id = 0 ;
		String sql = "select ticket_no from car_number where car_id = ?" ;
		PreparedStatement pst = null ;
		ResultSet rs = null ;
		try{
			pst = conn.prepareStatement(sql) ;
			pst.setInt(1,car_id) ;
			rs = pst.executeQuery() ;
			if(rs.next()){
				ticket_id = rs.getInt(1) ;
			}
		}catch(Exception e){
			e.printStackTrace() ;
		}finally{
			if(rs!=null){
				try {
					rs.close() ;
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(pst!=null){
				try {
					pst.close() ;
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
			}
		}
		return ticket_id ;
	}

}
