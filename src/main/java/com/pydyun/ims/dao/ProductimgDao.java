package com.pydyun.ims.dao;

import com.pydyun.ims.model.Productimg;

/**
 * @ClassName: ProductimgDao
 * @Description: TODO(商品图片)
 * @author tangxiaoyu
 * @date 2018年7月26日 下午2:29:38
 *
 */
public interface ProductimgDao
{
    
    
    Integer addProductimg(Productimg productimg);

    Productimg selectProductimg(Productimg productimg);

    Integer deleteProductimg(Integer id);

	void deletept(Integer id);
}
