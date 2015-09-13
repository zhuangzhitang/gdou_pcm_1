package net.itaem.dao.IDAO;

import java.util.List;

import net.itaem.po.Article;
import net.itaem.vo.ShowTitleVO;

/**
 * ����ӿ��漰�����±��dao�����
 * @author zhetang
 *
 */
public interface ArticleDAO {
	public Article getArticlebyId(int article_id) ;  //������Ź��棬������⣬����Ĵ����������ɷ���һ��Article����
	public boolean createArticle(String articleTitle,String ArticleContent,String speaker) ; 
	public boolean deleteArticleByid(int article_id) ;  //ɾ�����Ź���
	public int getPageCount(int pageSize);  //���ع��ж���ҳ����
	public List<ShowTitleVO> getNoteByPage(int pageSize,int pageNUm,String speaker ) ; //��ҳ��ʾ������Ϣ����speakerΪnull��ʾ����������Ϣ
}
