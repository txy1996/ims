package com.pydyun.ims.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pydyun.ims.dao.ProductClassDao;
import com.pydyun.ims.model.ProductClass;
import com.pydyun.ims.service.ProductClassService;

@Service
public class ProductClassServiceImpl implements ProductClassService{

	@Resource
	ProductClassDao productClassDao;
	@Override
	public PageInfo<ProductClass> getProductClass(Integer pageNum, Integer pageSize) {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNum, pageSize);
		List<ProductClass> list = productClassDao.getProductClass();
		return new PageInfo<>(list);
	}
	@Override
	public void addClass(ProductClass productClass) {
		// TODO Auto-generated method stub
		productClassDao.addClass(productClass);
	}
	@Override
	public String selectbyid(Integer id) {
		// TODO Auto-generated method stub
		return productClassDao.selectbyid(id);
	}
	@Override
	public void deleteByid(Integer id) {
		// TODO Auto-generated method stub
		productClassDao.deleteByid(id);
	}
	@Override
	public List<ProductClass> findcid(Integer cid) {
		// TODO Auto-generated method stub
		return productClassDao.findcid(cid);
	}
    @Override
    public List<ProductClass> selectAll()
    {
        // TODO Auto-generated method stub
        return productClassDao.getProductClass();
    }
	@Override
	public ProductClass findproclass(Integer id) {
		// TODO Auto-generated method stub
		return productClassDao.findproclass(id);
	}
	@Override
	public List<ProductClass> finds() {
		// TODO Auto-generated method stub
		List<ProductClass> finds = productClassDao.finds();
//		ProductClass finds1 = productClassDao.finds1();
//		finds.add(finds1);
		return finds;
	}
	@Override
	public String findccname(Integer cid) {
		// TODO Auto-generated method stub
		return productClassDao.findccname(cid);
	}
	@Override
	public Integer findmodel(Integer pcid) {
		// TODO Auto-generated method stub
		return productClassDao.findmodel(pcid);
	}
	@Override
	public List<ProductClass> findtemplet() {
		// TODO Auto-generated method stub
		return productClassDao.findtemplet();
	}	

}
