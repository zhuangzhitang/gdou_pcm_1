package net.itaem.test;



import net.itaem.dao.IDAO.DeleteTicketDao;

import net.itaem.factory.Factory;


public class DingdanText {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DeleteTicketDao del=Factory.getDeleteTicketDaoIntance();
		System.out.print(del.deleteTicket(11));
	}

}
