package net.itaem.dao.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.itaem.dao.IDAO.NoteDAO;
import net.itaem.po.Note;
import net.itaem.tool.ExceptionRecordTool;
import net.itaem.vo.ShowTitleVO;

/**
 * NoteDAO的实现类，处理模块：拼车论坛模块
 * @author zhetang
 *
 */
public class NoteDAOImpl implements NoteDAO {
	private Connection conn;
	public NoteDAOImpl(Connection conn){
		this.conn = conn ;
	}
	
	/**
	 * 发回共有多少页帖子
	 */
	public int getPageCount(int pageSize)  {
		int pageCount = 0 ;   //页数
	    int noteCount = 0 ;   //帖子总数
		String sql = "select count(note_id)from note" ;
		PreparedStatement pst = null ;
		ResultSet rs = null ;
		try{
			pst = conn.prepareStatement(sql) ;
			rs = pst.executeQuery() ;   //得到总共有多少条数据
			if(rs.next()){
				noteCount = rs.getInt(1);
			}
			if(noteCount%pageSize==0){
				pageCount = noteCount/pageSize ;
				System.out.print("notecount"+noteCount);
			}else{
				pageCount = noteCount/pageSize + 1 ;
			}
		}catch(Exception e){
			ExceptionRecordTool.writeExceptionRecord(e);
			e.printStackTrace();
		}finally{
			if(rs!=null){
				try {
					rs.close();
				} catch (SQLException e) {
					ExceptionRecordTool.writeExceptionRecord(e);
					e.printStackTrace();
				}
				rs=null ;
			 }
			 if(pst!=null){
				try {
					pst.close();
				} catch (SQLException e) {
					ExceptionRecordTool.writeExceptionRecord(e);
					e.printStackTrace();
				}
				pst=null ;
			}
		}
		return pageCount;
	}
	
	/**
	 * 显示每一页的帖子
	 */
	public List<ShowTitleVO> getNoteByPage(int pageSize, int pageNum, int userId)
			 {
		List<ShowTitleVO> notes = new ArrayList<ShowTitleVO>();
		String sql = null ;
		PreparedStatement pst = null ;
		ResultSet rs = null ;
		int firstnote = (pageNum-1)*pageSize ;
		if(userId == 0){
			sql= "select * from  note limit ?,?" ;
			try {
				pst = conn.prepareStatement(sql) ;
				pst.setInt(1, firstnote) ;
				pst.setInt(2,pageSize) ;
			} catch (SQLException e) {
				ExceptionRecordTool.writeExceptionRecord(e);
				e.printStackTrace();
			}
		}else{
			sql = "select * from  note where user_id=? " ;
			try {
				pst = conn.prepareStatement(sql) ;
			} catch (SQLException e1) {
				ExceptionRecordTool.writeExceptionRecord(e1);
				e1.printStackTrace();
			}
			try {
				pst.setInt(1,userId) ;
			} catch (SQLException e) {
				ExceptionRecordTool.writeExceptionRecord(e);
				e.printStackTrace();
			}
		}
		try{
			rs = pst.executeQuery() ;
			while(rs.next()){
				ShowTitleVO notevo = new ShowTitleVO();
				notevo.setNoteId(rs.getInt("note_id"));
				notevo.setDate(rs.getDate("insert_time"));
				notevo.setTitle(rs.getString("note_title"));
				notes.add(notevo);
			}
		}catch(Exception e){
			ExceptionRecordTool.writeExceptionRecord(e);
			e.printStackTrace();
		}finally{
			if(rs!=null){
				try {
					rs.close();
				} catch (SQLException e) {
					ExceptionRecordTool.writeExceptionRecord(e);
					e.printStackTrace();
				}
				rs=null ;
			 }
			 if(pst!=null){
				try {
					pst.close();
				} catch (SQLException e) {
					ExceptionRecordTool.writeExceptionRecord(e);
					e.printStackTrace();
				}
				pst=null ;
			}
		}
		
		return notes ;
	}

