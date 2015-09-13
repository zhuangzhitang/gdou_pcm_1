package net.itaem.dao.IDAO;

import java.sql.SQLException;



/*
 * 数据库中表User操作接口
 * @author zaopeng
 */
public interface UserDao {
    public boolean insertUsermessage(String username,String password,
    		String mail,String truename,String id_card,String phone,int shortphone);//将注册信息写入数据库
    public boolean ishaveusername(String username);//验证是否存在该用户名
    public boolean ishavemail(String mail);//验证该邮箱是否存在
    public boolean isEnter(String role, String username,String password);  //登录验证。
    public boolean revokeCreateNoteLisi(String usename) throws Exception;  //取消发帖的权限
    public boolean revokeGetTicketLisi(String username) throws Exception;   //取消订票的权限
    public String getPassword(String username);//根据用户名找回密码
    public boolean insertTeam(String team_username,String team_password,String team_name) throws Exception;//为某个车队注册
    public boolean changePassword(String role,String name,String oldPasswrd,String newPassword);//修改密码。
    public int getTicketLisi(String user_name) throws SQLException;   //获取该用户订票的权限，是否被拉黑。
    public int getNoteLisi(String user_name) throws SQLException;     //获取该用户发帖的权限，是否被拉黑。
    public int getUserid(String username);          //根据用户名，得到用户id,即user_id.
    public String getEmail(String username);        //根据用户名，得到该用户的注册邮箱。
}
