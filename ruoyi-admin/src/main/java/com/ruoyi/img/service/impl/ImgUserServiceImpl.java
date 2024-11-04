package com.ruoyi.img.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.img.mapper.ImgUserMapper;
import com.ruoyi.img.domain.ImgUser;
import com.ruoyi.img.service.IImgUserService;

/**
 * 图片Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-03-03
 */
@Service
public class ImgUserServiceImpl implements IImgUserService 
{
    @Autowired
    private ImgUserMapper imgUserMapper;

    /**
     * 查询图片
     * 
     * @param id 图片主键
     * @return 图片
     */
    @Override
    public ImgUser selectImgUserById(Long id)
    {
        return imgUserMapper.selectImgUserById(id);
    }

    /**
     * 查询图片列表
     * 
     * @param imgUser 图片
     * @return 图片
     */
    @Override
    public List<ImgUser> selectImgUserList(ImgUser imgUser)
    {
        return imgUserMapper.selectImgUserList(imgUser);
    }

    /**
     * 新增图片
     * 
     * @param imgUser 图片
     * @return 结果
     */
    @Override
    public int insertImgUser(ImgUser imgUser)
    {
        imgUser.setCreateTime(DateUtils.getNowDate());
        return imgUserMapper.insertImgUser(imgUser);
    }

    /**
     * 修改图片
     * 
     * @param imgUser 图片
     * @return 结果
     */
    @Override
    public int updateImgUser(ImgUser imgUser)
    {
        imgUser.setUpdateTime(DateUtils.getNowDate());
        return imgUserMapper.updateImgUser(imgUser);
    }

    /**
     * 批量删除图片
     * 
     * @param ids 需要删除的图片主键
     * @return 结果
     */
    @Override
    public int deleteImgUserByIds(Long[] ids)
    {
        return imgUserMapper.deleteImgUserByIds(ids);
    }

    /**
     * 删除图片信息
     * 
     * @param id 图片主键
     * @return 结果
     */
    @Override
    public int deleteImgUserById(Long id)
    {
        return imgUserMapper.deleteImgUserById(id);
    }
}
