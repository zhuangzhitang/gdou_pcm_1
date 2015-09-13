package net.itaem.po;
/**
 * 订单表
 * @author zhitang
 * change by zaopeng
 */
public class Ticket {
	private int ticketId ;  //主键
	private int userId ;	//外键，引用用户表中的userId
	private int carId ; 	//外键，引用车次表中的carId
	private String gocatLacation ;  //下车点
	private int ticketNum ; //票数
	private String truename;//真实姓名
	private String  idcard;  //身份证号码
	private String  phone; //手机号码
	private int shortphone;//短号
	public String getTruename() {
		return truename;
	}
	public void setTruename(String truename) {
		this.truename = truename;
	}
	public String getIdcard() {
		return idcard;
	}
	public void setIdcard(String string) {
		this.idcard = string;
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
	public int getTicketId() {
		return ticketId;
	}
	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getCarId() {
		return carId;
	}
	public void setCarId(int carId) {
		this.carId = carId;
	}
	public String getGocatLacation() {
		return gocatLacation;
	}
	public void setGocatLacation(String gocatLacation) {
		this.gocatLacation = gocatLacation;
	}
	public int getTicketNum() {
		return ticketNum;
	}
	public void setTicketNum(int ticketNum) {
		this.ticketNum = ticketNum;
	}
	@Override
	public String toString() {
		return "Ticket [ticketId=" + ticketId + 
				", userId=" + userId + ", carId=" + carId
				+ ", gocatLacation=" + gocatLacation + ", ticketNum="
				+ ticketNum + ",truename="+truename+",idcard="+idcard+",phone="+phone+"]";
	}
	
}
