package net.itaem.po;

/**
 * �û���
 * @author zhitang
 *
 */
public class User {
	private int userId ;   //����
	private String userName ; //�û���
	private String password ; //����
	private String email ; // ����
	private int userType ; //�Ƿ��ֹ���û���Ʊ��1��ʾ����ֹ��0��ʾ��ֹ
	private int noteType ; //�Ƿ��ֹ���û������ظ���1��ʾ����ֹ��0��ʾ��ֹ
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getUserType() {
		return userType;
	}
	public void setUserType(int userType) {
		this.userType = userType;
	}
	public int getNoteType() {
		return noteType;
	}
	public void setNoteType(int noteType) {
		this.noteType = noteType;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName
				+ ", password=" + password + ", email=" + email + ", userType="
				+ userType + ", noteType=" + noteType + "]";
	}
	
	
}
