package net.itaem.tool;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * 有关excel操作的api
 * 可以使用这个类完成excel的导出，导入等各种操作
 * @date 2014-03-10
 * 
 * */
public class ExcelTool {

	//cell 的格式为date的style格式
	private CellStyle dateStyle;
	//cell 的格式为string，int，float等其他的style格式，如果没有指定dateStyle，那么就使用默认的格式
	private CellStyle defaultStyle;
	//cell 的header style格式
	private CellStyle headerStyle;
	//excel 格式
	private boolean is2007;
	//excel sheet 的名字
	private String sheetName;
	//文件输出流
	private OutputStream outStream;
	//到导出的excel头部信息
	private List<String> headerList;
	//要导出excel的内容信息
	private List<ArrayList<Object>> rowValuesList;
	//日期的格式
	private String formatStr;

	public ExcelTool(){}

	/**
	 * 指定这个类的构造方法
	 * 直接在这里已经创建好并且输出了excel
	 * @param is2007 要创建什么格式的excel
	 * @param sheetName excel的sheetname
	 * @param headerList excel的第一行头信息
	 * @param objValus excel的内容
	 * @param filepath 要保存的路径
	 * @param formatStr 日期的格式
	 * */
	public ExcelTool(boolean is2007, String sheetName, List<String> headerList, 
			List<ArrayList<Object>> rowValuesList, String filename, String formatStr){
		this.is2007 = is2007;
		this.sheetName = sheetName;
		this.headerList = headerList;
		this.rowValuesList = rowValuesList;
		try {
			outStream = new FileOutputStream(filename);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("文件不存在" + filename);
		}
		this.formatStr = formatStr;
		export();
		
	}
	
	/**
	 * 指定这个类的构造方法
	 * 直接在这里已经创建好并且输出了excel
	 * @param is2007 要创建什么格式的excel
	 * @param sheetName excel的sheetname
	 * @param headerList excel的第一行头信息
	 * @param objValus excel的内容
	 * @param outStream 输出流
	 * @param formatStr 日期的格式
	 * */
	public ExcelTool(boolean is2007, String sheetName, List<String> headerList, 
			List<ArrayList<Object>> rowValuesList, OutputStream outStream, String formatStr){
		this.is2007 = is2007;
		this.sheetName = sheetName;
		this.headerList = headerList;
		this.rowValuesList = rowValuesList;
		this.outStream = outStream;
		this.formatStr = formatStr;
		export();
	}
	
	/**
	 * 指定这个类的构造方法
	 * 直接在这里已经创建好并且输出了excel
	 * @param is2007 要创建什么格式的excel
	 * @param sheetName excel的sheetname
	 * @param headerList excel的第一行头信息
	 * @param objValus excel的内容
	 * @param file 输出文件
	 * @param formatStr 日期的格式
	 * */
	public ExcelTool(boolean is2007, String sheetName, List<String> headerList, 
			List<ArrayList<Object>> rowValuesList, File file, String formatStr){
		this.is2007 = is2007;
		this.sheetName = sheetName;
		this.headerList = headerList;
		this.rowValuesList = rowValuesList;
		
		try {
			this.outStream = new FileOutputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("文件不存在" + file);
		}
		
		this.formatStr = formatStr;
		export();
	}
	
	

	public boolean isIs2007() {
		return is2007;
	}

	public void setIs2007(boolean is2007) {
		this.is2007 = is2007;
	}

	public String getSheetName() {
		return sheetName;
	}

	public void setSheetName(String sheetName) {
		this.sheetName = sheetName;
	}

	
	public OutputStream getOutStream() {
		return outStream;
	}

	public void setOutStream(OutputStream outStream) {
		this.outStream = outStream;
	}

	public CellStyle getDateStyle() {
		return dateStyle;
	}

	public void setDateStyle(CellStyle dateStyle) {
		this.dateStyle = dateStyle;
	}

	public CellStyle getDefaultStyle() {
		return defaultStyle;
	}

	public void setDefaultStyle(CellStyle defaultStyle) {
		this.defaultStyle = defaultStyle;
	}

	public CellStyle getHeaderStyle() {
		return headerStyle;
	}

	public void setHeaderStyle(CellStyle headerStyle) {
		this.headerStyle = headerStyle;
	}
	
	public List<String> getHeaderList() {
		return headerList;
	}