	/**
	 * 查询感兴趣的帖子
	 */
	public List<ShowTitleVO> SeekNote(String actionFrom, String actionTo,
			String date){
		List<ShowTitleVO> notevo = new ArrayList<ShowTitleVO>() ;
		String sql = "select * from note where action_time=?";
		PreparedStatement pst = null ;
		ResultSet rs = null ;
		try{
			pst = conn.prepareStatement(sql);
			pst.setString(1,date) ;
			rs = pst.executeQuery() ;
			while(rs.next()){
				if((rs.getString("action_from").indexOf(actionFrom)!=-1)&&(rs.getString("action_to").indexOf(actionTo)!=-1)){
					ShowTitleVO shownotevo = new ShowTitleVO();
					shownotevo.setDate(rs.getDate("insert_time"));
					shownotevo.setNoteId(rs.getInt("note_id")) ;
					shownotevo.setTitle(rs.getString("note_title")) ;
					notevo.add(shownotevo) ;
				}
				
			}
		}catch(Exception e){
			ExceptionRecordTool.writeExceptionRecord(e);
			e.printStackTrace();
		}finally{
			if(rs!=null){
				try {
					rs.close();
				} catch (SQLException e) {
					ExceptionRecordTool.writeExceptionRecord(e);
					e.printStackTrace();
				}
				rs = null ;
			}
			if(pst!=null){
				try {
					pst.close();
				} catch (SQLException e) {
					ExceptionRecordTool.writeExceptionRecord(e);
					e.printStackTrace();
				}
				pst = null ;
			}
		}
		return notevo;
	}
	
	/**
	 * 通过id号查询该帖子
	 */
	public Note showNoteByid(int noteId) {
		Note note = null ;
		String sql = "select * from note where note_id = ?" ;
		PreparedStatement pst = null ;
		ResultSet rs =null ;
		try{
			pst = conn.prepareStatement(sql);
			pst.setInt(1, noteId) ;
			rs = pst.executeQuery() ;
			if(rs.next()){
				note = new Note();
				note.setNoteId(rs.getInt("note_id"));
				note.setUserId(rs.getInt("user_id"));
				note.setNoteTitle(rs.getString("note_title"));
				note.setNoteContent(rs.getString("note_content"));
				note.setActionFrom(rs.getString("action_from"));
				note.setActionTo(rs.getString("action_to"));
				note.setTime(rs.getString("action_time"));
				note.setInsertTime(rs.getDate("insert_time")) ;
				
			}
		}catch(Exception e){
			ExceptionRecordTool.writeExceptionRecord(e);
			e.printStackTrace();
		}finally{
			if(rs!=null){
				try {
					rs.close();
				} catch (SQLException e) {
					ExceptionRecordTool.writeExceptionRecord(e);
					e.printStackTrace();
				}
				rs=null ;
			 }
			 if(pst!=null){
				try {
					pst.close();
				} catch (SQLException e) {
					ExceptionRecordTool.writeExceptionRecord(e);
					e.printStackTrace();
				}
				pst=null ;
			}
		}
		return note;
	}
	
	/**
	 * 创建一个帖子
	 */
	public boolean CreateNote(Note note)  {
		boolean flag = false ;
		String sql = "insert into note(user_id,note_title,note_content," +
				     "action_from,action_to,action_time)values(?,?,?,?,?,?)" ;
		PreparedStatement pst = null ;
		try{
			pst = conn.prepareStatement(sql) ;
			pst.setInt(1,note.getUserId()) ;
			pst.setString(2,note.getNoteTitle()) ;
			pst.setString(3, note.getNoteContent()) ;
			pst.setString(4, note.getActionFrom()) ;
			pst.setString(5, note.getActionTo()) ;
			pst.setString(6, note.getTime()) ;
			pst.executeUpdate();
			flag = true ;
		}catch(Exception e){
			ExceptionRecordTool.writeExceptionRecord(e);
			e.printStackTrace();
		}finally{
			if(pst!=null){
				try {
					pst.close();
				} catch (SQLException e) {
					ExceptionRecordTool.writeExceptionRecord(e);
					e.printStackTrace();
				}
				pst = null ;
			}
		}
		return flag;
	}
	
	/**
	 * 删除恶意帖子
	 */
	public boolean deleteNoteById(int id) {
		boolean flag = false ;
		String sql = "delete from note where note_id=?" ;
		PreparedStatement pst = null ;
		try{
			pst = conn.prepareStatement(sql) ;
			pst.setInt(1, id) ;
			pst.executeUpdate();
			flag = true ;
		}catch(Exception e){
			ExceptionRecordTool.writeExceptionRecord(e);
			e.printStackTrace();
		}finally{
			if(pst!=null){
				try {
					pst.close();
				} catch (SQLException e) {
					ExceptionRecordTool.writeExceptionRecord(e);
					e.printStackTrace();
				}
				pst=null ;
			}
		}
		return flag;
	}
}
