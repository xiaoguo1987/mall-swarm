package com.macro.mall.dao;

import com.macro.mall.dto.Bo.OilwellPressureFlowBo;
import com.macro.mall.dto.OilwellPressureFlow;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author gjm
 * @since 2020-07-18
 */
public interface OilwellPressureFlowMapper {

	List<OilwellPressureFlow> getUndergroundList(@Param("queryParam") OilwellPressureFlowBo queryParam);
}
