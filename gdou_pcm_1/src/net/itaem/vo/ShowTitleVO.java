package net.itaem.vo;

import java.util.Date;

/**
 * ������װnote��ʱ��ͱ������
 * @author zhetang
 *
 */
public class ShowTitleVO {
	private int Id ;//���ӵļ�
	private Date date ;    //����ʱ�䷢��ʱ��
	private String title ;   //���ӵı���
	
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
