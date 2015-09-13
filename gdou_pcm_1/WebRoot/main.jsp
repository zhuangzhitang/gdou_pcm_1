<%@ page language="java" import="java.util.*,net.itaem.factory.*,net.itaem.vo.*" pageEncoding="utf-8"%>
<%@page import="net.itaem.vo.ShowCityVO"%>
<%@page import="net.itaem.factory.Factory"%>
<%@page import="net.itaem.dao.IDAO.GetTicketDao" %>
<%
	List<ShowTeamVO> teamvos = Factory.getTeamMsgDAOInstance().getAllTeamShow() ;
	Iterator<ShowTeamVO> iter = teamvos.iterator() ;

 %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="renderer" content="webkit"/>

<link rel="stylesheet" href="css/index_style.css" />
<script type="text/javascript" src="js/jquery-1.6.1.min.js"></script>
<script type="text/javascript" src="js/index.js"></script>
<link rel="stylesheet" href="css/datepicker.css" type="text/css" />
<script type="text/javascript" src="js/datepicker.js"></script>

<title>主页块</title>
<script>
$(document).ready(function(e) {
    

 $('.inputDate').DatePicker({
		format:'Y-m-d',
		date: $('#inputDate').val(),
		current: $('#inputDate').val(),
		starts: 1,
		position: 'right',
		onBeforeShow: function(){
			$('#inputDate').DatePickerSetDate($('#inputDate').val(), true);
		},
		onChange: function(formated, dates){
			$('#inputDate').val(formated);
			$('#inputDate').DatePickerHide();
		}
	});
	/*
	$("#search").click(function(){
	var date=$("#date").val();
	if(date==null||date==""){
	alert("请选择日期");
	}
	return false;
	});
	
	*/
});
   //parent.location.reload()
 </script>


</head>

<body onload="jiazai()">
	<div class="main">
	<div class="center">
        <div class="center_left">
        	<h3 id="click">车队信息</h3>
            <div>
            <ul id="pc">
            <%
	            while(iter.hasNext()){
					ShowTeamVO teamvo = iter.next() ;
					String imagepath = teamvo.getImage() ;
					int teamid = teamvo.getId() ;
                    String realpath = imagepath.substring(imagepath.indexOf(".")+3) ;
			%>
			   <li><a href="carshow.jsp?teamId=<%=teamid%>"><img src="<%=realpath %>" width="100%" height="170px"/></a></li>
			<%
				} 
            %>
            </ul>
            </div>
        </div>
        <div class="center_middle">
          <%!  
            	     GetTicketDao ticket=Factory.getTicketDaoIntance();
            	     ShowCityVO cityVO=ticket.getCityMessage();
            	     List<String> fromcity=cityVO.getFromCity();
            	     List<String> tocity=cityVO.getToCity();
            	     List<String> name=cityVO.getTeam_name();
           %>
        	<h3>预订车票&nbsp;<!-- <img src="image/search.png" /> --></h3>
            <div class="book">
             <form action="FindTicketServlet?type=FirstPage" method="post">
            	<table border="0">
                <col width="100px" />
                <tr>
            	<td class="tRight">车队：</td><td>
            	 <select name="name" style="width:160px">
                 <% 
            	         for(int i=0;i<name.size();i++){
            	        %>
                					<option  value=<%=name.get(i)%>><%=name.get(i)%></option>
                			<%
                			   }
                			 %>
                  </select>
                  </td>
                </tr>
                <tr>
            	<td class="tRight">始发地：</td>
            	<td>
            	 <select name="fromcity" style="width:160px">
            	          <%
            	              for(int i=0;i<fromcity.size();i++){
            	           %>
            	           <option value="<%=fromcity.get(i)%>"><%=fromcity.get(i)%></option>
            	           <%
            	             }
            	            %>
            	       </select>
            	  </td>
            	</tr>
                <tr>
                
                <td class="tRight">目的地：</td>
          <td>
                       <select name="tocity" style="width:160px">
                           <%
                               for(int i=0;i<tocity.size();i++){
                            %>
                            <option value="<%=tocity.get(i)%>"><%=tocity.get(i) %></option>
                            <%
                               }
                             %>
                       </select>
                   </td>
                </tr>
                <tr><td class="tRight">时间：</td>
               <td><input type="date" id="date" name="date" /></td></tr>
</td></tr>
                <tr >
                <td></td><td><input type="submit" value="查询" id="search" /></td>
                </tr>
                </table>
               </form>
            </div>
            <div class="right3">
                <h3>便民链接&nbsp;<!--<img src="image/ico_bm.png" /> --></h3>
                <p><a href="http://bbs.gdou.edu.cn/forum.php" target="new">海浪</a></p>
                <p><a href="http://weibo.com/hdxs90" target="new">海大夜洞</a></p>
                <p><a href="http://tieba.baidu.com/f?kw=%B9%E3%B6%AB%BA%A3%D1%F3%B4%F3%D1%A7" target="new">海大贴吧</a></p>
                <p><a href="http://210.38.137.101:9080/xsxt/" target="new">海大教务系统</a></p>
            </div>
        </div>
        <div class="center_right">
        	
            <div class="right2">
                <h3>网上购票客服&nbsp;<!-- <img src="image/kf_1.jpg" /> --></h3>
                <p><a href="#">车元素客服电话：23555654</a></p>
                <p><a href="#">服务时间：8:30~~21:00</a></p>
                <p><a href="#">粤逍遥客服电话：23555654</a></p>
                <p><a href="#">服务时间：8:30~~21:00</a></p>
                <p><a href="#">潮汕车讯客服电话：23555654</a></p>
                <p><a href="#">服务时间：8:30~~21:00</a></p>
            </div>
            <div class="right1">
                <h3>服务指南&nbsp;<!--<img src="image/ico_fw.png" />  --></h3>
                <p><a href="#">退票须知</a></p>
                <p><a href="#">注册须知</a></p>
                <p><a href="#">如何查看订票信息</a></p>
                <p><a href="#">查看个人订票信息</a></p>
            </div>
        </div>
        <div style="clear:both"></div>
        </div>
        
      </div>
</body>
</html>
