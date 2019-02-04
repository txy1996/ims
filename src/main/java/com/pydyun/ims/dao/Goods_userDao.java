package com.pydyun.ims.dao;

import java.util.List;

import com.pydyun.ims.model.Goods_user;
import com.pydyun.ims.model.PointsGoldCoinsRequest;

public interface Goods_userDao
{

    /**
     * @Title: selete
     * @Description: TODO(条件分页查询)
     * @param request
     * @return
     */

    List<Goods_user> selete(PointsGoldCoinsRequest request);

    void delete(Integer gid);

    /**
     * @Title: saveGoodsUser
     * @Description: TODO(新增用户金币记录)
     * @param goods_user
     * @return
     */
    Integer saveGoodsUser(Goods_user goods_user);

    Integer save(Goods_user goods_user);

    Integer seleteNum(Integer urid);
    
    Integer seleteNumA(Integer urid);

}
