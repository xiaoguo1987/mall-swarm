package com.macro.mall.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

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
public class OilwellPressureUnderground implements Serializable {

	private Long id;

    /**
     * 井ID
     */
    private Integer wellId;

	/**
	 * 井区
	 */
	private String wellRegion;

    /**
     * 原始地层压力
     */
    private BigDecimal initStratumPres;

    /**
     * 饱和压力
     */
    private BigDecimal initSaturationPres;

    /**
     * 测试压力
     */
    private BigDecimal testPres;

    /**
     * 压力保持水平 = 测试压力 / 原始地层压力
     */
    private BigDecimal presRate;

    /**
     * 创建人
     */
    private String creator;

    /**
     * 创建时间
     */
	@JsonFormat(pattern = "yyyy-MM-dd")
    private Date createTime;


}
