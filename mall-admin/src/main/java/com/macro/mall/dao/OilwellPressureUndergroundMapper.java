package com.macro.mall.dao;

import com.macro.mall.dto.Bo.OilwellPressureUndergroundBo;
import com.macro.mall.dto.OilwellPressureUnderground;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author guojm
 * @since 2020-07-12
 */
public interface OilwellPressureUndergroundMapper  {

	List<OilwellPressureUnderground> getUndergroundList(@Param("queryParam") OilwellPressureUndergroundBo queryParam);

}
