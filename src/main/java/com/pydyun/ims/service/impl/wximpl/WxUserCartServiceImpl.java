package com.pydyun.ims.service.impl.wximpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pydyun.ims.dao.WxShopDao;
import com.pydyun.ims.dao.WxUserCartDao;
import com.pydyun.ims.model.WxShop;
import com.pydyun.ims.model.WxUserCart;
import com.pydyun.ims.model.WxUserCartResponse;
import com.pydyun.ims.service.wxservice.WxUserCartService;
import com.pydyun.ims.util.BusinessInformation;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

/**
 * FileName: WxUserCartServiceImpl
 * Author:   tangxiaoyu
 * Date:     2018/8/27 9:31
 * Description: TODO(微信:购物车服务类)
 *
 * @since 1.0.0
 */
@Service
public class WxUserCartServiceImpl implements WxUserCartService
{

    @Resource
    private WxUserCartDao wxUserCartDao;
    @Resource
    private WxShopDao wxShopDao;

    @Override
    public WxUserCart saveWxUserCart(WxUserCart wxUserCart) throws Exception {
        if(wxUserCart==null){
            throw new InvalidParameterException("购物车信息不能为空");
        }
        if(wxUserCart.getOid()==null){
            throw new InvalidParameterException("商品id不能为空");
        }
        if(wxUserCart.getUid()==null){
            throw new InvalidParameterException("用户id不能为空");
        }
        WxUserCart oldWxuserCart = wxUserCartDao.getWxUserCart(wxUserCart);
        if (oldWxuserCart != null) {
            //购物车存在该商品,增加数量
            oldWxuserCart.setNumber(wxUserCart.getNumber() + oldWxuserCart.getNumber());
            wxUserCartDao.updateWxUserCart(oldWxuserCart);
            return oldWxuserCart;
        }

        wxUserCartDao.saveWxUserCart(wxUserCart);
        return wxUserCart;
    }

    @Override
    public Integer updateWxUserCart(WxUserCart wxUserCart) {

        return wxUserCartDao.updateWxUserCart(wxUserCart);
    }

    @Override
    public Integer updateWxUserCartByUidAllStatus(Integer uid, Integer status) {

        return wxUserCartDao.updateWxUserCartByUidAllStatus(uid, status);
    }

    @Override
    public Integer deleteWxUserCart(List<Integer> ids) {
        if (ids == null) {
            return null;
        }
        return wxUserCartDao.deleteWxUserCart(ids);
    }

    @Override
    public PageInfo<WxUserCartResponse> findWxUserCart(Integer pageNum, Integer pageSize,WxUserCart wxUserCart) {
        PageHelper.startPage(pageNum, pageSize);
        List<WxUserCartResponse> responses = new ArrayList<>();
        responses = wxUserCartDao.findWxUserCartProduct(wxUserCart);
        for (WxUserCartResponse respons : responses) {
            if (respons.getFreight() != null && respons.getFgxf() != null) {
                Double freight = respons.getFreight()
                        + (respons.getFgxf() * respons.getNum());
                respons.setFreight(freight);
            }
        }
        WxShop findWxShopBySid = wxShopDao.findWxShopBySid(BusinessInformation.VSM);
        List<WxUserCartResponse> list = wxUserCartDao.findWxUserCartVoucher(wxUserCart);
        for (WxUserCartResponse wxUserCartResponse : list) {
            wxUserCartResponse.setSid(BusinessInformation.VSM);
            wxUserCartResponse.setSname(findWxShopBySid.getSname());
        }
        responses.addAll(list);

        return new PageInfo<>(responses);
    }
}
