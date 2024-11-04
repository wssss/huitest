package com.ruoyi.system.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
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
import com.ruoyi.system.domain.TestResult;
import com.ruoyi.system.service.ITestResultService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 测试结果Controller
 * 
 * @author weis
 * @date 2023-01-31
 */
@RestController
@RequestMapping("/system/result")
public class TestResultController extends BaseController
{
    @Autowired
    private ITestResultService testResultService;

    /**
     * 查询测试结果列表
     */
    @PreAuthorize("@ss.hasPermi('system:result:list')")
    @GetMapping("/list")
    public TableDataInfo list(TestResult testResult)
    {
        startPage();
        List<TestResult> list = testResultService.selectTestResultList(testResult);
        return getDataTable(list);
    }

    /**
     * 导出测试结果列表
     */
    @PreAuthorize("@ss.hasPermi('system:result:export')")
    @Log(title = "测试结果", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TestResult testResult)
    {
        List<TestResult> list = testResultService.selectTestResultList(testResult);
        ExcelUtil<TestResult> util = new ExcelUtil<TestResult>(TestResult.class);
        util.exportExcel(response, list, "测试结果数据");
    }

    /**
     * 获取测试结果详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:result:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Integer id)
    {
        return success(testResultService.selectTestResultById(id));
    }

    /**
     * 新增测试结果
     */
    @PreAuthorize("@ss.hasPermi('system:result:add')")
    @Log(title = "测试结果", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TestResult testResult)
    {
        return toAjax(testResultService.insertTestResult(testResult));
    }

    /**
     * 修改测试结果
     */
    @PreAuthorize("@ss.hasPermi('system:result:edit')")
    @Log(title = "测试结果", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TestResult testResult)
    {
        return toAjax(testResultService.updateTestResult(testResult));
    }

    /**
     * 删除测试结果
     */
    @PreAuthorize("@ss.hasPermi('system:result:remove')")
    @Log(title = "测试结果", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Integer[] ids)
    {
        return toAjax(testResultService.deleteTestResultByIds(ids));
    }
}
