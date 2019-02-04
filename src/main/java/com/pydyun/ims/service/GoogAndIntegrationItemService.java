package com.pydyun.ims.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.pydyun.ims.model.GoogAndIntegrationItem;

/**
 * @ClassName: GoogAndIntegrationItemService
 * @Description: TODO(金币积分记录操作项)
 * @author tangxiaoyu
 * @date 2018年7月14日 下午3:26:32
 *
 */
public interface GoogAndIntegrationItemService
{

    /**
     * @Title: select
     * @Description: TODO(查询金币积分操作项)
     * @return
     */
    List<GoogAndIntegrationItem> select(GoogAndIntegrationItem item);

    /**
     * @Title: select
     * @Description: TODO(查询金币积分操作项)
     * @return
     */
    List<GoogAndIntegrationItem> selectItemXML();

    /**
     * @Title: selectPage
     * @Description: TODO(分页查询)
     * @param pageNum
     * @param pageSize
     * @param item
     * @return
     */
    PageInfo<GoogAndIntegrationItem> selectPage(Integer pageNum, Integer pageSize, GoogAndIntegrationItem item);

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
