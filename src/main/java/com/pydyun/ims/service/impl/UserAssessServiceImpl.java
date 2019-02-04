package com.pydyun.ims.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pydyun.ims.dao.UserAssessDao;
import com.pydyun.ims.model.UserAssessPageResponse;
import com.pydyun.ims.service.UserAssessService;

/**
 * @ClassName: UserAssessServiceImpl
 * @Description: TODO(用户评论表service实现类)
 * @author tangxiaoyu
 * @date 2018年7月11日 上午11:26:19
 *
 */
@Service
public class UserAssessServiceImpl implements UserAssessService
{

    @Resource
    private UserAssessDao userAssessDao;

    @Override
    public PageInfo<UserAssessPageResponse> select(Integer pageNum, Integer pageSize, UserAssessPageResponse response)
    {

        PageHelper.startPage(pageNum, pageSize);
        if (response.getUaotype() != null && response.getCommentinfo() != null)
        {
            switch (response.getUaotype())
            {
                case 0:
                    response.setShopname(response.getCommentinfo());
                    break;
                case 1:
                    response.setSchemename(response.getCommentinfo());
                    break;
                case 2:
                    response.setStage(response.getCommentinfo());
                    break;
                case 3:
                    response.setPname(response.getCommentinfo());
                    break;
            }
        }

        List<UserAssessPageResponse> list = userAssessDao.select(response);
        return new PageInfo<>(list);
    }

}
