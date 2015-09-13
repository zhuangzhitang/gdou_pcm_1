package net.itaem.dao.DAOProxy;

import java.util.List;

import net.itaem.dao.DAOImpl.ArticleDAOImpl;
import net.itaem.dao.IDAO.ArticleDAO;
import net.itaem.po.Article;
import net.itaem.tool.DataBaseConnection;
import net.itaem.tool.ExceptionRecordTool;
import net.itaem.vo.ShowTitleVO;
/**
 * ¥˙¿Ì¿‡
 * @author zhetang
 *
 */
public class ArticleDAOProxy implements ArticleDAO {
	private ArticleDAOImpl dao = null;
	private DataBaseConnection dbc = null ;
	public ArticleDAOProxy(){
	    dbc = new DataBaseConnection() ;
	    dao = new ArticleDAOImpl(dbc.getConnection()) ;
	}
	public Article getArticlebyId(int article_id){
		Article article = null ;
		try{
			article =dao.getArticlebyId(article_id);
		}catch(Exception e){
			ExceptionRecordTool.writeExceptionRecord(e);
			e.printStackTrace();
		}
		return article ;
	}

	public boolean createArticle(String articleTitle, String articleContent,
			String speaker) {
		boolean flag = false ;
		try{
			flag = dao.createArticle(articleTitle, articleContent, speaker) ;
		}catch(Exception e){
			ExceptionRecordTool.writeExceptionRecord(e);
			e.printStackTrace();
		}
		return flag;
	}

	public boolean deleteArticleByid(int article_id)  {
		boolean flag = false ;
		try{
			flag = dao.deleteArticleByid(article_id) ;
		}catch(Exception e){
			ExceptionRecordTool.writeExceptionRecord(e);
			e.printStackTrace();
		}
		return flag;
	}

	public int getPageCount(int pageSize) {
		int pageCount = 0 ;
		try{
			pageCount = dao.getPageCount(pageSize) ;
		}catch(Exception e){
			ExceptionRecordTool.writeExceptionRecord(e);
			e.printStackTrace();
		}
		return pageCount;
	}

	public List<ShowTitleVO> getNoteByPage(int pageSize, int pageNUm,
			String speaker){
		List<ShowTitleVO> titles = null ;
		try{
			titles = dao.getNoteByPage(pageSize, pageNUm, speaker) ;
		}catch(Exception e){
			ExceptionRecordTool.writeExceptionRecord(e);
			e.printStackTrace();
		}
		return titles;
	}

}
