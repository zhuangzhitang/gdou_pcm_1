package net.itaem.test;

import java.util.ArrayList;
import java.util.List;

public class GeshiText {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//List<String> s=new ArrayList<String>();
		GeshiText h=new GeshiText();
		System.out.println(h.checkRegiser("hdfoisajdi","15811706550@163.com","������", "123456789123456789","12345678912","636550").size());
	}
	public List<String> checkRegiser(String password,String email,String truename,String idcard,String phone,String shortphone){
		String password_check="\\w{4,10}";
		String email_check="^\\w+@\\w+\\.\\w+$";
		String true_name="^([\u4e00-\u9fa5]){2,4}$";
		String idcard_check="\\d{18}";
		String phone_check="\\d{11}";
		String shortphone_check="\\d{6}";
		List<String> list=new ArrayList<String>();
		if(!password.matches(password_check)){
			list.add("����Ӧ����4��10���ַ�֮��");
		}
		if(!email.matches(email_check)){
			list.add("�����ʽ����ȷ");
		}
		if(!truename.matches(true_name)){
			list.add("�������ʵ����������ʵ�����");
		}
		if(!idcard.matches(idcard_check)){
			list.add("���֤���������18λ����");
		}
		if(!phone.matches(phone_check)){
			list.add("�ֻ����������11λ");
		}
		if(!shortphone.matches(shortphone_check)){
		   list.add("�̺ű�����6λ����");
	}
		return list;

	
}
}
