package com.ruoyi.img.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 会员卡对象 img_card
 * 
 * @author ruoyi
 * @date 2023-03-03
 */
public class ImgCard extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 会员卡id */
    private Long id;

    /** 价格 */
    @Excel(name = "价格")
    private BigDecimal price;

    /** 会员卡名称 */
    @Excel(name = "会员卡名称")
    private String name;

    /** 有效日期 */
    @Excel(name = "有效日期")
    private Long validDay;

    /** 状态：0启用 1停用 */
    @Excel(name = "状态：0启用 1停用")
    private Long status;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setPrice(BigDecimal price) 
    {
        this.price = price;
    }

    public BigDecimal getPrice() 
    {
        return price;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setValidDay(Long validDay) 
    {
        this.validDay = validDay;
    }

    public Long getValidDay() 
    {
        return validDay;
    }
    public void setStatus(Long status) 
    {
        this.status = status;
    }

    public Long getStatus() 
    {
        return status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("price", getPrice())
            .append("remark", getRemark())
            .append("createTime", getCreateTime())
            .append("name", getName())
            .append("validDay", getValidDay())
            .append("status", getStatus())
            .toString();
    }
}
