package net.itaem.dao.IDAO;

import java.util.List;

import net.itaem.po.LiuYan;

public interface LiuyanDAO {
	public List<LiuYan> getLiuyanByNoteId(int id) ; //�������ӵ�id���ҵ��������
	public boolean createLiuyan(LiuYan liuyan) ; //��������
}
