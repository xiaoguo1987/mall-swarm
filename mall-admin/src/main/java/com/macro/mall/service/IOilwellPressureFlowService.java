package com.macro.mall.service;

import com.macro.mall.dto.Bo.OilwellPressureFlowBo;
import com.macro.mall.dto.OilwellPressureFlow;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author gjm
 * @since 2020-07-18
 */
public interface IOilwellPressureFlowService {

	List<OilwellPressureFlow> getUndergroundList(OilwellPressureFlowBo oilwellPressureFlowBo);

	void export(OilwellPressureFlowBo oilwellPressureFlowBo,HttpServletResponse response) throws Exception;
}
