package net.itaem.dao.IDAO;

import java.sql.SQLException;



/*
 * ���ݿ��б�User�����ӿ�
 * @author zaopeng
 */
public interface UserDao {
    public boolean insertUsermessage(String username,String password,
    		String mail,String truename,String id_card,String phone,int shortphone);//��ע����Ϣд�����ݿ�
    public boolean ishaveusername(String username);//��֤�Ƿ���ڸ��û���
    public boolean ishavemail(String mail);//��֤�������Ƿ����
    public boolean isEnter(String role, String username,String password);  //��¼��֤��
    public boolean revokeCreateNoteLisi(String usename) throws Exception;  //ȡ��������Ȩ��
    public boolean revokeGetTicketLisi(String username) throws Exception;   //ȡ����Ʊ��Ȩ��
    public String getPassword(String username);//�����û����һ�����
    public boolean insertTeam(String team_username,String team_password,String team_name) throws Exception;//Ϊĳ������ע��
    public boolean changePassword(String role,String name,String oldPasswrd,String newPassword);//�޸����롣
    public int getTicketLisi(String user_name) throws SQLException;   //��ȡ���û���Ʊ��Ȩ�ޣ��Ƿ����ڡ�
    public int getNoteLisi(String user_name) throws SQLException;     //��ȡ���û�������Ȩ�ޣ��Ƿ����ڡ�
    public int getUserid(String username);          //�����û������õ��û�id,��user_id.
    public String getEmail(String username);        //�����û������õ����û���ע�����䡣
}
