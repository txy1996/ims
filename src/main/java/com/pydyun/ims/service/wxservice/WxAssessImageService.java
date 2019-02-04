package com.pydyun.ims.service.wxservice;

import com.pydyun.ims.model.WxAssessImage;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * FileName: WxAssessImageService
 * Author:   tangxiaoyu
 * Date:     2018/9/5 10:01
 * Description: TODO(微信:评论表下图片)
 *
 * @since 1.0.0
 */
public interface WxAssessImageService
{

    Integer saveWxAssessImage(List<WxAssessImage> wxAssessImages);

    Integer deleteWxAssessImage(Integer plid);

    List<WxAssessImage> selectWxAssessImage(Integer plid);

    /*根据id批量查询*/
    List<WxAssessImage> findWxAssessImages(List<Integer> ids);
}
