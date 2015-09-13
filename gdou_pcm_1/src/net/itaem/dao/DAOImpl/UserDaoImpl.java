package net.itaem.dao.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import net.itaem.dao.IDAO.UserDao;

/*
 * �����ǽӿ�UserDao��ʵ����,��ɶԱ�user�ĸ��ֲ�����
 * @author zaopeng
 */

public class UserDaoImpl implements UserDao{
	private Connection conn;
	public UserDaoImpl(Connection conn){
		this.conn=conn;
	}
	public boolean insertUsermessage(String username,String password,String mail,
			String truename,String id_card,String phone,int shortphone){               //��ע����Ϣд�����ݿ�
		boolean b=true;
		/*
		 * �Ƚ��������ݲ��뵽User����ȥ��
		 */
		PreparedStatement pre=null;
		String sql1="insert into user(user_name,password,email) Values (?,?,?)";
		try {
			pre=conn.prepareStatement(sql1);
			pre.setString(1,username);
			pre.setString(2,password);
			pre.setString(3,mail);
			int i=pre.executeUpdate();
			if(i==0){
				b=false;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			b=false;
		}
		/*
		 * ����һ�������ݲ��뵽commom_name��ȥ���̺��������null��
		 */
		int userid=this.findUserid(username, password);
		PreparedStatement pre1=null;
		String sql2="insert into common_name(user_id,true_name,idcard,phone,shortphone,biaozhi) Values (?,?,?,?,?,?)";
		try {
			pre1=conn.prepareStatement(sql2);
			pre1.setInt(1,userid);
			pre1.setString(2,truename);
			pre1.setString(3,id_card);
			pre1.setString(4,phone);
			pre1.setInt(5,shortphone);
			pre1.setInt(6,0);
			int k=pre1.executeUpdate();
			if(k==0){
				b=false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			b=false;
		}
		
		return b;
	}
	/*
	 * 
	 * @see net.itaem.dao.IDAO.UserRegisterDao#ishaveusername(java.lang.String)
	 * ��֤�û����Ƿ���ڣ�����true,����û����Ѿ����ڣ���֮��
	 */
    public boolean ishaveusername(String username) {
    	boolean b=false;
    	PreparedStatement pre=null;
    	ResultSet  res=null;
    	int i=0;
    	String sql="select count(*) from user where user_name=?";
    	try {
			pre=conn.prepareStatement(sql);
			pre.setString(1,username);
			res=pre.executeQuery();
			if(res.next()){
				i=res.getInt(1);
			}
			if(i>0){
				b=true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
	}finally {
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
    	
    	return b;
    }
    
    
    
    
    /*
     * (non-Javadoc)
     * @see net.itaem.dao.IDAO.UserRegisterDao#ishavemail(java.lang.String)
     * ��֤�����Ƿ���ڣ�����true��������Ѵ����ˣ���֮��
     */
    public boolean ishavemail(String email) {
    	boolean b=false;
    	PreparedStatement pre=null;
    	ResultSet  res=null;
    	int i=0;
    	String sql="select count(*) from user where email=?";
    	try {
			pre=conn.prepareStatement(sql);
			pre.setString(1,email);
			res=pre.executeQuery();
			if(res.next()){
				i=res.getInt(1);
			}
			if(i>0){
				b=true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
	}finally {
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
    	
    	return b;
    }
    /*
     * (non-Javadoc)
     * @see net.itaem.dao.IDAO.UserEnter#isEnter(java.lang.String, java.lang.String)
     * ��¼��������֤�û����������Ƿ�ƥ�䣬����true����¼�ɹ���
     * ���� role��ֵ���ж���ʲô��ɫ���е�¼�������Ӷ���ѯ��ͬ�ı�
     * ��ͨ�û���role=OU
	 * �����û���role=SU
	 * ��վ����Ա��role=WB
     */
 	public boolean isEnter(String role,String username, String password)  {
 		boolean b=false;
 		int i=0;
 		PreparedStatement pre=null;
 		ResultSet res=null;
 		String sql=null;
 		if(role=="OU"){
 	      sql="select count(*) from user where user_name=? and password=?";
 		}
 		else if(role=="SU"){
 			sql="select count(*) from teammsg where team_username=? and taem_passwrod=?";
 		}
 		else if(role=="WB"){
 			sql="select count(*) from webmaster where master_name=? and master_password=?";
 		}
 		try {
 			pre=conn.prepareStatement(sql);
 			pre.setString(1,username);
 			pre.setString(2,password);
 			res=pre.executeQuery();
 			if(res.next()){
 				i=res.getInt(1);
 			}
 			if(i==1){
 				b=true;
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
 				res=null;
 			}
 		}
 		
 		
 		return b;
 	}
 	 public boolean revokeCreateNoteLisi(String usename) throws Exception{
 		 //ȡ��������Ȩ�� 
 		 boolean b=false;
 		 int i=0;
 		 PreparedStatement pre=null;
 		 String sql="update user set note_type=0 Where user_name=?";
 		 try {
			pre=conn.prepareStatement(sql);
			pre.setString(1, usename);
			i=pre.executeUpdate();
			if(i==1){
				b=true;
			}
		} catch (SQLException e) {
			throw e;
		}finally{
			if(pre!=null){
				pre.close();
				pre=null;
			}
		}
 		 
 		 return b;
 	 }
     public boolean revokeGetTicketLisi(String username) throws Exception  {
    	 //ȡ����Ʊ��Ȩ��
    	 boolean b=false;
    	 int i=0;
 		 PreparedStatement pre=null;
 		 String sql="update user set user_type=0 Where user_name=?";
 		 try {
			pre=conn.prepareStatement(sql);
			pre.setString(1, username);
			i=pre.executeUpdate();
			if(i==1){
				b=true;
			}
		} catch (SQLException e) {
			throw e;
		}finally{
			if(pre!=null){
				pre.close();
				pre=null;
			}
		}
    	 return b;
     } 
     /*
      * (non-Javadoc)
      * @see net.itaem.dao.IDAO.UserDao#getPassword(java.lang.String)
      * �����û��������������ֵ��������ص������ֵΪnull����˵���û��������ڡ�
      */
     public String getPassword(String username){
    	 PreparedStatement pre=null;
    	 ResultSet res=null;
    	 String password = null;
    	 String sql="select password from user where user_name=?";
    	 try {
			pre=conn.prepareStatement(sql);
			pre.setString(1,username);
			res=pre.executeQuery();
			if(res.next()){
				password=res.getString(1);
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
				} catch (SQLException e){
					e.printStackTrace();
				}
 				res=null;
		}
    	 
     }
    	 return password;
     }   

    public int findUserid(String username,String password){  //�����û����������ѯ��useid��
    	PreparedStatement pre=null;
    	ResultSet res=null;
    	int i=0;
    	String sql="select user_id from user where user_name=? and password=?";
        try {
			pre=conn.prepareStatement(sql);
			 pre.setString(1,username);
		     pre.setString(2,password);
		     res=pre.executeQuery();
		     if(res.next()){
		    	 i=res.getInt(1);
		     }
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
        return i;
        
    }
	public boolean insertTeam(String team_username, String team_password,
			String team_name) throws Exception {
		/*
		 * �Գ��ӽ���ע�ᣬע��ɹ�����true����֮��
		 */
		boolean b=false;
		PreparedStatement pre=null;
		int i=0;
		String sql="insert into teammsg(team_username,taem_passwrod,team_name) values (?,?,?)";
	    try {
			pre=conn.prepareStatement(sql);
			pre.setString(1,team_username);
			pre.setString(2,team_password);
			pre.setString(3,team_name);
			i=pre.executeUpdate();
			if(i==1){
				b=true;
			}
		} catch (SQLException e) {
			throw e;
		}
	    
		return b;
	}
	/*
	 * (non-Javadoc)
	 * @see net.itaem.dao.IDAO.UserDao#changePassword(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 * �޸����룬roleΪ��ɫ�����ݽ�ɫ�Ĳ�ͬ��Ϊ��ͨ�û������ӹ���Ա�޸����������
	 * ��ͨ�û���role=OU
	 * �����û���role=SU
	 */
	public boolean changePassword(String role, String name, String oldPasswrd,
			String newPassword) {
		boolean b=false;
		boolean c=this.isEnter(role, name, oldPasswrd);
		int i=0;
		if(!c){
		return b;
		}
		else{
			String sql=null;
			PreparedStatement pre=null;
			if(role=="OU"){
			 sql="update user set password=? where user_name=?";
		     }
			else if(role=="SU"){
				sql="update teammsg set taem_passwrod=? where team_username=?";
			} 
			try {
				pre=conn.prepareStatement(sql);
				pre.setString(1,newPassword);
				pre.setString(2,name);
				i=pre.executeUpdate();
				if(i==1){
					b=true;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return b;
	  } 
	}
	public int getTicketLisi(String user_name) throws SQLException {
		int i=0;
		PreparedStatement pre=null;
		ResultSet res=null;
		String sql="select user_type from user where user_name=?";
		pre=conn.prepareStatement(sql);
		pre.setString(1,user_name);
		res=pre.executeQuery();
		if(res.next()){
			i=res.getInt(1);
		}
		return i;
	}
	public int getNoteLisi(String user_name) throws SQLException {
		int i=0;
		PreparedStatement pre=null;
		ResultSet res=null;
		String sql="select note_type from user where user_name=?";
		pre=conn.prepareStatement(sql);
		pre.setString(1,user_name);
		res=pre.executeQuery();
		if(res.next()){
			i=res.getInt(1);
		}
		return i;
	}
	/*
	 * ����������û�������ȡ���û�id.
	 */
    public int getUserid(String username){
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
			e.printStackTrace();
			
		}
    	return i;
    }
	public String getEmail(String username) {
		PreparedStatement pre=null;
		ResultSet res=null;
		String sql="select email from user where user_name=?";
		String email=null;
		try {
			pre=conn.prepareStatement(sql);
			pre.setString(1,username);
			res=pre.executeQuery();
			if(res.next()){
				email=res.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	   
		return email;
	}
}
