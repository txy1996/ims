package com.pydyun.ims.dao;

import java.util.List;

import com.pydyun.ims.model.PointsGoldCoinsRequest;
import com.pydyun.ims.model.Slintegration;

public interface SlintegrationDao
{

    void delete(Integer slid);

    /**
     * @Title: selectSlintegration
     * @Description: TODO(商户积分条件分页查询)
     * @param request
     * @return
     */
    List<Slintegration> selectSlintegration(PointsGoldCoinsRequest request);

    /**
     * @Title: addSlintegration
     * @Description: TODO(新增商户积分记录)
     * @param slintegration
     */
    void addSlintegration(Slintegration slintegration);

    void addshop(Slintegration slintegration);

    /**
     * @Title: seleteNum
     * @Description: TODO(根据商户id查询商户当前积分)
     * @param sid
     * @return
     */
    Integer seleteNum(Integer sid);
    
    Integer seleteNumA(Integer sid);
    
    

}
