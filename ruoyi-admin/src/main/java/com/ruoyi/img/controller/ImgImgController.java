package com.ruoyi.img.controller;


import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.common.utils.SecurityUtils;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.img.domain.ImgImg;
import com.ruoyi.img.service.IImgImgService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;




/**
 * 图片地址Controller
 * 
 * @author ruoyi
 * @date 2023-03-03
 */
@RestController
@RequestMapping("/img/img")
public class ImgImgController extends BaseController
{
    @Autowired
    private IImgImgService imgImgService;



    /**
     * 查询图片地址列表
     */
    @PreAuthorize("@ss.hasPermi('img:img:list')")
    @GetMapping("/list")
    public TableDataInfo list(ImgImg imgImg)
    {
        startPage();
        List<ImgImg> list = imgImgService.selectImgImgList(imgImg);
        return getDataTable(list);
    }

    @GetMapping("/app/list")
    public TableDataInfo Applist(ImgImg imgImg)
    {
        startPage();
        List<ImgImg> list = imgImgService.selectImgImgList(imgImg);
        return getDataTable(list);
    }


    /**
     * 导出图片地址列表
     */
    @PreAuthorize("@ss.hasPermi('img:img:export')")
    @Log(title = "图片地址", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ImgImg imgImg)
    {
        List<ImgImg> list = imgImgService.selectImgImgList(imgImg);
        ExcelUtil<ImgImg> util = new ExcelUtil<ImgImg>(ImgImg.class);
        util.exportExcel(response, list, "图片地址数据");
    }

    /**
     * 获取图片地址详细信息
     */
    @PreAuthorize("@ss.hasPermi('img:img:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(imgImgService.selectImgImgById(id));
    }

    /**
     * 新增图片地址
     */
    @PreAuthorize("@ss.hasPermi('img:img:add')")
    @Log(title = "图片地址", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ImgImg imgImg)
    {
        Long userId = SecurityUtils.getUserId();

        imgImg.setUserId(userId);
        return toAjax(imgImgService.insertImgImg(imgImg));
    }

    /**
     * 修改图片地址
     */
    @PreAuthorize("@ss.hasPermi('img:img:edit')")
    @Log(title = "图片地址", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ImgImg imgImg)
    {
        return toAjax(imgImgService.updateImgImg(imgImg));
    }

    /**
     * 删除图片地址
     */
    @PreAuthorize("@ss.hasPermi('img:img:remove')")
    @Log(title = "图片地址", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(imgImgService.deleteImgImgByIds(ids));
    }
}
