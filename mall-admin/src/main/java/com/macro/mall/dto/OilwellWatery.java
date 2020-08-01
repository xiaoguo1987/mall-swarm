package com.macro.mall.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author gjm
 * @since 2020-07-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class OilwellWatery implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 井ID
     */
    private Integer wellId;

	/**
	 * 井区域
	 */
	private int wellRegion;

    /**
     * 月产油量
     */
    private BigDecimal oilProdMon;

    /**
     * 月产水量
     */
    private BigDecimal waterProdMon;

    /**
     * 月产液量
     */
    private BigDecimal liqProdMon;

    /**
     * 日产油量
     */
    private BigDecimal oilProdDaily;

    /**
     * 日产水量
     */
    private BigDecimal waterProdDaily;

    /**
     * 日产液量
     */
    private BigDecimal liqProdDaily;

    /**
     * 创建时间
     */
	@JsonFormat(pattern = "yyyy-MM-dd")
    private Date createTime;


}
