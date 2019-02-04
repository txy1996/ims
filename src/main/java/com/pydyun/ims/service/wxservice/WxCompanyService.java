package com.pydyun.ims.service.wxservice;

import java.util.List;

import com.pydyun.ims.model.WxCompany;

/**
 * @ClassName: WxCompanyService
 * @Description: TODO(用户发票信息)
 * @author tangxiaoyu
 * @date 2018年8月13日 上午10:43:38
 *
 */
public interface WxCompanyService
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
