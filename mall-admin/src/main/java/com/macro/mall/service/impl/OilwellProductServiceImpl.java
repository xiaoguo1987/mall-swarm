package com.macro.mall.service.impl;

import com.google.common.collect.Lists;
import com.macro.mall.dao.OilwellProductMapper;
import com.macro.mall.dto.Bo.OilwellProductBo;
import com.macro.mall.dto.OilwellProduct;
import com.macro.mall.dto.vo.OilwellProductVo;
import com.macro.mall.service.IOilwellProductService;
import com.macro.mall.util.OperateExcel;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author guojm
 * @since 2020-07-23
 */
@Service
public class OilwellProductServiceImpl  implements IOilwellProductService {

	private static final String titleStr="井区域,井号,静液面,月产油量,月产水量,月产液量,月,年";


	@Autowired
	private OilwellProductMapper oilwellProductMapper;


	@Override public List<OilwellProductVo> getUndergroundList(
			OilwellProductBo oilwellProductBo) {
		List<OilwellProduct> oilwellProductList = oilwellProductMapper.getUndergroundList(oilwellProductBo);
		List<OilwellProductVo> oilwellProductVoList = Lists
				.newArrayList();
		oilwellProductList.forEach(s ->{
			OilwellProductVo oilwellProductVo = new OilwellProductVo();
			BeanUtils.copyProperties(s,oilwellProductVo);
			oilwellProductVoList.add(oilwellProductVo);
		});
		return oilwellProductVoList;
	}

	@Override public List<OilwellProduct> getWateryList(
			OilwellProductBo oilwellProductBo) {
		List<OilwellProduct> oilwellWateryList = oilwellProductMapper.getUndergroundList(oilwellProductBo);
		return oilwellWateryList;
	}

	@Override public void export(OilwellProductBo oilwellProductBo,
			HttpServletResponse response) throws Exception {
		String sheetName="产油变化报表";
		// 第一步，创建一个HSSFWorkbook，对应一个Excel文件
		// 创建Excel工作薄
		XSSFWorkbook wb = new XSSFWorkbook();//excell2007
		XSSFSheet sheet = OperateExcel.getTableXSS(wb,titleStr,sheetName);
		//调用方法获取统计报表内的表格数据(此处省略，需自行补充，同前台echarts统计图数据源)
		List<OilwellProductVo> list = this.getUndergroundList(oilwellProductBo);

		//查询结果赋值到对应的列
		for(int i=0;i<list.size();i++){
			OilwellProductVo oilwellProductVo = list.get(i);
			//第二行
			Row rowNext = sheet.createRow(i+1);
			//每一列赋对应列名的值
			rowNext.createCell(0).setCellValue(oilwellProductVo.getWellRegion());
			rowNext.createCell(1).setCellValue(oilwellProductVo.getWellId());
			rowNext.createCell(2).setCellValue(oilwellProductVo.getStaticLiqLevel());
			rowNext.createCell(3).setCellValue(oilwellProductVo.getOilProdMon());
			rowNext.createCell(4).setCellValue(oilwellProductVo.getWaterProdMon());
			rowNext.createCell(5).setCellValue(oilwellProductVo.getLiqProdMon());
			rowNext.createCell(6).setCellValue(oilwellProductVo.getOilMonth());
			rowNext.createCell(7).setCellValue(oilwellProductVo.getOilYear());
		}
		OperateExcel.exportExcel(wb,sheet,oilwellProductBo.getImgOutput(),sheetName+".xlsx",list.size(),response);
	}
}
