package net.itaem.dao.IDAO;

import java.util.List;

import net.itaem.po.Team;
import net.itaem.vo.ShowTeamVO;

/**
 * 该接口负责车队信息表的操作
 * @author zhetang
 *
 */
public interface TeamMsgDAO {
	public Team getTeamMsgById(int team_id) ; //通过传入车队的id号，即可得到车队对象
	public List<ShowTeamVO> getAllTeamShow() ; //用户点击车队展示，需要用到的信息
	public boolean UpdateTeamMsg(int team_id,String iamge,String ticketmsg,String introduce) ; //车队可以修改自身的资料
	public int getTeamid(String username);   //获取车队的ID。
	public String getTeamName(String username);  //获取车队的名字
}
