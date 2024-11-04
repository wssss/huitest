package com.ruoyi.img.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 图片对象 img_user
 * 
 * @author ruoyi
 * @date 2023-03-03
 */
public class ImgUser extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 用户id */
    private Long id;

    /** 用户名称 */
    @Excel(name = "用户名称")
    private String username;

    /** 手机 */
    @Excel(name = "手机")
    private String phone;

    /** 头像 */
    @Excel(name = "头像")
    private String headUrl;

    /** 省份 */
    @Excel(name = "省份")
    private String province;

    /** 城市 */
    @Excel(name = "城市")
    private String city;

    /** 快手唯一标识 */
    @Excel(name = "快手唯一标识")
    private String uid;

    /** 到期时间 */
    @Excel(name = "到期时间")
    private String validDate;

    /** 口令 */
    private String word;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setUsername(String username) 
    {
        this.username = username;
    }

    public String getUsername() 
    {
        return username;
    }
    public void setPhone(String phone) 
    {
        this.phone = phone;
    }

    public String getPhone() 
    {
        return phone;
    }
    public void setHeadUrl(String headUrl) 
    {
        this.headUrl = headUrl;
    }

    public String getHeadUrl() 
    {
        return headUrl;
    }
    public void setProvince(String province) 
    {
        this.province = province;
    }

    public String getProvince() 
    {
        return province;
    }
    public void setCity(String city) 
    {
        this.city = city;
    }

    public String getCity() 
    {
        return city;
    }
    public void setUid(String uid) 
    {
        this.uid = uid;
    }

    public String getUid() 
    {
        return uid;
    }
    public void setValidDate(String validDate) 
    {
        this.validDate = validDate;
    }

    public String getValidDate() 
    {
        return validDate;
    }
    public void setWord(String word) 
    {
        this.word = word;
    }

    public String getWord() 
    {
        return word;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("username", getUsername())
            .append("phone", getPhone())
            .append("headUrl", getHeadUrl())
            .append("province", getProvince())
            .append("city", getCity())
            .append("uid", getUid())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("createBy", getCreateBy())
            .append("validDate", getValidDate())
            .append("word", getWord())
            .toString();
    }
}
