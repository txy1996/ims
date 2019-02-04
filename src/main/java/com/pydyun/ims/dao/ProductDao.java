package com.pydyun.ims.dao;

import java.util.List;

import com.pydyun.ims.model.*;

import org.apache.ibatis.annotations.Param;

/**
 * @author tangxiaoyu
 * @ClassName: ProductDao
 * @Description: TODO(商品类)
 * @date 2018年7月23日 下午5:28:31
 */
public interface ProductDao
{

    /**
     * @param product
     * @return
     * @Title: addProduct
     * @Description: TODO(新增商品)
     */
    Integer addProduct(Product product);

    /**
     * @param request
     * @return
     * @Title: selectProduct
     * @Description: TODO(条件分页查询)
     */
    List<ProductResponse> selectProduct(ProductRequest request);

    /**
     * @param product
     * @return
     * @Title: updateProduct
     * @Description: TODO(修改商品)
     */
    Integer updateProduct(Product product);

    /**
     * @param id
     * @return
     * @Title: selectProductById
     * @Description: TODO(根据id查询)
     */
    ProductUpdateResponse selectProductById(Integer id);

    Integer findcid(@Param("id") Integer id);

    /*根据商品ids查询商品信息*/
    List<ProductInfoResponse> findProductByIds(@Param("ids") List<Integer> ids);

	List<Product> plist(String string);

	void deletepro(Integer id);

	List<ProductResponse> selectPro(@Param("scid")Integer scid, @Param("choise")String choise);
}
