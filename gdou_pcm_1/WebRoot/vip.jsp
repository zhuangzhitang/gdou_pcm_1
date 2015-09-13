<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge"/>
<meta name="renderer" content="webkit" />
<link rel="stylesheet" href="css/vip.css" />
<script type="text/javascript" src="js/jquery-1.6.1.min.js"></script>
<script type="text/javascript" src="js/index.js"></script>
<title>会员中心</title>
<script type="text/javascript">
$(document).ready(function(e) {
	$("#iframe",window.parent.document).height($("body").height()+10);
	
	var list = $(".type_list ul li")
  
        list.click(function(e) {
		
        list.removeClass("selected");
		$(this).addClass("selected");
		
   	 });
     list.each(function(index) {
		 $(this).click(function() {
		 
            $("div.contentin").removeClass("contentin");
			$("div.vip_right").eq(index).addClass("contentin");
			$("#iframe",window.parent.document).height($("body").height()+10);
        });
		 
		  });	
	$(".addbtn").click(function(e) {
        var addTr =$("<tr><td><input type='text' name='truename' style='width:120px;'/></td><td><input type='text' width='100px' name='idcard'/></td><td><input type='text' name='phone' /></td><td><input type='text' name='shortphone'  style='width:80px;'/></td><td><input type='submit' value='保存' /></td></tr>");
		
		$(".haha").append(addTr);
		$("#iframe",window.parent.document).height($("body").height()+10);
    });
	

});
	
	
	



     //parent.location.reload();
     
</script> 
</head>

