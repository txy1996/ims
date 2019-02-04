package com.pydyun.ims.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pydyun.ims.dao.PromotionDao;
import com.pydyun.ims.model.Promotion;
import com.pydyun.ims.service.PromotionService;

@Service
public class PromotionServiceImpl implements PromotionService
{
    @Resource
    private PromotionDao pdao;

    @Override
    public Integer add(Promotion promotion) {
        pdao.add(promotion);
        return promotion.getId();
    }

    @Override
    public PageInfo<Promotion> selectlist(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Promotion> list = pdao.select();
        return new PageInfo<>(list);
    }


    @Override
    public List<Promotion> modify() {
        return pdao.modify();
    }

    @Override
    public void updateshop(Promotion promotion) {
        pdao.update(promotion);
    }

    @Override
    public Promotion getPromotion(Integer id) {
        return pdao.getPromotion(id);
    }

    @Override
    public List<Promotion> edit(Integer id) {
        List<Promotion> list = pdao.edit(id);
        return list;
    }

    @Override
    public PageInfo<Promotion> polling(Integer pageNum, Integer pageSize, String stadate, String enddate, Integer ptype, String bt) {
        PageHelper.startPage(pageNum, pageSize);
        List<Promotion> list = pdao.polling(stadate, enddate, ptype, bt);
        return new PageInfo<>(list);
    }

    @Override
    public void updatepro(Promotion pt) {
        pdao.updatepro(pt);
    }

    @Override
    public void delete(Promotion promotion) {
        pdao.delete(promotion);
    }


    @Override
    public List<Promotion> findShopRecommend(Integer ptype) {
        // TODO Auto-generated method stub
        return pdao.findShopRecommend(ptype);
    }

    @Override
    public Promotion edit1(Integer id) {
        // TODO Auto-generated method stub
        return pdao.edit1(id);
    }


    @Override
    public List<Promotion> Recommend(Integer id) {
        return pdao.Recommend(id);
    }

    @Override
    public void upRecommend(Promotion pr) {
        pdao.upRecommend(pr);
    }

    @Override
    public List<Promotion> inquire(Integer id) {
        return pdao.inquire(id);
    }


    /*根据分类查询有效广告位*/
    @Override
    public List<Promotion> findPromotionByPtype(Integer ptype) {
        return pdao.findPromotionByPtype(ptype);
    }


    @Override
    public List<Promotion> findpromlist(String psource) {
        // TODO Auto-generated method stub
        return pdao.findpromlist(psource);
    }

}
