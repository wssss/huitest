package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.TestResult;

/**
 * 测试结果Service接口
 * 
 * @author weis
 * @date 2023-01-31
 */
public interface ITestResultService 
{
    /**
     * 查询测试结果
     * 
     * @param id 测试结果主键
     * @return 测试结果
     */
    public TestResult selectTestResultById(Integer id);

    /**
     * 查询测试结果列表
     * 
     * @param testResult 测试结果
     * @return 测试结果集合
     */
    public List<TestResult> selectTestResultList(TestResult testResult);

    /**
     * 新增测试结果
     * 
     * @param testResult 测试结果
     * @return 结果
     */
    public int insertTestResult(TestResult testResult);

    /**
     * 修改测试结果
     * 
     * @param testResult 测试结果
     * @return 结果
     */
    public int updateTestResult(TestResult testResult);

    /**
     * 批量删除测试结果
     * 
     * @param ids 需要删除的测试结果主键集合
     * @return 结果
     */
    public int deleteTestResultByIds(Integer[] ids);

    /**
     * 删除测试结果信息
     * 
     * @param id 测试结果主键
     * @return 结果
     */
    public int deleteTestResultById(Integer id);
}