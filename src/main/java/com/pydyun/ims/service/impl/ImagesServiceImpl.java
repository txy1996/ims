package com.pydyun.ims.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pydyun.ims.dao.ImagesDao;
import com.pydyun.ims.model.Images;
import com.pydyun.ims.service.ImagesService;

@Service
public class ImagesServiceImpl implements ImagesService {
	
@Resource
private ImagesDao ImagesDao;

	@Override
	public Integer creimages(Images images) {
		ImagesDao.cre(images);
		return images.getIid();
	}

	@Override
	public void deleteimages(Integer iid) {
		ImagesDao.delete(iid);
	}

	@Override
	public PageInfo<Images> photolist(Integer pageNum,Integer pageSize,Integer aid) {
		PageHelper.startPage(pageNum, pageSize);
		List<Images> list = ImagesDao.selectshop(aid);
		return new PageInfo<> (list);
//		return list;
	}

	@Override
	public Images getiid(Integer iid) {
		return ImagesDao.getiid(iid);
	}

	@Override
	public void updateimages(Images images) {
		ImagesDao.updateimages(images);
	}

    @Override
    public List<Images> selectshopImage(Integer aid)
    {
        // TODO Auto-generated method stub
        return ImagesDao.selectshop(aid);
    }


}
