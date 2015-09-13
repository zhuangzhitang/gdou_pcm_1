package net.itaem.test;

import java.util.Iterator;
import java.util.List;

import net.itaem.factory.Factory;
import net.itaem.po.Note;
import net.itaem.vo.ShowTitleVO;

/**
 * �������������ӱ�ӿڵĲ�����
 * @author zhetang
 *
 */
public class NoteTest {
 public static void main(String arg[]){
	 //���ع��ж���ҳ����
	 int pageCount = 0 ;
	 try {
		pageCount = Factory.getNoteDAOInstatnce().getPageCount(6);
		System.out.println("�������ӣ�"+pageCount+"   ҳ");
	} catch (Exception e) {
	
		e.printStackTrace();
	}
	 
	 //��ҳ��ʾ�������Ϣ
	 try {
		List<ShowTitleVO> shownotevos = Factory.getNoteDAOInstatnce().getNoteByPage(6,2,2);
		Iterator<ShowTitleVO> iter = shownotevos.iterator();
		while(iter.hasNext()){
			ShowTitleVO shownotevo =(ShowTitleVO)iter.next() ;
			System.out.println(shownotevo);
		}
	} catch (Exception e) {
		
		e.printStackTrace();
	}
	 
	 //��ѯ����Ȥ������
	 try {
		List<ShowTitleVO> showvo = Factory.getNoteDAOInstatnce().SeekNote("տ��", "����", "1355");
		Iterator<ShowTitleVO> iter = showvo.iterator() ;
		while(iter.hasNext()){
			ShowTitleVO vo = new ShowTitleVO() ;
			vo=(ShowTitleVO)iter.next() ;
			System.out.println("��ѯ����Ȥ���ӵ���Ѱ�������"+vo) ;
		}
	} catch (Exception e1) {
		
		e1.printStackTrace();
	}
	 //ͨ��id�Ų�ѯ������
	 Note note = null ;
	 try {
		note = Factory.getNoteDAOInstatnce().showNoteByid(1);
		System.out.println("ͨ��note_id���ظ����ӵ�ȫ����Ϣ:"+note);
	} catch (Exception e) {
		
		e.printStackTrace();
	}
	 //ɾ������
	 
	 
	 //����һ��������
	 boolean flag = false ;
	 try {
		note = new Note(1,"���˷�����","�����Ҵ�","��ʦ��","��������ʦ","�����Ҵ�˵");   
		flag = Factory.getNoteDAOInstatnce().CreateNote(note);
		System.out.println("�Ƿ񴴽���һ�������ӣ�"+flag) ;
	} catch (Exception e) {
	
		e.printStackTrace();
	}
	//ɾ������
	 flag = false ;
	 try {
		flag = Factory.getNoteDAOInstatnce().deleteNoteById(1);
		System.out.println("ɾ�������Ƿ�ɹ�"+flag);
	} catch (Exception e) {
	
		e.printStackTrace();
	}
 }
}
