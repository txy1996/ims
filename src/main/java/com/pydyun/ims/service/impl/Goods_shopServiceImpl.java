package com.pydyun.ims.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pydyun.ims.dao.Goods_shopDao;
import com.pydyun.ims.model.Goods_shop;
import com.pydyun.ims.model.PointsGoldCoinsRequest;
import com.pydyun.ims.service.Goods_shopService;

@Service
public class Goods_shopServiceImpl implements Goods_shopService
{

    @Resource
    private Goods_shopDao Goods_shopDao;

    @Override
    public PageInfo<Goods_shop> shopmoney(Integer pageNum, Integer pageSize, PointsGoldCoinsRequest request)
    {
        PageHelper.startPage(pageNum, pageSize);
        List<Goods_shop> list = Goods_shopDao.select(request);
        return new PageInfo<>(list);
    }

    @Override
    public void delete(Integer gid)
    {
        Goods_shopDao.delete(gid);
    }

    @Override
    public Integer addshop(Goods_shop goods_shop)
    {
        Goods_shopDao.addshop(goods_shop);
        return goods_shop.getGid();
    }

    @Override
    public List<String> shop()
    {
        return Goods_shopDao.shop();
    }

    @Override
    public Integer seleteNum(Integer sid)
    {
        // TODO Auto-generated method stub
        return Goods_shopDao.seleteNum(sid);
    }

}
