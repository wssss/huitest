package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TestTestMapper;
import com.ruoyi.system.domain.TestTest;
import com.ruoyi.system.service.ITestTestService;

/**
 * 主题Service业务层处理
 * 
 * @author weis
 * @date 2023-02-08
 */
@Service
public class TestTestServiceImpl implements ITestTestService 
{
    @Autowired
    private TestTestMapper testTestMapper;

    /**
     * 查询主题
     * 
     * @param id 主题主键
     * @return 主题
     */
    @Override
    public TestTest selectTestTestById(Long id)
    {
        return testTestMapper.selectTestTestById(id);
    }

    /**
     * 查询主题列表
     * 
     * @param testTest 主题
     * @return 主题
     */
    @Override
    public List<TestTest> selectTestTestList(TestTest testTest)
    {
        return testTestMapper.selectTestTestList(testTest);
    }

    /**
     * 新增主题
     * 
     * @param testTest 主题
     * @return 结果
     */
    @Override
    public int insertTestTest(TestTest testTest)
    {
        testTest.setCreateTime(DateUtils.getNowDate());
        testTest.setUpdateTime(DateUtils.getNowDate());
        return testTestMapper.insertTestTest(testTest);
    }

    /**
     * 修改主题
     * 
     * @param testTest 主题
     * @return 结果
     */
    @Override
    public int updateTestTest(TestTest testTest)
    {
        testTest.setUpdateTime(DateUtils.getNowDate());
        return testTestMapper.updateTestTest(testTest);
    }

    /**
     * 批量删除主题
     * 
     * @param ids 需要删除的主题主键
     * @return 结果
     */
    @Override
    public int deleteTestTestByIds(Long[] ids)
    {
        return testTestMapper.deleteTestTestByIds(ids);
    }

    /**
     * 删除主题信息
     * 
     * @param id 主题主键
     * @return 结果
     */
    @Override
    public int deleteTestTestById(Long id)
    {
        return testTestMapper.deleteTestTestById(id);
    }
}
