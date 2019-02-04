package com.pydyun.ims.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.pydyun.ims.dao.ProductimgDao;
import com.pydyun.ims.model.Productimg;
import com.pydyun.ims.service.ProductimgService;

/**
 * @ClassName: ProductimgServiceImpl 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author tangxiaoyu 
 * @date 2018年7月26日 下午2:34:06 
 */
@Service
public class ProductimgServiceImpl implements ProductimgService
{
    @Resource
    private ProductimgDao productimgDao;
    
    @Override
    public Integer addProductimg(Productimg productimg)
    {
        // TODO Auto-generated method stub
        return productimgDao.addProductimg(productimg);
    }

    @Override
    public Productimg selectProductimg(Productimg productimg)
    {
        // TODO Auto-generated method stub
        return productimgDao.selectProductimg(productimg);
    }

    @Override
    public Integer deleteProductimg(Integer id)
    {
        // TODO Auto-generated method stub
        return productimgDao.deleteProductimg(id);
    }

	@Override
	public void deletept(Integer id) {
		productimgDao.deletept(id);
	}

}
