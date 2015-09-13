package net.itaem.po;

import java.util.Date;

/**
 * ������Ϣ��
 * @author zhitang
 * change_author zaopeng
 *
 */
public class LiuYan {
	private int liuYanId ;  //����
	private String creater;  //����������û����е�userId
	private int noteId ;   //�����Ӧ�����ӵ�noteId
	private String liuYanContent ;  //��������
	private Date insertTime ;  //���Է���ʱ��
	private int parentkey;   //�����Ե���һ��ظ���id
	public LiuYan(){
		
	}
	/**
	 * ͨ������creater,noteId,liuYanContent,parentkey����������
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
