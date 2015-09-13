package net.itaem.test;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import net.itaem.factory.Factory;
import net.itaem.po.CarNumber;
import net.itaem.vo.ShowDingPiaoMsgVO;

/**
 * ��̨Ʊ���ܲ�����
 * @author zhetang
 *
 */
public class CarNumberTest {
	public static void main(String args[]){
		 //��������
		CarNumber carnumber =new CarNumber(1,1,"dfa","daf","8��",new Date(),"sdfa",80,30) ;
		boolean flag = false ; 
		try {
			flag = Factory.getCarNumberDAOInstance().createCarNum(carnumber) ;
			System.out.println("���������Ƿ�ɹ��� "+flag ) ;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 //��ʾ�ߴ�
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
				System.out.println("��ʾ���Σ� "+num ) ;
				}
			
			}
			
		
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		 //��ʾ���εĶ�Ʊ��Ϣ
		List<ShowDingPiaoMsgVO> showvo = null ; 
		try {
		
			showvo = Factory.getCarNumberDAOInstance().showDPList(1) ;
			Iterator<ShowDingPiaoMsgVO> iter = showvo.iterator() ;
			while(iter.hasNext()){
				ShowDingPiaoMsgVO vo = new ShowDingPiaoMsgVO() ;
				vo = (ShowDingPiaoMsgVO)iter.next() ;
				System.out.println("��ʾ���εĶ�Ʊ��Ϣ�� "+vo) ;
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		int userId = 1 ;
		try{
			String userName = Factory.getCarNumberDAOInstance().getUserNamebyId(userId) ;
			System.out.println("�û�����"+userName) ;
		}catch(Exception e){
			e.printStackTrace() ;
		}
		int car_id = 3 ;   //ɾ������
	    flag = Factory.getCarNumberDAOInstance().deleteCheci(car_id) ;
	    System.out.print("ɾ�������Ƿ�ɹ���"+ flag ) ;
	    
	    //�õ�����
	    int ticket_no = Factory.getCarNumberDAOInstance().getTicketNumbyCarId(car_id);
	    System.out.println("ͨ��id���õ����κ�:"+ticket_no) ;
	    
	}
}
