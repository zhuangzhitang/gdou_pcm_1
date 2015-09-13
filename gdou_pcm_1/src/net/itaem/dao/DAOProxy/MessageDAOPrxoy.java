package net.itaem.dao.DAOProxy;

import java.util.List;

import net.itaem.dao.DAOImpl.MessageDAOImpl;
import net.itaem.dao.IDAO.MessageDAO;
import net.itaem.po.ticketMessage;
import net.itaem.tool.DataBaseConnection;
import net.itaem.tool.ExceptionRecordTool;
/**
 * 消息代理类  模块：消息管理模块
 * @author zhetang
 *
 */
public class MessageDAOPrxoy implements MessageDAO {
	private MessageDAOImpl  dao = null ;
	private DataBaseConnection dbc = null ;
	public MessageDAOPrxoy(){
		dbc = new DataBaseConnection() ;
		dao = new MessageDAOImpl(dbc.getConnection()) ;
	}
	public boolean sendMessage(List<Integer> user_id, String message)
			 {
		boolean flag = false ;
		try{
			flag = dao.sendMessage(user_id, message) ;
		}catch(Exception e){
			ExceptionRecordTool.writeExceptionRecord(e);
			e.printStackTrace();
		}
		return flag;
	}

	public boolean deleteMessage(int msg_id) {
		boolean flag = false ;
		try{
			flag = dao.deleteMessage(msg_id) ;
		}catch(Exception e){
			ExceptionRecordTool.writeExceptionRecord(e);
			e.printStackTrace();
		}
		return flag;
	}

	public int unReadNum(int user_id){
		int count = 0 ;
		try{
			count = dao.unReadNum(user_id) ;
		}catch(Exception e){
			ExceptionRecordTool.writeExceptionRecord(e);
			e.printStackTrace();
		}
		return count;
	}

	public List<ticketMessage> showUnReadMsg(int user_id)  {
		List<ticketMessage> msgs = null ;
		try{
			msgs = dao.showUnReadMsg(user_id) ;
		}catch(Exception e){
			ExceptionRecordTool.writeExceptionRecord(e);
			e.printStackTrace();
		}
		return msgs;
	}

	public List<ticketMessage> showMsg(int user_id)  {
		List<ticketMessage> msgs = null ;
		try{
			msgs = dao.showMsg(user_id) ;
		}catch(Exception e){
			ExceptionRecordTool.writeExceptionRecord(e);
			e.printStackTrace();
		}
		return msgs;
	}

	public boolean UpdateMesType(int user_id)  {
		boolean flag = false ;
		try{
			flag = dao.UpdateMesType(user_id) ;
		}catch(Exception e){
			ExceptionRecordTool.writeExceptionRecord(e);
			e.printStackTrace();
		}
		return flag ;
	}

}
