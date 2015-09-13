package net.itaem.factory;

import net.itaem.dao.DAOProxy.ArticleDAOProxy;
import net.itaem.dao.DAOProxy.CarNumberDAOProxy;
import net.itaem.dao.DAOProxy.DeleteTeamDaoProxy;
import net.itaem.dao.DAOProxy.DeleteTicketDaoProxy;
import net.itaem.dao.DAOProxy.GetTicketDaoProxy;
import net.itaem.dao.DAOProxy.InsertCommonDaoProxy;
import net.itaem.dao.DAOProxy.LiuyanDAOProxy;
import net.itaem.dao.DAOProxy.MessageDAOPrxoy;
import net.itaem.dao.DAOProxy.NoteDAOProxy;
import net.itaem.dao.DAOProxy.TeamMsgDAOProxy;
import net.itaem.dao.DAOProxy.UserDaoProxy;
import net.itaem.dao.IDAO.ArticleDAO;
import net.itaem.dao.IDAO.CarNumberDAO;
import net.itaem.dao.IDAO.DeleteTeamDao;
import net.itaem.dao.IDAO.DeleteTicketDao;
import net.itaem.dao.IDAO.GetTicketDao;
import net.itaem.dao.IDAO.InsertCommonNameDao;
import net.itaem.dao.IDAO.LiuyanDAO;
import net.itaem.dao.IDAO.MessageDAO;
import net.itaem.dao.IDAO.NoteDAO;
import net.itaem.dao.IDAO.TeamMsgDAO;
import net.itaem.dao.IDAO.UserDao;
/**
 * ������
 * @author Administrator
 *
 */
public class Factory {
	
	public static LiuyanDAO getLiuyanDAOInstance(){ //��������������������Խӿڣ����ж����ԵĲ��������Ǵ��������
		return new LiuyanDAOProxy();
	}
	public static NoteDAO getNoteDAOInstatnce(){   //��������������������ӽӿڵģ����ж����ӱ�Ĳ�������ʱ���������
		return new NoteDAOProxy();
	}
	public static UserDao getUserDaoIntance(){    //�����������������userDao�ӿڵģ����ж�user��Ĳ������Ǵ�������롣
		return new UserDaoProxy();
	} 
	public static DeleteTeamDao getDeleteTeamDaoIntance(){
		return new DeleteTeamDaoProxy();         //�����������������DeleteTeamDaoImp�ӿڵģ����жԳ��ӵ�ɾ���������Ǵ�������롣
	}
	public static ArticleDAO getArticleDAOInstance(){  //��������������������Žӿڵģ����ж�������Ϣ���dao����������Ǵ��������
		return new ArticleDAOProxy() ;
	}
	public static MessageDAO getMessageDAOInstance(){  //�������������������Ϣ����ģ���
		return new MessageDAOPrxoy() ;
	}
	public static DeleteTicketDao getDeleteTicketDaoIntance(){
		return new DeleteTicketDaoProxy();    //�����������������DeleteTicketDaoImp�ӿڵģ����жԶ�����ɾ���������Ǵ�������롣
	}

    public static InsertCommonNameDao getInsertCommonIntance(){
    	return new InsertCommonDaoProxy();  //�����������������InsertCommonNameDao�ӿڵģ����жԳ��������Ĳ������Ǵ�������롣
    }
    public static GetTicketDao getTicketDaoIntance(){
    	return new GetTicketDaoProxy();     //�����������������GetTicketDao�ӿڵģ����жԲ�ѯ�����Ĳ������Ǵ�������롣
    }

	public static TeamMsgDAO getTeamMsgDAOInstance(){ //���������������teammsg��ӿڵģ����жԳ�����Ϣ��Ĳ������Ǵ���������
		return new TeamMsgDAOProxy() ;
	}
	public static CarNumberDAO getCarNumberDAOInstance(){
		return new CarNumberDAOProxy() ;  //��������Ǻ�̨����ԱƱ���ܵ�dao�����
	}
}
