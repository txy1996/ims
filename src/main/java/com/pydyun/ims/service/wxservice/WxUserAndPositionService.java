package com.pydyun.ims.service.wxservice;

import java.util.List;

import com.pydyun.ims.model.WxUserAndPosition;

/**
 * @ClassName: WxUserAndPositionService
 * @Description: TODO(微信:用户和公司发票职位关系)
 * @author tangxiaoyu
 * @date 2018年8月13日 上午11:13:11
 *
 */
public interface WxUserAndPositionService
{

    /**
     * @Title: saveWxUserAndPosition
     * @Description: TODO(新增用户和公司职位关系)
     * @param userAndPosition
     * @return
     */
    Integer saveWxUserAndPosition(WxUserAndPosition userAndPosition);

    /**
     * @Title: findWxUserAndPosition
     * @Description: TODO(查询用户和公司职位关系)
     * @param userAndPosition
     * @return
     */
    List<WxUserAndPosition> findWxUserAndPosition(WxUserAndPosition userAndPosition);

    /**
     * @Title: deleteWxUserAndPosition
     * @Description: TODO(删除用户和公司职位关系)
     * @param upid
     * @return
     */
    Integer deleteWxUserAndPosition(Integer upid);

    /**
     * @Title: updateWxUserAndPosition
     * @Description: TODO(修改用户和公司职位关系)
     * @param userAndPosition
     * @return
     */
    Integer updateWxUserAndPosition(WxUserAndPosition userAndPosition);
}
