package com.pydyun.ims.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pydyun.ims.model.Label_scheme_sum;
import com.pydyun.ims.model.Label_scheme_sumResponse;

/**
 * @ClassName: Label_scheme_sumDao
 * @Description: TODO(方案、方案所属阶段。被用户选择的标签记录表)
 * @author tangxiaoyu
 * @date 2018年7月18日 下午8:12:33
 *
 */
public interface Label_scheme_sumDao
{

    /**
     * @Title: updateLabelscheme
     * @Description: TODO(修改)
     * @param laSum
     * @return Integer
     */
    Integer updateLabelscheme(Label_scheme_sum laSum);

    /**
     * @Title: addLabelscheme
     * @Description: TODO(新增)
     * @param laSum
     * @return Integer
     */
    Integer addLabelscheme(Label_scheme_sum laSum);

    /**
     * @Title: addLabelschemelist
     * @Description: TODO(批量新增)
     * @param lSums
     * @return Integer
     */
    Integer addLabelschemelist(List<Label_scheme_sum> list);

    /**
     * @Title: deleteLabelscheme
     * @Description: TODO(删除)
     * @param lssid
     * @return Integer
     */
    Integer deleteLabelscheme(@Param(value = "sid") Integer sid, @Param(value = "list") List<Integer> list);

    Integer findfabyid(Integer lid);

    Integer findjdbyid(Integer lid);

    /**
     * @Title: findBySid
     * @Description: TODO(根据sid查询)
     * @param sid
     * @param lstype
     * @return
     */
    List<Label_scheme_sumResponse> findBySid(@Param(value = "sid") Integer sid,
            @Param(value = "lstype") Integer lstype);

    /**
     * @Title: deleteLabelschemeBySid 
     * @Description: TODO(根据阶段或方案id删除) 
     * @param sid
     * @param lstype
     * @return
     */
    Integer deleteLabelschemeBySid(@Param(value = "sid") Integer sid, @Param(value = "lstype") Integer lstype);
}
