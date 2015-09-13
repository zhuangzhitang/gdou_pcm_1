package net.itaem.po;

import java.util.Date;

/**
 * 留言信息表
 * @author zhitang
 * change_author zaopeng
 *
 */
public class LiuYan {
	private int liuYanId ;  //主键
	private String creater;  //外键，引用用户表中的userId
	private int noteId ;   //外键，应用帖子的noteId
	private String liuYanContent ;  //留言内容
	private Date insertTime ;  //留言发布时间
	private int parentkey;   //该留言的上一层回复的id
	public LiuYan(){
		
	}
	/**
	 * 通过属性creater,noteId,liuYanContent,parentkey来创建留言
	 * @param creater
	 * @param noteId
	 * @param liuYanContent
	 * @param parentkey
	 */
	public LiuYan( String creater, int noteId,
			String liuYanContent, int parentkey) {
		super();
		this.creater = creater;
		this.noteId = noteId;
		this.liuYanContent = liuYanContent;
		this.parentkey = parentkey;
	}
	public String getCreater() {
		return creater;
	}
	public void setCreater(String creater) {
		this.creater = creater;
	}
	public int getParentkey() {
		return parentkey;
	}
	public void setParentkey(int parentkey) {
		this.parentkey = parentkey;
	}
	public int getLiuYanId() {
		return liuYanId;
	}
	public void setLiuYanId(int liuYanId) {
		this.liuYanId = liuYanId;
	}
	
	public int getNoteId() {
		return noteId;
	}
	public void setNoteId(int noteId) {
		this.noteId = noteId;
	}
	public String getLiuYanContent() {
		return liuYanContent;
	}
	public void setLiuYanContent(String liuYanContent) {
		this.liuYanContent = liuYanContent;
	}
	public Date getInsertTime() {
		return insertTime;
	}
	public void setInsertTime(Date insertTime) {
		this.insertTime = insertTime;
	}
	@Override
	public String toString() {
		return "LiuYan [liuYanId=" + liuYanId + ", creater=" + creater
				+ ", noteId=" + noteId + ", liuYanContent=" + liuYanContent
				+ ", insertTime=" + insertTime +",parentkey="+parentkey+ "]";
	}
	
}
