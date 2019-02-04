package com.pydyun.ims.service.impl.wximpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.pydyun.ims.dao.WxProductClassDao;
import com.pydyun.ims.model.ProductClass;
import com.pydyun.ims.model.WxProductClass;
import com.pydyun.ims.service.wxservice.WxProductClassService;

@Service
public class WxProductClassServiceimpl implements WxProductClassService
{

    @Resource
    WxProductClassDao wxProductClassDao;

    @Override
    public List<ProductClass> findSuperiorProudctClass()
    {
        // TODO Auto-generated method stub
        return wxProductClassDao.findSuperiorProudctClass();
    }

    @Override
    public List<ProductClass> findProudctClassByCid(Integer id)
    {
        // TODO Auto-generated method stub
        return wxProductClassDao.findProudctClassByCid(id);
    }

	@Override
	public WxProductClass findaddress(Integer id,String cname) {
		// TODO Auto-generated method stub
		return wxProductClassDao.findaddress(id,cname);
	}

	@Override
	public WxProductClass selectclass(Integer cid) {
		// TODO Auto-generated method stub
		return wxProductClassDao.selectclass(cid);
	}

}
