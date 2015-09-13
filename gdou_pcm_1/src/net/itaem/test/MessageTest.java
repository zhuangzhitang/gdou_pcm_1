package net.itaem.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.itaem.factory.Factory;
import net.itaem.po.ticketMessage;

/**
 * ��Ϣ���������
 * @author zhetang
 *
 */
public class MessageTest {
	public static void main(String args[]) {
		//������Ϣ
		List<Integer> users = new ArrayList<Integer>() ;
		users.add(1);
		users.add(2);
		users.add(3);
		boolean flag = false ;
		try {
			flag = Factory.getMessageDAOInstance().sendMessage(users, "nimeidesfafa") ;
			System.out.println("������Ϣ��"+flag) ;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//�û�ɾ����Ϣ
		boolean flag2 = false ;
		try {
			flag2 = Factory.getMessageDAOInstance().deleteMessage(5);
			System.out.println("ɾ����Ϣ�Ƿ�ɹ��� "+flag2) ;
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		//δ����Ϣ����
		int count = 0 ;
		try {
			count = Factory.getMessageDAOInstance().unReadNum(1);
			System.out.println("δ����Ϣ������"+count+"  ��") ;
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		//��ʾ�Ѷ���Ϣ
		try {
			List<ticketMessage> titles = Factory.getMessageDAOInstance().showMsg(1) ;
			Iterator<ticketMessage> iter = titles.iterator() ;
			while(iter.hasNext()){
				ticketMessage title = iter.next() ;
				System.out.println("�Ѷ���Ϣ�У�"+title) ;
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		//��ʾδ����Ϣ
		try {
			List<ticketMessage> titles = Factory.getMessageDAOInstance().showUnReadMsg(1) ;
			Iterator<ticketMessage> iter = titles.iterator() ;
			while(iter.hasNext()){
				ticketMessage title = iter.next() ;
				System.out.println("δ������Ϣ�У�"+title) ;
			}
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		
		//�޸���Ϣ״̬
		boolean flag1 = false ; 
		try {
			flag1 = Factory.getMessageDAOInstance().UpdateMesType(2);
			System.out.println("��Ϣ״̬�޸� : "+flag1) ;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
