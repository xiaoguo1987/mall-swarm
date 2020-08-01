package com.macro.mall.dao;

import com.macro.mall.dto.Bo.OilwellProductBo;
import com.macro.mall.dto.Bo.OilwellWateryBo;
import com.macro.mall.dto.OilwellProduct;
import com.macro.mall.dto.OilwellWatery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author guojm
 * @since 2020-07-23
 */
public interface OilwellProductMapper {

	List<OilwellProduct> getUndergroundList(@Param("queryParam") OilwellProductBo queryParam);

}
