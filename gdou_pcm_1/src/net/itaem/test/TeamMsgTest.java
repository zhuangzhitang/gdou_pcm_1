package net.itaem.test;

import java.util.Iterator;
import java.util.List;

import net.itaem.factory.Factory;
import net.itaem.po.Team;
import net.itaem.vo.ShowTeamVO;

/**
 * 这个类是车队信息测试类
 * @author zhetang
 *
 */
public class TeamMsgTest {
	public static void main(String args[]){
		//通过传入车队的id号，即可得到车队对象
		try {
			Team team  = Factory.getTeamMsgDAOInstance().getTeamMsgById(1);
			System.out.println("车队信息："+team) ;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//用户点击车队展示，需要用到的信息
		try {
			List<ShowTeamVO> teamvos = Factory.getTeamMsgDAOInstance().getAllTeamShow() ;
			Iterator<ShowTeamVO> iter = teamvos.iterator() ;
			while(iter.hasNext()){
				ShowTeamVO teamvo = iter.next() ;
				System.out.println("车队展示对片，信息："+ teamvo) ;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//车队可以修改自身的资料
		boolean flag1 = false ;
		try {
			flag1 = Factory.getTeamMsgDAOInstance().UpdateTeamMsg(1, "dfafsxiaozhuang", "你好", "sdfsafjaosfjao修改成功");
			System.out.println("修改车队信息是否成功："+ flag1) ;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
