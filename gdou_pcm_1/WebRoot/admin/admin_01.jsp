<%@ page language="java"
	import="java.util.*,net.itaem.po.*,net.itaem.factory.*"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link type="text/css" rel="stylesheet" href="../css/admin_01.css" />
<title>车队介绍</title>
<style>
</style>

</head>
<script type="text/javascript">
  	function upload(){
  	   
  		var filename = document.mainform.file.value ;
  		var teamintr = document.msg.teamintr.value ;
  		var teammsg = document.msg.teammsg.value ;
  		//alert(teammsg);
  		var teamphoto =  document.msg.teamphoto.value ;
  		var teamid = document.msg.teamid.value ;
  		// alert(teamid+teamintr+teamphoto+"dsfasdfa    "+teammsg) ;
  		if(filename == null || filename == ""){
  			 mainform.action = ("../TeamServlet?teamid="+teamid+"&teamphoto="+teamphoto+"&teammsg="+ teammsg+"&teamintr="+teamintr);
  		     mainform.submit() ;
            return true;
  		}
  		filename = filename.toLowerCase() ;
  		//alert("文件名："+filename) ;
  		var accept = false ;
  		accept |= (filename.indexOf('.jpg') > -1) ;
  		accept |= (filename.indexOf('.gif') > -1) ;
  		accept |= (filename.indexOf('.jpeg') > -1) ;
  		if(!accept){
  			alert("请选择允许上传的文件：.gif,jpg,.jpeg") ;
  			document.mainform.file.focus();
  			return false ;
  		}
  		 mainform.action = ("../TeamServlet?teamid="+teamid+"&teamphoto="+teamphoto+"&teammsg="+ teammsg+"&teamintr="+teamintr);
  		 mainform.submit() ;
         return true;
  	}
  </script>
<body>
	<%
		int teamId = (Integer) request.getSession().getAttribute("teamid");
		Team team = Factory.getTeamMsgDAOInstance().getTeamMsgById(teamId);
		pageContext.setAttribute("team", team);
	%>
	<div class="center_div">

		<div class="title">车队介绍</div>
		<form name="msg" method="get" action="">
			<div class="car_content">
				<p>
					车队名称： <input type="text" name="teamname"
						value="${team.getTeamName()}" />
				</p>
				<p>车队的介绍:</p>
				<textarea name="teamintr" rows="8" cols="47">${team.getTeamIntroduce()}</textarea>
				<p>优惠信息：</p>
				<%-- <textarea name="teammsg" class="xheditor {tools:'Bold,Italic,Underline,Strikethrough',skin:'default'}"  rows="5" cols="47" >${team.getTeamMessage()}</textarea> --%>
				<textarea name="teammsg" rows="5" cols="47">${team.getTeamMessage()}</textarea>
				<input type="hidden" name="teamid" value="${team.getTeamId()}" /> <input
					type="hidden" name="teamphoto" value="${team.getTeamImage()}" />
			</div>
		</form>
		<form action="../TeamServlet" enctype="multipart/form-data"
			name="mainform" onsubmit="return upload();" method="post">
			<div class="car_img">
				<div class="img_div">
					<img src="${team.getTeamImage()}" width="100" height="100" />
				</div>
				<br /> <input type="file" name="file" />
				<p>
					<font style="font-size:0.8em">(文件格式为gif,png)</font>
				</p>
				<p>
					<input type="submit" value="保存" />
				</p>
			</div>
		</form>
		<div class="hidden"></div>
	</div>
</body>
</html>
