package net.itaem.po;

import java.util.Date;
/**
 * ������Ϣ��
 * @author zhitang
 *
 */
public class Article {
	private int  articleId ;   //����
	private String articleTitle ; //���±���
	private String articleContent ;  //��������
	private Date articleDate ; //���·���ʱ��
	private String speaker ;  //���·�����
	public int getArticleId() {
		return articleId;
	}
	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}
	public String getArticleTitle() {
		return articleTitle;
	}
	public void setArticleTitle(String articleTitle) {
		this.articleTitle = articleTitle;
	}
	public String getArticleContent() {
		return articleContent;
	}
	public void setArticleContent(String articleContent) {
		this.articleContent = articleContent;
	}
	public Date getArticleDate() {
		return articleDate;
	}
	public void setArticleDate(Date articleDate) {
		this.articleDate = articleDate;
	}
	public String getSpeaker() {
		return speaker;
	}
	public void setSpeaker(String speaker) {
		this.speaker = speaker;
	}
	@Override
	public String toString() {
		return "Article [articleId=" + articleId + ", articleTitle="
				+ articleTitle + ", articleContent=" + articleContent
				+ ", articleDate=" + articleDate + ", speaker=" + speaker + "]";
	}

}
