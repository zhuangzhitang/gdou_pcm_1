package net.itaem.dao.IDAO;
/*
 * 接口：删除某个车队相关的信息。
 * @author zaopeng
 */
public interface DeleteTeamDao {
	 public boolean deleteTeam(String name);   //取消某个车队的权限，即删除某个车队的相关的信息。
}
