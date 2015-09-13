package net.itaem.dao.IDAO;

import java.util.List;

import net.itaem.po.ticketMessage;
/**
 * 模块：消息管理模块。本接口所有方法都是针对ticket_message dao层操作
 * @author zhetang
 *
 */
public interface MessageDAO {
	public boolean sendMessage(List<Integer> user_id,String message);//发送信息
	public boolean deleteMessage(int msg_id) ;           //用户可以删除消息信息
	public int unReadNum(int user_id);  //未读信息条数
	public List<ticketMessage> showUnReadMsg(int user_id);  //显示未读信息
	public List<ticketMessage> showMsg(int user_id) ;        //显示已读信息
	public boolean UpdateMesType(int user_id);            //修改消息的阅读状态，将手游消息转为已读
}
