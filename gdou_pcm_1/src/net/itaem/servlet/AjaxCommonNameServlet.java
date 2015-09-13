package net.itaem.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.itaem.dao.IDAO.InsertCommonNameDao;
import net.itaem.factory.Factory;
import net.itaem.po.CommonName;

public class AjaxCommonNameServlet extends HttpServlet {

	public AjaxCommonNameServlet() {
		super();
	}

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		HttpSession session=request.getSession();
		String username=(String) session.getAttribute("username");
		
		String name=new String(request.getParameter("commonName").getBytes("ISO-8859-1"),"utf-8");
		String commonName=URLDecoder.decode(name,"utf-8");
		InsertCommonNameDao com=Factory.getInsertCommonIntance();
		CommonName commonNameMessage=com.getCommonName(username, commonName);
		String s="";
		s+=commonNameMessage.getTrueName()+"|";
		s+=commonNameMessage.getIdCard()+"|";
		s+=commonNameMessage.getPhone()+"|";
		s+=commonNameMessage.getShortPhone();
		System.out.print(s);
		out.print(s);
		out.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
      this.doGet(request, response);
	}
	public void init() throws ServletException {
		// Put your code here
	}

}
