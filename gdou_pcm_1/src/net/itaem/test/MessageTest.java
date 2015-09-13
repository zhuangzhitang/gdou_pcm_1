package net.itaem.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.itaem.factory.Factory;
import net.itaem.po.ticketMessage;

/**
 * 消息管理测试类
 * @author zhetang
 *
 */
public class MessageTest {
	public static void main(String args[]) {
		//发布消息
		List<Integer> users = new ArrayList<Integer>() ;
		users.add(1);
		users.add(2);
		users.add(3);
		boolean flag = false ;
		try {
			flag = Factory.getMessageDAOInstance().sendMessage(users, "nimeidesfafa") ;
			System.out.println("发送信息："+flag) ;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//用户删除消息
		boolean flag2 = false ;
		try {
			flag2 = Factory.getMessageDAOInstance().deleteMessage(5);
			System.out.println("删除信息是否成功： "+flag2) ;
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		//未读信息条数
		int count = 0 ;
		try {
			count = Factory.getMessageDAOInstance().unReadNum(1);
			System.out.println("未读信息条数："+count+"  条") ;
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		//显示已读消息
		try {
			List<ticketMessage> titles = Factory.getMessageDAOInstance().showMsg(1) ;
			Iterator<ticketMessage> iter = titles.iterator() ;
			while(iter.hasNext()){
				ticketMessage title = iter.next() ;
				System.out.println("已读信息有："+title) ;
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		//显示未读消息
		try {
			List<ticketMessage> titles = Factory.getMessageDAOInstance().showUnReadMsg(1) ;
			Iterator<ticketMessage> iter = titles.iterator() ;
			while(iter.hasNext()){
				ticketMessage title = iter.next() ;
				System.out.println("未读读信息有："+title) ;
			}
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		
		//修改信息状态
		boolean flag1 = false ; 
		try {
			flag1 = Factory.getMessageDAOInstance().UpdateMesType(2);
			System.out.println("信息状态修改 : "+flag1) ;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
