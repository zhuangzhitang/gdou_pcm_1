package net.itaem.po;

import java.util.Date;
/**
 * 文章信息表
 * @author zhitang
 *
 */
public class Article {
	private int  articleId ;   //主键
	private String articleTitle ; //文章标题
	private String articleContent ;  //文章内容
	private Date articleDate ; //文章发布时间
	private String speaker ;  //文章发布者
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
