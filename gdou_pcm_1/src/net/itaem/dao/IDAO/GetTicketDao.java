package net.itaem.dao.IDAO;



import java.util.Date;
import java.util.List;

import net.itaem.po.CarNumber;
import net.itaem.po.Ticket;
import net.itaem.vo.ShowCityVO;
import net.itaem.vo.ShowTicketVO;
/*
 * �ýӿ�ʵ�ֵĹ����У�����������û�����������û���Ч�Ķ�������
 *                ��������ĳ��ε�id��������˸ó��ε��û�id�ļ��ϡ�
 *@author zaopeng
 */
public interface GetTicketDao {
   public List<ShowTicketVO> getTicketMessage(String username);//����������û������õ��û���Ʊ��ShowTicketVO����ļ��ϡ�
   public List<Integer> getUseridList(int car_id);//��������ĳ��ε�id�ţ����ض��˸ó��ε��û���user_id����
   public ShowCityVO getCityMessage();//��ȡ�����ϳ����У��³����У��������ơ�
   /*
    * ��������ĳ������У�������У����ڣ��������ƣ����ط��ϵ�ShowTicketVO���󼯺ϡ�
    */
   public List<ShowTicketVO> findTicket(String ticket_from,String ticket_to,Date ticket_date,String ticket_name);
   public int getPageNumber(List<ShowTicketVO> list,int num);  //����List���ϣ��Լ�һҳ�ļ�¼��������ҳ����
   public List<ShowTicketVO> getTicketPage(int pagenumber,List<ShowTicketVO> list,int num);//����ҳ�����Լ�List���ϣ����ظ�ҳ��ShowTicketVO���󼯺ϡ�
   public boolean isGetTicket(String username,int num);    //����Ƿ����乺Ʊ����������Ʊ���ܾ��乺Ʊ��
   public boolean InsertTicket(Ticket ticket);     //��Ʊ�������������Ϣ����ɶ�Ʊ��
   public int getUserid(String username);          //�����û������õ��û�id,��user_id.
   public int checkRestTicketNum(int car_id);             //���복�ε�id,�õ��ó��ε���Ʊ��
   public CarNumber getCarNumberMessage(int carid);       //���ݴ����carid���õ��ó�����Ϣ��
}
