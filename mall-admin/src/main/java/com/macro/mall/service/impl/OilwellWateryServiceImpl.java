package com.macro.mall.service.impl;

import com.google.common.collect.Lists;
import com.macro.mall.dao.OilwellWateryMapper;
import com.macro.mall.dto.Bo.OilwellWateryBo;
import com.macro.mall.dto.OilwellWatery;
import com.macro.mall.dto.vo.OilwellWateryVo;
import com.macro.mall.service.IOilwellWateryService;
import com.macro.mall.util.OperateExcel;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author gjm
 * @since 2020-07-19
 */
@Service
public class OilwellWateryServiceImpl implements IOilwellWateryService {

	private static final String titleStr="井区域,井号,月产油量,月产水量,月产液量,日产油量,日产水量,日产液量,含水率,创建时间";

	@Autowired
	private OilwellWateryMapper oilwellWateryMapper;

	@Override public List<OilwellWateryVo> getUndergroundList(
			OilwellWateryBo oilwellWateryBo) {
		List<OilwellWatery> oilwellWateryList = oilwellWateryMapper.getUndergroundList(oilwellWateryBo);
		List<OilwellWateryVo> oilwellWateryVoList = Lists
				.newArrayList();
		oilwellWateryList.forEach(s ->{
			OilwellWateryVo oilwellWateryVo = new OilwellWateryVo();
			BeanUtils.copyProperties(s,oilwellWateryVo);
			BigDecimal oilProdDaily = oilwellWateryVo.getOilProdDaily();
			BigDecimal liqProdDaily = oilwellWateryVo.getLiqProdDaily();
			BigDecimal moistureContent =BigDecimal.ONE.subtract(oilProdDaily.divide(liqProdDaily,2,BigDecimal.ROUND_HALF_UP));
			oilwellWateryVo.setMoistureContent(moistureContent);
			oilwellWateryVoList.add(oilwellWateryVo);
		});
		return oilwellWateryVoList;
	}

	@Override public List<OilwellWatery> getWateryList(
			OilwellWateryBo oilwellWateryBo) {
		List<OilwellWatery> oilwellWateryList = oilwellWateryMapper.getUndergroundList(oilwellWateryBo);
		return oilwellWateryList;
	}

	@Override public void export(OilwellWateryBo oilwellWateryBo,
			HttpServletResponse response) throws Exception{
		String sheetName="含水变化报表";
		// 第一步，创建一个HSSFWorkbook，对应一个Excel文件
		// 创建Excel工作薄
		XSSFWorkbook wb = new XSSFWorkbook();//excell2007
		XSSFSheet sheet = OperateExcel.getTableXSS(wb,titleStr,sheetName);
		//调用方法获取统计报表内的表格数据(此处省略，需自行补充，同前台echarts统计图数据源)
		List<OilwellWateryVo> list = this.getUndergroundList(oilwellWateryBo);

		//查询结果赋值到对应的列
		for(int i=0;i<list.size();i++){
			OilwellWateryVo oilwellWateryVo = list.get(i);
			//第二行
			Row rowNext = sheet.createRow(i+1);
			//每一列赋对应列名的值
			rowNext.createCell(0).setCellValue(oilwellWateryVo.getWellRegion());
			rowNext.createCell(1).setCellValue(oilwellWateryVo.getWellId());
			rowNext.createCell(2).setCellValue(oilwellWateryVo.getOilProdMon().toString());
			rowNext.createCell(3).setCellValue(oilwellWateryVo.getWaterProdMon().toString());
			rowNext.createCell(4).setCellValue(oilwellWateryVo.getLiqProdMon().toString());
			rowNext.createCell(5).setCellValue(oilwellWateryVo.getOilProdDaily().toString());
			rowNext.createCell(6).setCellValue(oilwellWateryVo.getWaterProdDaily().toString());
			rowNext.createCell(7).setCellValue(oilwellWateryVo.getLiqProdDaily().toString());
			rowNext.createCell(8).setCellValue(oilwellWateryVo.getMoistureContent().toString());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			rowNext.createCell(9).setCellValue(sdf.format(oilwellWateryVo.getCreateTime()));
		}

		OperateExcel.exportExcel(wb,sheet,oilwellWateryBo.getImgOutput(),sheetName+".xlsx",list.size(),response);
	}
}
