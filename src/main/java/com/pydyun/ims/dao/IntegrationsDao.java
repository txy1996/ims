package com.pydyun.ims.dao;

import java.util.List;

import com.pydyun.ims.model.Integrations;
import com.pydyun.ims.model.PointsGoldCoinsRequest;

public interface IntegrationsDao
{

    List<Integrations> selectintegrations(PointsGoldCoinsRequest request);

    void delete(Integer iid);

    /**
     * @Title: addIntegrations
     * @Description: TODO(新增用户积分日志)
     * @param integrations
     */
    void addIntegrations(Integrations integrations);

    void add(Integrations integrations);

    Integer seleteNum(Integer urid);
    
    Integer seleteNumA(Integer urid);

}
