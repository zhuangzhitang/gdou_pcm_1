package net.itaem.tool;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
/**
 * 容易查看异常的信息
 * @author itaem
 *change by zaoppeng :修改文件的路径。
 */
public class ExceptionRecoredTool {

	/*
	 * @param exceptionInfo 异常信息字符串
	 * 
	 * */
	public static void writeExceptionRecord(Exception e){
		if(e == null){
			return;
		}
		try {
			File file = new File("C:" + File.separator + "gdou_pcm_1"+File.separator+"exception.txt");

			FileWriter writer = new FileWriter(file, true);

            StackTraceElement[] stacks = e.getStackTrace();
            for(StackTraceElement stack: stacks){
            	writer.write(stack + ""+"\r\n");
            }
			writer.write("\r\n\r\n\r\n-------------------------------------------------\r\n\r\n\r\n");
			writer.flush();
			writer.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

	}
	
}
