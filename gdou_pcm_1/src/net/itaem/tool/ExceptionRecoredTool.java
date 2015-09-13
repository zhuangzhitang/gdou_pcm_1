package net.itaem.tool;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
/**
 * ���ײ鿴�쳣����Ϣ
 * @author itaem
 *change by zaoppeng :�޸��ļ���·����
 */
public class ExceptionRecoredTool {

	/*
	 * @param exceptionInfo �쳣��Ϣ�ַ���
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
