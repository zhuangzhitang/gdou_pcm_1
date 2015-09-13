package net.itaem.dao.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.itaem.dao.IDAO.LiuyanDAO;
import net.itaem.po.LiuYan;
import net.itaem.tool.ExceptionRecordTool;
/**
 * 这个类是实现对留言接口dao层的实现类
 * @author zhetang
 *
 */
public class LiuyanDAOImpl implements LiuyanDAO {
	private Connection conn = null ;
	public LiuyanDAOImpl(Connection conn){
		this.conn = conn ;
	}
	public List<LiuYan> getLiuyanByNoteId(int id) {      //通过id列出所有的留言
		List<LiuYan> liuyans = new ArrayList<LiuYan>();
		String sql = "select * from liuyan where note_id = ?" ;
		PreparedStatement pst = null ;
		ResultSet rs = null ;
		try{
			pst = conn.prepareStatement(sql) ;
			pst.setInt(1, id) ;
			rs = pst.executeQuery() ;
		    while(rs.next()){
		    	LiuYan liuyan = new LiuYan() ;
		    	liuyan.setLiuYanId(rs.getInt("liuyan_id")) ;
		    	liuyan.setCreater(rs.getString("creater")) ;
		    	liuyan.setNoteId(rs.getInt("note_id")) ;
		    	liuyan.setLiuYanContent(rs.getString("liuyan_content")) ;
		    	liuyan.setInsertTime(rs.getDate("insert_time")) ;
		    	liuyan.setParentkey(rs.getInt("parent_key")) ;
		    	liuyans.add(liuyan) ;
		    }
		}catch(Exception e){
			ExceptionRecordTool.writeExceptionRecord(e);
			e.printStackTrace();
		}finally{
			if(rs!=null){
				try {
					rs.close();
				} catch (SQLException e) {
		
					e.printStackTrace();
				}
				rs = null ;
			}
			if(pst!=null){
				try {
					pst.close();
				} catch (SQLException e) {
				
					e.printStackTrace();
				}
				pst = null ;
			}
		}
		return liuyans;
	}

	public boolean createLiuyan(LiuYan liuyan){     //发布留言
		boolean flag = false ;
		String sql = "insert into liuyan(creater,note_id,liuyan_content,parent_key) values(?,?,?,?)" ;
		PreparedStatement pst = null ;
		try{
			pst = conn.prepareStatement(sql) ;
			pst.setString(1, liuyan.getCreater()) ;
			pst.setInt(2, liuyan.getNoteId()) ;
			pst.setString(3, liuyan.getLiuYanContent()) ;
			pst.setInt(4, liuyan.getParentkey()) ;
			pst.executeUpdate() ;
			flag = true ;
		}catch(Exception e){
			ExceptionRecordTool.writeExceptionRecord(e);
			e.printStackTrace();
		}finally{
			if(pst!=null){
				try {
					pst.close() ;
				} catch (SQLException e) {
					e.printStackTrace();
				}
				pst = null ; 
			}
		}
		return flag;
	}

}
