package net.itaem.dao.IDAO;
/*
 * 退票操作，输入ticket_id,完成退票操作
 * @author zaopeng
 */
public interface DeleteTicketDao {
  public boolean deleteTicket(int ticket_id) ;
}
