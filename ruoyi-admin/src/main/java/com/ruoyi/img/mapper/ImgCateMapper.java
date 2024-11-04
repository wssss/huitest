package com.ruoyi.img.mapper;

import java.util.List;
import com.ruoyi.img.domain.ImgCate;

/**
 * 图片主题Mapper接口
 * 
 * @author ruoyi
 * @date 2023-03-03
 */
public interface ImgCateMapper 
{
    /**
     * 查询图片主题
     * 
     * @param id 图片主题主键
     * @return 图片主题
     */
    public ImgCate selectImgCateById(Long id);

    /**
     * 查询图片主题列表
     * 
     * @param imgCate 图片主题
     * @return 图片主题集合
     */
    public List<ImgCate> selectImgCateList(ImgCate imgCate);

    /**
     * 新增图片主题
     * 
     * @param imgCate 图片主题
     * @return 结果
     */
    public int insertImgCate(ImgCate imgCate);

    /**
     * 修改图片主题
     * 
     * @param imgCate 图片主题
     * @return 结果
     */
    public int updateImgCate(ImgCate imgCate);

    /**
     * 删除图片主题
     * 
     * @param id 图片主题主键
     * @return 结果
     */
    public int deleteImgCateById(Long id);

    /**
     * 批量删除图片主题
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteImgCateByIds(Long[] ids);
}
