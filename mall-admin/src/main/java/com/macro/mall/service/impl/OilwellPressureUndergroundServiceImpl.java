package com.macro.mall.service.impl;

import com.macro.mall.dao.OilwellPressureUndergroundMapper;
import com.macro.mall.dto.Bo.OilwellPressureUndergroundBo;
import com.macro.mall.dto.OilwellPressureUnderground;
import com.macro.mall.service.IOilwellPressureUndergroundService;
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
 * @author guojm
 * @since 2020-07-12
 */
@Service
public class OilwellPressureUndergroundServiceImpl
		implements IOilwellPressureUndergroundService {

	private static final String titleStr="井区域,井号,原始地层压力,饱和压力,测试压力,压力保持水平,创建人,创建时间";

	@Autowired
	private  OilwellPressureUndergroundMapper oilwellPressureUndergroundMapper;

	@Override public List<OilwellPressureUnderground> getUndergroundList(
			OilwellPressureUndergroundBo oilwellPressureUndergroundBo) {
		return oilwellPressureUndergroundMapper.getUndergroundList(oilwellPressureUndergroundBo);
	}

	@Override public List<String> initOilRegionList() {
		return oilwellPressureUndergroundMapper.initOilRegionList();
	}

	@Override public List<String> initWillIdList(String oilRegion) {
		return oilwellPressureUndergroundMapper.initWillIdList(oilRegion);
	}

	@Override
	public void export(OilwellPressureUndergroundBo oilwellPressureUndergroundBo, HttpServletResponse response) throws Exception {

		String sheetName="地下压力报表";
		// 第一步，创建一个HSSFWorkbook，对应一个Excel文件
		// 创建Excel工作薄
		XSSFWorkbook wb = new XSSFWorkbook();//excell2007
		XSSFSheet sheet = OperateExcel.getTableXSS(wb,titleStr,sheetName);
		//调用方法获取统计报表内的表格数据(此处省略，需自行补充，同前台echarts统计图数据源)
		List<OilwellPressureUnderground> list = this.getUndergroundList(oilwellPressureUndergroundBo);

		//查询结果赋值到对应的列
		for(int i=0;i<list.size();i++){
			OilwellPressureUnderground oilwellPressureUnderground = list.get(i);
			//第二行
			Row rowNext = sheet.createRow(i+1);
			//每一列赋对应列名的值
			rowNext.createCell(0).setCellValue(oilwellPressureUnderground.getWellRegion());
			rowNext.createCell(1).setCellValue(oilwellPressureUnderground.getWellId());
			rowNext.createCell(2).setCellValue(oilwellPressureUnderground.getInitStratumPres().toString());
			rowNext.createCell(3).setCellValue(oilwellPressureUnderground.getInitSaturationPres().toString());
			rowNext.createCell(4).setCellValue(oilwellPressureUnderground.getTestPres().toString());
			rowNext.createCell(5).setCellValue(oilwellPressureUnderground.getPresRate().toString());
			rowNext.createCell(6).setCellValue(oilwellPressureUnderground.getCreator());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			rowNext.createCell(7).setCellValue(sdf.format(oilwellPressureUnderground.getCreateTime()));
		}

		OperateExcel.exportExcel(wb,sheet,oilwellPressureUndergroundBo.getImgOutput(),sheetName+".xlsx",list.size(),response);
	}
}
