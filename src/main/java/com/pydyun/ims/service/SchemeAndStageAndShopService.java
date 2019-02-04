package com.pydyun.ims.service;

import com.pydyun.ims.model.SchemeAndStageAndShop;

import java.util.List;

/**
 * @author tangxiaoyu
 * @ClassName: SchemeAndStageAndShopService
 * @Description: TODO(方案所含阶段商家列表)
 * @date 2018年7月20日 下午11:18:44
 */
public interface SchemeAndStageAndShopService
{

    /**
     * @param stageAndShop
     * @return
     * @Title: addSchemeAndStageAndShop
     * @Description: TODO(新增方案所含阶段商家列表)
     */
    Integer addSchemeAndStageAndShop(SchemeAndStageAndShop stageAndShop);

    /**
     * @param stageAndShop
     * @return
     * @Title: updateSchemeAndStageAndShop
     * @Description: TODO(修改方案所含阶段商家列表)
     */
    Integer updateSchemeAndStageAndShop(SchemeAndStageAndShop stageAndShop);

    /**
     * @param ssid
     * @return
     * @Title: deleteSchemeAndStageAndShop
     * @Description: TODO(删除方案所含阶段商家列表)
     */
    Integer deleteSchemeAndStageAndShop(Integer ssid);

    /*阶段下商品*/
    List<SchemeAndStageAndShop> foundProductBySsid(List<Integer> ssids);
}
