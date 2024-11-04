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
import com.ruoyi.img.domain.ImgCard;
import com.ruoyi.img.service.IImgCardService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 会员卡Controller
 * 
 * @author ruoyi
 * @date 2023-03-03
 */
@RestController
@RequestMapping("/img/card")
public class ImgCardController extends BaseController
{
    @Autowired
    private IImgCardService imgCardService;

    /**
     * 查询会员卡列表
     */
    @PreAuthorize("@ss.hasPermi('img:card:list')")
    @GetMapping("/list")
    public TableDataInfo list(ImgCard imgCard)
    {
        startPage();
        List<ImgCard> list = imgCardService.selectImgCardList(imgCard);
        return getDataTable(list);
    }

    /**
     * 导出会员卡列表
     */
    @PreAuthorize("@ss.hasPermi('img:card:export')")
    @Log(title = "会员卡", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ImgCard imgCard)
    {
        List<ImgCard> list = imgCardService.selectImgCardList(imgCard);
        ExcelUtil<ImgCard> util = new ExcelUtil<ImgCard>(ImgCard.class);
        util.exportExcel(response, list, "会员卡数据");
    }

    /**
     * 获取会员卡详细信息
     */
    @PreAuthorize("@ss.hasPermi('img:card:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(imgCardService.selectImgCardById(id));
    }

    /**
     * 新增会员卡
     */
    @PreAuthorize("@ss.hasPermi('img:card:add')")
    @Log(title = "会员卡", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ImgCard imgCard)
    {
        return toAjax(imgCardService.insertImgCard(imgCard));
    }

    /**
     * 修改会员卡
     */
    @PreAuthorize("@ss.hasPermi('img:card:edit')")
    @Log(title = "会员卡", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ImgCard imgCard)
    {
        return toAjax(imgCardService.updateImgCard(imgCard));
    }

    /**
     * 删除会员卡
     */
    @PreAuthorize("@ss.hasPermi('img:card:remove')")
    @Log(title = "会员卡", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(imgCardService.deleteImgCardByIds(ids));
    }
}
