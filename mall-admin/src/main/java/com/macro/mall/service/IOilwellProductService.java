package com.macro.mall.service;

import com.macro.mall.dto.Bo.OilwellProductBo;
import com.macro.mall.dto.Bo.OilwellWateryBo;
import com.macro.mall.dto.OilwellProduct;
import com.macro.mall.dto.OilwellWatery;
import com.macro.mall.dto.vo.OilwellProductVo;
import com.macro.mall.dto.vo.OilwellWateryVo;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author guojm
 * @since 2020-07-23
 */
public interface IOilwellProductService  {

	List<OilwellProductVo> getUndergroundList(OilwellProductBo oilwellProductBo);

	List<OilwellProduct> getWateryList(OilwellProductBo oilwellProductBo);

	void export(OilwellProductBo oilwellProductBo,HttpServletResponse response) throws Exception ;
}
