package com.ruoyi.img.controller;

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
import com.ruoyi.img.domain.ImgCate;
import com.ruoyi.img.service.IImgCateService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 图片主题Controller
 * 
 * @author ruoyi
 * @date 2023-03-03
 */
@RestController
@RequestMapping("/img/cate")
public class ImgCateController extends BaseController
{
    @Autowired
    private IImgCateService imgCateService;

    /**
     * 查询图片主题列表
     */
    @PreAuthorize("@ss.hasPermi('img:cate:list')")
    @GetMapping("/list")
    public TableDataInfo list(ImgCate imgCate)
    {
        startPage();
        List<ImgCate> list = imgCateService.selectImgCateList(imgCate);
        return getDataTable(list);
    }

    /**
     * 导出图片主题列表
     */
    @PreAuthorize("@ss.hasPermi('img:cate:export')")
    @Log(title = "图片主题", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ImgCate imgCate)
    {
        List<ImgCate> list = imgCateService.selectImgCateList(imgCate);
        ExcelUtil<ImgCate> util = new ExcelUtil<ImgCate>(ImgCate.class);
        util.exportExcel(response, list, "图片主题数据");
    }

    /**
     * 获取图片主题详细信息
     */
    @PreAuthorize("@ss.hasPermi('img:cate:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(imgCateService.selectImgCateById(id));
    }

    /**
     * 新增图片主题
     */
    @PreAuthorize("@ss.hasPermi('img:cate:add')")
    @Log(title = "图片主题", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ImgCate imgCate)
    {
        return toAjax(imgCateService.insertImgCate(imgCate));
    }

    /**
     * 修改图片主题
     */
    @PreAuthorize("@ss.hasPermi('img:cate:edit')")
    @Log(title = "图片主题", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ImgCate imgCate)
    {
        return toAjax(imgCateService.updateImgCate(imgCate));
    }

    /**
     * 删除图片主题
     */
    @PreAuthorize("@ss.hasPermi('img:cate:remove')")
    @Log(title = "图片主题", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(imgCateService.deleteImgCateByIds(ids));
    }
}
