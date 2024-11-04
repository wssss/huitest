package com.ruoyi.img.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.img.mapper.ImgCateMapper;
import com.ruoyi.img.domain.ImgCate;
import com.ruoyi.img.service.IImgCateService;

/**
 * 图片主题Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-03-03
 */
@Service
public class ImgCateServiceImpl implements IImgCateService 
{
    @Autowired
    private ImgCateMapper imgCateMapper;

    /**
     * 查询图片主题
     * 
     * @param id 图片主题主键
     * @return 图片主题
     */
    @Override
    public ImgCate selectImgCateById(Long id)
    {
        return imgCateMapper.selectImgCateById(id);
    }

    /**
     * 查询图片主题列表
     * 
     * @param imgCate 图片主题
     * @return 图片主题
     */
    @Override
    public List<ImgCate> selectImgCateList(ImgCate imgCate)
    {
        return imgCateMapper.selectImgCateList(imgCate);
    }

    /**
     * 新增图片主题
     * 
     * @param imgCate 图片主题
     * @return 结果
     */
    @Override
    public int insertImgCate(ImgCate imgCate)
    {
        return imgCateMapper.insertImgCate(imgCate);
    }

    /**
     * 修改图片主题
     * 
     * @param imgCate 图片主题
     * @return 结果
     */
    @Override
    public int updateImgCate(ImgCate imgCate)
    {
        return imgCateMapper.updateImgCate(imgCate);
    }

    /**
     * 批量删除图片主题
     * 
     * @param ids 需要删除的图片主题主键
     * @return 结果
     */
    @Override
    public int deleteImgCateByIds(Long[] ids)
    {
        return imgCateMapper.deleteImgCateByIds(ids);
    }

    /**
     * 删除图片主题信息
     * 
     * @param id 图片主题主键
     * @return 结果
     */
    @Override
    public int deleteImgCateById(Long id)
    {
        return imgCateMapper.deleteImgCateById(id);
    }
}