<body>
	<div class="center">
    	<div class="vip_list">
        	<div class="vip_title">
              <div class="info_ico">&nbsp;会员中心  
              </div>
            </div>
            <div class="type_list">
            	<ul>
                	<li class="selected">我的订单</li>
                    <li>常用姓名</li>
                    <li>个人信息</li>
                    <li>修改密码</li>
                    <li>我的消息</li>
                   
                </ul>
            </div>
        </div>
         <!--我的订单模块-->
         
         
        <div class="vip_right contentin">
            <div class="vip_r_hd">
                <div class="info_list">
                    我的订单
                </div>
            </div>
            <div class="subframe">
             <form action="RefundTicket" method="post">
            	<table width="100%">
                	<tr>
                    	<th>ID号</th><th>车次</th><th>起始城市</th><th>到达城市</th><th>上次地点</th><th>发车日期</th><th>发车时间</th><th>车队</th><th>票价</th><th>票数</th><th>操作</th>
                    </tr>
                    
                     <c:if test="${fn:length(List_ShowTicketVO)==0}">
                        <Center>当前您没有订票，故没有订单</Center>
                     </c:if>
                   
                     <c:forEach items="${List_ShowTicketVO}" var="t">
                    <tr >
                    	<td><input type="hidden" name="ticketid" value="${t.ticket_id}">${t.ticket_id}</td>
                    	<td>${t.ticket_no}</td>
                    	<td>${t.ticket_from}</td>
                    	<td>${t.ticket_to}</td>
                    	<td>${t.gocar_location}</td>
                    	<td>${t.ticket_Date}</td>
                    	<td>${t.ticket_time}</td>
                    	<td>${t.ticket_name}</td>
                    	<td>${t.ticket_price}</td>
                    	<td>${t.ticket_num}</td>
                    	<td><input type="submit" value="退票" onclick="return confirm('您确认订票吗？');"/></td>
                    </tr>
                    </c:forEach>
                  
                     
                      <c:if test="${param.type=='change'}">
                      <tr><td colspan="10">信息通告:${isSuccess}</td></tr>
                      </c:if>
                     
                </table>
                </form>
            </div>
            
        </div>
       
         
        <!--常用姓名模块-->
        <div class="vip_right">
        	<div class="vip_r_hd">
                <div class="info_list">
                    常用姓名
                </div>
            </div>
             <div class="subframe">
            	<table width="650px" class="real">
                	<tr>
                    	<th>真实姓名</th><th width="100px">身份证号码</th><th>手机号码</th><th>短号</th><th>操作</th>
                    </tr>
                    
                      <c:forEach items="${list_common}" var="com">
                    <tr>
                    	<td>${com.trueName}</td>
                    	<td>${com.idCard}</td>
                    	<td>${com.phone}</td>
                    	<td>${com.shortPhone}</td>
                    	<td><a href="CommonNameServlet?type=delete&truename=${com.trueName}"><input type="button" value="删除" onclick="return confirm('您确认删除常用姓名吗？');"/></a></td>
                    	
                    </tr>
                    </c:forEach>
                    
                </table>
                <form action="CommonNameServlet?type=insert" method="post">
                <table width="650px" class="haha"><tr></tr></table>
                </form>
            </div>
            <div class="add"><input type="button" value="添加" class="addbtn" /></div>
        </div>
       
         <!--个人信息模块-->
        <div class="vip_right">
        	<div class="vip_r_hd">
                <div class="info_list">
                   个人信息
                </div>
            </div>
             <div class="subframe">
              <form action="PersonInformationServlet?type=update" method="post">
            	<ul>
                	<li>
                    <label><span class="xing">*</span>用户名：</label><div id="inp"><input type="text" value=${ShowUserMessage.user_name} ></div><div class="warnning">请填写用户名</div>
                    </li>
                    <li>
                    <label><span class="xing">*</span>邮箱：</label><div id="inp"><input type="text" value=${ShowUserMessage.mail} ></div><div class="warnning">请填写真实可用邮箱，接受交易提醒信息和取回密码</div>
                    </li>
                    <li>
                    <label><span class="xing">*</span>真实姓名：</label><div id="inp"><input type="text" value=${ShowUserMessage.true_name} name="truename"></div><div class="warnning">请填写真实姓名，取票时方便核实您的身份</div>
                    </li>
                   
                    <li>
                    <label><span class="xing">*</span>身份证号：</label><div id="inp"><input type="text" value=${ShowUserMessage.idcard} name="idcard"></div><div class="warnning">请填写身份证号，取票时方便核实您的身份</div>
                    </li>
                    <li>
                    <label><span class="xing">*</span>手机号：</label><div id="inp"><input type="text" value=${ShowUserMessage.phone} name="phone"></div><div class="warnning">请填写真实可用手机号，接受交易提醒信息和取回密码</div>
                    </li>
                     <li>
                    <label><span class="xing">*</span>短号：</label><div id="inp"><input type="text" value=${ShowUserMessage.shortphone} name="shortphone"></div><div class="warnning">请填写真实可用短号，方便联系</div>
                    </li>
                    <div style="clear:both"></div>
                </ul>
                 <div class="save"><input type="submit" value="保存" /></div>
                 </form>
            </div>
            
        </div>
       
         <!--修改密码模块-->
        <div class="vip_right">
        	<div class="vip_r_hd">
                <div class="info_list">
                   修改密码
                </div>
            </div>
             <div class="subframe">
             <form action="ChangePasswordServlet" method="post">
            	<ul>
                	<li>
                    <label><span class="xing">*</span>原密码：</label><div id="inp"><input type="password" name="oldPassword"/></div><div class="warnning"></div>
                    </li>
                    <li>
                    <label><span class="xing">*</span>新密码：</label><div id="inp"><input type="password" name="newPassword"/></div><div class="warnning"></div>
                    </li>
                    <li>
                    <label><span class="xing">*</span>确认新密码：</label><div id="inp"><input type="password" /></div><div class="warnning"></div>
                    </li>
                   
                    
                    <div style="clear:both"></div>
                </ul>
                 <div class="update"><input type="submit" value="修改" /></div>
                </form>
            </div>
            
        </div>
        
         <!--我的消息模块-->
        <div class="vip_right">
        	<div class="vip_r_hd">
                <div class="info_list">
                   我的消息
                </div>
                
            </div>
             <div class="subframe">
            	<ul>
            	
            	     <c:if test="${fn:length(unread)==0}">
            	        <c:if test="${fn:length(read)==0}">
            	          <center>对不起，暂时没有您的消息</center>
            	       </c:if>
            	    </c:if>
            	
            	 <c:forEach items="${unread}" var="Utm">
                <li><div class="message">${Utm.message}</div><div class="delete"><a href="MessageServlet?msg_id=${Utm.msgId}"><input type="button" value="删除"></a></div></li>
                </c:forEach>
                
                  <c:forEach items="${read}" var="tm">
                  <li><div class="message">${tm.message}</div><div class="delete"><a href="MessageServlet?msg_id=${tm.msgId}"><input type="button" value="删除"></a></div></li>
                  </c:forEach>
                  
                  <div style="clear:both"></div>
                </ul>
                <div style="clear:both"></div>
            </div>
            
        </div>
        
        <div style="clear:both"></div>
    </div>
    
</body>
</html>
