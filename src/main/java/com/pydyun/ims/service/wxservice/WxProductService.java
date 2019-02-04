package com.pydyun.ims.service.wxservice;

import java.util.List;

import com.pydyun.ims.model.WxProduct;

public interface WxProductService
{
    List<WxProduct> findbyids(String ids);

    WxProduct findlike(String pname, String pid);

    WxProduct findbypid(String pid);

    List<WxProduct> findtj(String pid,String cid);

    String findid(String cid);

    Integer findproid(Integer id);

    List<WxProduct> findProductByIds(List<Integer> ids);
    
    List<WxProduct> findbyids1(List<String> ids);

	List<WxProduct> selectproduct(Integer sid);
}
