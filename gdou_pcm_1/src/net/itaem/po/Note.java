package net.itaem.po;

import java.util.Date;

/**
 * 帖子表
 * @author zhitang
 *
 */
public class Note {
	private int noteId ;   //主键
	private int userId ;	//外键,引用用户表的userId
	private String noteTitle ; //标题
	private String noteContent ;  //内容
	private String actionFrom ;   //出发地
	private String actionTo ;   //目的地
	private String time ;     //时间
	private Date insertTime ;  //发布时间
	
	public Note(){
		
	}
	
	public Note(int userId, String noteTitle, String noteContent,
			String actionFrom, String actionTo, String time) {
		super();
		this.userId = userId;
		this.noteTitle = noteTitle;
		this.noteContent = noteContent;
		this.actionFrom = actionFrom;
		this.actionTo = actionTo;
		this.time = time;
	}
	public int getNoteId() {
		return noteId;
	}
	public void setNoteId(int noteId) {
		this.noteId = noteId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getNoteTitle() {
		return noteTitle;
	}
	public void setNoteTitle(String noteTitle) {
		this.noteTitle = noteTitle;
	}
	public String getNoteContent() {
		return noteContent;
	}
	public void setNoteContent(String noteContent) {
		this.noteContent = noteContent;
	}
	public String getActionFrom() {
		return actionFrom;
	}
	public void setActionFrom(String actionFrom) {
		this.actionFrom = actionFrom;
	}
	public String getActionTo() {
		return actionTo;
	}
	public void setActionTo(String actionTo) {
		this.actionTo = actionTo;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public Date getInsertTime() {
		return insertTime;
	}
	public void setInsertTime(Date insertTime) {
		this.insertTime = insertTime;
	}
	@Override
	public String toString() {
		return "Note [noteId=" + noteId + ", userId=" + userId + ", noteTitle="
				+ noteTitle + ", noteContent=" + noteContent + ", actionFrom="
				+ actionFrom + ", actionTo=" + actionTo + ", time=" + time
				+ ", insertTime=" + insertTime + "]";
	}
	
}
