package net.itaem.test;

import java.util.Iterator;
import java.util.List;

import net.itaem.factory.Factory;
import net.itaem.po.Article;
import net.itaem.vo.ShowTitleVO;

/**
 * ���Žӿڲ�����
 * @author zhetang
 *
 */
public class ArticleTest {
	public static void main(String args[]){
		//����ҳ��
		int pageCount = 0  ;
		try {
			pageCount = Factory.getArticleDAOInstance().getPageCount(3);
			System.out.println("����ҳ��Ϊ��"+pageCount+"  ҳ") ;
		} catch (Exception e) {
			e.printStackTrace();
		}
		//��ҳ��ʾ������Ϣ
		try {
			List<ShowTitleVO> titles = Factory.getArticleDAOInstance().getNoteByPage(30, 1, "��Ԫ��") ;
			Iterator<ShowTitleVO> iter = titles.iterator() ;
			while(iter.hasNext()){
				ShowTitleVO title = iter.next();
				System.out.println("��ҳ�е����ű��⣺"+title) ;
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		//ɾ�����Ź���
		boolean flag = false ;
		try {
			flag = Factory.getArticleDAOInstance().deleteArticleByid(2);
			System.out.println("ɾ�����ţ�  "+flag) ;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//��������
		flag  =false ;
		try {
			flag = Factory.getArticleDAOInstance().createArticle("nemieeafa", "sdfadfas", "zhetang") ;
			System.out.println("�������ţ�"+flag) ;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//�������
		try {
			Article article = Factory.getArticleDAOInstance().getArticlebyId(3);
			System.out.println("������������:"+article);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
