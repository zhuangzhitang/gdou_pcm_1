package net.itaem.dao.IDAO;

import java.util.List;

import net.itaem.po.Note;
import net.itaem.vo.ShowTitleVO;

/**
 * ����ӿڣ�������note����ص����ݿ�dao������߼�
 * @author zhetang
 *
 */
public interface NoteDAO {
	public int getPageCount(int pageSize) ;  //���ع��ж���ҳ����
	public List<ShowTitleVO> getNoteByPage(int pageSize,int pageNUm,int userId) ; //��ҳ��ʾ������Ϣ,��useridΪ��ʱ���鿴�������ӣ����䲻Ϊ��ʱ���鿴�û���������
	public List<ShowTitleVO> SeekNote(String actionFrom,String actionTo,String date) ;//���ݻ�����أ�Ŀ�ĵأ�ʱ���������
	public Note showNoteByid(int noteId) ;   //ͨ��id�ŷ�����
	public boolean CreateNote(Note note) ; //��������
	public boolean deleteNoteById(int id) ; //ɾ������
}
