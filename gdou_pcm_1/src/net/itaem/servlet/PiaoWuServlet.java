
	package net.itaem.servlet;

	import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.itaem.factory.Factory;
import net.itaem.po.CarNumber;
import net.itaem.tool.ExcelTool;
import net.itaem.vo.ShowDingPiaoMsgVO;

	public class PiaoWuServlet extends HttpServlet {

		
		public void doGet(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			
			request.setCharacterEncoding("utf-8") ;
			response.setCharacterEncoding("utf-8") ;
			String type = (String)request.getParameter("type") ;
			  ArrayList<ShowDingPiaoMsgVO> showvo = null ; 
	     	PrintWriter out = response.getWriter() ;
			 if(type.equals("lookcheciqpMsg")){
				String id = request.getParameter("carId");
	 			int carId = Integer.parseInt(id);
		
					  
						showvo = (ArrayList)Factory.getCarNumberDAOInstance().showDPList( carId) ;
						request.setAttribute("carId", id);
					    request.setAttribute("showDPMsg",showvo) ;
						request.getRequestDispatcher("admin/admin_03.jsp").forward(request,response) ;
					
				}else if(type.equals("sendCar")){    //发布车次
					
				    int teamid = (Integer)request.getSession().getAttribute("teamid") ;   //车队的id号
				    String teamname = (String)request.getSession().getAttribute("teamname");
					String tickeno = request.getParameter("checi") ;
					int ticketNo = Integer.parseInt(tickeno) ;
				
					String from2 = request.getParameter("from") ;
					String from1 = new String(from2.getBytes("ISO-8859-1"),"utf-8") ;
					String from = URLDecoder.decode(from1,"utf-8") ;
				
				        
				   String to2  = request.getParameter("to") ;
					String to1 = new String(to2.getBytes("ISO-8859-1"),"utf-8") ;
					String to = URLDecoder.decode(to1,"utf-8") ;
					//String to  = request.getParameter("to") ;
					String date = request.getParameter("date") ;
				
					String time2  = request.getParameter("time") ;
					String time1 = new String(time2.getBytes("ISO-8859-1"),"utf-8") ;
					String time = URLDecoder.decode(time1,"utf-8") ;
					
					String price = request.getParameter("price") ;
					float ticketPrice = Float.parseFloat(price) ;
					
					String count = request.getParameter("count") ;
					int ticketCount = Integer.parseInt(count) ;
					
					String address2 = request.getParameter("address") ;
					String address1 = new String(address2 .getBytes("ISO-8859-1"),"utf-8") ;
					String address = URLDecoder.decode(address1,"utf-8") ;
					//out.print(xmlHttp);
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
					Date date1 = null;
					try {
						date1 = sdf.parse(date);
					} catch (ParseException e) {
						out.print("日期格式不对");
						e.printStackTrace();
					}
					CarNumber carnumber =new CarNumber(teamid,ticketNo ,from+"|"+address,to,time, date1,teamname,ticketPrice,ticketCount) ;
					
						boolean flag = Factory.getCarNumberDAOInstance().createCarNum(carnumber) ;
						out.print(flag);
				
					
				}else if(type.equals("printTicket")){   //打印票务
					String carid = request.getParameter("carId") ;
					int carId = Integer.parseInt(carid);
				
					boolean flag = false ;
					String sheetName = "订票信息" ;
					List<String> headerList = new ArrayList<String>() ;
					headerList.add("真实姓名") ;
					headerList.add("身份证号") ;
					headerList.add("手机号") ;
					headerList.add("短号") ;
					headerList.add("订票数") ;
					 List<ArrayList<Object>> rowValuesList = new ArrayList<ArrayList<Object>>() ;
					List<ShowDingPiaoMsgVO> showvos = Factory.getCarNumberDAOInstance().showDPList(carId) ;
					Iterator<ShowDingPiaoMsgVO> iter =  showvos.iterator() ;
					while(iter.hasNext()){
						ShowDingPiaoMsgVO vo = (ShowDingPiaoMsgVO)iter.next() ;
						ArrayList<Object> object = new ArrayList<Object>() ;
						object.add(vo.getName()) ;
						object.add(vo.getIdcard()) ;
						object.add(vo.getPhone()) ;
						object.add(vo.getShortphone()) ;
						object.add(vo.getTicket_num()) ;
						rowValuesList.add(object) ;
					}
					
					 ExcelTool excel = new ExcelTool(flag,sheetName,headerList,rowValuesList,"c://1.xls","yyyy-mm-dd") ;
				
					out.print("true") ;
				}else if(type.equals("lahei")){         //拉黑
					String userId = request.getParameter("userid") ;
					int id = Integer.parseInt(userId) ;
					String userName = Factory.getCarNumberDAOInstance().getUserNamebyId(id) ;
					
						int flag = 0;
						try {
							flag = Factory.getUserDaoIntance().getTicketLisi(userName);
						} catch (SQLException e1) {
					
							e1.printStackTrace();
						}
						if(flag == 1){
							try {
								boolean flag1 = Factory.getUserDaoIntance().revokeGetTicketLisi(userName);
								if(flag1){
									out.print("true") ;
								}else{
									out.print("false");
								}
							
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
				
		
				}else if(type.equals("sendNew")){   //发送票务信息
					String id = request.getParameter("carId") ;
					String msg = request.getParameter("msg") ;
					String newMsg = new String(msg.getBytes("ISO-8859-1"),"utf-8") ;
					String MSg = URLDecoder.decode(newMsg,"utf-8") ;
					int car_id = Integer.parseInt(id) ;
					List<Integer> userIds = Factory.getTicketDaoIntance().getUseridList(car_id);
				
							boolean flag = Factory.getMessageDAOInstance().sendMessage(userIds,MSg) ;
							if(flag){
								out.print("true");
							}else{
								out.print("false");
							}
					
					
				}else if(type.equals("deletecheci")){
					String id = request.getParameter("carId") ;
					int carId = Integer.parseInt(id) ;
					boolean  flag = Factory.getCarNumberDAOInstance().deleteCheci(carId) ;
					if(flag){
						out.print("true") ;
					}
				}
		
		}

		
		public void doPost(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			this.doGet(request, response) ;
		}

	}


