package net.itaem.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.itaem.dao.IDAO.UserDao;
import net.itaem.factory.Factory;
import net.itaem.tool.MailSenderMessage;
import net.itaem.tool.SendMail;

public class FindPasswordServlet extends HttpServlet {

	
	public FindPasswordServlet() {
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
		String Username=request.getParameter("username");
		UserDao user=Factory.getUserDaoIntance();
		boolean b=user.ishaveusername(Username);
		if(!b){
			request.setAttribute("isSussess","���û���������");
		}else{
			String email=user.getEmail(Username);
			String password=user.getPassword(Username);
			MailSenderMessage mailInfo = new MailSenderMessage();   
		    mailInfo.setMailServerHost("smtp.163.com");   
		    mailInfo.setMailServerPort("25");   
		    mailInfo.setValidate(true);   
		    mailInfo.setUserName("15811706550@163.com");   
		    mailInfo.setPassword("889798guozaopeng"); 
		    mailInfo.setFromAddress("15811706550@163.com");   
		    mailInfo.setToAddress(email);   
		    mailInfo.setSubject("�㶫�����ѧ��Ʊϵͳ�ʼ�");   
		    mailInfo.setContent("����,"+Username+",���˺ŵ�������"+password+",�����Ʊ��ܺ�");   
		    boolean c=SendMail.sendTextMail(mailInfo);
		    if(!c){
		    	request.setAttribute("isSussess","�һ�����ʧ�ܣ�������ִ�в���");
			}else{
			   request.setAttribute("isSussess","���˺ŵ�������ͨ���ʼ�����ʽ���ͣ���ע�����");
			}
		}
		RequestDispatcher rep=request.getRequestDispatcher("");                        
		rep.forward(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
       this.doGet(request, response);
	}
	public void init() throws ServletException {
		// Put your code here
	}

}
