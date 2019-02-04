package com.pydyun.ims.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pydyun.ims.dao.LabelDao;
import com.pydyun.ims.model.Label;
import com.pydyun.ims.model.Label_class;
import com.pydyun.ims.service.LabelService;

@Service
public class LabelServiceImpl implements LabelService
{

    @Resource
    private LabelDao LabelDao;

  

    @Override
    public void delete(Integer lid,Integer urid)
    {
        LabelDao.delete(lid,urid);
    }

    @Override
    public Label getLabel(Integer lid)
    {
        return LabelDao.getLabel(lid);
    }

    @Override
    public void update(Label label)
    {
        LabelDao.update(label);
    }

    @Override
    public Integer add(Label label)
    {
        LabelDao.add(label);
        return label.getLid();
    }

    @Override
    public List<Label_class> list()
    {
        return LabelDao.list();
    }

	@Override
	public PageInfo<Label> select(Integer pageNum, Integer pageSize, Integer lcid,Integer urid) {
		PageHelper.startPage(pageNum, pageSize);
        List<Label> list = LabelDao.select(lcid,urid);
        return new PageInfo<>(list);
	}

	@Override
	public Integer findid(String lcinfo) {
		// TODO Auto-generated method stub
		return LabelDao.findid(lcinfo);
	}

	@Override
	public Label getLabel1(Integer lid) {
		// TODO Auto-generated method stub
		return LabelDao.getLabel1(lid);
	}

    @Override
    public List<Label> SelectAll(Integer lcid, Integer urid)
    {
        
        return LabelDao.select(lcid, urid);
    }


}
