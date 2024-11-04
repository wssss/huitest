package com.ruoyi.img.service;

import java.util.List;
import com.ruoyi.img.domain.ImgImg;

/**
 * 图片地址Service接口
 * 
 * @author ruoyi
 * @date 2023-03-03
 */
public interface IImgImgService 
{
    /**
     * 查询图片地址
     * 
     * @param id 图片地址主键
     * @return 图片地址
     */
    public ImgImg selectImgImgById(Long id);

    /**
     * 查询图片地址列表
     * 
     * @param imgImg 图片地址
     * @return 图片地址集合
     */
    public List<ImgImg> selectImgImgList(ImgImg imgImg);

    /**
     * 新增图片地址
     * 
     * @param imgImg 图片地址
     * @return 结果
     */
    public int insertImgImg(ImgImg imgImg);

    /**
     * 修改图片地址
     * 
     * @param imgImg 图片地址
     * @return 结果
     */
    public int updateImgImg(ImgImg imgImg);

    /**
     * 批量删除图片地址
     * 
     * @param ids 需要删除的图片地址主键集合
     * @return 结果
     */
    public int deleteImgImgByIds(Long[] ids);

    /**
     * 删除图片地址信息
     * 
     * @param id 图片地址主键
     * @return 结果
     */
    public int deleteImgImgById(Long id);
}
