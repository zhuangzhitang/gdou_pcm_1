package net.itaem.dao.DAOProxy;




import java.util.Date;
import java.util.List;

import net.itaem.dao.DAOImpl.GetTicketDaoImpl;
import net.itaem.dao.IDAO.GetTicketDao;
import net.itaem.po.CarNumber;
import net.itaem.po.Ticket;
import net.itaem.tool.DataBaseConnection;
import net.itaem.vo.ShowCityVO;
import net.itaem.vo.ShowTicketVO;
/*
 * 接口GetTicketDao的代理实现类
 * @author zaopeng
 */
public class GetTicketDaoProxy implements GetTicketDao {
    private DataBaseConnection db=null;
    private GetTicketDao t=null;
    public GetTicketDaoProxy(){
    	this.db=new DataBaseConnection();
    	this.t=new GetTicketDaoImpl(db.getConnection());
    }
    
	public List<ShowTicketVO> getTicketMessage(String username)
			 {
		
		return t.getTicketMessage(username);
	}

	public List<Integer> getUseridList(int car_id) {
		return this.t.getUseridList(car_id);
	}

	public ShowCityVO getCityMessage() {
		return this.t.getCityMessage();
	}

	public List<ShowTicketVO> findTicket(String ticket_from, String ticket_to,
			Date ticket_date, String ticket_name) {
		return this.t.findTicket(ticket_from, ticket_to, ticket_date, ticket_name);
	}

	public int getPageNumber(List<ShowTicketVO> list, int num) {
		return this.t.getPageNumber(list, num);
	}

	public List<ShowTicketVO> getTicketPage(int pagenumber,
			List<ShowTicketVO> list, int num) {
		return this.t.getTicketPage(pagenumber, list, num);
	}

	public boolean isGetTicket(String username,int num) {
		return this.t.isGetTicket(username,num);
	}

	public boolean InsertTicket(Ticket ticket) {
		return this.t.InsertTicket(ticket);
	}

	public int getUserid(String username) {
		return this.t.getUserid(username);
	}

	public int checkRestTicketNum(int car_id) {
		return this.t.checkRestTicketNum(car_id);
	}

	public CarNumber getCarNumberMessage(int carid) {
		return this.t.getCarNumberMessage(carid);
	}

	

	
	
}
