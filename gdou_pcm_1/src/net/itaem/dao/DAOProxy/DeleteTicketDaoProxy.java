package net.itaem.dao.DAOProxy;

import net.itaem.dao.DAOImpl.DeleteTicketDaoImpl;
import net.itaem.dao.IDAO.DeleteTicketDao;
import net.itaem.tool.DataBaseConnection;
/*
 * 接口DeleteTicketDao的代理实现类。
 * @author zaopeng
 */
public class DeleteTicketDaoProxy implements DeleteTicketDao {
    private DataBaseConnection database=null;
    private DeleteTicketDao dt=null;
    public DeleteTicketDaoProxy(){
    	this.database=new DataBaseConnection();
    	this.dt=new DeleteTicketDaoImpl(this.database.getConnection());
    }
	public boolean deleteTicket(int ticket_id) {
		boolean b=false;
		b=this.dt.deleteTicket(ticket_id);
		return b;
	}

}
