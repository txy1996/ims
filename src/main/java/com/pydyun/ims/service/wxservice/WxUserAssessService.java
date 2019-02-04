package com.pydyun.ims.service.wxservice;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.pydyun.ims.model.WxUserAssess;
import com.pydyun.ims.model.WxUserAssessRequest;
import com.pydyun.ims.model.WxUser_assess;

public interface WxUserAssessService
{
    List<WxUser_assess> selectassess(Integer uaoid);
    
    PageInfo<WxUser_assess> selectassess1(Integer uaoid,Integer pageNum,Integer pageSize);

    List<String> selectassessimg(Integer uaid);

    /**
     * @Description: TODO(新增用户评论)
     * @param: wxUserAssess
     * @return:Integer
     * @Date: 2018/8/31 17:51
     */
    WxUserAssess saveWxUserAssess(WxUserAssessRequest wxUserAssessRequest);

    /*根据对象id和类型查询评论列表*/
    List<WxUserAssess> findWxUserAssessByUaoid(Integer uaoid, Integer uaotype,boolean flag);
}
