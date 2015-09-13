package net.itaem.dao.IDAO;



import java.util.Date;
import java.util.List;

import net.itaem.po.CarNumber;
import net.itaem.po.Ticket;
import net.itaem.vo.ShowCityVO;
import net.itaem.vo.ShowTicketVO;
/*
 * 该接口实现的功能有：根据输入的用户名，输出该用户有效的订单集合
 *                根据输入的车次的id，输出订了该车次的用户id的集合。
 *@author zaopeng
 */
public interface GetTicketDao {
   public List<ShowTicketVO> getTicketMessage(String username);//根据输入的用户名，得到用户订票的ShowTicketVO对象的集合。
   public List<Integer> getUseridList(int car_id);//根据输入的车次的id号，返回订了该车次的用户的user_id集合
   public ShowCityVO getCityMessage();//获取所有上车城市，下车城市，车队名称。
   /*
    * 根据输入的出发城市，到达城市，日期，车队名称，返回符合的ShowTicketVO对象集合。
    */
   public List<ShowTicketVO> findTicket(String ticket_from,String ticket_to,Date ticket_date,String ticket_name);
   public int getPageNumber(List<ShowTicketVO> list,int num);  //输入List集合，以及一页的记录数，返回页数。
   public List<ShowTicketVO> getTicketPage(int pagenumber,List<ShowTicketVO> list,int num);//输入页数，以及List集合，返回该页的ShowTicketVO对象集合。
   public boolean isGetTicket(String username,int num);    //检测是否让其购票，超过两张票，拒绝其购票。
   public boolean InsertTicket(Ticket ticket);     //订票，根据输入的信息，完成订票。
   public int getUserid(String username);          //根据用户名，得到用户id,即user_id.
   public int checkRestTicketNum(int car_id);             //输入车次的id,得到该车次的余票。
   public CarNumber getCarNumberMessage(int carid);       //根据传入的carid，得到该车次信息。
}
