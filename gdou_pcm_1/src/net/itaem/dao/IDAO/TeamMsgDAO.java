package net.itaem.dao.IDAO;

import java.util.List;

import net.itaem.po.Team;
import net.itaem.vo.ShowTeamVO;

/**
 * �ýӿڸ��𳵶���Ϣ��Ĳ���
 * @author zhetang
 *
 */
public interface TeamMsgDAO {
	public Team getTeamMsgById(int team_id) ; //ͨ�����복�ӵ�id�ţ����ɵõ����Ӷ���
	public List<ShowTeamVO> getAllTeamShow() ; //�û��������չʾ����Ҫ�õ�����Ϣ
	public boolean UpdateTeamMsg(int team_id,String iamge,String ticketmsg,String introduce) ; //���ӿ����޸����������
	public int getTeamid(String username);   //��ȡ���ӵ�ID��
	public String getTeamName(String username);  //��ȡ���ӵ�����
}
