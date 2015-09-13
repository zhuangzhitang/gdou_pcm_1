package net.itaem.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.itaem.factory.Factory;
import net.itaem.dao.IDAO.*;


public class GetMessageNumberServlet extends HttpServlet {

	
	public GetMessageNumberServlet() {
		super();
	}

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
      this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		HttpSession s=request.getSession();
		String username=(String)s.getAttribute("username");
		if(username!=null){
		  MessageDAO message=Factory.getMessageDAOInstance();
          GetTicketDao getTicket=Factory.getTicketDaoIntance();
          int userid=getTicket.getUserid(username);
          int number=message.unReadNum(userid);
          out.println((String)s.getAttribute("username")+"|"+number);
	     }else{
	    	 out.print("0");
	     }
		out.close();
	}

	public void init() throws ServletException {
		// Put your code here
	}

}
