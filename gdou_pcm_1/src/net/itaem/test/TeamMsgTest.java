package net.itaem.test;

import java.util.Iterator;
import java.util.List;

import net.itaem.factory.Factory;
import net.itaem.po.Team;
import net.itaem.vo.ShowTeamVO;

/**
 * ������ǳ�����Ϣ������
 * @author zhetang
 *
 */
public class TeamMsgTest {
	public static void main(String args[]){
		//ͨ�����복�ӵ�id�ţ����ɵõ����Ӷ���
		try {
			Team team  = Factory.getTeamMsgDAOInstance().getTeamMsgById(1);
			System.out.println("������Ϣ��"+team) ;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//�û��������չʾ����Ҫ�õ�����Ϣ
		try {
			List<ShowTeamVO> teamvos = Factory.getTeamMsgDAOInstance().getAllTeamShow() ;
			Iterator<ShowTeamVO> iter = teamvos.iterator() ;
			while(iter.hasNext()){
				ShowTeamVO teamvo = iter.next() ;
				System.out.println("����չʾ��Ƭ����Ϣ��"+ teamvo) ;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//���ӿ����޸����������
		boolean flag1 = false ;
		try {
			flag1 = Factory.getTeamMsgDAOInstance().UpdateTeamMsg(1, "dfafsxiaozhuang", "���", "sdfsafjaosfjao�޸ĳɹ�");
			System.out.println("�޸ĳ�����Ϣ�Ƿ�ɹ���"+ flag1) ;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
