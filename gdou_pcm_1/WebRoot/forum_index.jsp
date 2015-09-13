<%@ page language="java" import="java.util.*,net.itaem.vo.*,net.itaem.factory.*" pageEncoding="utf-8"%>
<%
	String type = (String)request.getAttribute("seek") ;
	String showmynote = (String)request.getAttribute("showmynotes");
	int pageNow = 1 ;     //当前的页数
	int pageCount = 0 ;   //总页数
	int pageSize = 10 ;    //每页展示的条目
	List<ShowTitleVO> shownotevos = null ;
	Iterator<ShowTitleVO> iter =null ;
	 if(showmynote != null){
		shownotevos  = (List<ShowTitleVO>)request.getAttribute("showmynotes") ;
		iter = shownotevos.iterator();
	}else if(type != null){
		 shownotevos = (List<ShowTitleVO>)request.getAttribute("showvo");
	     iter =shownotevos.iterator() ;
	}else{
	    String s_pageNow = (String)request.getAttribute("pageNow") ;  //获得页
		if(s_pageNow !=null){
		pageNow = Integer.parseInt(s_pageNow);
		}
		pageCount = Factory.getNoteDAOInstatnce().getPageCount(pageSize);
	    shownotevos = Factory.getNoteDAOInstatnce().getNoteByPage(pageSize,pageNow,0);
		iter = shownotevos.iterator();
}

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="renderer" content="webkit"/>

<link rel="stylesheet" href="css/forum_index.css" />
<script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="js/index.js"></script>
<link rel="stylesheet" href="css/datepicker.css" type="text/css" />
<script type="text/javascript" src="js/datepicker.js"></script>

<title>论坛首页</title>
<style type="text/css">
.paging_box{
	margin-bottom:0.5em;
	float:right;
	margin-top:0.5em;
	}
</style>
<script type="text/javascript">
$(document).ready(function(e) {
	var refresh= $("#iframe",window.parent.document).height($("body").height()+10);
	
	var list = $(".type_list ul li")
  
        list.click(function(e) {
		
        list.removeClass("selected");
		$(this).addClass("selected");
		
   	 });
     list.each(function(index) {
		 $(this).click(function() {
			 
            $("div.contentin").removeClass("contentin");
			$("div.forum_right").eq(index).addClass("contentin");
			$("#iframe",window.parent.document).height($("body").height()+10);
        });
		 
		  });	
});
	
	
	

</script>
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
});
 </script>
</head>

<body>
<div class="center">
<!--左边导航-->
	<div class="forum_list">
        <div class="forum_title">
          <div class="info_ico">拼车论坛</div>
        </div>
        <div class="type_list">
            <ul>
                <li  class="selected">论坛首页</li>
                <li>我的帖子</li> 
                <li>发布帖子</li>
            </ul>
        </div>
    </div>
  <!--导航结束-->
   <!--论坛首页开始-->
     <div class="forum_right contentin">
     	 <div class="forum_r_hd">
            <div class="info_list">
                论坛首页
            </div>
        </div>
        
        <div class="subframe_l">
            
        	<ul>
        	 <%
		  		while(iter.hasNext()){
					ShowTitleVO shownotevo =(ShowTitleVO)iter.next() ;
				%>
				 <li><span>[<%=shownotevo.getDate()%>]</span>
				  <a href="ShowNoteServlet?type=shownotecontent&noteid=<%=shownotevo.getNoteId() %>"><%=shownotevo.getTitle()%></a>
				 </li>
			   <%
			    }
			   %>      
            </ul>
       
             <div class="paging_box">
             <%
             		
      				 if(type == null){      
              %>
             	   <a href="ShowNoteServlet?type=fenye&pageNow=<%=(pageNow - 1)>0?(pageNow-1):1 %>">
    			     <span class="back"></span>
    		    	</a>
              <%
		            for(int i = 1 ; i <= pageCount ; i ++){
	           %>
					 <span class="current"> <a href="ShowNoteServlet?type=fenye&pageNow=<%=i %>"><%=i %></a></span>
	
	   	        <% } %>
                 <a href="ShowNoteServlet?type=fenye&pageNow=<%=((pageNow + 1)<=pageCount)?(pageNow+1):pageNow %>">
            			 <span class="next"></span>
                 </a>
            <%} %>
            </div>
        </div>
     <form name="query" id="query" action="ShowNoteServlet?type=seek" method="post">   
        <div class="subframe_r">
            <ul>
                <li>出发地：<input type="text" name="action_from"/></li>
                <li>目的地：<input type="text" name="action_to" /></li>
                <li>时&nbsp;&nbsp;间：<input class="inputDate" id="inputDate" name="action_date" value="2014-04-25" />
</li>
            </ul>
            <div class="check"><input type="submit" value="查询" /></div>
        </div>
     </form>
        
        <div style="clear:both"></div>
        
     </div>
      <!--论坛首页结束-->
      <!--我的帖子-->
      <div class="forum_right ">
     	 <div class="forum_r_hd">
            <div class="info_list">
                我的帖子
            </div>
        </div>
     	<div class="subframe">
        	<table width="100%">
            <tr><th>标题</th><th>时间</th><th>操作</th></tr>
          <%
   			  while(iter.hasNext()){
   				  ShowTitleVO shownotevo =(ShowTitleVO)iter.next() ;
   			%>  
				  <tr><td><a href="ShowNoteServlet?type=shownotecontent&noteid=<%=shownotevo.getNoteId() %>"><%=shownotevo.getTitle()%></a></td><td>[<%=shownotevo.getDate()%>]</td><td><input type="button" value="删除" /></td></tr>
  			 <%
 				  }
    		 %> 
          
            </table>
        	<div class="paging_box">
             
            
            </div>
             <div style="clear:both"></div>
        </div>
       
	</div>
    <!--发布帖子-->
    <form action="ShowNoteServlet?type=createnote" method="post">
    <div class="forum_right ">
     	 <div class="forum_r_hd">
            <div class="info_list">
                发布帖子
            </div>
        </div>
     	<div class="subframe">
        	<div class="title">
            标题：<input type="text"  name="notetitle"/>
            </div>
            <div class="place">
            出发地：<input type="text" name="actionfrom"/>
            目的地：<input type="text" name="actionto"/>
            出发时间：<input type="text" name="actiondate"/>
            </div>
        	<div class="content">
            <p>内容：</p>
            <textarea rows="7" cols="75" name="notecontent"></textarea>
            </div>
            <div class="send"><input type="submit" value="发布" /></div>
        </div>
       
	</div>
    </form>
    <div style="clear:both"></div>
</div>
</body>
</html>
