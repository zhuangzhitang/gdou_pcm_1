package net.itaem.po;

/**
 * ��Ϣ��ʾ��
 * @author zhitang
 *
 */
public class ticketMessage {
	private int msgId ; //����
	private int userId ; //����������û����userId
	private String message ;  //��Ϣ����
	private int ifSee ;   //��Ϣ��״̬����ʾ�Ƿ��û����ģ�Ĭ��Ϊ1��ʾľ�б����ģ�0��ʾ�Ѿ�������
	public int getMsgId() {
		return msgId;
	}
	public void setMsgId(int msgId) {
		this.msgId = msgId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getIfSee() {
		return ifSee;
	}
	public void setIfSee(int ifSee) {
		this.ifSee = ifSee;
	}
	@Override
	public String toString() {
		return "Message [msgId=" + msgId + ", userId=" + userId + ", message="
				+ message + ", ifSee=" + ifSee + "]";
	}
	
}
