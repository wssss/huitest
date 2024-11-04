package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 测试结果对象 test_result
 * 
 * @author weis
 * @date 2023-01-31
 */
public class TestResult extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 结果id */
    private Integer id;
    /** 结果id */
    private Integer testId;

    /** 答案 */
    @Excel(name = "答案")
    private String answers;

    /** 内容 */
    @Excel(name = "内容")
    private String content;

    /** 标题 */
    @Excel(name = "标题")
    private String title;

    public void setId(Integer id) 
    {
        this.id = id;
    }

    public Integer getId() 
    {
        return id;
    }

    public Integer getTestId() {
        return testId;
    }

    public void setTestId(Integer testId) {
        this.testId = testId;
    }

    public void setAnswers(String answers)
    {
        this.answers = answers;
    }

    public String getAnswers() 
    {
        return answers;
    }
    public void setContent(String content) 
    {
        this.content = content;
    }

    public String getContent() 
    {
        return content;
    }
    public void setTitle(String title) 
    {
        this.title = title;
    }

    public String getTitle() 
    {
        return title;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("testId", getTestId())
            .append("id", getId())
            .append("answers", getAnswers())
            .append("content", getContent())
            .append("title", getTitle())
            .toString();
    }
}
