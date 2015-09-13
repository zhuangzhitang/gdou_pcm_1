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
		System.out.println(h.checkRegiser("hdfoisajdi","15811706550@163.com","郭灶鹏", "123456789123456789","12345678912","636550").size());
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
			list.add("密码应该在4到10个字符之间");
		}
		if(!email.matches(email_check)){
			list.add("邮箱格式不正确");
		}
		if(!truename.matches(true_name)){
			list.add("输入的真实姓名不符合实际情况");
		}
		if(!idcard.matches(idcard_check)){
			list.add("身份证号码必须是18位数字");
		}
		if(!phone.matches(phone_check)){
			list.add("手机号码必须是11位");
		}
		if(!shortphone.matches(shortphone_check)){
		   list.add("短号必须是6位数字");
	}
		return list;

	
}
}
