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
import com.ruoyi.img.domain.ImgOrder;
import com.ruoyi.img.service.IImgOrderService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 会员订单Controller
 * 
 * @author ruoyi
 * @date 2023-03-03
 */
@RestController
@RequestMapping("/img/order")
public class ImgOrderController extends BaseController
{
    @Autowired
    private IImgOrderService imgOrderService;

    /**
     * 查询会员订单列表
     */
    @PreAuthorize("@ss.hasPermi('img:order:list')")
    @GetMapping("/list")
    public TableDataInfo list(ImgOrder imgOrder)
    {
        startPage();
        List<ImgOrder> list = imgOrderService.selectImgOrderList(imgOrder);
        return getDataTable(list);
    }

    /**
     * 导出会员订单列表
     */
    @PreAuthorize("@ss.hasPermi('img:order:export')")
    @Log(title = "会员订单", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ImgOrder imgOrder)
    {
        List<ImgOrder> list = imgOrderService.selectImgOrderList(imgOrder);
        ExcelUtil<ImgOrder> util = new ExcelUtil<ImgOrder>(ImgOrder.class);
        util.exportExcel(response, list, "会员订单数据");
    }

    /**
     * 获取会员订单详细信息
     */
    @PreAuthorize("@ss.hasPermi('img:order:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(imgOrderService.selectImgOrderById(id));
    }

    /**
     * 新增会员订单
     */
    @PreAuthorize("@ss.hasPermi('img:order:add')")
    @Log(title = "会员订单", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ImgOrder imgOrder)
    {
        return toAjax(imgOrderService.insertImgOrder(imgOrder));
    }

    /**
     * 修改会员订单
     */
    @PreAuthorize("@ss.hasPermi('img:order:edit')")
    @Log(title = "会员订单", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ImgOrder imgOrder)
    {
        return toAjax(imgOrderService.updateImgOrder(imgOrder));
    }

    /**
     * 删除会员订单
     */
    @PreAuthorize("@ss.hasPermi('img:order:remove')")
    @Log(title = "会员订单", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(imgOrderService.deleteImgOrderByIds(ids));
    }
}
