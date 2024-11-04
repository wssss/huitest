package com.ruoyi.img.mapper;

import java.util.List;
import com.ruoyi.img.domain.ImgCard;

/**
 * 会员卡Mapper接口
 * 
 * @author ruoyi
 * @date 2023-03-03
 */
public interface ImgCardMapper 
{
    /**
     * 查询会员卡
     * 
     * @param id 会员卡主键
     * @return 会员卡
     */
    public ImgCard selectImgCardById(Long id);

    /**
     * 查询会员卡列表
     * 
     * @param imgCard 会员卡
     * @return 会员卡集合
     */
    public List<ImgCard> selectImgCardList(ImgCard imgCard);

    /**
     * 新增会员卡
     * 
     * @param imgCard 会员卡
     * @return 结果
     */
    public int insertImgCard(ImgCard imgCard);

    /**
     * 修改会员卡
     * 
     * @param imgCard 会员卡
     * @return 结果
     */
    public int updateImgCard(ImgCard imgCard);

    /**
     * 删除会员卡
     * 
     * @param id 会员卡主键
     * @return 结果
     */
    public int deleteImgCardById(Long id);

    /**
     * 批量删除会员卡
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteImgCardByIds(Long[] ids);
}
