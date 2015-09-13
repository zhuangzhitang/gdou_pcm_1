package net.itaem.dao.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



import net.itaem.dao.IDAO.InsertCommonNameDao;
import net.itaem.po.CommonName;
import net.itaem.vo.ShowUserMessageVo;
/*
 * 接口InsertCommonNameDao的实现类。
 * @author zaopeng
 */
public class InsertCommonNameDaoImpl implements InsertCommonNameDao {
   private Connection conn;
   public InsertCommonNameDaoImpl(Connection conn){
	   this.conn=conn;
   }
	public boolean insertCommonName(String username, String true_name,
			String idcard, String phone, int shortphone) {
		 boolean b=false;
		 int i=0;
		 int user_id=0;
		try {
			user_id = this.getUserid(username);
		} catch (Exception e) {
			e.printStackTrace();
		}
		 PreparedStatement pre=null;
		 String sql="insert into common_name(user_id,true_name,idcard,phone,shortphone,biaozhi) values (?,?,?,?,?,?)";
		 try {
			pre=conn.prepareStatement(sql);
			pre.setInt(1,user_id);
			pre.setString(2,true_name);
			pre.setString(3,idcard);
			pre.setString(4,phone);
			pre.setInt(5,shortphone);
			pre.setInt(6,1);
			i=pre.executeUpdate();
			 if(i==1){
				 b=true;
			 }
		} catch (SQLException e){ 
			e.printStackTrace();
		}
		return b;
	}
	/*
	 * 根据输入的用户名，获取其user_id
	 */
	public int getUserid(String username) throws Exception{
    	PreparedStatement pre=null;
    	ResultSet res=null;
    	int i=0;
    	String sql="select user_id from user where user_name=?";
    	try {
			pre=conn.prepareStatement(sql);
			pre.setString(1,username);
			res=pre.executeQuery();
			if(res.next()){
				i=res.getInt(1);
			}
		} catch (SQLException e) {
			
			throw e;
		}
    	return i;
    }
	public boolean changeMessage(String username, String true_name,
			String idcard, String phone, int shortphone) {
		boolean b=false;
		int i=0;
	    int user_id=0;
		try {
			user_id = this.getUserid(username);
		} catch (Exception e) {
			e.printStackTrace();
		}
	    PreparedStatement pre=null;
	    String sql="update common_name set true_name=?,idcard=?,phone=?,shortphone=? " +
	    		"where user_id=? and biaozhi=?";
	    try {
			pre=conn.prepareStatement(sql);
			pre.setString(1,true_name);
		    pre.setString(2,idcard);
		    pre.setString(3,phone);
		    pre.setInt(4,shortphone);
		    pre.setInt(5,user_id);
		    pre.setInt(6,0);
		    i=pre.executeUpdate();
		    if(i==1){
		    	b=true;
		    }
		} catch (SQLException e) {
			e.printStackTrace();
		}
	    
		return b;
	}
	public ShowUserMessageVo getUserMessage(String username) {
		int user_id=0;
		try {
			user_id = this.getUserid(username);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ShowUserMessageVo user=new ShowUserMessageVo();
		PreparedStatement pre=null;
		ResultSet res=null;
		String sql="select user_name,email,true_name,idcard,phone,shortphone from user natural join common_name " +
				   "where biaozhi=0 and user_id=?";
		try {
			pre=conn.prepareStatement(sql);
			pre.setInt(1,user_id);
			res=pre.executeQuery();
			while(res.next()){
				user.setUser_name(res.getString(1));
				user.setMail(res.getString(2));
				user.setTrue_name(res.getString(3));
				user.setIdcard(res.getString(4));
				user.setPhone(res.getString(5));
				user.setShortphone(res.getInt(6));
			    }
			} catch (SQLException e) {
			   e.printStackTrace();
		}finally{
			if(pre!=null){
			try {
				pre.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			pre=null;
		}
		if(res!=null){
			try {
				res.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			pre=null;
		}
		}
		return user;
	}
	public List<String> getCommonTrueName(String user_name) {
		int userid=0;
		try {
			userid = this.getUserid(user_name);
		} catch (Exception e) {
			e.printStackTrace();
		}
		List<String> commonName=new ArrayList<String>();
		PreparedStatement pre=null;
		ResultSet res=null;
		String sql="select true_name from common_name where user_id=? and biaozhi=?";
		try {
			pre=conn.prepareStatement(sql);
			pre.setInt(1,userid);
			pre.setInt(2,1);
			res=pre.executeQuery();
		    while(res.next()){
		    	commonName.add(res.getString(1));
		    }
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			if(pre!=null){
				try {
					pre.close();
					pre=null;
				} catch (SQLException e) {
					e.printStackTrace();
				}
				            
			}
			if(res!=null){
				try {
					res.close();
					res=null;
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return commonName;
	}
	public CommonName getDefultMessage(String user_name) {
		CommonName com=new CommonName();
		int user_id=0;
		try {
			user_id=this.getUserid(user_name);
		} catch (Exception e) {
			e.printStackTrace();
		}
		PreparedStatement pre=null;
		ResultSet res=null;
		String sql="select true_name,idcard,phone,shortphone from common_name where user_id=? and biaozhi=?";
		try {
			pre=conn.prepareStatement(sql);
			pre.setInt(1,user_id);
			pre.setInt(2,0);
			res=pre.executeQuery();
		    while(res.next()){
		    	com.setTrueName(res.getString(1));
		    	com.setIdCard(res.getString(2));
		    	com.setPhone(res.getString(3));
		    	com.setShortPhone(res.getInt(4));
		    }
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			if(pre!=null){
				try {
					pre.close();
					pre=null;
				} catch (SQLException e) {
					e.printStackTrace();
				}
				            
			}
			if(res!=null){
				try {
					res.close();
					res=null;
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return com;
	}
	public CommonName getCommonName(String user_name, String true_name) {
		CommonName com=new CommonName();
		int user_id=0;
		try {
			user_id=this.getUserid(user_name);
		} catch (Exception e) {
			e.printStackTrace();
		}
		PreparedStatement pre=null;
		ResultSet res=null;
		String sql="select true_name,idcard,phone,shortphone from common_name where user_id=? and biaozhi=? and true_name=?";
		try {
			pre=conn.prepareStatement(sql);
			pre.setInt(1,user_id);
			pre.setInt(2,1);
			pre.setString(3,true_name);
			res=pre.executeQuery();
		    while(res.next()){
		    	com.setTrueName(res.getString(1));
		    	com.setIdCard(res.getString(2));
		    	com.setPhone(res.getString(3));
		    	com.setShortPhone(res.getInt(4));
		    }
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			if(pre!=null){
				try {
					pre.close();
					pre=null;
				} catch (SQLException e) {
					e.printStackTrace();
				}
				            
			}
			if(res!=null){
				try {
					res.close();
					res=null;
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return com;
	}
	
	public boolean haveSameCommonName(String username, String truename) {
		boolean b=false;
		int userid=0;
		try {
			userid=this.getUserid(username);
		} catch (Exception e) {
			e.printStackTrace();
		}
		PreparedStatement pre=null;
		ResultSet res=null;
		int i=0;
		String sql="select count(*) from common_name where user_id=? and true_name=?";
		try {
			pre=conn.prepareStatement(sql);
			pre.setInt(1,userid);
			pre.setString(2,truename);
			res=pre.executeQuery();
			if(res.next()){
				i=res.getInt(1);
			}
			if(i>0){
				b=true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return b;
	}
	public boolean deleteCommonName(String username, String trueName) {
		int userid=0;
		int i=0;
		try {
			 userid=this.getUserid(username);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		boolean b=false;
		PreparedStatement pre=null;
		String sql="delete from common_name where  user_id= ? and true_name=? and biaozhi=1";
		try {
			pre=conn.prepareStatement(sql);
			pre.setInt(1, userid);
			pre.setString(2,trueName);
			i=pre.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(i>0){
			b=true;
		}
		return b;
	}

}
	
	

