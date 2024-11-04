package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 趣测，题目对象 test_question
 * 
 * @author weis
 * @date 2023-01-31
 */
public class TestQuestion extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 问题id */
    private Long id;

    /** 测试id */
    @Excel(name = "测试id")
    private Long testId;

    /** 1: 文字类型 2: 图文类型  */
    @Excel(name = "1: 文字类型 2: 图文类型 ")
    private Long questionType;

    /** 问题 */
    @Excel(name = "问题")
    private String questionTitle;

    /** 选项A */
    @Excel(name = "选项A")
    private String choiceA;

    /** 选项B */
    @Excel(name = "选项B")
    private String choiceB;

    /** 选项C */
    @Excel(name = "选项C")
    private String choiceC;

    /** 选项D */
    @Excel(name = "选项D")
    private String choiceD;

    /** 选项A图片 */
    private String choiceAUrl;

    /** 选项B图片 */
    private String choiceBUrl;

    /** 选项C图片 */
    private String choiceCUrl;

    /** 选项D图片 */
    private String choiceDUrl;

    /** 结果 */
    @Excel(name = "结果")
    private String answer;

    /** 上一段 */
    @Excel(name = "上一段")
    private String nextUrl;

    /** 后一段 */
    @Excel(name = "后一段")
    private String preUrl;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setTestId(Long testId) 
    {
        this.testId = testId;
    }

    public Long getTestId() 
    {
        return testId;
    }
    public void setQuestionType(Long questionType) 
    {
        this.questionType = questionType;
    }

    public Long getQuestionType() 
    {
        return questionType;
    }
    public void setQuestionTitle(String questionTitle) 
    {
        this.questionTitle = questionTitle;
    }

    public String getQuestionTitle() 
    {
        return questionTitle;
    }
    public void setChoiceA(String choiceA) 
    {
        this.choiceA = choiceA;
    }

    public String getChoiceA() 
    {
        return choiceA;
    }
    public void setChoiceB(String choiceB) 
    {
        this.choiceB = choiceB;
    }

    public String getChoiceB() 
    {
        return choiceB;
    }
    public void setChoiceC(String choiceC) 
    {
        this.choiceC = choiceC;
    }

    public String getChoiceC() 
    {
        return choiceC;
    }
    public void setChoiceD(String choiceD) 
    {
        this.choiceD = choiceD;
    }

    public String getChoiceD() 
    {
        return choiceD;
    }
    public void setChoiceAUrl(String choiceAUrl) 
    {
        this.choiceAUrl = choiceAUrl;
    }

    public String getChoiceAUrl() 
    {
        return choiceAUrl;
    }
    public void setChoiceBUrl(String choiceBUrl) 
    {
        this.choiceBUrl = choiceBUrl;
    }

    public String getChoiceBUrl() 
    {
        return choiceBUrl;
    }
    public void setChoiceCUrl(String choiceCUrl) 
    {
        this.choiceCUrl = choiceCUrl;
    }

    public String getChoiceCUrl() 
    {
        return choiceCUrl;
    }
    public void setChoiceDUrl(String choiceDUrl) 
    {
        this.choiceDUrl = choiceDUrl;
    }

    public String getChoiceDUrl() 
    {
        return choiceDUrl;
    }
    public void setAnswer(String answer) 
    {
        this.answer = answer;
    }

    public String getAnswer() 
    {
        return answer;
    }
    public void setNextUrl(String nextUrl) 
    {
        this.nextUrl = nextUrl;
    }

    public String getNextUrl() 
    {
        return nextUrl;
    }
    public void setPreUrl(String preUrl) 
    {
        this.preUrl = preUrl;
    }

    public String getPreUrl() 
    {
        return preUrl;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("testId", getTestId())
            .append("questionType", getQuestionType())
            .append("questionTitle", getQuestionTitle())
            .append("choiceA", getChoiceA())
            .append("choiceB", getChoiceB())
            .append("choiceC", getChoiceC())
            .append("choiceD", getChoiceD())
            .append("choiceAUrl", getChoiceAUrl())
            .append("choiceBUrl", getChoiceBUrl())
            .append("choiceCUrl", getChoiceCUrl())
            .append("choiceDUrl", getChoiceDUrl())
            .append("answer", getAnswer())
            .append("nextUrl", getNextUrl())
            .append("preUrl", getPreUrl())
            .toString();
    }
}
