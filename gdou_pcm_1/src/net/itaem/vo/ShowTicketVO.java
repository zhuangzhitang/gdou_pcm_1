package net.itaem.vo;

public class ShowTicketVO {
   private int ticket_no;//车次
   private String ticket_name;//车队名称
   private String ticket_from;//出发城市
   private String ticket_to;//到达城市
   private String gocar_location;//上车地点
   private String ticket_time;//上车时间
   private String ticket_Date;//上车日期
   private float ticket_price;//票价
   private int ticket_num;//票数
   private int ticket_yupiao;//余票数
   private int car_id;//车次的id号
   private int ticket_id;  //订单的ID号
public int getTicket_no() {
	return ticket_no;
}
public void setTicket_no(int ticket_no) {
	this.ticket_no = ticket_no;
}
public String getTicket_name() {
	return ticket_name;
}
public void setTicket_name(String ticket_name) {
	this.ticket_name = ticket_name;
}
public String getTicket_from() {
	return ticket_from;
}
public void setTicket_from(String ticket_from) {
	this.ticket_from = ticket_from;
}
public String getTicket_to() {
	return ticket_to;
}
public void setTicket_to(String ticket_to) {
	this.ticket_to = ticket_to;
}
public String getGocar_location() {
	return gocar_location;
}
public void setGocar_location(String gocar_location) {
	this.gocar_location = gocar_location;
}
public String getTicket_time() {
	return ticket_time;
}
public void setTicket_time(String ticket_time) {
	this.ticket_time = ticket_time;
}
public String getTicket_Date() {
	return ticket_Date;
}
public void setTicket_Date(String string) {
	this.ticket_Date = string;
}
public float getTicket_price() {
	return ticket_price;
}
public void setTicket_price(float ticket_price) {
	this.ticket_price = ticket_price;
}
public int getTicket_num() {
	return ticket_num;
}
public void setTicket_num(int ticket_num) {
	this.ticket_num = ticket_num;
}
public int getTicket_yupiao() {
	return ticket_yupiao;
}
public void setTicket_yupiao(int ticket_yupiao) {
	this.ticket_yupiao = ticket_yupiao;
}
public int getCar_id() {
	return car_id;
}
public void setCar_id(int car_id) {
	this.car_id = car_id;
}
public int getTicket_id() {
	return ticket_id;
}
public void setTicket_id(int ticket_id) {
	this.ticket_id = ticket_id;
}
}
