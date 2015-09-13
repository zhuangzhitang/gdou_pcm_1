package net.itaem.po;

/**
 * 常用姓名表
 * @author zhitang
 *
 */
public class CommonName {
	private int nameId ; //主键
	private int userId ; //外键，引用用户表中的userId
	private String trueName ; //真实姓名
	private String idCard ; //身份证号
	private String phone ;   //手机号
	private int shortPhone ; //短号
	private int biaozhi;//标志
	public int getNameId() {
		return nameId;
	}
	public void setNameId(int nameId) {
		this.nameId = nameId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getTrueName() {
		return trueName;
	}
	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}
	public String getIdCard() {
		return idCard;
	}
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getShortPhone() {
		return shortPhone;
	}
	public void setShortPhone(int shortPhone) {
		this.shortPhone = shortPhone;
	}
	@Override
	public String toString() {
		return "CommonName [nameId=" + nameId + ", userId=" + userId
				+ ", trueName=" + trueName + ", idCard=" + idCard + ", phone="
				+ phone + ", shortPhone=" + shortPhone + "]";
	}
	public int getBiaozhi() {
		return biaozhi;
	}
	public void setBiaozhi(int biaozhi) {
		this.biaozhi = biaozhi;
	}
	
}
