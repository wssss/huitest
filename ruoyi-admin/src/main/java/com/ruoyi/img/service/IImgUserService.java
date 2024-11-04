package com.ruoyi.img.service;

import java.util.List;
import com.ruoyi.img.domain.ImgUser;

/**
 * 图片Service接口
 * 
 * @author ruoyi
 * @date 2023-03-03
 */
public interface IImgUserService 
{
    /**
     * 查询图片
     * 
     * @param id 图片主键
     * @return 图片
     */
    public ImgUser selectImgUserById(Long id);

    /**
     * 查询图片列表
     * 
     * @param imgUser 图片
     * @return 图片集合
     */
    public List<ImgUser> selectImgUserList(ImgUser imgUser);

    /**
     * 新增图片
     * 
     * @param imgUser 图片
     * @return 结果
     */
    public int insertImgUser(ImgUser imgUser);

    /**
     * 修改图片
     * 
     * @param imgUser 图片
     * @return 结果
     */
    public int updateImgUser(ImgUser imgUser);

    /**
     * 批量删除图片
     * 
     * @param ids 需要删除的图片主键集合
     * @return 结果
     */
    public int deleteImgUserByIds(Long[] ids);

    /**
     * 删除图片信息
     * 
     * @param id 图片主键
     * @return 结果
     */
    public int deleteImgUserById(Long id);
}
