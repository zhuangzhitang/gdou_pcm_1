package net.itaem.dao.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.itaem.dao.IDAO.ArticleDAO;
import net.itaem.po.Article;
import net.itaem.tool.ExceptionRecordTool;
import net.itaem.vo.ShowTitleVO;
/**
 * ʵ������dao������з���
 * @author zhetang
 *
 */
public class ArticleDAOImpl implements ArticleDAO {
	private Connection conn ;
	public ArticleDAOImpl(Connection conn){
		this.conn = conn ;
	}
	/**
	 * ͨ�����ŵ�id�ŷ������Ŷ���Ӿ����ʾ���ű���
	 */
	public Article getArticlebyId(int article_id) {
		Article article = null ; 
		String sql = "select * from news where article_id = ?" ;
		PreparedStatement pst = null ;
		ResultSet rs = null ;
		try{
			pst = conn.prepareStatement(sql) ;
			pst.setInt(1, article_id) ;
			rs = pst.executeQuery() ;
			if(rs.next()){
				article =new Article() ;
				article.setArticleId(rs.getInt("article_id")) ;
				article.setArticleTitle(rs.getString("article_title")) ;
				article.setArticleContent(rs.getString("article_content")) ;
				article.setArticleDate(rs.getDate("article_date")) ;
				article.setSpeaker(rs.getString("speaker")) ;
			}
		}catch(Exception e){
			ExceptionRecordTool.writeExceptionRecord(e);
			e.printStackTrace();
		}finally{
			if(rs!=null){
				try {
					rs.close();
				} catch (SQLException e) {
				
					e.printStackTrace();
				}
				rs = null ;
			}
			if(pst!=null){
				try {
					pst.close();
				} catch (SQLException e) {
				
					e.printStackTrace();
				}
				pst = null ;
			}
		}
		return article;
	}
	/**
	 * ����������Ϣ��������Ա��д��������Ϣ�󣬵���ύ�����ø÷�������д�����ݿ�
	 */
	public boolean createArticle(String articleTitle, String articleContent,
			String speaker){
		boolean flag = false ;
		String sql = "insert into news(article_title,article_content,speaker)values(?,?,?)" ;
		PreparedStatement pst = null ;
		try{
			pst = conn.prepareStatement(sql) ;
			pst.setString(1, articleTitle) ;
			pst.setString(2, articleContent) ;
			pst.setString(3,speaker) ;
			pst.executeUpdate() ;
			flag = true ;
		}catch(Exception e){
			ExceptionRecordTool.writeExceptionRecord(e);
			e.printStackTrace();
		}finally{
			if(pst!=null){
				try {
					pst.close();
				} catch (SQLException e) {
				
					e.printStackTrace();
				}
				pst = null ;
			}
		}
		return flag;
	}
	/**
	 * ɾ������
	 */
	public boolean deleteArticleByid(int article_id)  {
		boolean flag = false ;
		String sql = "delete from news where article_id=?" ;
		PreparedStatement pst = null ;
		try{
		     pst = conn.prepareStatement(sql) ;
		     pst.setInt(1, article_id) ;
		     pst.executeUpdate() ;
		     flag = true ;
		}catch(Exception e){
			ExceptionRecordTool.writeExceptionRecord(e);
			e.printStackTrace();
		}finally{
			
		}
		return flag;
	}
	/**
	 * ����ҳ��
	 */
	public int getPageCount(int pageSize) {
		String sql = "select count(*) from news" ;
		int articleCount = 0 ;
		int pageCount = 0 ;
	    PreparedStatement pst = null ;
	    ResultSet rs = null ;
	    try{
	    	pst = conn.prepareStatement(sql) ;
	    	rs = pst.executeQuery() ;
	    	if(rs.next()){
	    		articleCount = rs.getInt(1);
		    	if(articleCount%pageSize==0){
		    		pageCount = articleCount/pageSize ;
		    	}else{
		    		pageCount = articleCount/pageSize +1 ;
		    	}
	    	}
	    	
	    }catch(Exception e){
	    	ExceptionRecordTool.writeExceptionRecord(e);
			e.printStackTrace();
	    }finally{
	    	if(rs!=null){
	    		try {
					rs.close() ;
				} catch (SQLException e) {
		
					e.printStackTrace();
				}
	    		rs = null ;
	    	}
	    	if(pst !=null){
	    		try {
					pst.close();
				} catch (SQLException e) {
				
					e.printStackTrace();
				}
	    		pst = null ;
	    	}
	    }
		return pageCount;
	}
	/**
	 * Ӿ����ʾ���е����ű���
	 */
	public List<ShowTitleVO> getNoteByPage(int pageSize, int pageNum,
			String speaker) {
		List<ShowTitleVO> titles = new ArrayList<ShowTitleVO>() ;
		PreparedStatement pst = null ;
		ResultSet rs = null;
		String sql = null ; 
		if(speaker == null||speaker==""){
			sql= "select * from news limit ?,?" ;
			try {
				pst = conn.prepareStatement(sql) ;
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			int firstnote = (pageNum-1)*pageSize ;
			try {
				pst.setInt(1, firstnote) ;
				pst.setInt(2,pageSize) ;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
		}else{
			sql = "select * from news where speaker=? " ;
			try {
				pst = conn.prepareStatement(sql) ;
				pst.setString(1, speaker);
			} catch (SQLException e) {
			
			}
		}
		try{
			rs = pst.executeQuery() ;
			while(rs.next()){
				ShowTitleVO title = new ShowTitleVO();
				title.setDate(rs.getDate("article_date")) ;
				title.setNoteId(rs.getInt("article_id")) ;
				title.setTitle(rs.getString("article_title")) ;
				titles.add(title) ;
			}
		}catch(Exception e){
			ExceptionRecordTool.writeExceptionRecord(e);
			e.printStackTrace();
		}finally{
			if(rs!=null){
				try {
					rs.close() ;
				} catch (SQLException e) {
					e.printStackTrace();
				}
				rs = null ;
			}
			if(pst!=null){
				try {
					pst.close();
				} catch (SQLException e) {
			
					e.printStackTrace();
				}
				pst = null ;
			}
		}
		return titles;
	}

}
