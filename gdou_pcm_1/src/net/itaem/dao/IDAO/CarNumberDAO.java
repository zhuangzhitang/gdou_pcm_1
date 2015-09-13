package net.itaem.dao.IDAO;

import java.util.List;

import net.itaem.po.CarNumber;
import net.itaem.vo.ShowDingPiaoMsgVO;

public interface CarNumberDAO {
	public boolean createCarNum(CarNumber carnum)  ; //创建车次 
	public List<CarNumber> showCarNumList(int team_id) ; //显示策次
	public List<ShowDingPiaoMsgVO> showDPList(int car_id) ;  //显示车次的订票信息
	public String getUserNamebyId(int userId) ;  //通过用户的ID 号得到 用户名
	public boolean deleteCheci(int car_id);   //删除车次
	public int getTicketNumbyCarId(int car_id) ;  //通过id拿到车次号
}
