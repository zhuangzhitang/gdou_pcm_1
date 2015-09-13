package net.itaem.po;

import java.util.Date;

/**
 * ���α���Ϣ
 * @author zhitang
 *
 */
public class CarNumber{
	
	private int carId ;  //����
	private int teamId ;  //���,���ó�����Ϣ���teamId 
	private int ticketNo ; //����
	private String ticketFrom ; //��������
	private String ticketTo ;  //�������

	private String ticketTime ; //����ʱ��
	private Date ticketDate ; //����ʱ��

	private String teamName ; //���ӵ�����
	public  CarNumber(){
		
	}
	public CarNumber( int teamId, int ticketNo, String ticketFrom,
			String ticketTo, String ticketTime, Date ticketDate,
			String teamName, float ticketPrice, int ticketExcept) {
		super();
	
		this.teamId = teamId;
		this.ticketNo = ticketNo;
		this.ticketFrom = ticketFrom;
		this.ticketTo = ticketTo;
		this.ticketTime = ticketTime;
		this.ticketDate = ticketDate;
		this.teamName = teamName;
		this.ticketPrice = ticketPrice;
		this.ticketExcept = ticketExcept;
		
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	private float ticketPrice ; //Ʊ��
	private int  ticketExcept ; //��Ʊ
	private int ticketType ; //Ʊ��״̬
	public String TicketName;  //��������
	public String getTicketName() {
		return TicketName;
	}
	public void setTicketName(String ticketName) {
		TicketName = ticketName;
	}
	public int getCarId() {
		return carId;
	}
	public void setCarId(int carId) {
		this.carId = carId;
	}
	public int getTeamId() {
		return teamId;
	}
	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}
	public int getTicketNo() {
		return ticketNo;
	}
	public void setTicketNo(int ticketNo) {
		this.ticketNo = ticketNo;
	}
	public String getTicketFrom() {
		return ticketFrom;
	}
	public void setTicketFrom(String ticketFrom) {
		this.ticketFrom = ticketFrom;
	}
	public String getTicketTo() {
		return ticketTo;
	}
	public void setTicketTo(String ticketTo) {
		this.ticketTo = ticketTo;
	}
	public String getTicketTime() {
		return ticketTime;
	}
	public void setTicketTime(String ticketTime) {
		this.ticketTime = ticketTime;
	}
	public Date getTicketDate() {
		return ticketDate;
	}
	public void setTicketDate(Date ticketDate) {
		this.ticketDate = ticketDate;
	}
	public float getTicketPrice() {
		return ticketPrice;
	}
	public void setTicketPrice(float ticketPrice) {
		this.ticketPrice = ticketPrice;
	}
	public int getTicketExcept() {
		return ticketExcept;
	}
	public void setTicketExcept(int ticketExcept) {
		this.ticketExcept = ticketExcept;
	}
	public int getTicketType() {
		return ticketType;
	}
	public void setTicketType(int ticketType) {
		this.ticketType = ticketType;
	}
	@Override
	public String toString() {
		return "CarNumber [carId=" + carId + ", teamId=" + teamId + ", ticketNo="
				+ ticketNo + ", ticketFrom=" + ticketFrom + ", ticketTo="
				+ ticketTo + ", ticketTime=" + ticketTime + ", ticketDate="
				+ ticketDate + ", ticketPrice=" + ticketPrice
				+ ", ticketExcept=" + ticketExcept + ", ticketType="
				+ ticketType + "]";
	}
	
}
