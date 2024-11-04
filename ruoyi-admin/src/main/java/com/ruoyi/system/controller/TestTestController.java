package com.ruoyi.system.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.common.annotation.Anonymous;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.system.domain.TestQuestion;
import com.ruoyi.system.domain.TestResult;
import com.ruoyi.system.service.ITestQuestionService;
import com.ruoyi.system.service.ITestResultService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.TestTest;
import com.ruoyi.system.service.ITestTestService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 主题Controller
 * 
 * @author weis
 * @date 2023-02-08
 */
@RestController
@RequestMapping("/system/test")
public class TestTestController extends BaseController
{
    @Autowired
    private ITestTestService testTestService;

    @Autowired
    private ITestQuestionService testQuestionService;

    @Autowired
    private ITestResultService testResultService;
    /**
     * 查询主题列表
     */
    @PreAuthorize("@ss.hasPermi('system:test:list')")
    @GetMapping("/list")
    public TableDataInfo list(TestTest testTest)
    {
        startPage();
        List<TestTest> list = testTestService.selectTestTestList(testTest);
        return getDataTable(list);
    }

    /**
     * 查询主题列表
     */

    @GetMapping("/list/app")
    public TableDataInfo recommendList(TestTest testTest)
    {
        startPage();
        List<TestTest> list = testTestService.selectTestTestList(testTest);
        return getDataTable(list);
    }

    /**
     * 导出主题列表
     */
    @PreAuthorize("@ss.hasPermi('system:test:export')")
    @Log(title = "主题", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TestTest testTest)
    {
        List<TestTest> list = testTestService.selectTestTestList(testTest);
        ExcelUtil<TestTest> util = new ExcelUtil<TestTest>(TestTest.class);
        util.exportExcel(response, list, "主题数据");
    }

    /**
     * 获取主题详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:test:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(testTestService.selectTestTestById(id));
    }

    /**
     * 获取主题详细信息
     */
    @GetMapping(value = "/app/{id}")
    public AjaxResult getAppInfo(@PathVariable("id") Long id)
    {
        return success(testTestService.selectTestTestById(id));
    }


    //    获取主题所有内容
    @GetMapping(value = "/detail/{id}")
    public AjaxResult getTestInfo(@PathVariable("id") Long id)
    {
        AjaxResult ajax = AjaxResult.success();
        //获取测试主题
        TestTest test = testTestService.selectTestTestById(id);
//        获取测试题目
        List<TestQuestion> qas = testQuestionService.questionsByIds(Convert.toLongArray(test.getQues()));
//        获取测试结果
        TestResult result = new TestResult();
        result.setTestId(id.intValue());
        List<TestResult> results = testResultService.selectTestResultList(result);


        ajax.put(AjaxResult.DATA_TAG, test);
        ajax.put("qas", qas);
        ajax.put("results", results);
        return ajax;
    }
    /**
     * 新增主题
     */
    @PreAuthorize("@ss.hasPermi('system:test:add')")
    @Log(title = "主题", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TestTest testTest)
    {
        return toAjax(testTestService.insertTestTest(testTest));
    }

    /**
     * 修改主题
     */
    @PreAuthorize("@ss.hasPermi('system:test:edit')")
    @Log(title = "主题", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TestTest testTest)
    {
        return toAjax(testTestService.updateTestTest(testTest));
    }

    /**
     * 删除主题
     */
    @PreAuthorize("@ss.hasPermi('system:test:remove')")
    @Log(title = "主题", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(testTestService.deleteTestTestByIds(ids));
    }
}
