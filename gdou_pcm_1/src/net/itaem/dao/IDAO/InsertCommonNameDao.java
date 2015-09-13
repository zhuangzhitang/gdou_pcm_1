package net.itaem.dao.IDAO;

import java.util.List;

import net.itaem.po.CommonName;
import net.itaem.vo.ShowUserMessageVo;
/*
 * 该接口主要实现的功能有：添加常用姓名，修改用户的常用信息，输出用户的基本信息。
 * @author zaopeng
 */
public interface InsertCommonNameDao {
    public boolean insertCommonName(String username,String true_name,
    		String idcard,String phone,int shortphone);                      //添加常用姓名
    /*
     * //修改用户的基本信息，只修改真实姓名，身份证号码，手机号码，短号。输入用户名，修改的结果，进行修改
     */
    public boolean changeMessage(String username,String true_name,
    		String idcard,String phone,int shortphone);
    /*
     * 输入用户名，返回ShowUserMessageVo对象，该对象封装用户的基本信息。
     */
    public ShowUserMessageVo getUserMessage(String username);
    public List<String> getCommonTrueName(String user_name);           //输入用户名，得到该用户名的常用姓名——真实姓名的数组
    public CommonName getDefultMessage(String user_name);     //输入用户名，获得该用户默认的信息
    public CommonName getCommonName(String user_name,String true_name);//输入用户名以及该用户某个常用姓名的真实姓名，获得该常用姓名的详细信息。
    public boolean haveSameCommonName(String username,String truename);      //检测一个用户名是否有相同的常用姓名。
    public boolean deleteCommonName(String username,String trueName);      //删除常用姓名。
}
