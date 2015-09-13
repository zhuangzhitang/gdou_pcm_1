package net.itaem.po;

/**
 * 用户表
 * @author zhitang
 *
 */
public class User {
	private int userId ;   //主键
	private String userName ; //用户名
	private String password ; //密码
	private String email ; // 邮箱
	private int userType ; //是否禁止该用户订票，1表示不禁止，0表示禁止
	private int noteType ; //是否禁止该用户发帖回复，1表示不禁止，0表示禁止
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
