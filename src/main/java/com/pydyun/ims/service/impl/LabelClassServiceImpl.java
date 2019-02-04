package com.pydyun.ims.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pydyun.ims.dao.LabelClassDao;
import com.pydyun.ims.model.Label_class;
import com.pydyun.ims.service.LabelClassService;

@Service
public class LabelClassServiceImpl implements LabelClassService
{

    @Resource
    private LabelClassDao labelClassDao;

    @Override
    public PageInfo<Label_class> select(Integer pageNum, Integer pageSize)
    {
        PageHelper.startPage(pageNum, pageSize);
        List<Label_class> list = labelClassDao.select();
        return new PageInfo<>(list);
    }

    @Override
    public List<Label_class> selectByLclcid(Integer lclcid)
    {

        return labelClassDao.selectByLclcid(lclcid);
    }

    @Override
    public Integer add(Label_class label_class)
    {
        labelClassDao.add(label_class);
        return label_class.getLcid();

    }

    @Override
    public void update(Label_class label_class)
    {
        labelClassDao.update(label_class);

    }

    @Override
    public void delete(Integer lcid)
    {
        labelClassDao.delete(lcid);

    }

    @Override
    public Label_class getByLclcid(Integer lcid)
    {
        return labelClassDao.getByLclcid(lcid);
    }

	@Override
	public List<Label_class> findscscid(Integer lcid) {
		// TODO Auto-generated method stub
		return labelClassDao.findscscid(lcid);
	}

	@Override
	public List<Label_class> selectall() {
		// TODO Auto-generated method stub
		return labelClassDao.select();
	}

	@Override
	public Integer findid(String lcname) {
		// TODO Auto-generated method stub
		return labelClassDao.findid(lcname);
	}

	@Override
	public String findlclcname(Integer lcid) {
		// TODO Auto-generated method stub
		return labelClassDao.findlclcname(lcid);
	}

}
