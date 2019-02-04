package com.pydyun.ims.service.impl.wximpl;

import com.pydyun.ims.dao.WxImagesPiDao;
import com.pydyun.ims.model.WxImagesPi;
import com.pydyun.ims.service.wxservice.WxImagesPiService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * FileName: WxImagesPiServiceImpl
 * Author:   tangxiaoyu
 * Date:     2018/8/31 18:12
 * Description: TODO(用户评论)
 *
 * @since 1.0.0
 */
@Service
public class WxImagesPiServiceImpl implements WxImagesPiService
{

    @Resource
    private WxImagesPiDao wxImagesPiDao;

    /**
     * @param wxImagesPi
     * @Description: TODO(新增用户评论图片)
     * @param:
     * @return:
     * @Date: 2018/8/31 18:10
     */
    @Override
    public WxImagesPi saveWxImagesPi(WxImagesPi wxImagesPi) {

        wxImagesPiDao.saveWxImagesPi(wxImagesPi);
        return wxImagesPi;
    }
}
