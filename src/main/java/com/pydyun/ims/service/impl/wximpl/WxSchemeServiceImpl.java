package com.pydyun.ims.service.impl.wximpl;

import java.util.List;

import javax.annotation.Resource;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pydyun.ims.model.WxSchemeResponse;
import org.springframework.stereotype.Service;

import com.pydyun.ims.dao.WxSchemeDao;
import com.pydyun.ims.model.WxScheme;
import com.pydyun.ims.service.wxservice.WxSchemeService;

@Service
public class WxSchemeServiceImpl implements WxSchemeService
{

    @Resource
    WxSchemeDao wxSchemeDao;

    @Override
    public List<WxScheme> findtrain(String task, String spnum, String sduration, String srange) {
        // TODO Auto-generated method stub
        return wxSchemeDao.findtrain(task, spnum, sduration, srange);
    }

    @Override
    public PageInfo<WxSchemeResponse> findWxSchemeAll(Integer pageNum, Integer pageSize, WxScheme  wxScheme) {
        PageHelper.startPage(pageNum, pageSize);
        List<WxSchemeResponse> responses= wxSchemeDao.findWxSchemeAll(wxScheme);
        return new PageInfo<>(responses);
    }

}
