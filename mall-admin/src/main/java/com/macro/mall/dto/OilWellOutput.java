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
 * @since 2020-07-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class OilWellOutput implements Serializable {

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
     * 生产天数
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date prodDayNum;

    /**
     * 静压
     */
    private BigDecimal staticPres;

    /**
     * 流压
     */
    private BigDecimal flowPres;


}
