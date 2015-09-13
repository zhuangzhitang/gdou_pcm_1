package net.itaem.test;

import java.util.ArrayList;
import java.util.List;

import net.itaem.dao.IDAO.InsertCommonNameDao;
import net.itaem.factory.Factory;
import net.itaem.po.CommonName;

public class Commontext {
	public static void main(String args[]) throws Exception{
		List<String> list=new ArrayList<String>();
		InsertCommonNameDao common=Factory.getInsertCommonIntance();
		list=common.getCommonTrueName("zhetang");
		System.out.println(list.get(0));
		CommonName com=common.getDefultMessage("zhetang");
		System.out.println(com.getIdCard());
		CommonName c=common.getCommonName("zhetang","hihi");
		System.out.println(c.getIdCard());
	}
}
