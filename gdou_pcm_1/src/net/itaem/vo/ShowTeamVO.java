package net.itaem.vo;
/**
 *�����û��������չʾ�����õ��������
 *@author zhetang
 */
public class ShowTeamVO {
	private int id ; //����id��
	private String TeamMsg ; //����Ķ�Ʊ��Ϣ
	private String image ;  //���ӵ�ͼƬ
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
