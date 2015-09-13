package net.itaem.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import net.itaem.dao.IDAO.InsertCommonNameDao;
import net.itaem.factory.Factory;
import net.itaem.vo.ShowUserMessageVo;

public class PersonInformationServlet extends HttpServlet {

	public PersonInformationServlet() {
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
		String type=request.getParameter("type");
		HttpSession session=request.getSession();
		String username=(String) session.getAttribute("username");
		InsertCommonNameDao commonName=Factory.getInsertCommonIntance();
		
	    if(type.equals("update")){
			String true_name=request.getParameter("truename");
			String idcard=request.getParameter("idcard");
			String phone=request.getParameter("phone");
			String shortphone_char=request.getParameter("shortphone");
			if(shortphone_char.equals("")){
				shortphone_char="0";
			}
			int  shortphone=Integer.parseInt(shortphone_char);
			List<String> list=this.checkMessage(true_name, idcard, phone, shortphone);
			if(list.size()==0){
			  boolean b=commonName.changeMessage(username, true_name, idcard, phone, shortphone);
			  if(b){
				  request.setAttribute("isSuccess","修改个人信息成功");
			  }else{
				  request.setAttribute("isSuccess","修改个人信息失败，请重新执行操作");
			  }
			}else if(list.size()>0){
			     String s="";
			     for(int i=0;i<list.size();i++){
			    	 String h=list.get(i)+"\n";
			    	 s+=h;
			     }
			    request.setAttribute("isSuccess",s);
			}
			RequestDispatcher rep=request.getRequestDispatcher("PersonShowServlet?type=change");           
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
   
    private List<String> checkMessage(String truename,String idcard,String phone,int shortphone){
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
		return list;
}
}
