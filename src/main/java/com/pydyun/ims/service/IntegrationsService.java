package com.pydyun.ims.service;

import com.github.pagehelper.PageInfo;
import com.pydyun.ims.model.Integrations;
import com.pydyun.ims.model.PointsGoldCoinsRequest;

public interface IntegrationsService
{

    PageInfo<Integrations> selectintegrations(Integer pageNum, Integer pageSize, PointsGoldCoinsRequest request);

    void delete(Integer iid);

    /**
     * @Title: addIntegrations
     * @Description: TODO(新增用户积分日志)
     * @param integrations
     */
    void addIntegrations(Integrations integrations);

    Integer seleteNum(Integer urid);

    void add(Integrations integrations);
    
    Integer seleteNumA(Integer urid);

}
