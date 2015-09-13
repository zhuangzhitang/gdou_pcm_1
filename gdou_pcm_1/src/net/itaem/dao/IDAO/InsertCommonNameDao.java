package net.itaem.dao.IDAO;

import java.util.List;

import net.itaem.po.CommonName;
import net.itaem.vo.ShowUserMessageVo;
/*
 * �ýӿ���Ҫʵ�ֵĹ����У���ӳ����������޸��û��ĳ�����Ϣ������û��Ļ�����Ϣ��
 * @author zaopeng
 */
public interface InsertCommonNameDao {
    public boolean insertCommonName(String username,String true_name,
    		String idcard,String phone,int shortphone);                      //��ӳ�������
    /*
     * //�޸��û��Ļ�����Ϣ��ֻ�޸���ʵ���������֤���룬�ֻ����룬�̺š������û������޸ĵĽ���������޸�
     */
    public boolean changeMessage(String username,String true_name,
    		String idcard,String phone,int shortphone);
    /*
     * �����û���������ShowUserMessageVo���󣬸ö����װ�û��Ļ�����Ϣ��
     */
    public ShowUserMessageVo getUserMessage(String username);
    public List<String> getCommonTrueName(String user_name);           //�����û������õ����û����ĳ�������������ʵ����������
    public CommonName getDefultMessage(String user_name);     //�����û�������ø��û�Ĭ�ϵ���Ϣ
    public CommonName getCommonName(String user_name,String true_name);//�����û����Լ����û�ĳ��������������ʵ��������øó�����������ϸ��Ϣ��
    public boolean haveSameCommonName(String username,String truename);      //���һ���û����Ƿ�����ͬ�ĳ���������
    public boolean deleteCommonName(String username,String trueName);      //ɾ������������
}
