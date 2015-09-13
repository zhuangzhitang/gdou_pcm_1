package net.itaem.dao.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;



import java.util.List;


import net.itaem.dao.IDAO.GetTicketDao;
import net.itaem.po.CarNumber;
import net.itaem.po.Ticket;
import net.itaem.vo.ShowCityVO;
import net.itaem.vo.ShowTicketVO;
/*
 * 接口GetTicketDao的实现类
 * @author zaopeng
 */
public class GetTicketDaoImpl implements GetTicketDao {
    private Connection conn;
    public GetTicketDaoImpl(Connection conn){
    	this.conn=conn;
    }
	public List<ShowTicketVO> getTicketMessage(String username) {
		List<ShowTicketVO> list=new ArrayList<ShowTicketVO>();
		int user_id=0;
		try {
			user_id = this.getUserid(username);
		} catch (Exception e) {
			e.printStackTrace();
		}
		PreparedStatement pre=null;
		ResultSet res=null;
		String sql="select ticket_no,ticket_name,ticket_from,ticket_to," +
				"gocar_lacation,ticket_time,ticket_date,ticket_price,ticket_num,ticket_id"+
				" ticket_ from ticket natural join car_number where user_id=? and ticket_date>=CURDATE()";
		try {
			pre=conn.prepareStatement(sql);
			pre.setInt(1,user_id);
			System.out.println(user_id);
			res=pre.executeQuery();
			while(res.next()){
	             ShowTicketVO ticket=new ShowTicketVO();
				 ticket.setTicket_no(res.getInt(1));     //车次
				 ticket.setTicket_name(res.getString(2));    //车队名称
				 ticket.setTicket_from(res.getString(3).split("\\|")[0]);       //出发城市
				 ticket.setTicket_to(res.getString(4));              //到达城市
				 ticket.setGocar_location(res.getString(5)); //上车地点
				 ticket.setTicket_time(res.getString(6));//上车时间
				 Calendar cal=Calendar.getInstance();
				   cal.setTime(res.getDate(7));
				   String date=cal.get(Calendar.YEAR)+"-"+(cal.get(Calendar.MONTH)+1)+"-"+cal.get(Calendar.DATE);
				  
				 ticket.setTicket_Date(date); //上车日期
				 ticket.setTicket_price(res.getFloat(8));//票价
				 ticket.setTicket_num(res.getInt(9));//票数
				 ticket.setTicket_id(res.getInt(10)); //id号
				 list.add(ticket);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;	
}
		

	
	public List<Integer> getUseridList(int car_id){
		List<Integer> userids=new ArrayList<Integer>();
		PreparedStatement pre=null;
		ResultSet res=null;
		String sql="select distinct user_id from ticket where car_id=?";
		try {
			pre=conn.prepareStatement(sql);
			pre.setInt(1,car_id);
			res=pre.executeQuery();
			while(res.next()){
				userids.add(res.getInt(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			if(pre!=null){
				try {
					pre.close();
					pre=null;
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(res!=null){
				try {
					res.close();
					res=null;
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
				
			}
		}
		return userids;
	}
	
	public ShowCityVO getCityMessage(){
		ShowCityVO showcity=new ShowCityVO();
		List<String> fromCity=new ArrayList<String>();
		List<String> toCity=new ArrayList<String>();
		List<String> team_name=new ArrayList<String>();
		PreparedStatement pre=null;
		ResultSet res=null;
		String sql="select substring_index(ticket_from,?,1),GROUP_CONCAT(distinct substring_index(ticket_from,?,1)) " +
				"from car_number GROUP BY substring_index(ticket_from,?,1)";
		String sql1="select ticket_to,GROUP_CONCAT(distinct ticket_to) from car_number GROUP BY ticket_to";
		String sql2="select ticket_name,GROUP_CONCAT(distinct ticket_name) from car_number GROUP BY ticket_name";
		try {
			pre=conn.prepareStatement(sql);
			pre.setString(1,"|");
			pre.setString(2,"|");
			pre.setString(3,"|");
			res=pre.executeQuery();
			while(res.next()){
				fromCity.add(res.getString(1));
			}
			pre=conn.prepareStatement(sql1);
			res=pre.executeQuery();
			while(res.next()){
				toCity.add(res.getString(1));
			}
			pre=conn.prepareStatement(sql2);
			res=pre.executeQuery();
			while(res.next()){
				team_name.add(res.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			if(pre!=null){
				try {
					pre.close();
					pre=null;
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(res!=null){
				try {
					res.close();
					res=null;
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
			}
		}
		showcity.setFromCity(fromCity);
		showcity.setToCity(toCity);
		showcity.setTeam_name(team_name);
		return showcity;
	}
	public List<ShowTicketVO> findTicket(String ticket_from, String ticket_to,
			Date ticket_date, String ticket_name) {
		List<ShowTicketVO> list=new ArrayList<ShowTicketVO>();
		PreparedStatement pre=null;
		ResultSet res=null;
		String sql="select ticket_no,ticket_from,ticket_to,ticket_time,ticket_date," +
				"ticket_name,ticket_price,ticket_except,car_id from car_number " +
				"where ticket_from LIKE ? and ticket_to=? and ticket_name=? and ticket_date=?";
		try {
			pre=conn.prepareStatement(sql);
			pre.setString(1,ticket_from+"%");
			pre.setString(2,ticket_to);
			pre.setDate(4,new java.sql.Date(ticket_date.getTime()));
			pre.setString(3,ticket_name);
			res=pre.executeQuery();
			while(res.next()){
				ShowTicketVO ticket=new ShowTicketVO();
				ticket.setTicket_no(res.getInt(1));
				ticket.setTicket_from(res.getString(2));
				ticket.setTicket_to(res.getString(3));
				ticket.setTicket_time(res.getString(4));
				 Calendar cal=Calendar.getInstance();
				   cal.setTime(res.getDate(5));
				   String date=cal.get(Calendar.YEAR)+"-"+(cal.get(Calendar.MONTH)+1)+"-"+cal.get(Calendar.DATE);
				ticket.setTicket_Date(date);
				ticket.setTicket_name(res.getString(6));
				ticket.setTicket_price(res.getFloat(7));
				ticket.setTicket_yupiao(res.getInt(8));
				ticket.setCar_id(res.getInt(9));
				list.add(ticket);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			if(pre!=null){
				try {
					pre.close();
					pre=null;
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(res!=null){
				try {
					res.close();
					res=null;
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
			}
		}
				
		return list;
	}
	public int getPageNumber(List<ShowTicketVO> list, int num) {
		int i=0;
		int size=list.size();
		if(size%num==0){
			i=size/num;
		}
		else{
			i=size/num+1;
		}
		return i;
	}
	public List<ShowTicketVO> getTicketPage(int pagenumber,
			List<ShowTicketVO> list,int num) {
		List<ShowTicketVO> result=new ArrayList<ShowTicketVO>();
		int max=this.getPageNumber(list, num);
		int j=(pagenumber-1)*num;
		if(pagenumber==max){
			for(int i=j;i<list.size();i++){
				result.add(list.get(i));
			}
		}
		else if(pagenumber<max){
			for(int i=j;i<(j+num);i++){
				result.add(list.get(i));
			}
		}
		return result;
	}
	public boolean isGetTicket(String username,int num) {
		int userid=0;
		boolean b=false;
		try {
			 userid=this.getUserid(username);
		} catch (Exception e) {
			e.printStackTrace();
		}
		PreparedStatement pre=null;
		ResultSet res=null;
		String sql="select ticket_num from ticket natural join car_number where user_id=? and ticket_Date>=CURDATE()";
		try {
			pre=conn.prepareStatement(sql);
			pre.setInt(1,userid);
			res=pre.executeQuery();
			int i=num;
			while(res.next()){
				i=i+res.getInt(1);
			}
			if(i<=2){
				b=true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			if(pre!=null){
				try {
					pre.close();
					pre=null;
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(res!=null){
				try {
					res.close();
					res=null;
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
			}
		}
		return b;
	}
	public boolean InsertTicket(Ticket ticket)  {
		//在servlet层加锁。
		  boolean b=false;
		  Statement sta=null;
		  try {
			conn.setAutoCommit(false);  //取消自动提交
			sta=conn.createStatement();
			sta.addBatch("Insert into ticket(user_id,car_id,gocar_lacation,ticket_num,"+
		               "true_name,id_card,phone,short_phone) values('"+ticket.getUserId()+"','"+ticket.getCarId()+
		               "','"+ticket.getGocatLacation()+"','"+ticket.getTicketNum()+"','"+ticket.getTruename()+"','"+
					ticket.getIdcard()+"','"+ticket.getPhone()+"','"+ticket.getShortphone()+"')");
			sta.addBatch("update car_number set ticket_except=ticket_except-"+ticket.getTicketNum()+
					    " where car_id="+ticket.getCarId());
			System.out.println("zaopeng");
			int[] temp=sta.executeBatch();
			System.out.println(temp[0]+"___________"+temp[1]);
			if(temp[0]==1&&temp[1]==1){
				b=true;
			}
			conn.commit();
		} catch (SQLException e) {
			try {
				conn.rollback();  //回滚操作。
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}finally{
			try {
				sta.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		   return b;
	}
	/*
	 * 根据输入的用户名，获取其用户id.
	 */
    public int getUserid(String username){
    	PreparedStatement pre=null;
    	ResultSet res=null;
    	int i=0;
    	String sql="select user_id from user where user_name=?";
    	try {
			pre=conn.prepareStatement(sql);
			pre.setString(1,username);
			res=pre.executeQuery();
			if(res.next()){
				i=res.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
    	return i;
    }
  public int checkRestTicketNum(int car_id){
	  int i=0;
	  PreparedStatement pre=null;
	  ResultSet res=null;
	  String sql="select ticket_except from car_number where car_id=?";
	  try {
		pre=conn.prepareStatement(sql);
		pre.setInt(1,car_id);
		res=pre.executeQuery();
		if(res.next()){
			i=res.getInt(1);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}finally{
		if(pre!=null){
			try {
				pre.close();
				pre=null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(res!=null){
			try {
				res.close();
				res=null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	  return i;
}
public CarNumber getCarNumberMessage(int carid) {
	  CarNumber car=new CarNumber();
	  PreparedStatement pre=null;
	  ResultSet res=null;
	  String sql="select * from car_number where car_id=?";
	  try {
		pre=conn.prepareStatement(sql);
		pre.setInt(1,carid);
		res=pre.executeQuery();
		if(res.next()){
			car.setTicketNo(res.getInt(3));
			car.setTicketFrom(res.getString(4));
			car.setTicketTo(res.getString(5));
			car.setTicketTime(res.getString(6));
			car.setTicketDate(res.getDate(7));
			car.setTicketName(res.getString(8));
			car.setTicketPrice(res.getFloat(9));
			car.setTicketExcept(res.getInt(10));
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}finally{
		if(pre!=null){
			try {
				pre.close();
				pre=null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(res!=null){
			try {
				res.close();
				res=null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	  return car;
}

	
}
