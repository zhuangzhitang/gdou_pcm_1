package net.itaem.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import net.itaem.dao.IDAO.MessageDAO;
import net.itaem.factory.Factory;

public class MessageServlet extends HttpServlet {

	
	public MessageServlet() {
		super();
	}

	
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
      this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String msg_id=request.getParameter("msg_id");
		System.out.println("LLLLLL"+msg_id+"MMMMMMMMM");
		int id=Integer.parseInt(msg_id);
		MessageDAO m=Factory.getMessageDAOInstance();
		boolean b=false;
		try {
			b=m.deleteMessage(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(b){
		    request.setAttribute("isSuccess","删除消息成功");
		}else{
			 request.setAttribute("isSuccess","删除消息失败，请重新执行操作");
		}
		request.getRequestDispatcher("PersonShowServlet?type=change").forward(request, response);
	}

	
	public void init() throws ServletException {
		
	}

}
