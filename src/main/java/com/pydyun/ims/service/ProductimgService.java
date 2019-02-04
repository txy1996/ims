package com.pydyun.ims.service;

import com.pydyun.ims.model.Productimg;

/**
 * @ClassName: ProductimgService
 * @Description: TODO(商品图片)
 * @author tangxiaoyu
 * @date 2018年7月26日 下午2:33:10
 *
 */
public interface ProductimgService
{

    Integer addProductimg(Productimg productimg);

    Productimg selectProductimg(Productimg productimg);

    Integer deleteProductimg(Integer id);

	void deletept(Integer id);
}
