package com.ruoyi.img.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.img.mapper.ImgOrderMapper;
import com.ruoyi.img.domain.ImgOrder;
import com.ruoyi.img.service.IImgOrderService;

/**
 * 会员订单Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-03-03
 */
@Service
public class ImgOrderServiceImpl implements IImgOrderService 
{
    @Autowired
    private ImgOrderMapper imgOrderMapper;

    /**
     * 查询会员订单
     * 
     * @param id 会员订单主键
     * @return 会员订单
     */
    @Override
    public ImgOrder selectImgOrderById(Long id)
    {
        return imgOrderMapper.selectImgOrderById(id);
    }

    /**
     * 查询会员订单列表
     * 
     * @param imgOrder 会员订单
     * @return 会员订单
     */
    @Override
    public List<ImgOrder> selectImgOrderList(ImgOrder imgOrder)
    {
        return imgOrderMapper.selectImgOrderList(imgOrder);
    }

    /**
     * 新增会员订单
     * 
     * @param imgOrder 会员订单
     * @return 结果
     */
    @Override
    public int insertImgOrder(ImgOrder imgOrder)
    {
        imgOrder.setCreateTime(DateUtils.getNowDate());
        return imgOrderMapper.insertImgOrder(imgOrder);
    }

    /**
     * 修改会员订单
     * 
     * @param imgOrder 会员订单
     * @return 结果
     */
    @Override
    public int updateImgOrder(ImgOrder imgOrder)
    {
        return imgOrderMapper.updateImgOrder(imgOrder);
    }

    /**
     * 批量删除会员订单
     * 
     * @param ids 需要删除的会员订单主键
     * @return 结果
     */
    @Override
    public int deleteImgOrderByIds(Long[] ids)
    {
        return imgOrderMapper.deleteImgOrderByIds(ids);
    }

    /**
     * 删除会员订单信息
     * 
     * @param id 会员订单主键
     * @return 结果
     */
    @Override
    public int deleteImgOrderById(Long id)
    {
        return imgOrderMapper.deleteImgOrderById(id);
    }
}
