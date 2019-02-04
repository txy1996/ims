package com.pydyun.ims.dao;

import com.pydyun.ims.model.WxAssessImage;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * FileName: WxAssessImageDao
 * Author:   tangxiaoyu
 * Date:     2018/9/5 9:45
 * Description: TODO(用户评论图片)
 *
 * @since 1.0.0
 */
public interface WxAssessImageDao
{

    Integer saveWxAssessImage(@Param("list") List<WxAssessImage> wxAssessImages);

    Integer deleteWxAssessImage(Integer plid);

    List<WxAssessImage> selectWxAssessImage(Integer plid);

    /*根据id批量查询*/
    List<WxAssessImage> findWxAssessImages(@Param("ids") List<Integer> ids);
}
