package com.ruoyi.system.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.TestQuestion;
import com.ruoyi.system.service.ITestQuestionService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 趣测，题目Controller
 * 
 * @author weis
 * @date 2023-01-31
 */
@RestController
@RequestMapping("/system/question")
public class TestQuestionController extends BaseController
{
    @Autowired
    private ITestQuestionService testQuestionService;

    /**
     * 查询趣测，题目列表
     */
    @PreAuthorize("@ss.hasPermi('system:question:list')")
    @GetMapping("/list")
    public TableDataInfo list(TestQuestion testQuestion)
    {
        startPage();
        List<TestQuestion> list = testQuestionService.selectTestQuestionList(testQuestion);
        return getDataTable(list);
    }

//    根据ids获取测试列表
    @PreAuthorize("@ss.hasPermi('system:question:list')")
    @GetMapping("/list/{ids}")
    public AjaxResult quesList(@PathVariable Long[] ids)
    {
        List<TestQuestion> list = testQuestionService.questionsByIds(ids);
        return AjaxResult.success(list);
    }

    /**
     * 导出趣测，题目列表
     */
    @PreAuthorize("@ss.hasPermi('system:question:export')")
    @Log(title = "趣测，题目", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TestQuestion testQuestion)
    {
        List<TestQuestion> list = testQuestionService.selectTestQuestionList(testQuestion);
        ExcelUtil<TestQuestion> util = new ExcelUtil<TestQuestion>(TestQuestion.class);
        util.exportExcel(response, list, "趣测，题目数据");
    }

    /**
     * 获取趣测，题目详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:question:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(testQuestionService.selectTestQuestionById(id));
    }

    /**
     * 新增趣测，题目
     */
    @PreAuthorize("@ss.hasPermi('system:question:add')")
    @Log(title = "趣测，题目", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TestQuestion testQuestion)
    {
        return toAjax(testQuestionService.insertTestQuestion(testQuestion));
    }

    /**
     * 修改趣测，题目
     */
    @PreAuthorize("@ss.hasPermi('system:question:edit')")
    @Log(title = "趣测，题目", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TestQuestion testQuestion)
    {
        return toAjax(testQuestionService.updateTestQuestion(testQuestion));
    }

    /**
     * 删除趣测，题目
     */
    @PreAuthorize("@ss.hasPermi('system:question:remove')")
    @Log(title = "趣测，题目", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(testQuestionService.deleteTestQuestionByIds(ids));
    }
}
