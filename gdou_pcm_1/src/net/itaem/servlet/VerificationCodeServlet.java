package net.itaem.servlet;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.itaem.tool.CreateVerificationCode;
import net.itaem.tool.DrawImage;


public class VerificationCodeServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public VerificationCodeServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
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
		request.setCharacterEncoding("utf-8");
		//CreateVerificationCode vtool=new CreateVerificationCode();
		//String s=vtool.getRandcode(request, response);
		DrawImage drawImage = new DrawImage();
		String random = drawImage.getRandcode(request, response);
		HttpSession session=request.getSession();
		session.removeAttribute("RANDOMCODEKEY");
		//session.setAttribute(RANDOMCODEKEY, randomString);
		session.setAttribute("RANDOMCODEKEY",random);
	}

	public void init() throws ServletException {
		// Put your code here
	}

}
