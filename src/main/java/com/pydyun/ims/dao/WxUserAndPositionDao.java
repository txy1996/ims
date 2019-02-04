package com.pydyun.ims.dao;

import java.util.List;

import com.pydyun.ims.model.WxUserAndPosition;

/**
 * @ClassName: WxUserAndPositionDao
 * @Description: TODO(微信:用户与公司职位关系)
 * @author tangxiaoyu
 * @date 2018年8月13日 上午10:11:41
 *
 */
public interface WxUserAndPositionDao
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
