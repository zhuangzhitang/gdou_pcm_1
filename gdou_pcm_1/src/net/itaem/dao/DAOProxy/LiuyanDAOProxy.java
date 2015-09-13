package net.itaem.dao.DAOProxy;

import java.util.List;

import net.itaem.dao.DAOImpl.LiuyanDAOImpl;
import net.itaem.dao.IDAO.LiuyanDAO;
import net.itaem.po.LiuYan;
import net.itaem.tool.DataBaseConnection;
import net.itaem.tool.ExceptionRecordTool;

/**
 * �����࣬����ʵ������
 * @autor��zhetang
 */
public class LiuyanDAOProxy implements LiuyanDAO {
	private LiuyanDAOImpl dao = null ;
	private DataBaseConnection dbc = null ;
	public LiuyanDAOProxy(){
		dbc = new DataBaseConnection() ;
		dao = new LiuyanDAOImpl(dbc.getConnection()) ;
	}
	/**
	 * ͨ�����ӵ�id�ţ���������������е�����
	 */
	public List<LiuYan> getLiuyanByNoteId(int id)  {
		List<LiuYan> liuyans = null ;
		try{
			liuyans = dao.getLiuyanByNoteId(id) ;
		}catch(Exception e){
			ExceptionRecordTool.writeExceptionRecord(e);
			e.printStackTrace();
		}finally{
			dbc.close() ;
		}
		return liuyans;
	}
	/**
	 * ����һ������
	 */
	public boolean createLiuyan(LiuYan liuyan) {
		boolean flag = false ;
		try{
			flag = dao.createLiuyan(liuyan) ;
		}catch(Exception e){
			ExceptionRecordTool.writeExceptionRecord(e);
			e.printStackTrace();
		}finally{
			dbc.close();
		}
		return flag;
	}

}
