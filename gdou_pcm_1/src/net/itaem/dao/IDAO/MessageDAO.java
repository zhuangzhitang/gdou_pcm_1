package net.itaem.dao.IDAO;

import java.util.List;

import net.itaem.po.ticketMessage;
/**
 * ģ�飺��Ϣ����ģ�顣���ӿ����з����������ticket_message dao�����
 * @author zhetang
 *
 */
public interface MessageDAO {
	public boolean sendMessage(List<Integer> user_id,String message);//������Ϣ
	public boolean deleteMessage(int msg_id) ;           //�û�����ɾ����Ϣ��Ϣ
	public int unReadNum(int user_id);  //δ����Ϣ����
	public List<ticketMessage> showUnReadMsg(int user_id);  //��ʾδ����Ϣ
	public List<ticketMessage> showMsg(int user_id) ;        //��ʾ�Ѷ���Ϣ
	public boolean UpdateMesType(int user_id);            //�޸���Ϣ���Ķ�״̬����������ϢתΪ�Ѷ�
}
