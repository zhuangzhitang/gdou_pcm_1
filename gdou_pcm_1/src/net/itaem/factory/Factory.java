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
 * 工厂类
 * @author Administrator
 *
 */
public class Factory {
	
	public static LiuyanDAO getLiuyanDAOInstance(){ //这个方法是用俩调用留言接口，所有对留言的操作，都是从这里接入
		return new LiuyanDAOProxy();
	}
	public static NoteDAO getNoteDAOInstatnce(){   //这个方法是用来调用帖子接口的，所有对帖子表的操作，到时从这里接入
		return new NoteDAOProxy();
	}
	public static UserDao getUserDaoIntance(){    //这个方法是用来调用userDao接口的，所有对user表的操作都是从这里接入。
		return new UserDaoProxy();
	} 
	public static DeleteTeamDao getDeleteTeamDaoIntance(){
		return new DeleteTeamDaoProxy();         //这个方法是用来调用DeleteTeamDaoImp接口的，所有对车队的删除操作都是从这里接入。
	}
	public static ArticleDAO getArticleDAOInstance(){  //这个方法是用来调用新闻接口的，所有对新闻信息表的dao层操作，都是从这里接入
		return new ArticleDAOProxy() ;
	}
	public static MessageDAO getMessageDAOInstance(){  //这个方法是用来处理消息管理模块的
		return new MessageDAOPrxoy() ;
	}
	public static DeleteTicketDao getDeleteTicketDaoIntance(){
		return new DeleteTicketDaoProxy();    //这个方法是用来调用DeleteTicketDaoImp接口的，所有对订单的删除操作都是从这里接入。
	}

    public static InsertCommonNameDao getInsertCommonIntance(){
    	return new InsertCommonDaoProxy();  //这个方法是用来调用InsertCommonNameDao接口的，所有对常用姓名的操作都是从这里接入。
    }
    public static GetTicketDao getTicketDaoIntance(){
    	return new GetTicketDaoProxy();     //这个方法是用来调用GetTicketDao接口的，所有对查询订单的操作都是从这里接入。
    }

	public static TeamMsgDAO getTeamMsgDAOInstance(){ //这个方法用来调用teammsg表接口的，所有对车队信息表的操作都是从这里输入
		return new TeamMsgDAOProxy() ;
	}
	public static CarNumberDAO getCarNumberDAOInstance(){
		return new CarNumberDAOProxy() ;  //这个方法是后台管理员票务功能的dao层接入
	}
}
