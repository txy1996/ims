package com.pydyun.ims.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pydyun.ims.model.Label;
import com.pydyun.ims.model.Label_class;

public interface LabelDao
{

    /**
     * @Title: select
     * @Description: TODO(条件分页查询)
     * @param label
     * @return
     */
    List<Label> select(@Param("lcid")Integer lcid,@Param("urid")Integer urid);

    void delete(@Param("lid")Integer lid,@Param("urid")Integer urid);

    Label getLabel(Integer lid);

    void update(Label label);

    void add(Label label);

    List<Label_class> list();

	Integer findid(String lcinfo);
	
	Label getLabel1(Integer lid);

}