	public void setHeaderList(List<String> headerList) {
		this.headerList = headerList;
	}

	

	public List<ArrayList<Object>> getRowValuesList() {
		return rowValuesList;
	}

	public void setRowValuesList(List<ArrayList<Object>> rowValuesList) {
		this.rowValuesList = rowValuesList;
	}

	public String getFormatStr() {
		return formatStr;
	}

	public void setFormatStr(String formatStr) {
		this.formatStr = formatStr;
	}
	
	//在这里完成导出操作
	public int export(){
		int result = 0;
		Workbook wb = createWorkbook(is2007);
		Sheet sheet = createSheet(wb, sheetName);
	    if(headerStyle == null){
	        headerStyle = createHearderStyle(wb);
	    }
	    
	    if(dateStyle == null){
	    	createDateStyle(wb, formatStr);
	    }
	    
	    if(defaultStyle == null){
	    	defaultStyle = createDefaultStyle(wb);
	    }
	    
	    //创建头部
	    createHeader(sheet, headerList, headerStyle);
	    
	    for(int i=0; i<rowValuesList.size(); i++){
	    	sheet.autoSizeColumn((short)i); //设置为自动调整宽度
	    	addRow(sheet, i+1, dateStyle, defaultStyle, rowValuesList.get(i));	    		
	    }
	   
	    try {
			wb.write(outStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 创建一个excel文件
	 * @param is2007 为true，创建excel 2007；否则，创建excel 2003
	 * */
	private Workbook createWorkbook(boolean is2007){
		Workbook workbook = null;
		if(is2007)
			workbook = new XSSFWorkbook();	
		else
			workbook = new HSSFWorkbook();
		return workbook;
	}

	/**
	 * 创建一个sheet
	 * @param workbook excel对象
	 * @param sheetName 要创建sheet对象的名字
	 * */
	private Sheet createSheet(Workbook workbook,String sheetName){
		return workbook.createSheet(sheetName);
	}

	/**
	 * 创建excel的Header row
	 * @param sheet 即将要创建header row的宿主对象
	 * @param headerList 第一列的数据
	 * @param headerList 第一列的格式，如果为null，则不添加样式
	 * */
	private void createHeader(Sheet sheet, List<String> headerList, CellStyle headerStyle){
		Row header = sheet.createRow(0);   
		if(headerStyle != null){
			header.setRowStyle(headerStyle);
		}
		
		for(int i=0; i<headerList.size(); i++){
			Cell cell = header.createCell(i);
			cell.setCellValue(headerList.get(i));
			if(headerStyle != null){
				cell.setCellStyle(headerStyle);
			}
		}
	}

	/**
	 * 创建一个Font，这里每次创建的样式默认都是这个固定的样式
	 * 如果需要创建更多样式，请直接在调用处创建
	 *  
	 * @param workbook 即将要创建HSSFFont的宿主对象 
	 * */
	private CellStyle createHearderStyle(Workbook workbook){
		Font font = workbook.createFont();

		font.setFontName("微软雅黑");
		font.setFontHeightInPoints((short) 14);
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		// 表头样式及背景色
		CellStyle hdStyle = workbook.createCellStyle();
		hdStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		hdStyle.setBottomBorderColor(HSSFColor.BLACK.index);

		hdStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		hdStyle.setLeftBorderColor(HSSFColor.BLACK.index);

		hdStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
		hdStyle.setRightBorderColor(HSSFColor.BLACK.index);

		hdStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
		hdStyle.setTopBorderColor(HSSFColor.BLACK.index);

		hdStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);

		hdStyle.setFillForegroundColor(HSSFColor.GREY_25_PERCENT.index);

		hdStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		hdStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);

		hdStyle.setFont(font);

		return hdStyle;
	}

	
	/**
	 * 写出一个workbook到指定目录中
	 * @param workbook 即将输出的excel文件
	 * @param outStream 即将要输出的文件流
	 * */
//	private void writeWorkbook(Workbook workbook, OutputStream outStream){
//		try {
//			workbook.write(outStream);
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}catch (IOException e) {
//			e.printStackTrace();
//		}finally{
//			try {
//				outStream.close();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
//	}

	
	
	/**
	 * 在sheet上面增加一行数据
	 * @param sheet 即将要增加row的sheet宿主对象
	 * @param addedIndex 要增加的行下标
	 * @param dateStyle 如果增加的cell格式是date，则使用这个dateStyle格式
	 * @param defaultStyle 其它数据使用的Style格式
	 * @param rowValuesList 要增加的row数据集合 
	 * @return 返回导出成功的数目
	 * */
	private int addRow(Sheet sheet, int addedIndex, CellStyle dateStyle, CellStyle defaultStyle, List<Object> rowValuesList){
		Row row = sheet.createRow(addedIndex);
		int result = 0;
		for (int j = 0; j < rowValuesList.size(); j++) {
			Object cell_data = rowValuesList.get(j);
			Cell cell = row.createCell(j);
			// 正文格式
			if (cell_data instanceof String) {
				cell.setCellValue((String)cell_data);
				cell.setCellStyle(defaultStyle);
			}
			else if (cell_data instanceof Double) {
				cell.setCellValue((Double) cell_data);
				cell.setCellStyle(defaultStyle);
			} 
			else if (cell_data instanceof Integer) {
				cell.setCellValue(Double.valueOf(String.valueOf(cell_data)));
				cell.setCellStyle(defaultStyle);
			} 	
			else if (cell_data instanceof Date) {
				cell.setCellValue((Date) cell_data);
				cell.setCellStyle(dateStyle);
			} 
			else if (cell_data instanceof Boolean) {
				cell.setCellValue((Boolean) cell_data);
			}else if (cell_data instanceof Float) {
				cell.setCellValue((Float) cell_data);
			}
			
			result++;
		}
		return result;
	}
	/**
	 * 创建cell的数据格式为text的样式
	 * @param 要创建cellstyle的宿主对象
	 * @return CellStyle
	 * */
	private CellStyle createDefaultStyle(Workbook workbook){
		DataFormat format = workbook.createDataFormat();
		CellStyle textStyle = workbook.createCellStyle();
		
		textStyle.setDataFormat(format.getFormat("text"));
		
		textStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		textStyle.setBottomBorderColor(HSSFColor.BLACK.index);
		textStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		textStyle.setLeftBorderColor(HSSFColor.BLACK.index);
		textStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
		textStyle.setRightBorderColor(HSSFColor.BLACK.index);
		textStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
		textStyle.setTopBorderColor(HSSFColor.BLACK.index);
		textStyle.setFillForegroundColor(HSSFColor.LIGHT_YELLOW.index);
		return textStyle;
	}
	
	/**
	 * 创建一个cell数据类型为date的格式
	 * */
	private CellStyle createDateStyle(Workbook workbook, String formatStr){
		CellStyle dateStyle = workbook.createCellStyle();
		
		DataFormat format = workbook.createDataFormat();
		
		dateStyle.setDataFormat(format.getFormat(formatStr));
		
		dateStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		dateStyle.setBottomBorderColor(HSSFColor.BLACK.index);
		dateStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		dateStyle.setLeftBorderColor(HSSFColor.BLACK.index);
		dateStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
		dateStyle.setRightBorderColor(HSSFColor.BLACK.index);
		dateStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
		dateStyle.setTopBorderColor(HSSFColor.BLACK.index);
		dateStyle.setFillForegroundColor(HSSFColor.LIGHT_YELLOW.index);
		return dateStyle;
	}
	
	//获取对象的所有属性值，以数组的形式返回
	//可以继续封装addRow()
	//目前没有进行进一步的封装
	//所以该方法目前没有作用，不需要删除，以后可以扩展
//	private Object[] getPeroperties(Object obj){
//		Field[] fields = obj.getClass().getDeclaredFields();
//		Object[] properties = new Object[fields.length+1];
//	    
//		Method[] methods = obj.getClass().getMethods();
//	    int i=0;
//	    for(Method method: methods){
//	    	if(method.getName().startsWith("get")){
//	    		try {
//	    			Object obj1 = method.invoke(obj, null);
//	    			if(obj != null){
//	    				properties[i] = obj1;
//	    				i++;
//	    			}
//				} catch (IllegalArgumentException e) {
//					e.printStackTrace();
//				} catch (IllegalAccessException e) {
//					e.printStackTrace();
//				} catch (InvocationTargetException e) {
//					e.printStackTrace();
//				}
//	    	}
//	    }
//		return properties;
//	}
	
}
