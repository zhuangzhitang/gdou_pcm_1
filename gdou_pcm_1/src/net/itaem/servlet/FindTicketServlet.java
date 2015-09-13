package net.itaem.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import net.itaem.dao.IDAO.GetTicketDao;
import net.itaem.factory.Factory;
import net.itaem.vo.ShowCityVO;
import net.itaem.vo.ShowTicketVO;

public class FindTicketServlet extends HttpServlet {

	
	public FindTicketServlet() {
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
		String type=request.getParameter("type");
		String fromcity=null;
		String tocity=null;
		String ticket_date=null;
		String car_name=null;
		GetTicketDao ticket=Factory.getTicketDaoIntance();
	    ShowCityVO cityVO=ticket.getCityMessage();
		if(type.equals("show")){
		     Calendar c=Calendar.getInstance();
		     String d=c.get(Calendar.YEAR)+"-"+(c.get(Calendar.MONTH)+1)+"-"+c.get(Calendar.DATE);
		     request.setAttribute("date",d);
			 request.setAttribute("cityVO",cityVO);
			 RequestDispatcher rep=request.getRequestDispatcher("tickets_01.jsp?xianshi=show");       
			 rep.forward(request, response);
		}
		else{
	      if(type.equals("FirstPage")){
		     fromcity=request.getParameter("fromcity");
		     tocity=request.getParameter("tocity");
		     ticket_date=request.getParameter("date");
		     car_name=request.getParameter("name");
		  }
		  else if(type.equals("otherPage")){
			String from=new String(request.getParameter("fromcity").getBytes("ISO-8859-1"),"utf-8");
			String to=new String(request.getParameter("tocity").getBytes("ISO-8859-1"),"utf-8");
		    String name=new String(request.getParameter("name").getBytes("ISO-8859-1"),"utf-8");
			 fromcity=URLDecoder.decode(from,"utf-8");
			 tocity=URLDecoder.decode(to,"utf-8");
			 ticket_date=URLDecoder.decode(request.getParameter("date"),"utf-8");
		   
			 car_name=URLDecoder.decode(name,"utf-8");
		   }
		   int year=Integer.parseInt(ticket_date.split("-")[0]);
		   int month=Integer.parseInt(ticket_date.split("-")[1]);
		   int day=Integer.parseInt(ticket_date.split("-")[2]);
		   Calendar cal=Calendar.getInstance();
		   cal.set(year, month-1, day);
		   Date date=cal.getTime();
		   List<ShowTicketVO> list=new ArrayList<ShowTicketVO>();
		
		   List<ShowTicketVO> list_Page=new ArrayList<ShowTicketVO>();
		
		   int pageNumber=0;
		   System.out.println(date);
		   list=ticket.findTicket(fromcity, tocity, date, car_name);
		   pageNumber=ticket.getPageNumber(list, 6);
		   if(type.equals("FirstPage")){                                  
		     list_Page=ticket.getTicketPage(1, list,6);
		   }else if(type.equals("otherPage")){
			  String num=request.getParameter("number");
			  list_Page=ticket.getTicketPage(Integer.parseInt(num), list,6);
		   }
		    request.setAttribute("cityVO",cityVO);
		    request.setAttribute("pagenumber",pageNumber);
		    request.setAttribute("list_Page",list_Page);
		    request.setAttribute("fromcity",fromcity);
		    request.setAttribute("tocity",tocity);
		    request.setAttribute("date",ticket_date);
		    request.setAttribute("name",car_name);
		    RequestDispatcher rep=request.getRequestDispatcher("tickets_01.jsp?xianshi=find");       
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
