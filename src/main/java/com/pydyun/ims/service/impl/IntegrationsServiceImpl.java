package com.pydyun.ims.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pydyun.ims.dao.IntegrationsDao;
import com.pydyun.ims.model.Integrations;
import com.pydyun.ims.model.PointsGoldCoinsRequest;
import com.pydyun.ims.service.IntegrationsService;

@Service
public class IntegrationsServiceImpl implements IntegrationsService
{

    @Resource
    private IntegrationsDao IntegrationsDao;

    @Override
    public PageInfo<Integrations> selectintegrations(Integer pageNum, Integer pageSize, PointsGoldCoinsRequest request)
    {
        PageHelper.startPage(pageNum, pageSize);
        List<Integrations> list = IntegrationsDao.selectintegrations(request);
        return new PageInfo<>(list);
    }

    @Override
    public void delete(Integer iid)
    {
        IntegrationsDao.delete(iid);
    }

    @Override
    public void addIntegrations(Integrations integrations)
    {
        IntegrationsDao.addIntegrations(integrations);

    }

    @Override
    public Integer seleteNum(Integer urid)
    {

        return IntegrationsDao.seleteNum(urid);
    }

    @Override
    public void add(Integrations integrations)
    {
        IntegrationsDao.add(integrations);

    }

    @Override
    public Integer seleteNumA(Integer urid)
    {
        // TODO Auto-generated method stub
        return IntegrationsDao.seleteNumA(urid);
    }

}
