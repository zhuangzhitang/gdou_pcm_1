package net.itaem.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.itaem.tool.MailSenderMessage;
import net.itaem.tool.SendMail;

public class GetRegisterLinkServlet extends HttpServlet {

	
	public GetRegisterLinkServlet() {
		super();
	}
	public void destroy() {
		super.destroy(); 
	}

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String username=new String(request.getParameter("user_name").getBytes("ISO-8859-1"),"utf-8");;
		String password=request.getParameter("password").trim();   
		String email=request.getParameter("email").trim();
		System.out.println(email);
		
		String truename=new String(request.getParameter("truename").getBytes("ISO-8859-1"),"utf-8");
		String idcard=request.getParameter("idcard").trim();
		String phone=request.getParameter("phone").trim();
		String  shortPhone=request.getParameter("shortphone").trim();
		if(shortPhone.equals("")){
			shortPhone="0";
		}
		List<String> list=this.checkRegiser(password, email, truename, idcard, phone, shortPhone);
		System.out.print(list.size());
		//System.out.println(list.get(0));
		System.out.println(truename);
		boolean b=false;
		if(list.size()==0){
		 MailSenderMessage mailInfo = new MailSenderMessage();   
	     mailInfo.setMailServerHost("smtp.163.com");   
	     mailInfo.setMailServerPort("25");   
	     mailInfo.setValidate(true);   
	     mailInfo.setUserName("15811706550@163.com");   
	     mailInfo.setPassword("889798guozaopeng"); 
	     mailInfo.setFromAddress("15811706550@163.com");   
	     mailInfo.setToAddress(email);   
	     mailInfo.setSubject("�㶫�����ѧ��Ʊϵͳע���ʼ�");  
	     Date date=new Date();
	     SimpleDateFormat mat=new SimpleDateFormat("yyyy-mm-dd");
	     String d=mat.format(date);
	    //mailInfo.setContent("�����ǻ��õ�");
	     mailInfo.setContent("��л��ʹ�ù㶫�����ѧ��Ʊϵͳ��ף����;��죬�������������ע��"+
	    		 "http://localhost:8080/gdou_pcm_1/RegisterServlet?username="
                 +username+"&password="+password+"&email="+email+"&truename="+truename+
                 "&idcard="+idcard+"&phone="+phone+"&shortphone="+shortPhone);    //�˴�������ӵ�ַ��
	    // b=SendMail.sendHtmlMail(mailInfo);     //����html��ʽ ���ʼ���
	     b=SendMail.sendTextMail(mailInfo);
		if(!b){
			list.add("�ʼ�����ʧ�ܣ�������ע��");
		}else{
			list.add("�ʼ����ͳɹ�����ע����գ�������һ��ע��");
		}
		}
		System.out.println(list.get(0));
		String s="";
		for(int i=0;i<list.size();i++){
			String h=list.get(i)+"\n";
			s+=h;
		}
	
		out.print(s);
		
	}
	

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        this.doGet(request, response);
	}
	public List<String> checkRegiser(String password,String email,String truename,String idcard,String phone,String shortphone){
		String password_check="\\w{4,10}";
		String email_check="^\\w+@\\w+\\.\\w+$";
		String true_name="^([\u4e00-\u9fa5]){2,4}$";
		String idcard_check="\\d{18}";
		String phone_check="\\d{11}";
		String shortphone_check="\\d{6}";
		List<String> list=new ArrayList<String>();
		System.out.println("iahda");
		if(!password.matches(password_check)){
			list.add("����Ӧ����4��10���ַ�֮��");
		}
		if(!email.matches(email_check)){
			list.add("�����ʽ����ȷ");
		}
		if(!truename.matches(true_name)){
			list.add("�������ʵ����������ʵ�����");
		}
		if(!idcard.matches(idcard_check)){
			list.add("���֤���������18λ����");
		}
		if(!phone.matches(phone_check)){
			list.add("�ֻ����������11λ");
		}
		if(shortphone!=""&&(!shortphone.matches(shortphone_check))){
		   list.add("�̺ű�����6λ����");
	}
		return list;

	
}
}
