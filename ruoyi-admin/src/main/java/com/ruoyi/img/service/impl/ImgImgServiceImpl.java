package com.ruoyi.img.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.img.mapper.ImgImgMapper;
import com.ruoyi.img.domain.ImgImg;
import com.ruoyi.img.service.IImgImgService;

/**
 * 图片地址Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-03-03
 */
@Service
public class ImgImgServiceImpl implements IImgImgService 
{
    @Autowired
    private ImgImgMapper imgImgMapper;

    /**
     * 查询图片地址
     * 
     * @param id 图片地址主键
     * @return 图片地址
     */
    @Override
    public ImgImg selectImgImgById(Long id)
    {
        return imgImgMapper.selectImgImgById(id);
    }

    /**
     * 查询图片地址列表
     * 
     * @param imgImg 图片地址
     * @return 图片地址
     */
    @Override
    public List<ImgImg> selectImgImgList(ImgImg imgImg)
    {
        return imgImgMapper.selectImgImgList(imgImg);
    }

    /**
     * 新增图片地址
     * 
     * @param imgImg 图片地址
     * @return 结果
     */
    @Override
    public int insertImgImg(ImgImg imgImg)
    {
        imgImg.setCreateTime(DateUtils.getNowDate());
        return imgImgMapper.insertImgImg(imgImg);
    }

    /**
     * 修改图片地址
     * 
     * @param imgImg 图片地址
     * @return 结果
     */
    @Override
    public int updateImgImg(ImgImg imgImg)
    {
        return imgImgMapper.updateImgImg(imgImg);
    }

    /**
     * 批量删除图片地址
     * 
     * @param ids 需要删除的图片地址主键
     * @return 结果
     */
    @Override
    public int deleteImgImgByIds(Long[] ids)
    {
        return imgImgMapper.deleteImgImgByIds(ids);
    }

    /**
     * 删除图片地址信息
     * 
     * @param id 图片地址主键
     * @return 结果
     */
    @Override
    public int deleteImgImgById(Long id)
    {
        return imgImgMapper.deleteImgImgById(id);
    }
}
