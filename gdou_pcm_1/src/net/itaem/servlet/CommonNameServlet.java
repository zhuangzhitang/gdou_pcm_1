package net.itaem.servlet;

import java.io.IOException;
import java.net.URLDecoder;
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
import net.itaem.po.CommonName;

public class CommonNameServlet extends HttpServlet {

	
	public CommonNameServlet() {
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
		String type=request.getParameter("type");
		HttpSession session=request.getSession();
		String username=(String) session.getAttribute("username");
		InsertCommonNameDao common=Factory.getInsertCommonIntance();
		List<String> list=new ArrayList<String>();
		if(type.equals("insert")){
			String truename=request.getParameter("truename");
			String idcard=request.getParameter("idcard");
			String phone=request.getParameter("phone");
			String shortphone=request.getParameter("shortphone");
			if(shortphone.equals("")){
				shortphone="0";
			}
			CommonName insert_CommonName=new CommonName();
			insert_CommonName.setTrueName(truename);
			insert_CommonName.setIdCard(idcard);
			insert_CommonName.setPhone(phone);
			insert_CommonName.setShortPhone(Integer.parseInt(shortphone));
			list=this.checkCommmonName(insert_CommonName);
			if(list.size()>0){
				String s="";
				for(int i=0;i<list.size();i++){
					String h=list.get(i)+"   ";
					s+=h;
				}
					
				request.setAttribute("isSuccess",s);
				RequestDispatcher rep=request.getRequestDispatcher("PersonShowServlet?type=change");      
		    	rep.forward(request, response);
			}
			else if(list.size()==0){
			    boolean b=common.insertCommonName(username, truename, idcard, phone, Integer.parseInt(shortphone));
		        if(b){
		    	  request.setAttribute("isSuccess","添加常用姓名成功");
		        }else{
		    	   request.setAttribute("isSuccess","添加常用姓名失败，请重新添加");
		       }
		        RequestDispatcher rep=request.getRequestDispatcher("PersonShowServlet?type=change");      
		    	rep.forward(request, response);
		}
		}
		else if(type.equals("delete")){
			String t=new String (request.getParameter("truename").getBytes("ISO-8859-1"),"utf-8");
			String truename=URLDecoder.decode(t,"utf-8");
			boolean b=common.deleteCommonName(username, truename);
			if(b){
				 request.setAttribute("isSuccess","删除常用姓名成功");
			}else{
				request.setAttribute("isSuccess","删除常用姓名失败，请重新执行操作");
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
     
     private List<String> checkCommmonName(CommonName com){
    	String true_name="^([\u4e00-\u9fa5]){2,4}$";
 		String idcard_check="\\d{18}";
 		String phone_check="\\d{11}";
 		List<String> list=new ArrayList<String>();
 		if(!com.getTrueName().matches(true_name)){
			list.add("输入的真实姓名不符合实际情况");
		}
		if(!com.getIdCard().matches(idcard_check)){
			list.add("身份证号码必须是18位数字");
		}
		if(!com.getPhone().matches(phone_check)){
			list.add("手机号码必须是11位");
		}
		if(com.getShortPhone()!=0){
			if(com.getShortPhone()<100000||com.getShortPhone()>999999){
		        list.add("短号必须是6位数字");
			}
		}
		return list;
}
     
     
}
