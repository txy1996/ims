package com.pydyun.ims.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.pydyun.ims.model.Scheme;
import com.pydyun.ims.model.SchemeIo;
import com.pydyun.ims.model.SchemeResponse;

public interface SchemeService
{
    // List<SchemeIo> getMessage(int id);
    PageInfo<Scheme> getSchemeMessage(Integer pageNum, Integer pageSize, Scheme scheme) throws Exception;

    /**
     * id对应消息
     * @param id
     * @return
     */
    Scheme getOneMessage(int id);

    /**
     * 更新方案信息
     * @param scheme
     */
    void updateScheme(Scheme scheme);

    /**
     * 删除方案信息
     * @param id
     */
    void delteScheme(int id);

    /**
     * 添加方案信息
     * @param scheme
     * @return
     */
    int addScheme(Scheme scheme);

    SchemeIo getMessageByid(int id);

    List<String> getSnameMessage();

    PageInfo<SchemeIo> getMessage(Integer pageNum, Integer pageSize, Integer id);

    /**
     * @Title: foundSchemeById
     * @Description: TODO(根据id查询方案详情)
     * @param sid
     * @return
     */
    SchemeResponse foundSchemeById(Integer sid);

	List<SchemeResponse> pscheme(String string);

	void deletesec(Integer id);

	PageInfo<Scheme> getSchemec(Integer pageNum, Integer pageSize,Integer scid,
			String choise, String timechoise, String naturechoise);

}
