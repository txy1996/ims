package com.pydyun.ims.dao;

import com.pydyun.ims.model.SchemeAndStageAndShop;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author tangxiaoyu
 * @ClassName: SchemeAndStageAndShopDao
 * @Description: TODO(方案所含阶段商家列表)
 * @date 2018年7月20日 下午11:16:18
 */
public interface SchemeAndStageAndShopDao
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
    List<SchemeAndStageAndShop> foundProductBySsid(@Param("ssids") List<Integer> ssids);
}
