package net.itaem.po;
/**
 * ������
 * @author zhitang
 * change by zaopeng
 */
public class Ticket {
	private int ticketId ;  //����
	private int userId ;	//����������û����е�userId
	private int carId ; 	//��������ó��α��е�carId
	private String gocatLacation ;  //�³���
	private int ticketNum ; //Ʊ��
	private String truename;//��ʵ����
	private String  idcard;  //���֤����
	private String  phone; //�ֻ�����
	private int shortphone;//�̺�
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
