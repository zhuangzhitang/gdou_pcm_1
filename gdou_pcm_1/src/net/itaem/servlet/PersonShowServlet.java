package net.itaem.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.itaem.dao.IDAO.GetTicketDao;
import net.itaem.dao.IDAO.InsertCommonNameDao;
import net.itaem.dao.IDAO.MessageDAO;
import net.itaem.factory.Factory;
import net.itaem.po.CommonName;
import net.itaem.po.ticketMessage;
import net.itaem.vo.ShowTicketVO;
import net.itaem.vo.ShowUserMessageVo;

public class PersonShowServlet extends HttpServlet {

	public PersonShowServlet() {
		super();
	}

	public void destroy() {
		super.destroy(); 
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
         response.setContentType("text/html");
         request.setCharacterEncoding("utf-8");
 		 HttpSession session=request.getSession();
 		 String username=(String) session.getAttribute("username");
 		GetTicketDao getTicket=Factory.getTicketDaoIntance();
	    int userid=getTicket.getUserid(username);
 		 String type=request.getParameter("type");
 		 if(type.equals("show")){
 	       if(!(username==null)){
 			List<ShowTicketVO> ticketMessage=getTicket.getTicketMessage(username);
 			request.setAttribute("List_ShowTicketVO",ticketMessage);
 			InsertCommonNameDao commonName=Factory.getInsertCommonIntance();
 	    	List<String> list= commonName.getCommonTrueName(username);
 	    	List<CommonName> Common_list=new ArrayList<CommonName>();
 	    	for(int i=0;i<list.size();i++){
 	    		CommonName com=commonName.getCommonName(username,list.get(i));
 	    		Common_list.add(com);
 	    	}
 	    	request.setAttribute("list_common",Common_list);
 	    	ShowUserMessageVo usermessage=commonName.getUserMessage(username);
 	    	request.setAttribute("ShowUserMessage",usermessage);
 	    	MessageDAO message=Factory.getMessageDAOInstance();
 	    	try {
				message.UpdateMesType(userid);
			} catch (Exception e2) {
				e2.printStackTrace();
			}
 	    	List<ticketMessage> Untm=null;
 	    	List<ticketMessage>  tm=null;
 	    	
 	    	try {
				 Untm=message.showUnReadMsg(userid);
			} catch (Exception e) {
				e.printStackTrace();
			}
 	    	try {
				  tm=message.showMsg(userid);
			} catch (Exception e) {
				e.printStackTrace();
			}
 	    	request.setAttribute("unread",Untm);
 	    	request.setAttribute("read",tm);
 	    	
 	    	RequestDispatcher rep=request.getRequestDispatcher("vip.jsp?type=show");          
 	    	rep.forward(request, response);
 	    	
 		  }else{
 			RequestDispatcher rep=request.getRequestDispatcher("login.jsp?type=enter&tiaozhuang=vip");         
 			rep.forward(request, response);
 		    }
 		 }
 	   else if(type.equals("change")){
 		        request.setAttribute("isSuccess",request.getAttribute("isSuccess"));
 	 			List<ShowTicketVO> ticketMessage=getTicket.getTicketMessage(username);
 	 			request.setAttribute("List_ShowTicketVO",ticketMessage);
 	 			InsertCommonNameDao commonName=Factory.getInsertCommonIntance();
 	 	    	List<String> list= commonName.getCommonTrueName(username);
 	 	    	List<CommonName> Common_list=new ArrayList<CommonName>();
 	 	    	for(int i=0;i<list.size();i++){
 	 	    		CommonName com=commonName.getCommonName(username,list.get(i));
 	 	    		Common_list.add(com);
 	 	    	}
 	 	    	request.setAttribute("list_common",Common_list);
 	 	    	ShowUserMessageVo usermessage=commonName.getUserMessage(username);
 	 	    	request.setAttribute("ShowUserMessage",usermessage);
 	 	    	MessageDAO message=Factory.getMessageDAOInstance();
 	 	    	try {
 					message.UpdateMesType(userid);
 				} catch (Exception e2) {
 					e2.printStackTrace();
 				}
 	 	    	List<ticketMessage> Untm=null;
 	 	    	List<ticketMessage>  tm=null;
 	 	    	int number=0;
 	 	    	try {
 					number=message.unReadNum(userid);
 				} catch (Exception e1) {
 					// TODO Auto-generated catch block
 					e1.printStackTrace();
 				}
 	 	    	try {
 					 Untm=message.showUnReadMsg(userid);
 				} catch (Exception e) {
 					e.printStackTrace();
 				}
 	 	    	try {
 					  tm=message.showMsg(userid);
 				} catch (Exception e) {
 					e.printStackTrace();
 				}
 	 	    	request.setAttribute("unread",Untm);
 	 	    	request.setAttribute("read",tm);
 	 	    	request.setAttribute("messagenum",number);
 	 	    	
 	 	    	
 	 	    	RequestDispatcher rep=request.getRequestDispatcher("vip.jsp?type=change");          
 	 	    	rep.forward(request, response);
 	 		  
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
