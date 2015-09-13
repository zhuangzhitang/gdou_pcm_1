package net.itaem.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.itaem.dao.IDAO.UserDao;
import net.itaem.factory.Factory;

public class ChangePasswordServlet extends HttpServlet {

	public ChangePasswordServlet() {
		super();
	}

	
	public void destroy() {
		super.destroy();
	}
     public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
    	 request.setCharacterEncoding("utf-8");
 		 response.setCharacterEncoding("utf-8");
         response.setContentType("text/html");
       
		PrintWriter out = response.getWriter();
		HttpSession session=request.getSession();
		String username=(String) session.getAttribute("username");
		String oldPassword=request.getParameter("oldPassword");
		String newPassword=request.getParameter("newPassword");
		UserDao user=Factory.getUserDaoIntance();
		boolean b=user.changePassword("OU", username, oldPassword, newPassword);
		if(b){
			request.setAttribute("isSuccess","修改密码成功");
		}else{
			request.setAttribute("isSuccess","修改密码失败，请重新修改");
		} 
		RequestDispatcher rep=request.getRequestDispatcher("PersonShowServlet?type=change");           
		rep.forward(request, response);
		
		                                                             
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
      this.doGet(request, response);
	}

	
	public void init() throws ServletException {
		// Put your code here
	}

}
