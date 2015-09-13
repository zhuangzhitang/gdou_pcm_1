package net.itaem.dao.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.itaem.dao.IDAO.MessageDAO;
import net.itaem.po.ticketMessage;
import net.itaem.tool.ExceptionRecordTool;
/**
 * messageDAO的实现类
 * @author zhetang
 *
 */
public class MessageDAOImpl implements MessageDAO {
	private Connection conn = null ;
	public MessageDAOImpl(Connection conn){
		this.conn = conn ;
	}
	public boolean sendMessage(List<Integer> users, String message)              //发布消息
		 {
		boolean flag = false ;
		String sql = "insert into ticket_message(user_id,message) values(?,?) " ;
		PreparedStatement pst = null ;
		Iterator<Integer> iter = users.iterator() ;
		try{
			
			pst = conn.prepareStatement(sql) ;
			conn.setAutoCommit(false) ;
			while(iter.hasNext()){
				int user_id = (Integer)iter.next() ;
				pst.setInt(1, user_id) ;
				pst.setString(2,message) ;
				pst.addBatch() ;
			}
			pst.executeBatch() ;
			conn.commit() ;
			conn.setAutoCommit(true) ;
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
		return flag ;
	}

	public boolean deleteMessage(int msg_id) {              //删除消息
		boolean flag = false ;
		String sql = "delete from ticket_message where msg_id = ?" ;
		PreparedStatement pst = null ;
		try{
			pst = conn.prepareStatement(sql) ;
			pst.setInt(1,msg_id);
			pst.executeUpdate();
			flag = true ;
		}catch(Exception e){
			ExceptionRecordTool.writeExceptionRecord(e);
			e.printStackTrace();
		}finally{
			if(pst != null){
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

	public int unReadNum(int user_id) {                                     //未读消息条数
		int count = 0 ;
		String sql ="select count(*) from ticket_message where user_id=? and if_see=?" ;
		PreparedStatement pst = null ;
		ResultSet rs = null ;
		try{
			pst = conn.prepareStatement(sql) ;
			pst.setInt(1, user_id) ;
			pst.setInt(2, 1) ;                                                          //1表示为这条信息未读
			rs = pst.executeQuery() ;
			if(rs.next()){
				count = rs.getInt(1) ;
			}
		}catch(Exception e){
			ExceptionRecordTool.writeExceptionRecord(e);
			e.printStackTrace();
		}finally{
			if(rs != null){
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
					pst.close() ;
				} catch (SQLException e) {
					ExceptionRecordTool.writeExceptionRecord(e);
					e.printStackTrace();
				}
				pst = null ;
			}
		}
		return count;
	}

	public List<ticketMessage> showUnReadMsg(int user_id) {                   //已读消息
		List<ticketMessage> unReadMsg = new ArrayList<ticketMessage>() ;
		String sql ="select * from ticket_message where user_id=? and if_see=?" ;
		PreparedStatement pst = null ;
		ResultSet rs = null ;
		try{
			pst = conn.prepareStatement(sql) ;
			pst.setInt(1, user_id) ;
			pst.setInt(2, 1) ;//1表示为这条信息未读
			rs = pst.executeQuery() ;
			while(rs.next()){
				ticketMessage  msg = new ticketMessage() ;
				msg.setIfSee(0);
				msg.setMessage(rs.getString("message"));
				msg.setMsgId(rs.getInt("msg_id")) ;
				msg.setUserId(rs.getInt("user_id"));
				unReadMsg.add(msg) ;
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
				rs=null ;
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
		return unReadMsg ;
	}

	public List<ticketMessage> showMsg(int user_id) {                          //修改消息状态
		List<ticketMessage> ReadMsg = new ArrayList<ticketMessage>() ;
		String sql ="select * from ticket_message where user_id=? and if_see=?" ;
		PreparedStatement pst = null ;
		ResultSet rs = null ;
		try{
			pst = conn.prepareStatement(sql) ;
			pst.setInt(1, user_id) ;
			pst.setInt(2, 0) ;                                                                //0表示为这条信息已读
			rs = pst.executeQuery() ;
			while(rs.next()){
				ticketMessage  msg = new ticketMessage() ;
				msg.setIfSee(0);
				msg.setMessage(rs.getString("message"));
				msg.setMsgId(rs.getInt("msg_id")) ;
				msg.setUserId(rs.getInt("user_id"));
				ReadMsg.add(msg) ;
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
				rs=null ;
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
		return ReadMsg ;
	}

	public boolean UpdateMesType(int user_id) {             //修改消息状态
		boolean flag = false ;
		List<ticketMessage> udmsg = this.showUnReadMsg(user_id);
		Iterator<ticketMessage> iter =udmsg.iterator() ;
		String sql = "update ticket_message set if_see=0 where msg_id=?" ;
		PreparedStatement pst = null ;
		try{
			pst = conn.prepareStatement(sql) ;
			conn.setAutoCommit(false) ;
			while(iter.hasNext()){
				ticketMessage msg = (ticketMessage)iter.next() ;
				pst.setInt(1,msg.getMsgId()) ;
				pst.addBatch() ;
			}
			pst.executeBatch() ;
			conn.setAutoCommit(true) ;
			flag = true ;
		}catch(Exception e){
			ExceptionRecordTool.writeExceptionRecord(e);
			e.printStackTrace();
		}
		return flag;
	}

}
