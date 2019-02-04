package com.pydyun.ims.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pydyun.ims.model.WxOrderProduct;
import com.pydyun.ims.model.WxProduct;

public interface WxProductDao
{
    List<WxProduct> findbyids(@Param("ids") String ids);

    WxProduct findlike(@Param("pname") String pname, @Param("id") String id);

    WxProduct findbypid(String pid);

    List<WxProduct> findtj(/*@Param("property") String property,*/ @Param("pid") String pid,@Param("cid") String cid);

    String findid(@Param("cid") String cid);

    List<WxOrderProduct> findPrdouctList(@Param(value = "ids") List<Integer> ids);
    
    Integer findproid(@Param("id") Integer id);

    List<WxProduct> findProductByIds(@Param("list") List<Integer> ids);
    
    List<WxProduct> findbyids1(@Param("list") List<String> ids);

	List<WxProduct> selectproduct(Integer sid);
}
