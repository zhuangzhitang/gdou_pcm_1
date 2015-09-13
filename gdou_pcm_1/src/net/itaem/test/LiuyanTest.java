package net.itaem.test;

import java.util.Iterator;
import java.util.List;

import net.itaem.factory.Factory;
import net.itaem.po.LiuYan;

/**
 * ���ԽӿڵĲ�����
 * @author zhetang
 *
 */
public class LiuyanTest {
	public static void main(String args[]){
		//��֤�������ӵ�id����ø��������е�����
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
		
		//��������
		LiuYan liuyan1 = new LiuYan("����",1,"guondfla",1);
		try {
			boolean flag = Factory.getLiuyanDAOInstance().createLiuyan(liuyan1);
			System.out.println("���Է����Ƿ�ɹ���"+flag);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
