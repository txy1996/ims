package com.pydyun.ims.dao;

import com.pydyun.ims.model.WxPosition;

/**
 * @ClassName: WxPositionDao
 * @Description: TODO(微信:职位头衔)
 * @author tangxiaoyu
 * @date 2018年8月13日 上午9:21:33
 *
 */
public interface WxPositionDao
{

    /**
     * @Title: saveWxPosition
     * @Description: TODO(新增职位头衔)
     * @param position
     * @return
     */
    Integer saveWxPosition(WxPosition position);

    /**
     * @Title: findWxPosition
     * @Description: TODO(查询职位头衔)
     * @param position
     * @return
     */
    WxPosition findWxPosition(WxPosition position);

    /**
     * @Title: deleteWxPosition
     * @Description: TODO(删除职位头衔)
     * @param pid
     * @return
     */
    Integer deleteWxPosition(Integer pid);

    /**
     * @Title: updateWxPosition
     * @Description: TODO(修改职位头衔)
     * @param position
     * @return
     */
    Integer updateWxPosition(WxPosition position);
}
