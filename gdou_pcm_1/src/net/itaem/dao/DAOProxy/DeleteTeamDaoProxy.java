package net.itaem.dao.DAOProxy;

import net.itaem.dao.DAOImpl.DeleteTeamDaoImpl;
import net.itaem.dao.IDAO.DeleteTeamDao;
import net.itaem.tool.DataBaseConnection;
/*
 * �ӿ�DeleteTeamDaoImp�Ĵ���ʵ����
 * @author zaopeng
 */
public class DeleteTeamDaoProxy implements DeleteTeamDao {
	 private DataBaseConnection daConnection=null;
	 private DeleteTeamDao delete=null;
	    public DeleteTeamDaoProxy(){
	    	this.daConnection=new DataBaseConnection();
	    	this.delete=new DeleteTeamDaoImpl(daConnection.getConnection());
	    }
	    /*
	     * (non-Javadoc)
	     * @see net.itaem.dao.IDAO.DeleteTeamDao#deleteTeam(java.lang.String)
	     * ���복�ӵĳ�����������ɾ��������
	     */
		public boolean deleteTeam(String name) {
			boolean b=false;
			b=this.delete.deleteTeam(name);
			return b;
		} 
}
