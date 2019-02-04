package com.pydyun.ims.service.wxservice;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pydyun.ims.model.WxOrderProduct;
import com.pydyun.ims.model.WxVoucherResponse;

/**
 * @ClassName: WxVoucherService 
 * @Description: TODO(微信端,代金券记录) 
 * @author tangxiaoyu 
 * @date 2018年8月8日 上午10:46:44 
 *
 */
public interface WxVoucherService
{
    
    /**
     * @Title: findVoucherByUrid 
     * @Description: TODO(用户代金券记录) 
     * @param urid
     * @return
     */
    List<WxVoucherResponse>findVoucherByUrid(Integer urid);
    
    /**
     * @Title: findVoucherInvalidByUrid 
     * @Description: TODO(代金券记录无效) 
     * @param urid
     * @return
     */
    List<WxVoucherResponse>findVoucherInvalidByUrid(Integer urid);
    
    
    List<WxOrderProduct>findVoucherByVid(@Param(value = "vids") List<Integer> vids);

    /*统计有效代金券*/
    Integer getVoucherCountByUrid(Integer urid);
}
