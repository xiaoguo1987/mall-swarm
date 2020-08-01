package com.macro.mall.dao;

import com.macro.mall.dto.Bo.OilwellPressureFlowBo;
import com.macro.mall.dto.Bo.OilwellWateryBo;
import com.macro.mall.dto.OilwellWatery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author gjm
 * @since 2020-07-19
 */
public interface OilwellWateryMapper  {

	List<OilwellWatery> getUndergroundList(@Param("queryParam") OilwellWateryBo queryParam);
}
