package net.itaem.po;

/**
 * 管理员信息表
 * @author Administrator
 *
 */
public class WebMaster {
	private int masterId ;  //主键
	private String masterName ;  //用户名
	private String masterPassword ;  //密码
	public int getMasterId() {
		return masterId;
	}
	public void setMasterId(int masterId) {
		this.masterId = masterId;
	}
	public String getMasterName() {
		return masterName;
	}
	public void setMasterName(String masterName) {
		this.masterName = masterName;
	}
	public String getMasterPassword() {
		return masterPassword;
	}
	public void setMasterPassword(String masterPassword) {
		this.masterPassword = masterPassword;
	}
	@Override
	public String toString() {
		return "WebMaster [masterId=" + masterId + ", masterName=" + masterName
				+ ", masterPassword=" + masterPassword + "]";
	}
	
}
