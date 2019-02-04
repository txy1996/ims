package com.pydyun.ims.service;

import java.util.List;

import com.pydyun.ims.model.*;
import org.apache.ibatis.annotations.Param;

/**
 * @author tangxiaoyu
 * @ClassName: Scheme_stageService
 * @Description: TODO(方案阶段)
 * @date 2018年7月16日 下午5:05:57
 */
public interface Scheme_stageService
{

    /**
     * @return
     * @Title: foundAlternateMerchant
     * @Description: TODO(查询方案阶段所属备选商家)
     */
    List<SchemeAlternativeShop> foundAlternateMerchant(List<Integer> ssids) throws Exception;

    /**
     * @return
     * @Title: foundSchemeAndStage
     * @Description: TODO(查询方案所属阶段详情)
     */
    List<SchemeAndStageResponse> foundSchemeAndStage(Integer sid);

    /**
     * @param scheme_stage
     * @Title: addStage
     * @Description: TODO(新增阶段)
     */
    Scheme_stage addStage(Scheme_stage scheme_stage);

    /**
     * @param scheme_stage
     * @Title: updateStage
     * @Description: TODO(修改阶段)
     */
    Integer updateStage(Scheme_stage scheme_stage);

    /**
     * @param sid
     * @return
     * @Title: findSchemeStageBySid
     * @Description: TODO(统计所属方案的阶段数量)
     */
    Integer findSchemeStageBySid(Integer sid);

    /**
     * @param ssid
     * @return
     * @Title: deleteStage
     * @Description: TODO(删除方案下阶段)
     */
    Integer deleteStage(Integer ssid);

    /*阶段下商品*/
    SchemeAndStageAndShop foundProductBySsid(List<Integer> ssids);

    /*根据id查询*/
    List<StageShopGoodsResponse> foundProductInformation(List<Integer> ssids);
}
