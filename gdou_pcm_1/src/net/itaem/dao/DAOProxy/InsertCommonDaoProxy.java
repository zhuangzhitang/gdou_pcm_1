package net.itaem.dao.DAOProxy;

import java.util.List;

import net.itaem.dao.DAOImpl.InsertCommonNameDaoImpl;
import net.itaem.dao.IDAO.InsertCommonNameDao;
import net.itaem.po.CommonName;
import net.itaem.tool.DataBaseConnection;
import net.itaem.vo.ShowUserMessageVo;
/*
 * 接口InsertCommonNameDao的代理实现类
 * @author zaopeng
 */
public class InsertCommonDaoProxy implements InsertCommonNameDao {
   private DataBaseConnection db=null;
   private InsertCommonNameDao insert=null;
   public InsertCommonDaoProxy(){
	   this.db=new DataBaseConnection();
	   this.insert=new InsertCommonNameDaoImpl(db.getConnection());
   }
	public boolean insertCommonName(String username, String true_name,
			String idcard, String phone, int shortphone) {
		boolean b=false;
		b=this.insert.insertCommonName(username, true_name, idcard, phone, shortphone);
		return b;
	}

	public boolean changeMessage(String username, String true_name,
			String idcard, String phone, int shortphone) {
		boolean b=false;
		b=this.insert.changeMessage(username, true_name, idcard, phone, shortphone);
		return b;
	}
	public ShowUserMessageVo getUserMessage(String username) {
	   return this.insert.getUserMessage(username);
	}
	public List<String> getCommonTrueName(String user_name) {
		return this.insert.getCommonTrueName(user_name);
	}
	public CommonName getDefultMessage(String user_name) {
		return this.insert.getDefultMessage(user_name);
	}
	public CommonName getCommonName(String user_name, String true_name) {
		return this.insert.getCommonName(user_name, true_name);
	}
	public boolean haveSameCommonName(String username, String truename) {
		return this.insert.haveSameCommonName(username, truename);
	}
	public boolean deleteCommonName(String username, String trueName) {
		
		return this.insert.deleteCommonName(username, trueName);
	}

}
