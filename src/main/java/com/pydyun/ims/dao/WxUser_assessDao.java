package com.pydyun.ims.dao;

import java.util.List;

import com.pydyun.ims.model.WxUserAssess;

import org.apache.ibatis.annotations.Param;

import com.pydyun.ims.model.WxUser_assess;

public interface WxUser_assessDao
{

    List<WxUser_assess> selectu(Integer sid);

    List<WxUser_assess> selectassess(@Param("uaoid") Integer uaoid);
    
    List<WxUser_assess> selectassess1(@Param("uaoid") Integer uaoid);

    List<String> selectassessimg(@Param("uaid") Integer uaid);

    List<WxUser_assess> comment(Integer id);

    /**
     * @Description: TODO(新增用户评论)
     * @param: wxUserAssess
     * @return:Integer
     * @Date: 2018/8/31 17:51
     */
    Integer saveWxUserAssess(WxUserAssess wxUserAssess);

    List<WxUser_assess> productcomment(Integer id);

    List<WxUser_assess> shopcomment(Integer id);


    /*根据对象id和类型查询评论列表*/
    List<WxUserAssess> findWxUserAssessByUaoid(@Param("uaoid") Integer uaoid, @Param("uaotype") Integer uaotype);

    Integer total(Integer id);

	Integer commentsum(Integer id);
}
