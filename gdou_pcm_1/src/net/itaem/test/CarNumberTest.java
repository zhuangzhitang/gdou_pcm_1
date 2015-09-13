package net.itaem.test;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import net.itaem.factory.Factory;
import net.itaem.po.CarNumber;
import net.itaem.vo.ShowDingPiaoMsgVO;

/**
 * 后台票务功能测试类
 * @author zhetang
 *
 */
public class CarNumberTest {
	public static void main(String args[]){
		 //创建车次
		CarNumber carnumber =new CarNumber(1,1,"dfa","daf","8点",new Date(),"sdfa",80,30) ;
		boolean flag = false ; 
		try {
			flag = Factory.getCarNumberDAOInstance().createCarNum(carnumber) ;
			System.out.println("发布车次是否成功： "+flag ) ;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 //显示策次
		List<CarNumber> numbers = null ;
		try {
			numbers = Factory.getCarNumberDAOInstance().showCarNumList(1) ;
			Iterator<CarNumber> iter = numbers.iterator() ;
			while(iter.hasNext()){
				CarNumber num = (CarNumber)iter.next() ;
				Date date = num.getTicketDate() ;
				long cardate = date.getTime() ;
				long nowdate = new Date().getTime() ;
				if(cardate>nowdate){
				System.out.println("显示车次： "+num ) ;
				}
			
			}
			
		
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		 //显示车次的订票信息
		List<ShowDingPiaoMsgVO> showvo = null ; 
		try {
		
			showvo = Factory.getCarNumberDAOInstance().showDPList(1) ;
			Iterator<ShowDingPiaoMsgVO> iter = showvo.iterator() ;
			while(iter.hasNext()){
				ShowDingPiaoMsgVO vo = new ShowDingPiaoMsgVO() ;
				vo = (ShowDingPiaoMsgVO)iter.next() ;
				System.out.println("显示车次的订票信息： "+vo) ;
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		int userId = 1 ;
		try{
			String userName = Factory.getCarNumberDAOInstance().getUserNamebyId(userId) ;
			System.out.println("用户名："+userName) ;
		}catch(Exception e){
			e.printStackTrace() ;
		}
		int car_id = 3 ;   //删除车次
	    flag = Factory.getCarNumberDAOInstance().deleteCheci(car_id) ;
	    System.out.print("删除车次是否成功："+ flag ) ;
	    
	    //拿到车次
	    int ticket_no = Factory.getCarNumberDAOInstance().getTicketNumbyCarId(car_id);
	    System.out.println("通过id号拿到车次号:"+ticket_no) ;
	    
	}
}
