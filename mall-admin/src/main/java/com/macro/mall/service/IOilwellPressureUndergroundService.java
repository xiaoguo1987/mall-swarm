package com.macro.mall.service;

import com.macro.mall.dto.Bo.OilwellPressureUndergroundBo;
import com.macro.mall.dto.OilwellPressureUnderground;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author guojm
 * @since 2020-07-12
 */
public interface IOilwellPressureUndergroundService {

	List<OilwellPressureUnderground>  getUndergroundList(OilwellPressureUndergroundBo oilwellPressureUndergroundBo);

	List<String>  initOilRegionList();

	List<String>  initWillIdList(String oilRegion);

	void export(OilwellPressureUndergroundBo oilwellPressureUndergroundBo,HttpServletResponse response) throws Exception;
}
