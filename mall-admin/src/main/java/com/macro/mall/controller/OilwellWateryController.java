package com.macro.mall.controller;

import com.google.common.collect.Lists;
import com.macro.mall.common.api.CommonResult;
import com.macro.mall.dto.Bo.OilwellPressureFlowBo;
import com.macro.mall.dto.Bo.OilwellWateryBo;
import com.macro.mall.dto.OilwellPressureFlow;
import com.macro.mall.dto.OilwellWatery;
import com.macro.mall.dto.vo.OilwellPressureFlowVo;
import com.macro.mall.dto.vo.OilwellWateryVo;
import com.macro.mall.service.IOilwellPressureFlowService;
import com.macro.mall.service.IOilwellWateryService;
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
 * @since 2020-07-19
 */
@RestController
@RequestMapping("/watery")
public class OilwellWateryController {

	@Autowired
	private IOilwellWateryService oilwellWateryService;

	@ApiOperation("获取一段时间的含水变化")
	@RequestMapping(value = "/getList", method = RequestMethod.POST)
	@ResponseBody
	public CommonResult<List<OilwellWateryVo>> getList(@RequestBody OilwellWateryBo oilwellWateryBo) {
		System.out.println("wellId="+oilwellWateryBo.getWellId());
		return CommonResult.success(oilwellWateryService.getUndergroundList(oilwellWateryBo));
	}


	@ApiOperation("根据查询条件查询井区数据")
	@RequestMapping(value = "/getTableDataList", method = RequestMethod.POST)
	@ResponseBody
	public CommonResult<List<OilwellWatery>> search(@RequestBody
			OilwellWateryBo oilwellWateryBo) {
		System.out.println("wellId="+oilwellWateryBo.getWellId());
		List<OilwellWatery> oilwellWateryList = oilwellWateryService.getWateryList(oilwellWateryBo);
		return CommonResult.success(oilwellWateryList);
	}

	@ApiOperation("根据查询条件导出报表数据")
	@RequestMapping(value = "/export", method = RequestMethod.POST)
	@ResponseBody
	public void exportData(@RequestBody
			OilwellWateryBo oilwellWateryBo,HttpServletResponse response) throws Exception{
		System.out.println("wellId="+oilwellWateryBo.getWellId());
		oilwellWateryService.export(oilwellWateryBo,response);

	}
}
