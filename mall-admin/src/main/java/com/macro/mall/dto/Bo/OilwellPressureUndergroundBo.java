package com.macro.mall.dto.Bo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDate;

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
    private Integer wellId;

    /**
     * 层位
     */
    private Integer layerNo;

    /**
     * 开始时间
     */
	@DateTimeFormat(pattern="yyyy-MM-dd")
    private LocalDate startDate;
	/**
	 * 结束时间
	 */
	@DateTimeFormat(pattern="yyyy-MM-dd")
    private LocalDate endDate;


}
