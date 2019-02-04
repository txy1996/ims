package com.pydyun.ims.service.impl.wximpl;

import com.pydyun.ims.dao.WxAssessImageDao;
import com.pydyun.ims.model.WxAssessImage;
import com.pydyun.ims.service.wxservice.WxAssessImageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * FileName: WxAssessImageServiceImpl
 * Author:   tangxiaoyu
 * Date:     2018/9/5 10:03
 * Description: TODO(评论图片)
 *
 * @since 1.0.0
 */
@Service
public class WxAssessImageServiceImpl implements WxAssessImageService
{

    @Resource
    private WxAssessImageDao wxAssessImageDao;

    @Override
    public Integer saveWxAssessImage(List<WxAssessImage> wxAssessImages) {
        return wxAssessImageDao.saveWxAssessImage(wxAssessImages);
    }

    @Override
    public Integer deleteWxAssessImage(Integer plid) {
        return wxAssessImageDao.deleteWxAssessImage(plid);
    }

    @Override
    public List<WxAssessImage> selectWxAssessImage(Integer plid) {
        return wxAssessImageDao.selectWxAssessImage(plid);
    }

    @Override
    public List<WxAssessImage> findWxAssessImages(List<Integer> ids) {
        return wxAssessImageDao.findWxAssessImages(ids);
    }
}
