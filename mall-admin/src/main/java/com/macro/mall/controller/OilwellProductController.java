package com.macro.mall.controller;

import com.macro.mall.common.api.CommonResult;
import com.macro.mall.dto.Bo.OilwellProductBo;
import com.macro.mall.dto.Bo.OilwellWateryBo;
import com.macro.mall.dto.OilwellProduct;
import com.macro.mall.dto.OilwellWatery;
import com.macro.mall.dto.vo.OilwellProductVo;
import com.macro.mall.dto.vo.OilwellWateryVo;
import com.macro.mall.service.IOilwellProductService;
import com.macro.mall.service.IOilwellWateryService;
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
 * @author guojm
 * @since 2020-07-23
 */
@RestController
@RequestMapping("/oilWell/product")
public class OilwellProductController {

	@Autowired
	private IOilwellProductService oilwellProductService;

	@ApiOperation("获取一段时间的含水变化")
	@RequestMapping(value = "/getList", method = RequestMethod.POST)
	@ResponseBody
	public CommonResult<List<OilwellProductVo>> getList(@RequestBody OilwellProductBo oilwellProductBo) {
		System.out.println("wellId="+oilwellProductBo.getWellId());
		return CommonResult.success(oilwellProductService.getUndergroundList(oilwellProductBo));
	}


	@ApiOperation("根据查询条件查询井区数据")
	@RequestMapping(value = "/getTableDataList", method = RequestMethod.POST)
	@ResponseBody
	public CommonResult<List<OilwellProduct>> search(@RequestBody
			OilwellProductBo oilwellProductBo) {
		System.out.println("wellId="+oilwellProductBo.getWellId());
		List<OilwellProduct> oilwellWateryList = oilwellProductService.getWateryList(oilwellProductBo);
		return CommonResult.success(oilwellWateryList);
	}

	@ApiOperation("根据查询条件导出报表数据")
	@RequestMapping(value = "/export", method = RequestMethod.POST)
	@ResponseBody
	public void exportData(@RequestBody
			OilwellProductBo oilwellProductBo,HttpServletResponse response) throws Exception{
		System.out.println("wellId="+oilwellProductBo.getWellId());
		oilwellProductService.export(oilwellProductBo,response);

	}
}
