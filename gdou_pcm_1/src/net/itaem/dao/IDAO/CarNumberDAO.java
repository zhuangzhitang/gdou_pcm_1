package net.itaem.dao.IDAO;

import java.util.List;

import net.itaem.po.CarNumber;
import net.itaem.vo.ShowDingPiaoMsgVO;

public interface CarNumberDAO {
	public boolean createCarNum(CarNumber carnum)  ; //�������� 
	public List<CarNumber> showCarNumList(int team_id) ; //��ʾ�ߴ�
	public List<ShowDingPiaoMsgVO> showDPList(int car_id) ;  //��ʾ���εĶ�Ʊ��Ϣ
	public String getUserNamebyId(int userId) ;  //ͨ���û���ID �ŵõ� �û���
	public boolean deleteCheci(int car_id);   //ɾ������
	public int getTicketNumbyCarId(int car_id) ;  //ͨ��id�õ����κ�
}
