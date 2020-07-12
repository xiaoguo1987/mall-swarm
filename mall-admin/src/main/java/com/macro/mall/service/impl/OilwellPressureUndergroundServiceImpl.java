package com.macro.mall.service.impl;

import com.macro.mall.dao.OilwellPressureUndergroundMapper;
import com.macro.mall.dto.Bo.OilwellPressureUndergroundBo;
import com.macro.mall.dto.OilwellPressureUnderground;
import com.macro.mall.service.IOilwellPressureUndergroundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author guojm
 * @since 2020-07-12
 */
@Service
public class OilwellPressureUndergroundServiceImpl
		implements IOilwellPressureUndergroundService {

	@Autowired
	private  OilwellPressureUndergroundMapper oilwellPressureUndergroundMapper;

	@Override public List<OilwellPressureUnderground> getUndergroundList(
			OilwellPressureUndergroundBo oilwellPressureUndergroundBo) {
		return oilwellPressureUndergroundMapper.getUndergroundList(oilwellPressureUndergroundBo);
	}
}
