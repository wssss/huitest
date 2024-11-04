package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TestQuestionMapper;
import com.ruoyi.system.domain.TestQuestion;
import com.ruoyi.system.service.ITestQuestionService;

/**
 * 趣测，题目Service业务层处理
 * 
 * @author weis
 * @date 2023-01-31
 */
@Service
public class TestQuestionServiceImpl implements ITestQuestionService 
{
    @Autowired
    private TestQuestionMapper testQuestionMapper;

    /**
     * 查询趣测，题目
     * 
     * @param id 趣测，题目主键
     * @return 趣测，题目
     */
    @Override
    public TestQuestion selectTestQuestionById(Long id)
    {
        return testQuestionMapper.selectTestQuestionById(id);
    }

    @Override
    public List<TestQuestion> questionsByIds(Long[] ids)
    {
        return testQuestionMapper.questionsByIds(ids);
    }


    /**
     * 查询趣测，题目列表
     * 
     * @param testQuestion 趣测，题目
     * @return 趣测，题目
     */
    @Override
    public List<TestQuestion> selectTestQuestionList(TestQuestion testQuestion)
    {
        return testQuestionMapper.selectTestQuestionList(testQuestion);
    }

    @Override
    public List<TestQuestion> selectTestQuestionListByTestId(Long testId)
    {
        return testQuestionMapper.selectTestQuestionListByTestId(testId);
    }

    /**
     * 新增趣测，题目
     * 
     * @param testQuestion 趣测，题目
     * @return 结果
     */
    @Override
    public int insertTestQuestion(TestQuestion testQuestion)
    {
        return testQuestionMapper.insertTestQuestion(testQuestion);
    }

    /**
     * 修改趣测，题目
     * 
     * @param testQuestion 趣测，题目
     * @return 结果
     */
    @Override
    public int updateTestQuestion(TestQuestion testQuestion)
    {
        return testQuestionMapper.updateTestQuestion(testQuestion);
    }

    /**
     * 批量删除趣测，题目
     * 
     * @param ids 需要删除的趣测，题目主键
     * @return 结果
     */
    @Override
    public int deleteTestQuestionByIds(Long[] ids)
    {
        return testQuestionMapper.deleteTestQuestionByIds(ids);
    }

    /**
     * 删除趣测，题目信息
     * 
     * @param id 趣测，题目主键
     * @return 结果
     */
    @Override
    public int deleteTestQuestionById(Long id)
    {
        return testQuestionMapper.deleteTestQuestionById(id);
    }
}
