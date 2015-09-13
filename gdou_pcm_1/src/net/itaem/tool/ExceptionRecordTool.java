package net.itaem.tool;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/*
* 用来记录异常的工具类
 * 在以后程序维护的时候，更加容易找到程序出现错误的地方
 * */
public class ExceptionRecordTool {


	/*
	 * @param exceptionInfo 
	 * 
	 * */
	public static void writeExceptionRecord(Exception e){
		if(e == null){
			return;
		}
		try {
			File file = new File("C:" + File.separator + "exception.txt");

			FileWriter writer = new FileWriter(file, true);

            StackTraceElement[] stacks = e.getStackTrace();
            for(StackTraceElement stack: stacks){
            	writer.write(stack + "");
            }

			writer.write("\r\n\r\n\r\n-------------------------------------------------\r\n\r\n\r\n");
			writer.flush();
			writer.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

	}
}
