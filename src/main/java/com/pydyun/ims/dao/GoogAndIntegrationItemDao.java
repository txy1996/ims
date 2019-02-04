package com.pydyun.ims.dao;

import java.util.List;

import com.pydyun.ims.model.GoogAndIntegrationItem;

/**
 * @ClassName: GoogAndIntegrationItemDao
 * @Description: TODO(金币积分操作项dao)
 * @author tangxiaoyu
 * @date 2018年7月14日 下午3:24:31
 *
 */
public interface GoogAndIntegrationItemDao
{

    /**
     * @Title: select
     * @Description: TODO(查询金币积分操作项)
     * @return
     */
    List<GoogAndIntegrationItem> select(GoogAndIntegrationItem item);

    /**
     * @Title: updateGoogAndIntegrationItem
     * @Description: TODO(修改积分金币操作项)
     * @param item
     * @return
     */
    Integer updateGoogAndIntegrationItem(GoogAndIntegrationItem item);

    /**
     * @Title: deleteById
     * @Description: TODO(删除积分金币操作项)
     * @param id
     * @return
     */
    Integer deleteById(Integer id);

    /**
     * @Title: addGoogAndIntegrationItem
     * @Description: TODO(新增积分金币操作项)
     * @param item
     * @return
     */
    Integer addGoogAndIntegrationItem(GoogAndIntegrationItem item);

}
