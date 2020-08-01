package com.macro.mall.controller;


import com.google.common.collect.Lists;
import com.macro.mall.common.api.CommonResult;
import com.macro.mall.dto.Bo.OilwellPressureFlowBo;
import com.macro.mall.dto.Bo.OilwellPressureUndergroundBo;
import com.macro.mall.dto.OilwellPressureFlow;
import com.macro.mall.dto.OilwellPressureUnderground;
import com.macro.mall.dto.vo.OilwellPressureFlowVo;
import com.macro.mall.dto.vo.OilwellPressureUndergroundVo;
import com.macro.mall.service.IOilwellPressureFlowService;
import com.macro.mall.service.IOilwellPressureUndergroundService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author gjm
 * @since 2020-07-18
 */
@RestController
@RequestMapping("/flow")
public class OilwellPressureFlowController {
	@Autowired
	private IOilwellPressureFlowService oilwellPressureFlowService;

	@ApiOperation("获取一段时间的流动压力变化")
	@RequestMapping(value = "/getList", method = RequestMethod.POST)
	@ResponseBody
	public CommonResult<List<OilwellPressureFlowVo>> getList(@RequestBody OilwellPressureFlowBo oilwellPressureFlowBo) {
		System.out.println("wellId="+oilwellPressureFlowBo.getWellId());
		List<OilwellPressureFlow> oilwellPressureUndergroundList = oilwellPressureFlowService.getUndergroundList(oilwellPressureFlowBo);
		List<OilwellPressureFlowVo> oilwellPressureUndergroundVoList = Lists
				.newArrayList();
		oilwellPressureUndergroundList.forEach(s ->{
			OilwellPressureFlowVo oilwellPressureUndergroundVo = new OilwellPressureFlowVo();
			BeanUtils.copyProperties(s,oilwellPressureUndergroundVo);
			oilwellPressureUndergroundVoList.add(oilwellPressureUndergroundVo);
		});
		return CommonResult.success(oilwellPressureUndergroundVoList);
	}


	@ApiOperation("根据查询条件查询井区数据")
	@RequestMapping(value = "/getTableDataList", method = RequestMethod.POST)
	@ResponseBody
	public CommonResult<List<OilwellPressureFlow>> search(@RequestBody
			OilwellPressureFlowBo oilwellPressureFlowBo) {
		System.out.println("wellId="+oilwellPressureFlowBo.getWellId());
		List<OilwellPressureFlow> oilwellPressureUndergroundList = oilwellPressureFlowService.getUndergroundList(oilwellPressureFlowBo);
		return CommonResult.success(oilwellPressureUndergroundList);
	}

	@ApiOperation("根据查询条件导出报表数据")
	@RequestMapping(value = "/export", method = RequestMethod.POST)
	@ResponseBody
	public void exportData(@RequestBody
			OilwellPressureFlowBo oilwellPressureFlowBo,HttpServletResponse response) throws Exception{
		System.out.println("wellId="+oilwellPressureFlowBo.getWellId());
		oilwellPressureFlowService.export(oilwellPressureFlowBo,response);

	}
}
