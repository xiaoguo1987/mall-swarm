package com.macro.mall.controller;

import com.google.common.collect.Lists;
import com.macro.mall.common.api.CommonResult;
import com.macro.mall.dto.Bo.OilwellPressureUndergroundBo;
import com.macro.mall.dto.OilwellPressureUnderground;
import com.macro.mall.dto.vo.OilwellPressureUndergroundVo;
import com.macro.mall.model.PmsSkuStock;
import com.macro.mall.service.IOilwellPressureUndergroundService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.function.Consumer;

/**
 * @ClassName: PressureController
 * @description: 压力数据
 * @author: gjm
 * @date: 2020-07-12 14 02
 **/
@Controller
@Api(tags = "PressureController", description = "油井压力数据")
@RequestMapping("/pressure")
public class PressureController {

	@Autowired
	private IOilwellPressureUndergroundService oilWellPressureUndergroundService;

	@ApiOperation("获取一段时间的地层压力变化，默认10天")
	@RequestMapping(value = "/underground", method = RequestMethod.POST)
	@ResponseBody
	public CommonResult<List<OilwellPressureUndergroundVo>> getList(@RequestBody
			OilwellPressureUndergroundBo oilwellPressureUndergroundBo) {
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
}
