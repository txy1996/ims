package com.pydyun.ims.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.pydyun.ims.model.Product;
import com.pydyun.ims.model.ProductRequest;
import com.pydyun.ims.model.ProductResponse;
import com.pydyun.ims.model.ProductUpdateResponse;

/**
 * @ClassName: ProductService
 * @Description: TODO(商品表)
 * @author tangxiaoyu
 * @date 2018年7月23日 下午5:40:54
 *
 */
public interface ProductService
{

    /**
     * @Title: addProduct
     * @Description: TODO(新增商品)
     * @param product
     * @return
     */
    Product addProduct(Product product);

    /**
     * @Title: selectPage 
     * @Description: TODO(商品条件分页查询) 
     * @param pageNum
     * @param pageSize
     * @param request
     * @return
     */
    PageInfo<ProductResponse> selectPage(Integer pageNum, Integer pageSize, ProductRequest request);
    
    /**
     * @Title: updateProduct 
     * @Description: TODO(修改商品) 
     * @param product
     * @return
     */
    Integer updateProduct(Product product);
    
    /**
     * @Title: selectProductById 
     * @Description: TODO(根据id查询) 
     * @param id
     * @return
     */
    ProductUpdateResponse selectProductById(Integer id);

	Integer findcid(Integer id);

	List<Product> plist(String string);

	void deletepro(Integer id);

	PageInfo<ProductResponse> selectPro(Integer pageNum, Integer pageSize,
			Integer scid, String choise);
}
