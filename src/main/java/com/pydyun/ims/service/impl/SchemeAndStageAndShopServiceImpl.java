package com.pydyun.ims.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pydyun.ims.dao.SchemeAndStageAndShopDao;
import com.pydyun.ims.model.SchemeAndStageAndShop;
import com.pydyun.ims.service.SchemeAndStageAndShopService;

import java.util.List;

@Service
public class SchemeAndStageAndShopServiceImpl implements SchemeAndStageAndShopService
{

    @Resource
    private SchemeAndStageAndShopDao SchemeAndStageAndShopDao;

    @Override
    @Transactional
    public Integer addSchemeAndStageAndShop(SchemeAndStageAndShop stageAndShop) {
        // TODO Auto-generated method stub
        return SchemeAndStageAndShopDao.addSchemeAndStageAndShop(stageAndShop);
    }

    @Override
    @Transactional
    public Integer updateSchemeAndStageAndShop(SchemeAndStageAndShop stageAndShop) {
        // TODO Auto-generated method stub
        return SchemeAndStageAndShopDao.updateSchemeAndStageAndShop(stageAndShop);
    }

    @Override
    public Integer deleteSchemeAndStageAndShop(Integer ssid) {
        // TODO Auto-generated method stub
        return SchemeAndStageAndShopDao.deleteSchemeAndStageAndShop(ssid);
    }

    @Override
    public List<SchemeAndStageAndShop> foundProductBySsid(List<Integer> ssids) {

        return SchemeAndStageAndShopDao.foundProductBySsid(ssids);
    }

}
