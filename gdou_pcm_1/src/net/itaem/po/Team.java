package net.itaem.po;

/**
 * 车队信息表
 * @author zhitang
 *
 */
public class Team {
	private int teamId ;   //主键
	private String teamUserName ; //用户名 
	private String teamPassword ; //密码
	private String teamName ;  //车队名
    private String teamImage ; //车队的标识图片
    private String teamIntroduce ; //车队的介绍
    private String teamMessage ;  //优惠信息
	public int getTeamId() {
		return teamId;
	}
	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}
	public String getTeamUserName() {
		return teamUserName;
	}
	public void setTeamUserName(String teamUserName) {
		this.teamUserName = teamUserName;
	}
	public String getTeamPassword() {
		return teamPassword;
	}
	public void setTeamPassword(String teamPassword) {
		this.teamPassword = teamPassword;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public String getTeamImage() {
		return teamImage;
	}
	public void setTeamImage(String teamImage) {
		this.teamImage = teamImage;
	}
	public String getTeamIntroduce() {
		return teamIntroduce;
	}
	public void setTeamIntroduce(String teamIntroduce) {
		this.teamIntroduce = teamIntroduce;
	}
	public String getTeamMessage() {
		return teamMessage;
	}
	public void setTeamMessage(String teamMessage) {
		this.teamMessage = teamMessage;
	}
	@Override
	public String toString() {
		return "Team [teamId=" + teamId + ", teamUserName=" + teamUserName
				+ ", teamPassword=" + teamPassword + ", teamName=" + teamName
				+ ", teamImage=" + teamImage + ", teamIntroduce="
				+ teamIntroduce + ", teamMessage=" + teamMessage + "]";
	}
    
}
