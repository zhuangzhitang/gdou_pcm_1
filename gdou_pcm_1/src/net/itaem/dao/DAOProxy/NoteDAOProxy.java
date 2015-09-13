package net.itaem.dao.DAOProxy;

import java.util.List;

import net.itaem.dao.DAOImpl.NoteDAOImpl;
import net.itaem.dao.IDAO.NoteDAO;
import net.itaem.po.Note;
import net.itaem.tool.DataBaseConnection;
import net.itaem.tool.ExceptionRecordTool;
import net.itaem.vo.ShowTitleVO;
/**
 * 代理类，是处理帖子相关事务的代理
 * @author zhetang
 *
 */
public class NoteDAOProxy implements NoteDAO {
	DataBaseConnection dbc = null ;
	NoteDAOImpl dao = null ;
	public NoteDAOProxy(){
		dbc = new DataBaseConnection() ;
		dao = new NoteDAOImpl(dbc.getConnection()) ;
	}
	/**
	 * 代理通过输入一页要显示的帖子数，返回帖子有多少页
	 */
	public int getPageCount(int pageSize) {
		int pageCount = 0 ;
		try{
			pageCount = dao.getPageCount(pageSize) ; 
		}catch(Exception e){
			ExceptionRecordTool.writeExceptionRecord(e);
			e.printStackTrace();
		}finally{
			dbc.close() ; 
		}
		return pageCount;
	}
	/**
	 * 代理通过传入一页该显示的帖子数，当前属于第几页，返回相对应的帖子（userid 为0 时表示是显示所有地贴子，否则显示相对应用户自己写的帖子）
	 */
	public List<ShowTitleVO> getNoteByPage(int pageSize, int pageNum, int userId)
			 {
		List<ShowTitleVO> notes = null ;
		try{
			notes = dao.getNoteByPage(pageSize, pageNum, userId) ;
		}catch(Exception e){
			ExceptionRecordTool.writeExceptionRecord(e);
			e.printStackTrace();
		}finally{
			dbc.close() ;
		}
		return notes;
	}
	/**
	 * 代理查询用户感兴趣的帖子
	 */
	public List<ShowTitleVO> SeekNote(String actionFrom, String actionTo,
			String date) {
		List<ShowTitleVO> notes = null ;
		try{
			notes = dao.SeekNote(actionFrom, actionTo, date) ;
		}catch(Exception e){
			ExceptionRecordTool.writeExceptionRecord(e);
			e.printStackTrace();
		}finally{
			dbc.close() ;
		}
		return notes;
	}
	/**
	 * 代理通过传入帖子的id号，返回相对应的帖子
	 */
	public Note showNoteByid(int noteId)  {
		Note note = null ;
		try{
			note = dao.showNoteByid(noteId) ;
		}catch(Exception e){
			ExceptionRecordTool.writeExceptionRecord(e);
			e.printStackTrace();
		}finally{
			dbc.close(); 
		}
		return note;
	}
	/**
	 * 代理创建一个帖子
	 */
	public boolean CreateNote(Note note)  {
		boolean flag = false ;
		try{
			flag = dao.CreateNote(note) ;
		}catch(Exception e){
			ExceptionRecordTool.writeExceptionRecord(e);
			e.printStackTrace();
		}finally{
			dbc.close();
		}
		return flag;
	}
	/**
	 * 代理删除恶意帖子
	 */
	public boolean deleteNoteById(int id){
		boolean flag = false ;
		try{
			flag = dao.deleteNoteById(id) ;
		}catch(Exception e){
			ExceptionRecordTool.writeExceptionRecord(e);
			e.printStackTrace();
		}finally{
			dbc.close() ;
		}
		return flag ;
	}

}
