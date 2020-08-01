package com.macro.mall.dto.Bo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author guojm
 * @since 2020-07-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class OilwellProductBo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 井ID
     */
    private Integer wellId;

    /**
     * 井区域ID
     */
    private String wellRegion;

    /**
     * 年
     */
    private String oilYear;

	/**
	 * 图片流
	 */
	private String  imgOutput;
}
