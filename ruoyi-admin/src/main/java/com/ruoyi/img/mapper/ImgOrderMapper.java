package com.ruoyi.img.mapper;

import java.util.List;
import com.ruoyi.img.domain.ImgOrder;

/**
 * 会员订单Mapper接口
 * 
 * @author ruoyi
 * @date 2023-03-03
 */
public interface ImgOrderMapper 
{
    /**
     * 查询会员订单
     * 
     * @param id 会员订单主键
     * @return 会员订单
     */
    public ImgOrder selectImgOrderById(Long id);

    /**
     * 查询会员订单列表
     * 
     * @param imgOrder 会员订单
     * @return 会员订单集合
     */
    public List<ImgOrder> selectImgOrderList(ImgOrder imgOrder);

    /**
     * 新增会员订单
     * 
     * @param imgOrder 会员订单
     * @return 结果
     */
    public int insertImgOrder(ImgOrder imgOrder);

    /**
     * 修改会员订单
     * 
     * @param imgOrder 会员订单
     * @return 结果
     */
    public int updateImgOrder(ImgOrder imgOrder);

    /**
     * 删除会员订单
     * 
     * @param id 会员订单主键
     * @return 结果
     */
    public int deleteImgOrderById(Long id);

    /**
     * 批量删除会员订单
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteImgOrderByIds(Long[] ids);
}
