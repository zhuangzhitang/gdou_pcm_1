package net.itaem.servlet;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.itaem.dao.IDAO.GetTicketDao;
import net.itaem.factory.Factory;
import net.itaem.po.CarNumber;
import net.itaem.po.Ticket;

public class OrderTicketServlet extends HttpServlet{

	public OrderTicketServlet() {
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
		GetTicketDao ticketDao=Factory.getTicketDaoIntance();
		HttpSession session=request.getSession();
		String username=(String) session.getAttribute("username");
		int userid=ticketDao.getUserid(username);
		String carid=request.getParameter("carid");
		String loc=new String(request.getParameter("location").getBytes("ISO-8859-1"),"utf-8");
		String location=URLDecoder.decode(loc,"utf-8");
		String truename=request.getParameter("truename");
		String idcard=request.getParameter("idcard");
		String num=request.getParameter("num");
		String phone=request.getParameter("phone");
		String shortphone=request.getParameter("shortphone");
		if(shortphone.equals("")){
			shortphone="0";
		}
		boolean isAllow=ticketDao.isGetTicket(username,Integer.parseInt(num));
		if(isAllow){
		  List<String> list=new ArrayList<String>();
		  list=this.checkMessage(truename, idcard, phone, Integer.parseInt(shortphone),Integer.parseInt(num));
		  if(list.size()>0){
			String s="";
			for(int i=0;i<list.size();i++){
				String h=list.get(i)+"\n";
				s+=h;
			}
			request.setAttribute("isSuccess",s);
		  }else if(list.size()==0){
		    Ticket ticket=new Ticket();
		    ticket.setUserId(userid);
		    ticket.setCarId(Integer.parseInt(carid));
		    ticket.setTruename(truename);
		    ticket.setGocatLacation(location);
		    ticket.setIdcard(idcard);
		    ticket.setTicketNum(Integer.parseInt(num));
		    ticket.setPhone(phone);
		    ticket.setShortphone(Integer.parseInt(shortphone));
		    Lock lock=new ReentrantLock();
		    lock.lock();
		    int ticket_yupiao=ticketDao.checkRestTicketNum(Integer.parseInt(carid));
		    if(Integer.parseInt(num)>ticket_yupiao){
			    request.setAttribute("isSuccess","您所订的票数大于余票数，请预定其他车次的车票");
		    }else{
			     boolean b=ticketDao.InsertTicket(ticket);
			   if(b){
				  request.setAttribute("isSuccess","订票成功");
			   }
			   else{
				  request.setAttribute("isSuccess","订票失败，请重新订票");
			   }
		     }
		        lock.unlock();
		  }
		}
		else{
			request.setAttribute("isSuccess","您目前所订的票数已经满两张，系统规定一个用户最多只能预定两张票");
		}
		request.setAttribute("carid",carid);
		request.setAttribute("location",location);
		request.setAttribute("truename",truename);
		request.setAttribute("phone",phone);
		request.setAttribute("num",num);
		GetTicketDao ticket=Factory.getTicketDaoIntance();
	    CarNumber car=ticket.getCarNumberMessage(Integer.parseInt(carid));
	    request.setAttribute("carnumber",car);
		 RequestDispatcher rep=request.getRequestDispatcher("GetTicketSuccess.jsp");                 
		 rep.forward(request, response);
		
		
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
       this.doGet(request, response);
	}

	public void init() throws ServletException {
		// Put your code here
	}
	 private List<String> checkMessage(String truename,String idcard,String phone,int shortphone,int num){
	    	String true_name="^([\u4e00-\u9fa5]){2,4}$";
	 		String idcard_check="\\d{18}";
	 		String phone_check="\\d{11}";
	 		List<String> list=new ArrayList<String>();
	 		if(!truename.matches(true_name)){
				list.add("输入的真实姓名不符合实际情况");
			}
			if(!idcard.matches(idcard_check)){
				list.add("身份证号码必须是18位数字");
			}
			if(!phone.matches(phone_check)){
				list.add("手机号码必须是11位");
			}
			if(shortphone!=0){
				if(shortphone<100000||shortphone>999999){
			        list.add("短号必须是6位数字");
				}
			}
			if(num<0||num>2){
				list.add("抱歉，一个用户最多只能预定两张票");
			}
			return list;
	}


}
