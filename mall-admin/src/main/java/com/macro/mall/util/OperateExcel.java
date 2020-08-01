package com.macro.mall.util;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFClientAnchor;
import org.apache.poi.xssf.usermodel.XSSFDrawing;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import sun.misc.BASE64Decoder;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URLDecoder;
import java.net.URLEncoder;
/**
 * @ClassName: OperateExcel
 * @description: 导出excel xlsx 工具类
 * @author: gjm
 * @date: 2020-07-26 10 54
 **/

public class OperateExcel {

	//发送响应流方法
	public static void setResponseHeader(HttpServletResponse response, String fileName) {
		try {
			response.setCharacterEncoding("UTF-8");
			response.setContentType("application/vnd.ms-excel;charset=UTF-8");
			response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder
					.encode(fileName,"UTF-8"));

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * 导出报表
	 *
	 * @return
	 */
	public static void exportExcel(XSSFWorkbook wb,XSSFSheet sheet,String imgUrl,
			String fileName,int ListSize,HttpServletResponse response) throws Exception {

		/*生成图表*/
		String[] imgUrlArr = imgUrl.split("base64,");//拆分base64编码后部分
		String dataChartString = URLDecoder.decode(imgUrlArr[1], "UTF-8");
		dataChartString = dataChartString.replaceAll(" ", "+");

		BASE64Decoder base64Decoder = new BASE64Decoder();
		ByteArrayInputStream dataChartStringin = new ByteArrayInputStream(
				base64Decoder.decodeBuffer(dataChartString)); //将picInfoByte作为输入流；
		setResponseHeader(response, fileName);
		OutputStream os = response.getOutputStream();
		//先把读进来的图片放到一个ByteArrayOutputStream中，以便产生ByteArray
		try {
			ByteArrayOutputStream byteArrayOut = new ByteArrayOutputStream();
			BufferedImage bufferImg = ImageIO.read(dataChartStringin);
			ImageIO.write(bufferImg, "png", byteArrayOut);
			//画图的顶级管理器，一个sheet只能获取一个（一定要注意这点）
			XSSFDrawing patriarch = sheet.createDrawingPatriarch();
			//anchor主要用于设置图片的属性
//			dx1：起始单元格的x偏移量，如例子中的255表示直线起始位置距A1单元格左侧的距离；
//			dy1：起始单元格的y偏移量，如例子中的125表示直线起始位置距A1单元格上侧的距离；
//			dx2：终止单元格的x偏移量，如例子中的1023表示直线起始位置距C3单元格左侧的距离；
//			dy2：终止单元格的y偏移量，如例子中的150表示直线起始位置距C3单元格上侧的距离；
//			col1：起始单元格列序号，从0开始计算；
//			row1：起始单元格行序号，从0开始计算，如例子中col1=0,row1=0就表示起始单元格为A1；
//			col2：终止单元格列序号，从0开始计算；
//			row2：终止单元格行序号，从0开始计算，如例子中col2=2,row2=2就表示起始单元格为C3；
			XSSFClientAnchor anchor = new XSSFClientAnchor(ListSize+5, ListSize+5, 256, 256, (short) 1, ListSize+3, (short) 16, ListSize+35);
			anchor.setAnchorType(ClientAnchor.AnchorType.DONT_MOVE_AND_RESIZE);
			//插入图片
			patriarch.createPicture(anchor,wb.addPicture(byteArrayOut.toByteArray(), XSSFWorkbook.PICTURE_TYPE_JPEG));
			wb.write(os);
			os.flush();
			wb.close();
			os.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (os != null) {
				try {
					os.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static XSSFSheet getTableXSS(XSSFWorkbook wb,String titleStr,String sheetName){

		// 第二步，在workbook中添加一个sheet,对应Excel文件中的sheet
		XSSFSheet sheet = wb.createSheet(sheetName);

		// 第三步,设置标题和表头;
		Row rowIndex = sheet.createRow(0);// 创建第一行,设置表的标题;
		rowIndex.setHeightInPoints(32);//设置行的高度是32个点

		//循环赋值
		String[] title = titleStr.split(",");
		for(int i=0;i<title.length;i++){
			Cell second = rowIndex.createCell(i);
			second.setCellValue(title[i]);
		}
		return sheet;
	}

}
