package com.macro.mall.dao;

import com.macro.mall.dto.Bo.OilWellOutputBo;
import com.macro.mall.dto.Bo.OilwellWateryBo;
import com.macro.mall.dto.OilWellOutput;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author gjm
 * @since 2020-07-23
 */
public interface OilWellOutputMapper  {

	List<OilWellOutput> getUndergroundList(@Param("queryParam") OilWellOutputBo queryParam);

}
