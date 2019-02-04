package com.pydyun.ims.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.pydyun.ims.model.Label;
import com.pydyun.ims.model.Label_class;

public interface LabelService
{

    /**
     * @Title: select
     * @Description: TODO(条件分页查询)
     * @param pageNum
     * @param pageSize
     * @param label
     * @return
     */
    PageInfo<Label> select(Integer pageNum, Integer pageSize, Integer lcid, Integer urid);

  
    List<Label> SelectAll(Integer lcid, Integer urid);
    
    void delete(Integer lid, Integer urid);

    Label getLabel(Integer lid);

    void update(Label label);

    Integer add(Label label);

    List<Label_class> list();

    Integer findid(String lcinfo);

    Label getLabel1(Integer lid);
}
