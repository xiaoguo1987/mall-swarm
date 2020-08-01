package com.macro.mall.dto.Bo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author gjm
 * @since 2020-07-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class OilWellOutputBo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 井号
     */
    private Integer wellId;

    /**
     * 井区域
     */
    private String wellRegion;

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

	/**
	 * 图片流
	 */
	private String  imgOutput;
}
