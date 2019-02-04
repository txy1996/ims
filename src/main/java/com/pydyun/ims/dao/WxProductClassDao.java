package com.pydyun.ims.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pydyun.ims.model.ProductClass;
import com.pydyun.ims.model.WxProductClass;

public interface WxProductClassDao
{

    List<WxProductClass> restaurant(Integer id);

    List<WxProductClass> listsang(Integer id1);

    List<WxProductClass> listtravel(Integer id2);

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
    
    WxProductClass findaddress(@Param("id")Integer id,@Param("cname")String cname);

	WxProductClass selectclass(Integer cid);

}
