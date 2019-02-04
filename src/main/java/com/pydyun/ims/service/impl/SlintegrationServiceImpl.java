package com.pydyun.ims.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pydyun.ims.dao.SlintegrationDao;
import com.pydyun.ims.model.PointsGoldCoinsRequest;
import com.pydyun.ims.model.Slintegration;
import com.pydyun.ims.service.SlintegrationService;

@Service
public class SlintegrationServiceImpl implements SlintegrationService
{

    @Resource
    private SlintegrationDao SlintegrationDao;

    @Override
    public PageInfo<Slintegration> selectSlintegration(Integer pageNum, Integer pageSize,
            PointsGoldCoinsRequest request)
    {
        PageHelper.startPage(pageNum, pageSize);
        List<Slintegration> list = SlintegrationDao.selectSlintegration(request);
        return new PageInfo<>(list);
    }

    @Override
    public void delete(Integer slid)
    {
        SlintegrationDao.delete(slid);
    }

    @Override
    public void addSlintegration(Slintegration slintegration)
    {

        SlintegrationDao.addSlintegration(slintegration);

    }

    @Override
    public Integer seleteNum(Integer sid)
    {

        return SlintegrationDao.seleteNum(sid);
    }

    @Override
    public void addshop(Slintegration slintegration)
    {
        SlintegrationDao.addshop(slintegration);

    }

    @Override
    public Integer seleteNumA(Integer sid)
    {
        // TODO Auto-generated method stub
        return SlintegrationDao.seleteNumA(sid);
    }

}
