package com.macro.mall.dto.Bo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author guojm
 * @since 2020-07-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class OilwellPressureUndergroundBo implements Serializable {


    /**
     * 井ID
     */
    private String wellId;

    /**
     * 井区
     */
    private String wellRegion;

    /**
     * 开始时间
     */
	@DateTimeFormat(pattern="yyyy-MM-dd")
    private Date startDate;
	/**
	 * 结束时间
	 */
	@DateTimeFormat(pattern="yyyy-MM-dd")
    private Date endDate;

	/**
	 * 图片流
	 */
	private String  imgOutput;
}
