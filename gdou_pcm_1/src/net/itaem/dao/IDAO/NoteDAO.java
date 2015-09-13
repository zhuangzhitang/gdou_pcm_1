package net.itaem.dao.IDAO;

import java.util.List;

import net.itaem.po.Note;
import net.itaem.vo.ShowTitleVO;

/**
 * 这个接口，处理与note表相关的数据库dao层操作逻辑
 * @author zhetang
 *
 */
public interface NoteDAO {
	public int getPageCount(int pageSize) ;  //发回共有多少页帖子
	public List<ShowTitleVO> getNoteByPage(int pageSize,int pageNUm,int userId) ; //分页显示帖子信息,当userid为零时，查看所有贴子，当其不为零时，查看用户发的帖子
	public List<ShowTitleVO> SeekNote(String actionFrom,String actionTo,String date) ;//根据活动出发地，目的地，时间进行搜贴
	public Note showNoteByid(int noteId) ;   //通过id号发回帖
	public boolean CreateNote(Note note) ; //创建帖子
	public boolean deleteNoteById(int id) ; //删除帖子
}
