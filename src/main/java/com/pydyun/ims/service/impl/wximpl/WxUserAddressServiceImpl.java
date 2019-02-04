package com.pydyun.ims.service.impl.wximpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.pydyun.ims.dao.WxUserAddressDao;
import com.pydyun.ims.model.WxUserAddress;
import com.pydyun.ims.service.wxservice.WxUserAddressService;

/**
 * @author tangxiaoyu
 * @ClassName: WxUserAddressServiceImpl
 * @Description: TODO(微信 : 用户地址管理)
 * @date 2018年8月10日 下午3:13:27
 */
@Service
public class WxUserAddressServiceImpl implements WxUserAddressService
{

    @Resource
    private WxUserAddressDao WxUserAddressDao;

    @Override
    public Integer saveWxUserAddress(WxUserAddress address) {

        /*判断默认地址是否存在,如果存在,修改其默认状态,每个用户只能存在一个默认地址*/
        if (address.getUaone().equals(1)) {
            WxUserAddress wxUserAddress = WxUserAddressDao.getWxUserDefaultAddress(address);
            if (wxUserAddress != null) {
                wxUserAddress.setUaone(0);
                WxUserAddressDao.updateWxUserAddress(wxUserAddress);
            }
        }
        return WxUserAddressDao.saveWxUserAddress(address);
    }

    @Override
    public Integer updateWxUserAddress(WxUserAddress address) {
        return WxUserAddressDao.updateWxUserAddress(address);
    }

    @Override
    public Integer deleteWxUserAddress(Integer uaid) {
        return WxUserAddressDao.deleteWxUserAddress(uaid);
    }

    @Override
    public List<WxUserAddress> findWxUserAddress(WxUserAddress address) {
        return WxUserAddressDao.findWxUserAddress(address);
    }

    @Override
    public WxUserAddress getWxUserDefaultAddress(WxUserAddress address) {
        return WxUserAddressDao.getWxUserDefaultAddress(address);
    }

	@Override
	public void updateuaone(Integer uauid) {
		// TODO Auto-generated method stub
		WxUserAddressDao.updateuaone(uauid);
	}

}
