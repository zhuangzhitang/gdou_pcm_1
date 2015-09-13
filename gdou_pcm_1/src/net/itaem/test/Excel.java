package net.itaem.test;

import java.util.ArrayList;
import java.util.List;

import net.itaem.tool.ExcelTool;

public class Excel {
	public static void main(String args[]){
		boolean flag = false ;
		String sheetName = "人事资料表" ;
		 List<String> headerList = new ArrayList<String>() ;
		 headerList.add("1");
		 headerList.add("2");
		 headerList.add("3");
		 headerList.add("4");
		 
		 ArrayList<Object> object = new ArrayList<Object>() ;
		 object.add("q");
		 object.add("q");
		 object.add("q");
		 object.add("q");
		 List<ArrayList<Object>> rowValuesList = new ArrayList<ArrayList<Object>>() ;
		 
		 rowValuesList.add(object) ;
		 
		 @SuppressWarnings("unused")
		ExcelTool excel = new ExcelTool(flag,sheetName,headerList,rowValuesList,"c://1.xls","yyyy-mm-dd") ;
		 
	}
}
