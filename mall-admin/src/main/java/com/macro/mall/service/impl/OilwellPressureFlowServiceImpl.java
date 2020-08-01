package com.macro.mall.service.impl;

import com.macro.mall.dao.OilwellPressureFlowMapper;
import com.macro.mall.dto.Bo.OilwellPressureFlowBo;
import com.macro.mall.dto.OilwellPressureFlow;
import com.macro.mall.service.IOilwellPressureFlowService;
import com.macro.mall.util.OperateExcel;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author gjm
 * @since 2020-07-18
 */
@Service
public class OilwellPressureFlowServiceImpl
		implements IOilwellPressureFlowService {

	private static final String titleStr="井区域,井号,动液面,泵深,油压,套压,流压,静压,沉没度,创建时间";


	@Autowired
	private OilwellPressureFlowMapper oilwellPressureFlowMapper;

	@Override public List<OilwellPressureFlow> getUndergroundList(
			OilwellPressureFlowBo oilwellPressureFlowBo) {
		return oilwellPressureFlowMapper.getUndergroundList(oilwellPressureFlowBo);
	}

	@Override public void export(OilwellPressureFlowBo oilwellPressureFlowBo,
			HttpServletResponse response) throws Exception{
		String sheetName="流动压力报表";
		// 第一步，创建一个HSSFWorkbook，对应一个Excel文件
		// 创建Excel工作薄
		XSSFWorkbook wb = new XSSFWorkbook();//excell2007
		XSSFSheet sheet = OperateExcel.getTableXSS(wb,titleStr,sheetName);
		//调用方法获取统计报表内的表格数据(此处省略，需自行补充，同前台echarts统计图数据源)
		List<OilwellPressureFlow> list = this.getUndergroundList(oilwellPressureFlowBo);

		//查询结果赋值到对应的列
		for(int i=0;i<list.size();i++){
			OilwellPressureFlow oilwellPressureFlow = list.get(i);
			//第二行
			Row rowNext = sheet.createRow(i+1);
			//每一列赋对应列名的值
			rowNext.createCell(0).setCellValue(oilwellPressureFlow.getWellRegion());
			rowNext.createCell(1).setCellValue(oilwellPressureFlow.getWellId());
			rowNext.createCell(2).setCellValue(oilwellPressureFlow.getDynLiqLevel().toString());
			rowNext.createCell(3).setCellValue(oilwellPressureFlow.getPumpDepth().toString());
			rowNext.createCell(4).setCellValue(oilwellPressureFlow.getTubingPres().toString());
			rowNext.createCell(5).setCellValue(oilwellPressureFlow.getCasingPres().toString());
			rowNext.createCell(6).setCellValue(oilwellPressureFlow.getFlowPres().toString());
			rowNext.createCell(7).setCellValue(oilwellPressureFlow.getStaticPres().toString());
			rowNext.createCell(8).setCellValue(oilwellPressureFlow.getSubmergence().toString());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			rowNext.createCell(9).setCellValue(sdf.format(oilwellPressureFlow.getCreateTime()));
		}

		OperateExcel.exportExcel(wb,sheet,oilwellPressureFlowBo.getImgOutput(),sheetName+".xlsx",list.size(),response);
	}

}
