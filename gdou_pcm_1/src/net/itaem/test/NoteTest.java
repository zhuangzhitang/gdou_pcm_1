package net.itaem.test;

import java.util.Iterator;
import java.util.List;

import net.itaem.factory.Factory;
import net.itaem.po.Note;
import net.itaem.vo.ShowTitleVO;

/**
 * 这个类似针对帖子表接口的测试类
 * @author zhetang
 *
 */
public class NoteTest {
 public static void main(String arg[]){
	 //发回共有多少页帖子
	 int pageCount = 0 ;
	 try {
		pageCount = Factory.getNoteDAOInstatnce().getPageCount(6);
		System.out.println("共有帖子："+pageCount+"   页");
	} catch (Exception e) {
	
		e.printStackTrace();
	}
	 
	 //分页显示货物的信息
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
	 
	 //查询感兴趣的帖子
	 try {
		List<ShowTitleVO> showvo = Factory.getNoteDAOInstatnce().SeekNote("湛江", "广州", "1355");
		Iterator<ShowTitleVO> iter = showvo.iterator() ;
		while(iter.hasNext()){
			ShowTitleVO vo = new ShowTitleVO() ;
			vo=(ShowTitleVO)iter.next() ;
			System.out.println("查询感兴趣帖子的搜寻、结果："+vo) ;
		}
	} catch (Exception e1) {
		
		e1.printStackTrace();
	}
	 //通过id号查询该帖子
	 Note note = null ;
	 try {
		note = Factory.getNoteDAOInstatnce().showNoteByid(1);
		System.out.println("通过note_id返回该帖子的全部信息:"+note);
	} catch (Exception e) {
		
		e.printStackTrace();
	}
	 //删除帖子
	 
	 
	 //创建一个新帖子
	 boolean flag = false ;
	 try {
		note = new Note(1,"撒了法撒旦","法萨芬大","法师打发","法撒旦法师","法萨芬大说");   
		flag = Factory.getNoteDAOInstatnce().CreateNote(note);
		System.out.println("是否创建了一个新帖子："+flag) ;
	} catch (Exception e) {
	
		e.printStackTrace();
	}
	//删除帖子
	 flag = false ;
	 try {
		flag = Factory.getNoteDAOInstatnce().deleteNoteById(1);
		System.out.println("删除帖子是否成功"+flag);
	} catch (Exception e) {
	
		e.printStackTrace();
	}
 }
}
