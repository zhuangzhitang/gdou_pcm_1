package net.itaem.vo;
/**
 *这是用户点击车队展示后，有用到的类对象
 *@author zhetang
 */
public class ShowTeamVO {
	private int id ; //车队id号
	private String TeamMsg ; //最近的订票信息
	private String image ;  //车队的图片
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTeamMsg() {
		return TeamMsg;
	}
	public void setTeamMsg(String teamMsg) {
		TeamMsg = teamMsg;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	@Override
	public String toString() {
		return "ShowTeamVO [id=" + id + ", TeamMsg=" + TeamMsg + ", image="
				+ image + "]";
	}
}
