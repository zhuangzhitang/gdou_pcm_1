package net.itaem.test;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


import net.itaem.dao.IDAO.GetTicketDao;

import net.itaem.factory.Factory;
import net.itaem.po.Ticket;

import net.itaem.vo.ShowTicketVO;


public class UserTest {
	public static void main(String args[]){
	  GetTicketDao p=Factory.getTicketDaoIntance();
	  List<ShowTicketVO> user=new ArrayList<ShowTicketVO>();
	 // List<ShowTicketVO> haha=new ArrayList<ShowTicketVO>();
	 // boolean b=false;
	  boolean c=false;
	  Ticket t=new Ticket();
	  try {
		 Calendar cal=Calendar.getInstance();
		 cal.set(2014,11,11);
		 cal.add(Calendar.MONTH,-1);
		 java.util.Date date=cal.getTime();
		 user=p.findTicket("’øΩ≠","π„÷›",date,"itaem");
		int i=p.getPageNumber(user,4);
		System.out.println(i);
		//haha=p.getTicketPage(1,user,4);
		//b=p.isGetTicket("haha");
		t.setCarId(1);
		t.setUserId(1);
		t.setGocatLacation("haida");
		t.setTicketNum(2);
		t.setTruename("zaopeng");
		t.setIdcard("172");
		t.setPhone("718");
		t.setShortphone(12123);
		c=p.InsertTicket(t);
	} catch (Exception e) {
		
		e.printStackTrace();
	}
	  
	System.out.println(c);
	System.out.println(p.checkRestTicketNum(1));
}
	
}
