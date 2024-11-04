package com.ruoyi.img.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.img.mapper.ImgCardMapper;
import com.ruoyi.img.domain.ImgCard;
import com.ruoyi.img.service.IImgCardService;

/**
 * 会员卡Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-03-03
 */
@Service
public class ImgCardServiceImpl implements IImgCardService 
{
    @Autowired
    private ImgCardMapper imgCardMapper;

    /**
     * 查询会员卡
     * 
     * @param id 会员卡主键
     * @return 会员卡
     */
    @Override
    public ImgCard selectImgCardById(Long id)
    {
        return imgCardMapper.selectImgCardById(id);
    }

    /**
     * 查询会员卡列表
     * 
     * @param imgCard 会员卡
     * @return 会员卡
     */
    @Override
    public List<ImgCard> selectImgCardList(ImgCard imgCard)
    {
        return imgCardMapper.selectImgCardList(imgCard);
    }

    /**
     * 新增会员卡
     * 
     * @param imgCard 会员卡
     * @return 结果
     */
    @Override
    public int insertImgCard(ImgCard imgCard)
    {
        imgCard.setCreateTime(DateUtils.getNowDate());
        return imgCardMapper.insertImgCard(imgCard);
    }

    /**
     * 修改会员卡
     * 
     * @param imgCard 会员卡
     * @return 结果
     */
    @Override
    public int updateImgCard(ImgCard imgCard)
    {
        return imgCardMapper.updateImgCard(imgCard);
    }

    /**
     * 批量删除会员卡
     * 
     * @param ids 需要删除的会员卡主键
     * @return 结果
     */
    @Override
    public int deleteImgCardByIds(Long[] ids)
    {
        return imgCardMapper.deleteImgCardByIds(ids);
    }

    /**
     * 删除会员卡信息
     * 
     * @param id 会员卡主键
     * @return 结果
     */
    @Override
    public int deleteImgCardById(Long id)
    {
        return imgCardMapper.deleteImgCardById(id);
    }
}
