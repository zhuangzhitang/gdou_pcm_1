package net.itaem.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.itaem.dao.DAOImpl.TeamMsgDAOImpl;
import net.itaem.dao.IDAO.TeamMsgDAO;
import net.itaem.dao.IDAO.UserDao;
import net.itaem.factory.Factory;

public class HtEnterServlet extends HttpServlet {

	public HtEnterServlet() {
		super();
	}

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
	      request.setCharacterEncoding("utf-8");
	      response.setCharacterEncoding("utf-8");
	      String username=request.getParameter("username").trim();
	      String password= request.getParameter("Password").trim();
	      HttpSession s=request.getSession();
	      String VerificationCode=request.getParameter("VerificationCode").trim();
	      UserDao user=Factory.getUserDaoIntance();
	      String true_VerificationCode=(String)s.getAttribute("RANDOMCODEKEY");
	      System.out.print(username+"??????"+VerificationCode+"???????"+true_VerificationCode);
	      if(username==""||username==null||username.length()<2||username.length()>8||
	    		  password==""||password==null||password.length()<4||password.length()>10||
	    		  VerificationCode==""||VerificationCode==null||VerificationCode.length()!=4){
	    	
	    	 request.setAttribute("error","用户名或者密码或者验证码不符合格式");
	    	 request.setAttribute("username",username);
	         request.setAttribute("Password",password);
	         request.setAttribute("VerificationCode",VerificationCode);
	    	 request.getRequestDispatcher("hEnter.jsp?type=return").forward(request, response);
	      }
	      else if(!VerificationCode.equals(true_VerificationCode)){
	    	 request.setAttribute("error","验证码不正确");
	    	 request.setAttribute("username",username);
	         request.setAttribute("Password",password);
	         request.setAttribute("VerificationCode",VerificationCode);
	     	 request.getRequestDispatcher("hEnter.jsp?type=return").forward(request, response);
			  	  }
		  else if(!user.isEnter("SU", username, password)){
			  request.setAttribute("error","用户名与密码不一致");
			  request.setAttribute("username",username);
		      request.setAttribute("Password",password);
		      request.setAttribute("VerificationCode",VerificationCode);
		      request.getRequestDispatcher("hEnter.jsp?type=return").forward(request, response); 
		  }
		  else{
			 TeamMsgDAO msg=Factory.getTeamMsgDAOInstance();
			 s.setAttribute("teamid",msg.getTeamid(username));
			 s.setAttribute("teamname",msg.getTeamName(username));
			 request.getRequestDispatcher("admin/admin.jsp").forward(request, response);	
		  }
	}

	public void init() throws ServletException {
		// Put your code here
	}

}
