package com.pydyun.ims.dao;

import java.util.List;

import com.pydyun.ims.model.StageGoodsResponse;
import org.apache.ibatis.annotations.Param;

import com.pydyun.ims.model.SchemeAlternativeShop;
import com.pydyun.ims.model.SchemeAndStageResponse;
import com.pydyun.ims.model.Scheme_stage;

/**
 * @author tangxiaoyu
 * @ClassName: Scheme_stageDao
 * @Description: TODO(方案阶段)
 * @date 2018年7月16日 下午4:17:23
 */
public interface Scheme_stageDao
{

    /**
     * @return
     * @Title: foundAlternateMerchant
     * @Description: TODO(查询方案阶段所属备选商家)
     */
    List<SchemeAlternativeShop> foundAlternateMerchant(@Param("ssids") List<Integer> ssids);

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
    int addStage(Scheme_stage scheme_stage);

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

    /**
     * @param sid
     * @return
     * @Title: getSchemeStageById
     * @Description: TODO(根据方案id查询阶段信息)
     */
    List<Scheme_stage> getSchemeStageById(Integer sid);

    /*根据id查询*/
    List<StageGoodsResponse> foundProductInformation(@Param("ids") List<Integer> ids);

}
