package net.itaem.vo;
/**
 * ��̨����Ա�鿴һ�����ζ�Ʊ����Ϣ
 * @author zhetang
 *
 */
public class ShowDingPiaoMsgVO {
	private int user_id ;  // �û�id
	private String name  ;  //��ʵ����
	private String idcard ; //���֤��
	private String phone ; //�û��ĳ���
	private int shortphone ; //�û��̺�
	private int ticket_num ;  //��Ʊ��
	private int car_id ; 
	public int getCar_id() {
		return car_id;
	}

	public void setCar_id(int car_id) {
		this.car_id = car_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIdcard() {
		return idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getShortphone() {
		return shortphone;
	}

	public void setShortphone(int shortphone) {
		this.shortphone = shortphone;
	}

	public int getTicket_num() {
		return ticket_num;
	}

	public void setTicket_num(int ticket_num) {
		this.ticket_num = ticket_num;
	}

	@Override
	public String toString() {
		return "ShowDingPiaoMsgVO [user_id=" + user_id + ", name=" + name
				+ ", idcard=" + idcard + ", phone=" + phone + ", shortphone="
				+ shortphone + ", ticket_num=" + ticket_num + ", car_id="
				+ car_id + "]";
	}

	
}
