package net.itaem.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.itaem.factory.Factory;
import net.itaem.po.Article;
import net.itaem.po.LiuYan;
import net.itaem.po.Note;
import net.itaem.vo.ShowTitleVO;

public class NewServlet extends HttpServlet {



	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8") ;
		String type = request.getParameter("type") ;
		if(type.equals("fenye")){   //新闻分页（新闻列表展示）
			int pageSize = 10 ;   //页数
			String pageNow1  = request.getParameter("pageNow") ;
			int pageCount = Factory.getArticleDAOInstance().getPageCount(pageSize);
			int pageNow = Integer.parseInt(pageNow1);
			List<ShowTitleVO> titles = Factory.getArticleDAOInstance().getNoteByPage(pageSize, pageNow, "") ;
			request.setAttribute("pageNow", pageNow);
			request.setAttribute("pageCount", pageCount) ;
			request.setAttribute("pageSize", pageSize) ;
			request.setAttribute("titles", titles) ;
			request.getRequestDispatcher("new.jsp").forward(request, response) ;
		}else if(type.equals("shownotecontent")){    //展示新闻内容
 			String id = request.getParameter("noteid");
 			int newId = Integer.parseInt(id);
 		   
	     	Article article = Factory.getArticleDAOInstance().getArticlebyId(newId);
	     	request.setAttribute("article",article) ;
			request.getRequestDispatcher("article.jsp").forward(request, response) ;
		
 		}else if(type.equals("houtaixinwen")){   //后台新闻
 		
 				String speaker = request.getParameter("speaker") ;
 				String speaker1  = new String(speaker.getBytes("ISO-8859-1"),"utf-8") ;
 				String speaker2 = URLDecoder.decode(speaker1,"utf-8") ;
				List<ShowTitleVO> titles = Factory.getArticleDAOInstance().getNoteByPage(30, 1, speaker2) ;
				request.setAttribute("titles", titles) ;
				request.setAttribute("speaker",speaker2) ;
				request.getRequestDispatcher("admin/admin_04.jsp").forward(request, response) ;
		
 		}else if(type.equals("deletehtxinwen")){    //删除新闻
 			String id = request.getParameter("newId") ;
 			int newId = Integer.parseInt(id) ;
 			boolean flag = false ;
 		
				flag = Factory.getArticleDAOInstance().deleteArticleByid(newId);
				String speaker = request.getParameter("speaker") ;
 				String speaker1  = new String(speaker.getBytes("ISO-8859-1"),"utf-8") ;
 				String speaker2 = URLDecoder.decode(speaker1,"utf-8") ;
				List<ShowTitleVO> titles = Factory.getArticleDAOInstance().getNoteByPage(30, 1, speaker2);
			    type = "delete" ;    //状态吗
				request.setAttribute("type",type );
				request.setAttribute("titles", titles) ;
				request.setAttribute("speaker", speaker) ;
				request.getRequestDispatcher("admin/admin_04.jsp").forward(request, response) ;
		
 		}else if(type.equals("htfabuxinwen")){      //发布新闻
 			String speaker = request.getParameter("speaker") ;
			String speaker1  = new String(speaker.getBytes("ISO-8859-1"),"utf-8") ;
			String speaker2 = URLDecoder.decode(speaker1,"utf-8") ;
 			String newsTitle = request.getParameter("newtitle") ;
 			String newsContent = request.getParameter("newcontent") ;
 			boolean flag  =false ;
 			
			flag = Factory.getArticleDAOInstance().createArticle(newsTitle, newsContent, speaker2) ;
			List<ShowTitleVO> titles = Factory.getArticleDAOInstance().getNoteByPage(30, 1, speaker2) ;
			request.setAttribute("titles", titles) ;
			request.setAttribute("speaker", speaker2) ;
			request.getRequestDispatcher("admin/admin_04.jsp").forward(request, response) ;
			
		}
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response) ;
	}

}
