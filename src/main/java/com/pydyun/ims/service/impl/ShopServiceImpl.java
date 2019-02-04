package com.pydyun.ims.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pydyun.ims.dao.ShopDao;
import com.pydyun.ims.model.Shop;
import com.pydyun.ims.model.ShopResponse;
import com.pydyun.ims.model.ShopSpare;
import com.pydyun.ims.model.Zone;
import com.pydyun.ims.service.ShopService;

@Service
public class ShopServiceImpl implements ShopService
{
    @Resource
    private ShopDao ShopDao;

    @Override
    public PageInfo<Shop> selectshop(Integer pageNum, Integer pageSize,Integer scid1,Integer bid1,String sname,String scommerce)
    {
        PageHelper.startPage(pageNum, pageSize);
        List<Shop> list = ShopDao.selectshop(scid1,bid1,sname,scommerce);
        return new PageInfo<>(list);
    }

    @Override
    public ShopSpare getshop(Integer sid)
    {
        return ShopDao.getshop(sid);
    }

    @Override
    public void deleteshop(Integer sid)
    {
        ShopDao.delete(sid);

    }

    @Override
    public Integer addshop(Shop shop)
    {
        ShopDao.add(shop);
        return shop.getSid();

    }

    @Override
    public void updateshop(Shop shop)
    {
        ShopDao.updateshop(shop);

    }

    @Override
    public List<String> selectbid()
    {
        return ShopDao.selectbid();
    }

//    @Override
//    public List<String> selectlevel()
//    {
//        return ShopDao.selectlevel();
//    }

    @Override
    public List<Zone> selectzid()
    {
        // TODO Auto-generated method stub
        return ShopDao.selectzid();
    }

    @Override
    public PageInfo<Shop> getshop(Integer pageNum, Integer pageSize, Integer id)
    {
        PageHelper.startPage(pageNum, pageSize);
        List<Shop> list = ShopDao.getshopsta(id);
        return new PageInfo<>(list);
    }

    @Override
    public List<Shop> findshop()
    {
        // TODO Auto-generated method stub
        return ShopDao.findshop();
    }

    @Override
    public PageInfo<Shop> selectby(Integer pageNum, Integer pageSize, Integer scid1, Integer bid1, String sname,
            String stel)
    {
        // TODO Auto-generated method stub
        PageHelper.startPage(pageNum, pageSize);
        List<Shop> list = ShopDao.selectby(scid1, bid1, sname, stel);
        return new PageInfo<>(list);
    }

    @Override
    public List<Shop> findshop1(Integer sid)
    {
        // TODO Auto-generated method stub
        return ShopDao.findshop1(sid);
    }

    @Override
    public Integer getbid(Integer scid)
    {
        // TODO Auto-generated method stub
        return ShopDao.getbid(scid);
    }

    @Override
    public Integer getscid(Integer bid)
    {
        // TODO Auto-generated method stub
        return ShopDao.getscid(bid);
    }

    @Override
    public Integer getbid1(Integer sid)
    {
        // TODO Auto-generated method stub
        return ShopDao.getbid1(sid);
    }

    @Override
    public List<ShopResponse> getByShopName(ShopResponse response)
    {
        // TODO Auto-generated method stub
        return ShopDao.getByShopName(response);
    }

	@Override
	public String getsname(Integer sid) {
		// TODO Auto-generated method stub
		return ShopDao.getsname(sid);
	}


    @Override
    public Shop getByShopId(Integer sid)
    {
        // TODO Auto-generated method stub
        return ShopDao.getByShopId(sid);
    }

	@Override
	public void picture(Shop shop) {
		 ShopDao.picture(shop);
	}

	@Override
	public List<Shop> Styleimg(Integer sid) {
		return ShopDao.Styleimg(sid);
	}

	@Override
	public List<Shop> shops(String string) {
		return ShopDao.shops(string);
	}

	@Override
	public void deletesp(Integer id) {
		ShopDao.deletesp(id);
	}

}
