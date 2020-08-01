package com.macro.mall.controller;

import com.google.common.collect.Lists;
import com.macro.mall.common.api.CommonResult;
import com.macro.mall.dto.Bo.OilwellPressureUndergroundBo;
import com.macro.mall.dto.OilwellPressureUnderground;
import com.macro.mall.dto.vo.OilwellPressureUndergroundVo;
import com.macro.mall.service.IOilwellPressureUndergroundService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFClientAnchor;
import org.apache.poi.xssf.usermodel.XSSFDrawing;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sun.misc.BASE64Decoder;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLDecoder;
import java.util.List;

/**
 * @ClassName: PressureController
 * @description: 压力数据
 * @author: gjm
 * @date: 2020-07-12 14 02
 **/
@Controller
@Api(tags = "PressureController", description = "油井压力数据")
@RequestMapping("/pressure")
public class PressureUnderController {

	@Autowired
	private IOilwellPressureUndergroundService oilWellPressureUndergroundService;

	@ApiOperation("获取一段时间的地层压力变化")
	@RequestMapping(value = "/underground", method = RequestMethod.POST)
	@ResponseBody
	public CommonResult<List<OilwellPressureUndergroundVo>> getList(@RequestBody
			OilwellPressureUndergroundBo oilwellPressureUndergroundBo) {
		System.out.println("wellId="+oilwellPressureUndergroundBo.getWellId());
		List<OilwellPressureUnderground> oilwellPressureUndergroundList = oilWellPressureUndergroundService.getUndergroundList(oilwellPressureUndergroundBo);
		List<OilwellPressureUndergroundVo> oilwellPressureUndergroundVoList = Lists
				.newArrayList();
		oilwellPressureUndergroundList.forEach(s ->{
			OilwellPressureUndergroundVo oilwellPressureUndergroundVo = new OilwellPressureUndergroundVo();
			BeanUtils.copyProperties(s,oilwellPressureUndergroundVo);
			oilwellPressureUndergroundVoList.add(oilwellPressureUndergroundVo);
		});
		return CommonResult.success(oilwellPressureUndergroundVoList);
	}

	@ApiOperation("初始化井区下拉框")
	@RequestMapping(value = "/initOilRegionList", method = RequestMethod.GET)
	@ResponseBody
	public CommonResult<List<String>> getOilRegionList() {
		List<String> list = oilWellPressureUndergroundService.initOilRegionList();
		return CommonResult.success(list);
	}

	@ApiOperation("根据井区查询对应井号下拉框")
	@RequestMapping(value = "/initWellIdList", method = RequestMethod.POST)
	@ResponseBody
	public CommonResult<List<String>> getWillIdList(String oilRegion) {
		List<String> list = oilWellPressureUndergroundService.initWillIdList(oilRegion);
		return CommonResult.success(list);
	}

	@ApiOperation("根据查询条件查询井区数据")
	@RequestMapping(value = "/getTableDataList", method = RequestMethod.POST)
	@ResponseBody
	public CommonResult<List<OilwellPressureUnderground>> search(@RequestBody
			OilwellPressureUndergroundBo oilwellPressureUndergroundBo) {
		System.out.println("wellId="+oilwellPressureUndergroundBo.getWellId());
		List<OilwellPressureUnderground> oilwellPressureUndergroundList = oilWellPressureUndergroundService.getUndergroundList(oilwellPressureUndergroundBo);
		return CommonResult.success(oilwellPressureUndergroundList);
	}

	@ApiOperation("根据查询条件导出报表数据")
	@RequestMapping(value = "/export", method = RequestMethod.POST)
	@ResponseBody
	public void exportData(@RequestBody
			OilwellPressureUndergroundBo oilwellPressureUndergroundBo,HttpServletResponse response) throws Exception{
		System.out.println("wellId="+oilwellPressureUndergroundBo.getWellId());
		oilWellPressureUndergroundService.export(oilwellPressureUndergroundBo,response);

	}

}
