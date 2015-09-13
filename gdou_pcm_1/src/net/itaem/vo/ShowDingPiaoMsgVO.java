package net.itaem.vo;
/**
 * 后台管理员查看一个车次订票的信息
 * @author zhetang
 *
 */
public class ShowDingPiaoMsgVO {
	private int user_id ;  // 用户id
	private String name  ;  //真实姓名
	private String idcard ; //身份证号
	private String phone ; //用户的长号
	private int shortphone ; //用户短号
	private int ticket_num ;  //订票数
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
