package net.itaem.test;

import java.sql.SQLException;

import net.itaem.dao.IDAO.UserDao;
import net.itaem.factory.Factory;

public class TextLisi {

	/**
	 * @param args
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws SQLException {
		UserDao user=Factory.getUserDaoIntance();
		System.out.println(user.getTicketLisi("zhetang"));
		System.out.println(user.getNoteLisi("zhetang"));		
				
				
}

}
