package com.pydyun.ims.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pydyun.ims.model.WxOrderProduct;
import com.pydyun.ims.model.WxVoucher;
import com.pydyun.ims.model.WxVoucherResponse;

public interface WxVoucherDao
{

	List<WxVoucher> selectv(String vrange);
	

    /**
     * @param urid
     * @return
     * @Title: findVoucherByUrid
     * @Description: TODO(用户代金券记录有效)
     */
    List<WxVoucherResponse> findVoucherByUrid(Integer urid);

    /**
     * @param urid
     * @return
     * @Title: findVoucherInvalidByUrid
     * @Description: TODO(代金券记录无效)
     */
    List<WxVoucherResponse> findVoucherInvalidByUrid(Integer urid);

    List<WxOrderProduct> findVoucherByVid(@Param(value = "vids") List<Integer> vids);

    /*统计有效代金券*/
    Integer getVoucherCountByUrid(Integer urid);

}
