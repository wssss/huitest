package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.TestTest;

/**
 * 主题Mapper接口
 * 
 * @author weis
 * @date 2023-02-08
 */
public interface TestTestMapper 
{
    /**
     * 查询主题
     * 
     * @param id 主题主键
     * @return 主题
     */
    public TestTest selectTestTestById(Long id);

    /**
     * 查询主题列表
     * 
     * @param testTest 主题
     * @return 主题集合
     */
    public List<TestTest> selectTestTestList(TestTest testTest);

    /**
     * 新增主题
     * 
     * @param testTest 主题
     * @return 结果
     */
    public int insertTestTest(TestTest testTest);

    /**
     * 修改主题
     * 
     * @param testTest 主题
     * @return 结果
     */
    public int updateTestTest(TestTest testTest);

    /**
     * 删除主题
     * 
     * @param id 主题主键
     * @return 结果
     */
    public int deleteTestTestById(Long id);

    /**
     * 批量删除主题
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTestTestByIds(Long[] ids);
}
