package net.itaem.dao.IDAO;

import java.util.List;

import net.itaem.po.LiuYan;

public interface LiuyanDAO {
	public List<LiuYan> getLiuyanByNoteId(int id) ; //根据帖子的id号找到相关留言
	public boolean createLiuyan(LiuYan liuyan) ; //创建留言
}
