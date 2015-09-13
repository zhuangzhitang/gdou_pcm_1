package net.itaem.dao.DAOProxy;

import java.util.List;

import net.itaem.dao.DAOImpl.CarNumberDAOImpl;
import net.itaem.dao.IDAO.CarNumberDAO;
import net.itaem.po.CarNumber;
import net.itaem.tool.DataBaseConnection;
import net.itaem.tool.ExceptionRecordTool;
import net.itaem.vo.ShowDingPiaoMsgVO;

public class CarNumberDAOProxy implements CarNumberDAO {
	private DataBaseConnection dbc ;
	private CarNumberDAOImpl dao ;
	public CarNumberDAOProxy(){
		dbc = new DataBaseConnection() ;
		dao = new CarNumberDAOImpl(dbc.getConnection()) ;
		
	}
	public boolean createCarNum(CarNumber carnum) {
		boolean flag = false ; 
		try{
			flag = dao.createCarNum(carnum) ;
		}catch(Exception e){
			ExceptionRecordTool.writeExceptionRecord(e);
			e.printStackTrace();
		}
		return flag ;
	}

	public List<CarNumber> showCarNumList(int team_id) {
		List<CarNumber> carnumber= null ;
		try{
			carnumber = dao.showCarNumList(team_id) ;
		}catch (Exception e){
			ExceptionRecordTool.writeExceptionRecord(e);
			e.printStackTrace();
		}
		return carnumber;
	}

	public List<ShowDingPiaoMsgVO> showDPList(int car_id){
		List<ShowDingPiaoMsgVO> dingdans = null ;
		try{
			 dingdans = dao.showDPList(car_id) ;
		}catch(Exception e){
			ExceptionRecordTool.writeExceptionRecord(e);
			e.printStackTrace();
		}
		return dingdans;
	}
	public String getUserNamebyId(int userId) {
		String userName = null ;
		try{
			userName = dao.getUserNamebyId(userId) ;
		}catch(Exception e){
			e.printStackTrace() ;
		}
		return userName;
	}
	public boolean deleteCheci(int car_id) {
		boolean flag = false ;
		try{
			flag = dao.deleteCheci(car_id) ;
		}catch(Exception e){
			e.printStackTrace() ;
		}
		return flag;
	}
	public int getTicketNumbyCarId(int car_id) {
		int ticket_no = 0 ;
		try{
			ticket_no = dao.getTicketNumbyCarId(car_id) ;
		}catch(Exception e){
			e.printStackTrace() ;
		}
		return  ticket_no;
	}

}
