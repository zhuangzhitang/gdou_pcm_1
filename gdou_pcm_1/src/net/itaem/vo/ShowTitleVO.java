package net.itaem.vo;

import java.util.Date;

/**
 * 用来封装note的时间和标题的类
 * @author zhetang
 *
 */
public class ShowTitleVO {
	private int Id ;//帖子的尖
	private Date date ;    //贴子时间发布时间
	private String title ;   //贴子的标题
	
	public int getNoteId() {
		return Id;
	}
	public void setNoteId(int noteId) {
		this.Id = noteId;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@Override
	public String toString() {
		return "ShowNoteVO [noteId=" + Id + ", date=" + date + ", title="
				+ title + "]";
	}
	
	
}
