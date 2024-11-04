package com.ruoyi.img.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 会员订单对象 img_order
 * 
 * @author ruoyi
 * @date 2023-03-03
 */
public class ImgOrder extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 订单id */
    private Long id;

    /** 花费金额 */
    @Excel(name = "花费金额")
    private Long payMoney;

    /** 会员卡id */
    @Excel(name = "会员卡id")
    private Long cardId;

    /** 订单id */
    @Excel(name = "订单id")
    private Long orderNum;

    /** 有效天数 */
    @Excel(name = "有效天数")
    private Long vaildDays;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setPayMoney(Long payMoney) 
    {
        this.payMoney = payMoney;
    }

    public Long getPayMoney() 
    {
        return payMoney;
    }
    public void setCardId(Long cardId) 
    {
        this.cardId = cardId;
    }

    public Long getCardId() 
    {
        return cardId;
    }
    public void setOrderNum(Long orderNum) 
    {
        this.orderNum = orderNum;
    }

    public Long getOrderNum() 
    {
        return orderNum;
    }
    public void setVaildDays(Long vaildDays) 
    {
        this.vaildDays = vaildDays;
    }

    public Long getVaildDays() 
    {
        return vaildDays;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("createTime", getCreateTime())
            .append("payMoney", getPayMoney())
            .append("cardId", getCardId())
            .append("orderNum", getOrderNum())
            .append("vaildDays", getVaildDays())
            .toString();
    }
}
