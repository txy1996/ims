package com.pydyun.ims.service.impl.wximpl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.pydyun.ims.dao.WxOrderPayDao;
import com.pydyun.ims.model.WxOrderPay;
import com.pydyun.ims.service.wxservice.WxOrderPayService;

/**
 * @ClassName: WxOrderPayServiceImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author tangxiaoyu
 * @date 2018年8月23日 上午10:40:54
 *
 */
@Service
public class WxOrderPayServiceImpl implements WxOrderPayService
{

    @Resource
    private WxOrderPayDao wxOrderPayDao;

    @Override
    public Integer saveWxOrderPay(WxOrderPay wxOrderPay)
    {
        // TODO Auto-generated method stub
        return wxOrderPayDao.saveWxOrderPay(wxOrderPay);
    }
}
