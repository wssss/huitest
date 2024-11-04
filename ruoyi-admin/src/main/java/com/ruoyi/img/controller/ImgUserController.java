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
import com.ruoyi.img.domain.ImgUser;
import com.ruoyi.img.service.IImgUserService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 图片Controller
 * 
 * @author ruoyi
 * @date 2023-03-03
 */
@RestController
@RequestMapping("/img/user")
public class ImgUserController extends BaseController
{
    @Autowired
    private IImgUserService imgUserService;

    /**
     * 查询图片列表
     */
    @PreAuthorize("@ss.hasPermi('img:user:list')")
    @GetMapping("/list")
    public TableDataInfo list(ImgUser imgUser)
    {
        startPage();
        List<ImgUser> list = imgUserService.selectImgUserList(imgUser);
        return getDataTable(list);
    }

    /**
     * 导出图片列表
     */
    @PreAuthorize("@ss.hasPermi('img:user:export')")
    @Log(title = "图片", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ImgUser imgUser)
    {
        List<ImgUser> list = imgUserService.selectImgUserList(imgUser);
        ExcelUtil<ImgUser> util = new ExcelUtil<ImgUser>(ImgUser.class);
        util.exportExcel(response, list, "图片数据");
    }

    /**
     * 获取图片详细信息
     */
    @PreAuthorize("@ss.hasPermi('img:user:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(imgUserService.selectImgUserById(id));
    }

    /**
     * 新增图片
     */
    @PreAuthorize("@ss.hasPermi('img:user:add')")
    @Log(title = "图片", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ImgUser imgUser)
    {
        return toAjax(imgUserService.insertImgUser(imgUser));
    }

    /**
     * 修改图片
     */
    @PreAuthorize("@ss.hasPermi('img:user:edit')")
    @Log(title = "图片", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ImgUser imgUser)
    {
        return toAjax(imgUserService.updateImgUser(imgUser));
    }

    /**
     * 删除图片
     */
    @PreAuthorize("@ss.hasPermi('img:user:remove')")
    @Log(title = "图片", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(imgUserService.deleteImgUserByIds(ids));
    }
}
