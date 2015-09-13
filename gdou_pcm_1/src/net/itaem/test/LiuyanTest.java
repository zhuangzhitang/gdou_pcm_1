package net.itaem.test;

import java.util.Iterator;
import java.util.List;

import net.itaem.factory.Factory;
import net.itaem.po.LiuYan;

/**
 * 留言接口的测试类
 * @author zhetang
 *
 */
public class LiuyanTest {
	public static void main(String args[]){
		//验证输入帖子的id，获得该帖子所有的留言
		int note_id = 1 ;
		try {
			List<LiuYan> liuyans = Factory.getLiuyanDAOInstance().getLiuyanByNoteId(note_id) ;
			Iterator<LiuYan> iter = liuyans.iterator();
			while(iter.hasNext()){
				LiuYan liuyan = (LiuYan)iter.next() ;
				System.out.println(liuyan);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//发布留言
		LiuYan liuyan1 = new LiuYan("果子",1,"guondfla",1);
		try {
			boolean flag = Factory.getLiuyanDAOInstance().createLiuyan(liuyan1);
			System.out.println("留言发布是否成功："+flag);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
