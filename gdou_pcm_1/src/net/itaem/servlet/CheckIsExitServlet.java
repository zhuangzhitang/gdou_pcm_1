package net.itaem.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.itaem.dao.IDAO.InsertCommonNameDao;
import net.itaem.dao.IDAO.UserDao;
import net.itaem.factory.Factory;

public class CheckIsExitServlet extends HttpServlet {

	
	public CheckIsExitServlet() {
		super();
	}

	
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
        PrintWriter write=response.getWriter();
        String type=request.getParameter("type");
        UserDao user=Factory.getUserDaoIntance();
        InsertCommonNameDao common=Factory.getInsertCommonIntance();
        if(type.equals("name")){    
        	String username=request.getParameter("username");
        	boolean b=user.ishaveusername(username);
        	if(b){
        		write.print("0");  
        	}else{
        		write.print("1");   
        	}
        }
        if(type.equals("mail")){
        	String email=request.getParameter("email");
        	boolean b=user.ishavemail(email);
        	if(b){
        		write.print(2);  
        	}else{
        		write.print(3);  
        	}
        }
        if(type.equals("truename")){
        	HttpSession session=request.getSession();
        	String username=(String) session.getAttribute("username");
        	String truename=request.getParameter("truename");
        	boolean b=common.haveSameCommonName(username, truename);
        	if(b){
        		write.print(4);   
        	}else{
        		write.print(5);   
        	}
        	
        }
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
       this.doGet(request, response);
	}

	public void init() throws ServletException {
		// Put your code here
	}

}
