package net.itaem.po;

/**
 * 信息提示表
 * @author zhitang
 *
 */
public class ticketMessage {
	private int msgId ; //主键
	private int userId ; //外键，引用用户表的userId
	private String message ;  //消息内容
	private int ifSee ;   //消息的状态，表示是否被用户查阅，默认为1表示木有被查阅，0表示已经被查阅
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
