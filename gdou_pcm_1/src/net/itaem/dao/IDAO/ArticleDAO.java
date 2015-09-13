package net.itaem.dao.IDAO;

import java.util.List;

import net.itaem.po.Article;
import net.itaem.vo.ShowTitleVO;

/**
 * 这个接口涉及到文章表的dao层操作
 * @author zhetang
 *
 */
public interface ArticleDAO {
	public Article getArticlebyId(int article_id) ;  //浏览新闻公告，点击标题，加你的传进来，即可发回一个Article对象
	public boolean createArticle(String articleTitle,String ArticleContent,String speaker) ; 
	public boolean deleteArticleByid(int article_id) ;  //删除新闻公告
	public int getPageCount(int pageSize);  //发回共有多少页新闻
	public List<ShowTitleVO> getNoteByPage(int pageSize,int pageNUm,String speaker ) ; //分页显示新闻信息，当speaker为null显示所有新闻信息
}
