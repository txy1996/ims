package com.pydyun.ims.service.impl.wximpl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.pydyun.ims.dao.WxProductDao;
import com.pydyun.ims.model.WxProduct;
import com.pydyun.ims.service.wxservice.WxProductService;

@Service
public class WxProductServiceImpl implements WxProductService
{

    @Resource
    WxProductDao wxProductDao;

    @Override
    public List<WxProduct> findbyids(String ids) {
        // TODO Auto-generated method stub
        return wxProductDao.findbyids(ids);
    }

	@Override
	public List<WxProduct> findtj(String pid,String cid) {
		// TODO Auto-generated method stub
		return wxProductDao.findtj(pid,cid);
	}
    @Override
    public WxProduct findlike(String pname, String pid) {
        // TODO Auto-generated method stub
        return wxProductDao.findlike(pname, pid);
    }

    @Override
    public WxProduct findbypid(String pid) {
        // TODO Auto-generated method stub
        return wxProductDao.findbypid(pid);
    }

    @Override
    public String findid(String cid) {
        // TODO Auto-generated method stub
        return wxProductDao.findid(cid);
    }

    @Override
    public Integer findproid(Integer id) {
        // TODO Auto-generated method stub
        return wxProductDao.findproid(id);
    }

    @Override
    public List<WxProduct> findProductByIds(List<Integer> ids) {

        List<WxProduct> oldWxProducts=wxProductDao.findProductByIds(ids);

//        CommodityAttributeProcessing(oldWxProducts);
        return oldWxProducts;
    }

    private List<WxProduct> CommodityAttributeProcessing(List<WxProduct> oldWxProducts){

        List<List<String>> attributes=new ArrayList<>();
        for (WxProduct oldWxProduct : oldWxProducts) {
            String Property=oldWxProduct.getProperty();

            List<String> Attributes = new ArrayList<>();
            for(String sss:Property.replaceAll("[^0-9]", ",").split(",")){
                if (sss.length()>0)
                    Attributes.add(sss);
            }
            attributes.add(Attributes);
        }

        return oldWxProducts;
    }

	@Override
	public List<WxProduct> findbyids1(List<String> ids) {
		// TODO Auto-generated method stub
		return wxProductDao.findbyids1(ids);
	}

	@Override
	public List<WxProduct> selectproduct(Integer sid) {
		return wxProductDao.selectproduct(sid);
	}

}
