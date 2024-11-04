package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.TestQuestion;

/**
 * 趣测，题目Mapper接口
 * 
 * @author weis
 * @date 2023-01-31
 */
public interface TestQuestionMapper 
{
    /**
     * 查询趣测，题目
     * 
     * @param id 趣测，题目主键
     * @return 趣测，题目
     */
    public TestQuestion selectTestQuestionById(Long id);


    public List<TestQuestion> questionsByIds(Long[] ids);


    public List<TestQuestion> selectTestQuestionListByTestId(Long id);
    /**
     * 查询趣测，题目列表
     * 
     * @param testQuestion 趣测，题目
     * @return 趣测，题目集合
     */
    public List<TestQuestion> selectTestQuestionList(TestQuestion testQuestion);

    /**
     * 新增趣测，题目
     * 
     * @param testQuestion 趣测，题目
     * @return 结果
     */
    public int insertTestQuestion(TestQuestion testQuestion);

    /**
     * 修改趣测，题目
     * 
     * @param testQuestion 趣测，题目
     * @return 结果
     */
    public int updateTestQuestion(TestQuestion testQuestion);

    /**
     * 删除趣测，题目
     * 
     * @param id 趣测，题目主键
     * @return 结果
     */
    public int deleteTestQuestionById(Long id);

    /**
     * 批量删除趣测，题目
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTestQuestionByIds(Long[] ids);
}
