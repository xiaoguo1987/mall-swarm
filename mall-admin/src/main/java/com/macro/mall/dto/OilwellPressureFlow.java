package com.macro.mall.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author gjm
 * @since 2020-07-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class OilwellPressureFlow implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 井ID
     */
    private int wellId;

    /**
     * 井区域
     */
    private int wellRegion;

    /**
     * 动液面(m)
     */
    private BigDecimal dynLiqLevel;

    /**
     * 泵深
     */
    private BigDecimal pumpDepth;

    /**
     * 油压
     */
    private BigDecimal tubingPres;

    /**
     * 套压
     */
    private BigDecimal casingPres;

    /**
     * 流压
     */
    private BigDecimal flowPres;

    /**
     * 静压
     */
    private BigDecimal staticPres;

    /**
     * 沉没度
     */
    private BigDecimal submergence;


	/**
	 * 创建时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date createTime;


}

