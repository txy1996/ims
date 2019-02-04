package com.pydyun.ims.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pydyun.ims.model.Scheme;
import com.pydyun.ims.model.SchemeIo;
import com.pydyun.ims.model.SchemeResponse;

public interface SchemeDao
{
    // List<SchemeIo> selectBySid(int id);
    List<Scheme> getMessage(Scheme scheme);

    Scheme getOneMessage(int id);

    /**
     * 更新方案信息
     * @param scheme
     */
    void updateScheme(Scheme scheme);

    /**
     * 删除方案
     * @param id
     */
    void deleteScheme(int id);

    /**
     * 添加方案信息
     * @param scheme
     */
    void addScheme(Scheme scheme);

    SchemeIo getMessageByid(int id);

    /**
     * 获取方案名称的集合
     * @return
     */
    List<String> getSname();

    List<SchemeIo> selectBySid(Integer id);

    /**
     * @Title: foundSchemeById
     * @Description: TODO(根据id查询方案详情)
     * @param sid
     * @return
     */
    SchemeResponse foundSchemeById(Integer sid);

    /**
     * @Title: getSchemeByid 
     * @Description: TODO(根据方案id查询方案名称,介绍) 
     * @param sid
     * @return
     */
    Scheme getSchemeByid(Integer sid);

	List<SchemeResponse> pscheme(String string);

	void deletesec(Integer id);

	List<Scheme> getSchemec(@Param("scid")Integer scid, @Param("choise")String choise, @Param("timechoise")String timechoise,
			@Param("naturechoise")String naturechoise);

}
