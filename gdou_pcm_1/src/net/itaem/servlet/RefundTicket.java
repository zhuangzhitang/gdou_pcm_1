package net.itaem.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.itaem.dao.IDAO.DeleteTicketDao;
import net.itaem.dao.IDAO.GetTicketDao;
import net.itaem.factory.Factory;
import net.itaem.vo.ShowTicketVO;

public class RefundTicket extends HttpServlet {

	public RefundTicket() {
		super();
	}

	public void destroy() {
		super.destroy(); 
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		HttpSession session=request.getSession();
		String username=(String)session.getAttribute("username");
		int ticket_id=Integer.parseInt(request.getParameter("ticketid"));
		DeleteTicketDao deleteTicket=Factory.getDeleteTicketDaoIntance();
		boolean b=deleteTicket.deleteTicket(ticket_id);
		if(b){
			request.setAttribute("isSuccess","退票成功");
		}else{
			request.setAttribute("isSuccess","退票失败，请重新执行操作");
		}
		
		
		RequestDispatcher rep=request.getRequestDispatcher("PersonShowServlet?type=change");     
		rep.forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
     this.doGet(request, response);
   }

	public void init() throws ServletException {
		// Put your code here
	}

}
