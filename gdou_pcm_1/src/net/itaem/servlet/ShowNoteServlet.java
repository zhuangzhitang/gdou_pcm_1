package net.itaem.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.itaem.factory.Factory;
import net.itaem.po.LiuYan;
import net.itaem.po.Note;
import net.itaem.vo.ShowTitleVO;

public class ShowNoteServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//得到type ,判断是想分页
	    request.setCharacterEncoding("utf-8") ;
		String type = request.getParameter("type") ;
		if(type.equals("fenye")){
			String pageNow  = request.getParameter("pageNow") ;
			request.setAttribute("pageNow", pageNow);
			request.getRequestDispatcher("forum_01.jsp").forward(request, response) ;
		}else if(type.equals("seek")){
			String actionFrom = (String)request.getParameter("action_from") ;
			String actionTO = (String)request.getParameter("action_to") ;
			String actionDate = (String)request.getParameter("action_date");
		
			List<ShowTitleVO> showvo = Factory.getNoteDAOInstatnce().SeekNote(actionFrom, actionTO, actionDate);
			request.setAttribute("showvo",showvo);
			type = "seek" ;
			request.setAttribute("seek",type );
			request.getRequestDispatcher("forum_01.jsp").forward(request, response) ;
			
		}else if(type.equals("showmynote")){     //我的帖子
			
				String userId =  (String)request.getSession().getAttribute("userid") ;
				if(userId == null){
					request.getRequestDispatcher("login.jsp?type=enter&tiaozhuang=mynote").forward(request, response) ;
				}else{
					int id = Integer.parseInt(userId) ;
					List<ShowTitleVO> shownotevos = Factory.getNoteDAOInstatnce().getNoteByPage(30,1,id);
					request.setAttribute("showmynotes", shownotevos);
					request.getRequestDispatcher("forum_04.jsp").forward(request, response) ;
				}
			
		}else if(type.equals("delmynote")){    //删除帖子
			 String userId =  (String)request.getSession().getAttribute("userid") ;
			 int userid = Integer.parseInt(userId) ;
			 String id = request.getParameter("noteId") ;
			 int noteId = Integer.parseInt(id);
			 boolean flag = false ; 
	
			 flag  = Factory.getNoteDAOInstatnce().deleteNoteById(noteId);
			 List<ShowTitleVO> shownotevos = Factory.getNoteDAOInstatnce().getNoteByPage(30,1, userid);
			 request.setAttribute("delete", flag) ;
			 request.setAttribute("showmynotes", shownotevos);
			 request.getRequestDispatcher("forum_04.jsp").forward(request, response) ;
		
		}else if(type.equals("createnote")){   //创建帖子
			String userId =  (String)request.getSession().getAttribute("userid") ;
			int id = Integer.parseInt(userId) ;
         	String notetitle = request.getParameter("notetitle") ;
			String actionfrom = request.getParameter("actionfrom") ;
			String actionto = request.getParameter("actionto") ;
			String actiondate = request.getParameter("actiondate") ;
			String noteContent = request.getParameter("notecontent") ;
			
			Note   note = new Note(id, notetitle, noteContent,actionfrom,actionto,actiondate) ;
			
			boolean flag = false ;
			
		   flag = Factory.getNoteDAOInstatnce().CreateNote(note);
		   request.getRequestDispatcher("forum_01.jsp").forward(request, response) ;
			  
 		}else if(type.equals("shownotecontent")){
 			String id = request.getParameter("noteid");
 			int noteId = Integer.parseInt(id);
	
			Note note =  Factory.getNoteDAOInstatnce().showNoteByid(noteId);
			List<LiuYan> liuyans = Factory.getLiuyanDAOInstance().getLiuyanByNoteId(noteId) ;
			request.setAttribute("liuyans", liuyans);
			request.setAttribute("showNoteContent", note);
			request.getRequestDispatcher("forum_03.jsp").forward(request, response) ;
		
 		}else if(type.equals("createliuyan")){   //创建留言
 			String creater = request.getParameter("username") ; 
 			if(creater == null || creater == ""){
 				creater = "游客" ;
 			}
 			String content = request.getParameter("liuyancontent") ;
 			String noteid = request.getParameter("noteid") ;
 			String liuyanid = request.getParameter("liuyanid") ;
 			int noteId = Integer.parseInt( noteid ) ; 
 			int parentkey = Integer.parseInt(liuyanid) ;
 			LiuYan liuyan = new LiuYan(creater,noteId,content,parentkey);
 			
 		
			boolean  flag = Factory.getLiuyanDAOInstance().createLiuyan(liuyan);  //是否创建成功
			Note note =  Factory.getNoteDAOInstatnce().showNoteByid(noteId);
			List<LiuYan> liuyans = Factory.getLiuyanDAOInstance().getLiuyanByNoteId(noteId) ;
			request.setAttribute("liuyans", liuyans);
			request.setAttribute("showNoteContent", note);
			request.getRequestDispatcher("forum_03.jsp").forward(request, response) ;
		
 		}else if(type.equals("getFatiePower")){
 			String userId =  (String)request.getSession().getAttribute("userid") ;
			if(userId == null){
				request.getRequestDispatcher("login.jsp?type=enter&tiaozhuang=sendNode").forward(request, response) ;
			}else {
				request.getRequestDispatcher("forum_02.jsp").forward(request, response) ;
			}
 		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response) ;
	}

}
