package net.itaem.po;

/**
 * ������Ϣ��
 * @author zhitang
 *
 */
public class Team {
	private int teamId ;   //����
	private String teamUserName ; //�û��� 
	private String teamPassword ; //����
	private String teamName ;  //������
    private String teamImage ; //���ӵı�ʶͼƬ
    private String teamIntroduce ; //���ӵĽ���
    private String teamMessage ;  //�Ż���Ϣ
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
