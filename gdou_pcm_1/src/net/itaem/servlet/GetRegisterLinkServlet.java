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
	     mailInfo.setSubject("广东海洋大学订票系统注册邮件");  
	     Date date=new Date();
	     SimpleDateFormat mat=new SimpleDateFormat("yyyy-mm-dd");
	     String d=mat.format(date);
	    //mailInfo.setContent("啊还嗲还好点");
	     mailInfo.setContent("感谢您使用广东海洋大学订票系统，祝您旅途愉快，请点击此链接完成注册"+
	    		 "http://localhost:8080/gdou_pcm_1/RegisterServlet?username="
                 +username+"&password="+password+"&email="+email+"&truename="+truename+
                 "&idcard="+idcard+"&phone="+phone+"&shortphone="+shortPhone);    //此处填充链接地址。
	    // b=SendMail.sendHtmlMail(mailInfo);     //发送html格式 的邮件。
	     b=SendMail.sendTextMail(mailInfo);
		if(!b){
			list.add("邮件发送失败，请重新注册");
		}else{
			list.add("邮件发送成功，请注意查收，完成最后一步注册");
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
			list.add("密码应该在4到10个字符之间");
		}
		if(!email.matches(email_check)){
			list.add("邮箱格式不正确");
		}
		if(!truename.matches(true_name)){
			list.add("输入的真实姓名不符合实际情况");
		}
		if(!idcard.matches(idcard_check)){
			list.add("身份证号码必须是18位数字");
		}
		if(!phone.matches(phone_check)){
			list.add("手机号码必须是11位");
		}
		if(shortphone!=""&&(!shortphone.matches(shortphone_check))){
		   list.add("短号必须是6位数字");
	}
		return list;

	
}
}
