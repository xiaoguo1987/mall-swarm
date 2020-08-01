package com.macro.mall.dto.vo;

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
public class OilwellProductVo implements Serializable {

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
     * 静液面
     */
    private String staticLiqLevel;

    /**
     * 月产油量
     */
    private String oilProdMon;

    /**
     * 月产水量
     */
    private String waterProdMon;

    /**
     * 月产液量
     */
    private String liqProdMon;

    /**
     * 月
     */
    private String oilMonth;

    /**
     * 年
     */
    private String oilYear;


}
