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

import net.itaem.dao.DAOProxy.InsertCommonDaoProxy;
import net.itaem.dao.IDAO.GetTicketDao;
import net.itaem.dao.IDAO.InsertCommonNameDao;
import net.itaem.factory.Factory;
import net.itaem.po.CarNumber;
import net.itaem.po.CommonName;

public class GetTicketServlet extends HttpServlet {


	public GetTicketServlet() {
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
	    String username=(String) session.getAttribute("username");
	    String carid=request.getParameter("carid");
	    String carlocation=request.getParameter("carlocation");
	    GetTicketDao ticket=Factory.getTicketDaoIntance();
	    CarNumber car=ticket.getCarNumberMessage(Integer.parseInt(carid));
	    if(username==null){
	    	RequestDispatcher rep=request.getRequestDispatcher("login.jsp?type=enter&tiaozhuang=goumai&carid="+carid+"&carlocation="+carlocation);            
	    	rep.forward(request, response);
	    }else{
	    	InsertCommonNameDao name=Factory.getInsertCommonIntance();
	    	List<String> commonNameList=name.getCommonTrueName(username);
	    	CommonName com=name.getDefultMessage(username);
	    	request.setAttribute("commonNameList",commonNameList);
	    	request.setAttribute("DefultName",com);
	    	request.setAttribute("carid",carid);
	    	request.setAttribute("CarNumber",car);
	    	request.setAttribute("carlocation",carlocation);
	    	RequestDispatcher rep=request.getRequestDispatcher("tickets_02.jsp?type=normal");     
	    	rep.forward(request, response);
	    }
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        this.doGet(request, response);
	}


	public void init() throws ServletException {
	}

}
