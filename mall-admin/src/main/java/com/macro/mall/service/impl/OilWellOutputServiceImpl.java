package com.macro.mall.service.impl;

import com.google.common.collect.Lists;
import com.macro.mall.dao.OilWellOutputMapper;
import com.macro.mall.dto.Bo.OilWellOutputBo;
import com.macro.mall.dto.OilWellOutput;
import com.macro.mall.dto.vo.OilWellOutputVo;
import com.macro.mall.service.IOilWellOutputService;
import com.macro.mall.util.OperateExcel;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.BeanUtils;
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
 * @since 2020-07-23
 */
@Service
public class OilWellOutputServiceImpl implements IOilWellOutputService {

	private static final String titleStr="井区域,井号,生产天数,静压,流压";

	@Autowired
	private OilWellOutputMapper oilWellOutputMapper;

	@Override public List<OilWellOutputVo> getUndergroundList(
			OilWellOutputBo oilWellOutputBo) {
		List<OilWellOutput> oilWellOutputList = oilWellOutputMapper.getUndergroundList(oilWellOutputBo);
		List<OilWellOutputVo> oilWellOutputVoList = Lists
				.newArrayList();
		oilWellOutputList.forEach(s ->{
			OilWellOutputVo oilWellOutputVo = new OilWellOutputVo();
			BeanUtils.copyProperties(s,oilWellOutputVo);
			oilWellOutputVoList.add(oilWellOutputVo);
		});
		return oilWellOutputVoList;
	}

	@Override public List<OilWellOutput> getWateryList(
			OilWellOutputBo oilWellOutputBo) {
		List<OilWellOutput> oilWellOutputList = oilWellOutputMapper.getUndergroundList(oilWellOutputBo);
		return oilWellOutputList;
	}

	@Override public void export(OilWellOutputBo oilWellOutputBo,
			HttpServletResponse response) throws Exception {

		String sheetName="生产变化报表";
		// 第一步，创建一个HSSFWorkbook，对应一个Excel文件
		// 创建Excel工作薄
		XSSFWorkbook wb = new XSSFWorkbook();//excell2007
		XSSFSheet sheet = OperateExcel.getTableXSS(wb,titleStr,sheetName);
		//调用方法获取统计报表内的表格数据(此处省略，需自行补充，同前台echarts统计图数据源)
		List<OilWellOutputVo> list = this.getUndergroundList(oilWellOutputBo);

		//查询结果赋值到对应的列
		for(int i=0;i<list.size();i++){
			OilWellOutputVo oilWellOutputVo = list.get(i);
			//第二行
			Row rowNext = sheet.createRow(i+1);
			//每一列赋对应列名的值
			rowNext.createCell(0).setCellValue(oilWellOutputVo.getWellRegion());
			rowNext.createCell(1).setCellValue(oilWellOutputVo.getWellId());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			rowNext.createCell(2).setCellValue(sdf.format(oilWellOutputVo.getProdDayNum()));
			rowNext.createCell(3).setCellValue(oilWellOutputVo.getStaticPres().toString());
			rowNext.createCell(4).setCellValue(oilWellOutputVo.getFlowPres().toString());

		}
		OperateExcel.exportExcel(wb,sheet,oilWellOutputBo.getImgOutput(),sheetName+".xlsx",list.size(),response);
	}

}
