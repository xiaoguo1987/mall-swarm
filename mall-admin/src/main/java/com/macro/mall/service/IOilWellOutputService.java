package com.macro.mall.service;

import com.macro.mall.dto.Bo.OilWellOutputBo;
import com.macro.mall.dto.OilWellOutput;
import com.macro.mall.dto.vo.OilWellOutputVo;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author gjm
 * @since 2020-07-23
 */
public interface IOilWellOutputService  {

	List<OilWellOutputVo> getUndergroundList(OilWellOutputBo oilWellOutputBo);

	List<OilWellOutput> getWateryList(OilWellOutputBo oilWellOutputBo);

	void export(OilWellOutputBo oilWellOutputBo,HttpServletResponse response) throws 	Exception;
}
