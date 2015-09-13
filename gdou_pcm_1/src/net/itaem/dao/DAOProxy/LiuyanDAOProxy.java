package net.itaem.dao.DAOProxy;

import java.util.List;

import net.itaem.dao.DAOImpl.LiuyanDAOImpl;
import net.itaem.dao.IDAO.LiuyanDAO;
import net.itaem.po.LiuYan;
import net.itaem.tool.DataBaseConnection;
import net.itaem.tool.ExceptionRecordTool;

/**
 * 代理类，代理实现留言
 * @autor：zhetang
 */
public class LiuyanDAOProxy implements LiuyanDAO {
	private LiuyanDAOImpl dao = null ;
	private DataBaseConnection dbc = null ;
	public LiuyanDAOProxy(){
		dbc = new DataBaseConnection() ;
		dao = new LiuyanDAOImpl(dbc.getConnection()) ;
	}
	/**
	 * 通过帖子的id号，货到这个帖子所有的留言
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
	 * 发布一条留言
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
