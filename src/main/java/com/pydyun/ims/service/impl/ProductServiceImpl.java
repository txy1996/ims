package com.pydyun.ims.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pydyun.ims.dao.ProductDao;
import com.pydyun.ims.model.Product;
import com.pydyun.ims.model.ProductRequest;
import com.pydyun.ims.model.ProductResponse;
import com.pydyun.ims.model.ProductUpdateResponse;
import com.pydyun.ims.service.ProductService;

/**
 * @ClassName: ProductServiceImpl
 * @Description: TODO(商品类)
 * @author tangxiaoyu
 * @date 2018年7月23日 下午5:43:17
 *
 */
@Service
public class ProductServiceImpl implements ProductService
{

    @Resource
    private ProductDao productDao;

    @Override
    public Product addProduct(Product product)
    {
        productDao.addProduct(product);

        return product;
    }

    @Override
    public PageInfo<ProductResponse> selectPage(Integer pageNum, Integer pageSize, ProductRequest request)
    {
        PageHelper.startPage(pageNum, pageSize);
        List<ProductResponse> products = productDao.selectProduct(request);
        return new PageInfo<>(products);
    }

    @Override
    public Integer updateProduct(Product product)
    {

        return productDao.updateProduct(product);
    }

    @Override
    public ProductUpdateResponse selectProductById(Integer id)
    {
        // TODO Auto-generated method stub
        return productDao.selectProductById(id);
    }

	@Override
	public Integer findcid(Integer id) {
		// TODO Auto-generated method stub
		return productDao.findcid(id);
	}

	@Override
	public List<Product> plist(String string) {
		return productDao.plist(string);
	}

	@Override
	public void deletepro(Integer id) {
		productDao.deletepro(id);
	}

	@Override
	public PageInfo<ProductResponse> selectPro(Integer pageNum,
			Integer pageSize, Integer scid, String choise) {
		PageHelper.startPage(pageNum, pageSize);
		List<ProductResponse> list = productDao.selectPro(scid,choise);
		return new PageInfo<>(list);
	}

}
