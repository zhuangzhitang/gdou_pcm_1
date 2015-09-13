package net.itaem.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.itaem.dao.IDAO.GetTicketDao;
import net.itaem.dao.IDAO.InsertCommonNameDao;
import net.itaem.dao.IDAO.UserDao;
import net.itaem.factory.Factory;
import net.itaem.po.CarNumber;
import net.itaem.po.CommonName;
import net.itaem.tool.CreateVerificationCode;
import net.itaem.vo.ShowTitleVO;


public class EnterServlet extends HttpServlet {

    
	public EnterServlet() {
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
      String username=request.getParameter("username").trim();
      String password= request.getParameter("Password").trim();
      String VerificationCode=request.getParameter("VerificationCode").trim();
      UserDao user=Factory.getUserDaoIntance();
      HttpSession s=request.getSession();
      String true_VerificationCode=(String)s.getAttribute("RANDOMCODEKEY");
      System.out.print(username+"??????"+VerificationCode+"???????"+true_VerificationCode);
      if(username==""||username==null||username.length()<2||username.length()>8||
    		  password==""||password==null||password.length()<4||password.length()>10||
    		  VerificationCode==""||VerificationCode==null||VerificationCode.length()!=4){
    	
    	 request.setAttribute("error","用户名或者密码或者验证码不符合格式");
    	 request.setAttribute("username",username);
         request.setAttribute("Password",password);
         request.setAttribute("VerificationCode",VerificationCode);
    	 request.getRequestDispatcher("login.jsp?type=return&tiaozhuang=index").forward(request, response);
      }
      else if(!VerificationCode.equals(true_VerificationCode)){
    	 request.setAttribute("error","验证码不正确");
    	 request.setAttribute("username",username);
         request.setAttribute("Password",password);
         request.setAttribute("VerificationCode",VerificationCode);
     	 request.getRequestDispatcher("login.jsp?type=return&tiaozhuang=index").forward(request, response);
		  	  }
	  else if(!user.isEnter("OU", username, password)){
		  request.setAttribute("error","用户名与密码不一致");
		  request.setAttribute("username",username);
	      request.setAttribute("Password",password);
	      request.setAttribute("VerificationCode",VerificationCode);
	     request.getRequestDispatcher("login.jsp?type=return&tiaozhuang=index").forward(request, response); 
	  }
	  else{
		  HttpSession session=request.getSession();
		  session.setAttribute("userid", user.getUserid(username)+"");
		  session.setAttribute("username",username);
		  String h=request.getParameter("tiao");
		  if(h.equals("register")){
			  RequestDispatcher rep=request.getRequestDispatcher("index.jsp");       //填充跳转路径，登录成功后，跳转的页面有多个，要一起考虑。
			  rep.forward(request, response);
			  }
		  if(h.equals("index")){
		  RequestDispatcher rep=request.getRequestDispatcher("main.jsp");       //填充跳转路径，登录成功后，跳转的页面有多个，要一起考虑。
		  rep.forward(request, response);
		  }
		  if(h.equals("vip")){
			  RequestDispatcher rep=request.getRequestDispatcher("PersonShowServlet?type=show");       //填充跳转路径，登录成功后，跳转的页面有多个，要一起考虑。
			  rep.forward(request, response);
		  }
		  if(h.equals("goumai")){
			  String carid=request.getParameter("carid");
			  String carlocation=request.getParameter("carlocation");
			  GetTicketDao ticket=Factory.getTicketDaoIntance();
			  CarNumber car=ticket.getCarNumberMessage(Integer.parseInt(carid));
			  InsertCommonNameDao name=Factory.getInsertCommonIntance();
		    	List<String> commonNameList=name.getCommonTrueName(username);
		    	CommonName com=name.getDefultMessage(username);
		    	request.setAttribute("commonNameList",commonNameList);
		    	request.setAttribute("DefultName",com);
		    	request.setAttribute("carid",carid);
		    	request.setAttribute("CarNumber",car);
		    	request.setAttribute("carlocation",carlocation);
		    	RequestDispatcher rep=request.getRequestDispatcher("tickets_02.jsp?type=enter");     
		    	rep.forward(request, response);
		  }
		  if(h.equals("mynote")){
			    String userId =  (String)request.getSession().getAttribute("userid") ;
			    int id = Integer.parseInt(userId) ;
				List<ShowTitleVO> shownotevos;
				try {
					shownotevos = Factory.getNoteDAOInstatnce().getNoteByPage(30,1,id);
					request.setAttribute("showmynotes", shownotevos);
					request.getRequestDispatcher("forum_04.jsp").forward(request, response) ;
				} catch (Exception e) {
					
					e.printStackTrace();
				}
			
		  }
		  if(h.equals("sendNode")){
			  request.getRequestDispatcher("forum_02.jsp").forward(request, response) ;
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
