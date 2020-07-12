package com.macro.mall.dto.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
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
public class OilwellPressureUndergroundVo implements Serializable {


    /**
     * 原始地层压力
     */
    private BigDecimal initStratumPres;


    /**
     * 测试压力
     */
    private BigDecimal testPres;

    /**
     * 压力保持水平 = 测试压力 / 原始地层压力
     */
    private BigDecimal presRate;

    /**
     * 创建时间
     */
	@JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate createTime;


}
