package com.ruoyi.img.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 图片地址对象 img_img
 * 
 * @author ruoyi
 * @date 2023-03-03
 */
public class ImgImg extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 图片唯一标识 */
    private Long id;

    /** 图片地址 */
    @Excel(name = "图片地址")
    private String url;

    /** 用户id */
    @Excel(name = "用户id")
    private Long userId;

    /** 主题ID */
    @Excel(name = "主题ID")
    private Long cateId;

    @Excel(name="是否停用")
    private String isDel;
    @Excel(name="是否推荐, 1推荐")
    private String isRec;
    @Excel(name="是否置顶, 1置顶")
    private String isTop;
    @Excel(name = "下载次数")
    private Long times;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setUrl(String url) 
    {
        this.url = url;
    }

    public String getUrl() 
    {
        return url;
    }
    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }
    public void setCateId(Long cateId) 
    {
        this.cateId = cateId;
    }

    public Long getCateId() 
    {
        return cateId;
    }

    public Long getTimes() {
        return times;
    }

    public void setTimes(Long times) {
        this.times = times;
    }

    public String getIsDel() {
        return isDel;
    }

    public void setIsDel(String isDel) {
        this.isDel = isDel;
    }

    public String getIsRec() {
        return isRec;
    }

    public void setIsRec(String isRec) {
        this.isRec = isRec;
    }

    public String getIsTop() {
        return isTop;
    }

    public void setIsTop(String isTop) {
        this.isTop = isTop;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("url", getUrl())
            .append("userId", getUserId())
            .append("cateId", getCateId())
            .append("createTime", getCreateTime())
            .toString();
    }
}
