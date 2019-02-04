package com.pydyun.ims.service;

import com.github.pagehelper.PageInfo;
import com.pydyun.ims.model.Goods_user;
import com.pydyun.ims.model.PointsGoldCoinsRequest;

/**
 * @ClassName: Goods_userService
 * @Description: TODO(用户金币日志管理service接口)
 * @author tangxiaoyu
 * @date 2018年7月10日 上午9:41:17
 *
 */
public interface Goods_userService
{

    /**
     * @Title: usermoney
     * @Description: TODO(条件分页查询)
     * @param pageNum
     * @param pageSize
     * @param request
     * @return
     */
    PageInfo<Goods_user> usermoney(Integer pageNum, Integer pageSize, PointsGoldCoinsRequest request);

    void delete(Integer gid);

    /**
     * @Title: saveGoodsUser
     * @Description: TODO(新增用户金币记录)
     * @param goods_user
     */
    Integer saveGoodsUser(Goods_user goods_user);
    
    Integer seleteNum(Integer urid);
    
    Integer save(Goods_user goods_user);
    
    Integer seleteNumA(Integer urid);

}
