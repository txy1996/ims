package com.pydyun.ims.dao;

import java.util.List;

import com.pydyun.ims.model.WxCompany;

/**
 * @ClassName: WxCompanyDao
 * @Description: TODO(微信:个人中心-发票管理)
 * @author tangxiaoyu
 * @date 2018年8月10日 下午3:35:11
 *
 */
public interface WxCompanyDao
{

    /**
     * @Title: saveWxCompany
     * @Description: TODO(发票新增)
     * @param company
     * @return
     */
    Integer saveWxCompany(WxCompany company);

    /**
     * @Title: findWxCompany
     * @Description: TODO(查询发票)
     * @param urid
     * @return
     */
    List<WxCompany> findWxCompany(Integer urid);

    /**
     * @Title: deleteWxCompany
     * @Description: TODO(删除)
     * @param cid
     * @return
     */
    Integer deleteWxCompany(Integer cid);

    /**
     * @Title: updateWxCompany 
     * @Description: TODO(修改) 
     * @param company
     * @return
     */
    Integer updateWxCompany(WxCompany company);
}
