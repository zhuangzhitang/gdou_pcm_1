package net.itaem.po;

/**
 * ����Ա��Ϣ��
 * @author Administrator
 *
 */
public class WebMaster {
	private int masterId ;  //����
	private String masterName ;  //�û���
	private String masterPassword ;  //����
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
