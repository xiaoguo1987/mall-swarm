package com.macro.mall.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.io.Serializable;

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
     * 层位
     */
    private Integer layerNo;

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
    private LocalDate createTime;


}
