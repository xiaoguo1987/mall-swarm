package com.macro.mall.service;

import com.macro.mall.dto.Bo.OilwellPressureFlowBo;
import com.macro.mall.dto.Bo.OilwellWateryBo;
import com.macro.mall.dto.OilwellPressureFlow;
import com.macro.mall.dto.OilwellWatery;
import com.macro.mall.dto.vo.OilwellWateryVo;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author gjm
 * @since 2020-07-19
 */
public interface IOilwellWateryService {

	List<OilwellWateryVo> getUndergroundList(OilwellWateryBo oilwellWateryBo);

	List<OilwellWatery> getWateryList(OilwellWateryBo oilwellWateryBo);

	void export(OilwellWateryBo oilwellWateryBo,HttpServletResponse response) throws Exception;

}
