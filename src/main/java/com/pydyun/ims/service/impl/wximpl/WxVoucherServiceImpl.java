package com.pydyun.ims.service.impl.wximpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.pydyun.ims.dao.WxVoucherDao;
import com.pydyun.ims.model.WxOrderProduct;
import com.pydyun.ims.model.WxVoucherResponse;
import com.pydyun.ims.service.wxservice.WxVoucherService;

/**
 * @author tangxiaoyu
 * @ClassName: WxVoucherServiceImpl
 * @Description: TODO(微信端, 代金券记录)
 * @date 2018年8月8日 上午10:47:55
 */
@Service
public class WxVoucherServiceImpl implements WxVoucherService
{

    @Resource
    private WxVoucherDao WxVoucherDao;

    @Override
    public List<WxVoucherResponse> findVoucherByUrid(Integer urid) {
        // TODO Auto-generated method stub
        return WxVoucherDao.findVoucherByUrid(urid);
    }

    @Override
    public List<WxVoucherResponse> findVoucherInvalidByUrid(Integer urid) {
        // TODO Auto-generated method stub
        return WxVoucherDao.findVoucherInvalidByUrid(urid);
    }

    @Override
    public List<WxOrderProduct> findVoucherByVid(List<Integer> vids) {
        // TODO Auto-generated method stub
        return WxVoucherDao.findVoucherByVid(vids);
    }

    @Override
    public Integer getVoucherCountByUrid(Integer urid) {
        return WxVoucherDao.getVoucherCountByUrid(urid);
    }

}
