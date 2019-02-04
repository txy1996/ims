package com.pydyun.ims.service.impl.wximpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.pydyun.ims.dao.WxCompanyDao;
import com.pydyun.ims.model.WxCompany;
import com.pydyun.ims.service.wxservice.WxCompanyService;

/**
 * @ClassName: WxCompanyServiceImpl
 * @Description: TODO(用户发票管理)
 * @author tangxiaoyu
 * @date 2018年8月13日 上午10:54:11
 *
 */
@Service
public class WxCompanyServiceImpl implements WxCompanyService
{

    @Resource
    private WxCompanyDao WxCompanyDao;

    @Override
    public Integer saveWxCompany(WxCompany company)
    {
        // TODO Auto-generated method stub
        return WxCompanyDao.saveWxCompany(company);
    }

    @Override
    public List<WxCompany> findWxCompany(Integer urid)
    {
        // TODO Auto-generated method stub
        return WxCompanyDao.findWxCompany(urid);
    }

    @Override
    public Integer deleteWxCompany(Integer cid)
    {
        // TODO Auto-generated method stub
        return WxCompanyDao.deleteWxCompany(cid);
    }

    @Override
    public Integer updateWxCompany(WxCompany company)
    {
        // TODO Auto-generated method stub
        return WxCompanyDao.updateWxCompany(company);
    }

}
