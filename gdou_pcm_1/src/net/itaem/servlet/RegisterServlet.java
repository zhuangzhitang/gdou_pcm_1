package net.itaem.servlet;

import java.io.IOException;
import java.net.URLDecoder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.itaem.dao.IDAO.UserDao;
import net.itaem.factory.Factory;

public class RegisterServlet extends HttpServlet {

	
	public RegisterServlet() {
		super();
	}

	
	public void destroy() {
		super.destroy(); 
	}

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
		    
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		
		String username1=new String(request.getParameter("username").getBytes("ISO-8859-1"),"gbk");
		String username=URLDecoder.decode(username1,"gbk");
		String password=request.getParameter("password");
		String email=request.getParameter("email");
		String truename=new String(request.getParameter("truename").getBytes("ISO-8859-1"),"gbk");
		//String truename =request.getParameter("truename").getBytes("ISO-8859-1") ;
		String truename1 =URLDecoder.decode(truename, "gbk");
		String idcard=request.getParameter("idcard");
		String phone=request.getParameter("phone");
		String Shortphone=request.getParameter("shortphone");
		int shortphone=Integer.parseInt(Shortphone);
		UserDao user=Factory.getUserDaoIntance();
		System.out.println(truename+"!!!!!!!");
		if(user.ishavemail(email)||user.ishaveusername(username)){
			  request.setAttribute("isSuccess","" +
			  		"用户名或密码已经存在");  
		}else{
		  boolean b=user.insertUsermessage(username, password, email, truename1, idcard, phone, shortphone);
		  System.out.println(b);
		  if(b){
			request.setAttribute("isSuccess","注册成功");                             
		  }
		  else{
			request.setAttribute("isSuccess","注册失败，请重新注册");                             
		  }
	  }
		RequestDispatcher req=request.getRequestDispatcher("login.jsp?type=register&tiaozhuang=register");         
		req.forward(request, response);
		
	}

	
	public void init() throws ServletException {
		
	}

}
