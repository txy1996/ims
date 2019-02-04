package com.pydyun.ims.service.wxservice;

import java.util.List;

import com.pydyun.ims.model.ProductClass;
import com.pydyun.ims.model.WxProductClass;

public interface WxProductClassService {
	
	
	/**
     * @Title: findSuperiorProudctClass 
     * @Description: TODO(查询商品分类所有的顶级分类) 
     * @return
     */
    List<ProductClass> findSuperiorProudctClass();
    
    /**
     * @Title: findSuperiorProudctClass
     * @Description: TODO(查询商品分类顶级分类下的所有子类)
     * @return
     */
    List<ProductClass> findProudctClassByCid(Integer id);
    
    WxProductClass findaddress(Integer id,String cname);

	WxProductClass selectclass(Integer cid);
}
