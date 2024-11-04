package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 主题对象 test_test
 * 
 * @author weis
 * @date 2023-02-08
 */
public class TestTest extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 测试id */
    private Long id;

    /** 标题 */
    @Excel(name = "标题")
    private String title;

    /** banner */
    @Excel(name = "banner")
    private String photo;

    /** 问题数组 */
    @Excel(name = "问题数组")
    private String ques;

    /** 备用图片 */
    @Excel(name = "备用图片")
    private String banner;

    /** 是否被删除 */
    @Excel(name = "是否被删除")
    private Integer isDel;

    /** 是否推荐 */
    @Excel(name = "是否推荐")
    private Integer isRecommend;

    /** 是否上架 */
    @Excel(name = "是否上架")
    private Integer isProducting;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setTitle(String title) 
    {
        this.title = title;
    }

    public String getTitle() 
    {
        return title;
    }
    public void setPhoto(String photo) 
    {
        this.photo = photo;
    }

    public String getPhoto() 
    {
        return photo;
    }
    public void setQues(String ques) 
    {
        this.ques = ques;
    }

    public String getQues() 
    {
        return ques;
    }
    public void setBanner(String banner) 
    {
        this.banner = banner;
    }

    public String getBanner() 
    {
        return banner;
    }

    public void setIsDel(Integer isDel)
    {
        this.isDel = isDel;
    }

    public Integer getIsDel()
    {
        return isDel;
    }

    public void setIsRecommend(Integer isRecommend)
    {
        this.isRecommend = isRecommend;
    }

    public Integer getIsRecommend()
    {
        return isRecommend;
    }
    public void setIsProducting(Integer isProducting)
    {
        this.isProducting = isProducting;
    }

    public Integer getIsProducting()
    {
        return isProducting;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("title", getTitle())
                .append("photo", getPhoto())
                .append("ques", getQues())
                .append("banner", getBanner())
                .append("createTime", getCreateTime())
                .append("updateTime", getUpdateTime())
                .append("updateBy", getUpdateBy())
                .append("isDel", getIsDel())
                .append("isRecommend", getIsRecommend())
                .append("isProducting", getIsProducting())
                .toString();
    }
}
