package com.macro.mall.controller;

import com.macro.mall.common.api.CommonResult;
import com.macro.mall.dto.Bo.OilWellOutputBo;
import com.macro.mall.dto.Bo.OilwellWateryBo;
import com.macro.mall.dto.OilWellOutput;
import com.macro.mall.dto.vo.OilWellOutputVo;
import com.macro.mall.service.IOilWellOutputService;
import io.swagger.annotations.ApiOperation;
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
 * @since 2020-07-23
 */
@RestController
@RequestMapping("/oil/output")
public class OilWellOutputController {

	@Autowired
	private IOilWellOutputService oilWellOutputService;

	@ApiOperation("获取一段时间的含水变化")
	@RequestMapping(value = "/getList", method = RequestMethod.POST)
	@ResponseBody
	public CommonResult<List<OilWellOutputVo>> getList(@RequestBody OilWellOutputBo oilWellOutputBo) {
		System.out.println("wellId="+oilWellOutputBo.getWellId());
		return CommonResult.success(oilWellOutputService.getUndergroundList(oilWellOutputBo));
	}


	@ApiOperation("根据查询条件查询井区数据")
	@RequestMapping(value = "/getTableDataList", method = RequestMethod.POST)
	@ResponseBody
	public CommonResult<List<OilWellOutput>> search(@RequestBody
			OilWellOutputBo oilWellOutputBo) {
		System.out.println("wellId="+oilWellOutputBo.getWellId());
		List<OilWellOutput> oilWellOutputList = oilWellOutputService.getWateryList(oilWellOutputBo);
		return CommonResult.success(oilWellOutputList);
	}

	@ApiOperation("根据查询条件导出报表数据")
	@RequestMapping(value = "/export", method = RequestMethod.POST)
	@ResponseBody
	public void exportData(@RequestBody OilWellOutputBo oilWellOutputBo,HttpServletResponse response) throws Exception{
		System.out.println("wellId="+oilWellOutputBo.getWellId());
		oilWellOutputService.export(oilWellOutputBo,response);

	}
}
