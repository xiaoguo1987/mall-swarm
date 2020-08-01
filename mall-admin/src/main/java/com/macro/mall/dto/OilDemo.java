package com.macro.mall.dto;/**
 * @Auther: guojm
 * @Date: 2020-7-26 16:17
 * @Description:
 */

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @ClassName: OilDemo
 * @description:
 * @author: gjm
 * @date: 2020-07-26 16 17
 **/
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class OilDemo implements Serializable {

	private static final long serialVersionUID = 1L;

	private String stationId;
	//井ID
	private String wellId;
	private String sorting;
	private String siteId;
	private String injectionMethod;
	private String updateDate;
	private String orgId;
	private String oilMethodName;
	private String wellPurposeName;
	private String siteName;
	private String projectName;
	private String injMethodName;
	private String geoOffsetEast;
	private String drivingTypeName;
	private String reason;
	//井区域
	private String wellPurpose;



}
