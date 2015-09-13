package net.itaem.servlet;

import java.io.File;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.itaem.factory.Factory;

import org.apache.commons.fileupload.DiskFileUpload;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;

public class TeamServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8") ;
		response.setCharacterEncoding("utf-8") ;
     	String id = request.getParameter("teamid") ;
		int teamId = 1;
		 if(id!=null){
			teamId = Integer.parseInt(id.trim()) ;
		}
	
			boolean flag = false ;
			String oldName = null ;
		
			    String teamintro = (String)request.getParameter("teamintr") ;
			    String teamIntro=new String(teamintro.getBytes("ISO-8859-1"),"utf-8");
			    String Intro=URLDecoder.decode(teamIntro,"utf-8");
			    
			    String teammsg = (String)request.getParameter("teammsg") ;
			    String msg = new String(teammsg.getBytes("ISO-8859-1"),"utf-8");
			    String teamMsg = URLDecoder.decode(msg,"utf-8") ;
			    String teamphoto = (String)request.getParameter("teamphoto") ;
			    oldName = teamphoto.substring(teamphoto.lastIndexOf("/")+1, teamphoto.lastIndexOf(".")) ;
			     if(teamphoto!=null ||"" != teamphoto){
			    	  String oldext = teamphoto.substring(teamphoto.lastIndexOf(".")+1) ;
					  
			     }
				
				 DiskFileUpload fu = new DiskFileUpload();
				 List fileItems = null ;
				try {
					fileItems = fu.parseRequest(request);
				} catch (FileUploadException e) {
					
					e.printStackTrace();
				}    //拿到所有的form标签
				 Iterator i = fileItems.iterator() ;
			
				 while(i.hasNext()){
					 FileItem fi = (FileItem)i.next() ;
					 if(!fi.isFormField()){
						 if(fi.getSize() <= 0){
							 fi.delete() ;
							// id = new String(id.getBytes("utf-8"),"ISO8859_1"); 
							 response.sendRedirect("admin/admin_01.jsp?teamId="+id) ;
							
						     flag = Factory.getTeamMsgDAOInstance().UpdateTeamMsg(teamId,teamphoto, teamMsg, Intro);
						   //  response.sendRedirect("index.jsp") ;
							 return ;
						 }else {
							 String fileName = fi.getName() ;
							 if(fileName == null || ("").equals(fileName)){
								 return ;
							 }
							 String ext = fileName.substring(fileName.lastIndexOf(".")+1) ;
							 ext = ext.toLowerCase() ;
							 String savePath = this.getServletContext().getRealPath("\\image\\") ;
							 
						
							 File savePathFile = new File(savePath) ;
							 if(!savePathFile.exists()){
								 savePathFile.mkdirs() ;
							 }
							 String saveName = oldName+"." + ext ;
							 try {
								fi.write(new File(savePath+"\\" + saveName)) ;
							} catch (Exception e) {
							
								e.printStackTrace();
							}
					         flag = Factory.getTeamMsgDAOInstance().UpdateTeamMsg(teamId,"../image/"+saveName,teamMsg, Intro);
							// id = new String(id.getBytes("utf-8"),"ISO8859_1"); 
							 response.sendRedirect("admin/admin_01.jsp?") ;
							 return ;
						 }
					 }
			 }
			   
		}
	
	

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response) ;
	}

}
