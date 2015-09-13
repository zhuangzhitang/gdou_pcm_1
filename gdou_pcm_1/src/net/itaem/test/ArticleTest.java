package net.itaem.test;

import java.util.Iterator;
import java.util.List;

import net.itaem.factory.Factory;
import net.itaem.po.Article;
import net.itaem.vo.ShowTitleVO;

/**
 * 新闻接口测试类
 * @author zhetang
 *
 */
public class ArticleTest {
	public static void main(String args[]){
		//发回页数
		int pageCount = 0  ;
		try {
			pageCount = Factory.getArticleDAOInstance().getPageCount(3);
			System.out.println("新闻页数为："+pageCount+"  页") ;
		} catch (Exception e) {
			e.printStackTrace();
		}
		//分页显示新闻信息
		try {
			List<ShowTitleVO> titles = Factory.getArticleDAOInstance().getNoteByPage(30, 1, "车元素") ;
			Iterator<ShowTitleVO> iter = titles.iterator() ;
			while(iter.hasNext()){
				ShowTitleVO title = iter.next();
				System.out.println("本页有的新闻标题："+title) ;
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		//删除新闻公告
		boolean flag = false ;
		try {
			flag = Factory.getArticleDAOInstance().deleteArticleByid(2);
			System.out.println("删除新闻：  "+flag) ;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//发布新闻
		flag  =false ;
		try {
			flag = Factory.getArticleDAOInstance().createArticle("nemieeafa", "sdfadfas", "zhetang") ;
			System.out.println("发布新闻："+flag) ;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//浏览新闻
		try {
			Article article = Factory.getArticleDAOInstance().getArticlebyId(3);
			System.out.println("发布新闻内容:"+article);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
