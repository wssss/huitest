package com.ruoyi.system.service.impl;

import java.util.List;

import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TestResultMapper;
import com.ruoyi.system.domain.TestResult;
import com.ruoyi.system.service.ITestResultService;

/**
 * 测试结果Service业务层处理
 * 
 * @author weis
 * @date 2023-01-31
 */
@Service
public class TestResultServiceImpl implements ITestResultService 
{
    @Autowired
    private TestResultMapper testResultMapper;

    /**
     * 查询测试结果
     * 
     * @param id 测试结果主键
     * @return 测试结果
     */
    @Override
    public TestResult selectTestResultById(Integer id)
    {
        return testResultMapper.selectTestResultById(id);
    }

    /**
     * 查询测试结果列表
     * 
     * @param testResult 测试结果
     * @return 测试结果
     */
    @Override
    public List<TestResult> selectTestResultList(TestResult testResult)
    {
        return testResultMapper.selectTestResultList(testResult);
    }

    /**
     * 新增测试结果
     * 
     * @param testResult 测试结果
     * @return 结果
     */
    @Override
    public int insertTestResult(TestResult testResult)
    {
        testResult.setCreateTime(DateUtils.getNowDate());

        return testResultMapper.insertTestResult(testResult);
    }

    /**
     * 修改测试结果
     * 
     * @param testResult 测试结果
     * @return 结果
     */
    @Override
    public int updateTestResult(TestResult testResult)
    {
        testResult.setUpdateTime(DateUtils.getNowDate());
        return testResultMapper.updateTestResult(testResult);
    }

    /**
     * 批量删除测试结果
     * 
     * @param ids 需要删除的测试结果主键
     * @return 结果
     */
    @Override
    public int deleteTestResultByIds(Integer[] ids)
    {
        return testResultMapper.deleteTestResultByIds(ids);
    }

    /**
     * 删除测试结果信息
     * 
     * @param id 测试结果主键
     * @return 结果
     */
    @Override
    public int deleteTestResultById(Integer id)
    {
        return testResultMapper.deleteTestResultById(id);
    }
}
