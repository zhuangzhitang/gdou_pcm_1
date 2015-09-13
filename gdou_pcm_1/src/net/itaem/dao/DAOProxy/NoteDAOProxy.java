package net.itaem.dao.DAOProxy;

import java.util.List;

import net.itaem.dao.DAOImpl.NoteDAOImpl;
import net.itaem.dao.IDAO.NoteDAO;
import net.itaem.po.Note;
import net.itaem.tool.DataBaseConnection;
import net.itaem.tool.ExceptionRecordTool;
import net.itaem.vo.ShowTitleVO;
/**
 * �����࣬�Ǵ��������������Ĵ���
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
	 * ����ͨ������һҳҪ��ʾ�������������������ж���ҳ
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
	 * ����ͨ������һҳ����ʾ������������ǰ���ڵڼ�ҳ���������Ӧ�����ӣ�userid Ϊ0 ʱ��ʾ����ʾ���е����ӣ�������ʾ���Ӧ�û��Լ�д�����ӣ�
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
	 * �����ѯ�û�����Ȥ������
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
	 * ����ͨ���������ӵ�id�ţ��������Ӧ������
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
	 * ������һ������
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
	 * ����ɾ����������
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
