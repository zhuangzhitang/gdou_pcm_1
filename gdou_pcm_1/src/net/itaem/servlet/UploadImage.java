package net.itaem.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.DiskFileUpload;
import org.apache.commons.fileupload.FileItem;

public class UploadImage extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8") ;
		PrintWriter out = response.getWriter();
		//String path = request.getContextPath();
		//String url = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
		
		//String uploadmessage = "";
		try{
		 DiskFileUpload fu = new DiskFileUpload();
			//fu.setSizeMax(200*1000);
		 List fileItems = fu.parseRequest(request);
			
		 Iterator i = fileItems.iterator();
		
		while(i.hasNext()){
			FileItem fi = (FileItem)i.next();
			if(!fi.isFormField()){
				if (fi.getSize()<=0){
					fi.delete();
					//uploadmessage = "上传的文件大小不能为零！";
				}
				else{
					String fileName = fi.getName();
					if (fileName==null || ("").equals(fileName) )
					    return;
					String ext = fileName.substring(fileName.lastIndexOf(".")+1);
					ext = ext.toLowerCase();
					String savePath = getServletContext().getRealPath("\\uploadimages\\");
					request.setAttribute("url", savePath) ;	
					request.getRequestDispatcher("test.jsp").forward(request, response) ;
					File savePathFile = new File(savePath);
					if (!savePathFile.exists()) {
						savePathFile.mkdirs();
					}
					String saveName = System.currentTimeMillis()+"."+ext;
					fi.write(new File(savePath + "\\" + saveName));
					//uploadmessage = "上传成功！";	
				}}}
		}catch(Exception e){
			System.err.println("up rcm pic:"+e.toString());
			//uploadmessage = "上传失败，请重新上传！";
		}
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response) ;
	}

}
