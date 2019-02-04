package com.pydyun.ims.dao;

import com.pydyun.ims.model.WxGuestBook;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * FileName: WxGuestBookDao
 * Author:   tangxiaoyu
 * Date:     2018/8/27 17:00
 * Description: TODO(这里用一句话描述这个类的作用)
 *
 * @since 1.0.0
 */
public interface WxGuestBookDao
{

    /**
     * @Description: TODO(新增用户留言及回复)
     * @param:
     * @return:
     * @Date: 2018/8/28 9:19
     */

    Integer saveWxGuestBook(WxGuestBook wxGuestBook);

    /**
     * @Description: TODO(查看用户留言记录)
     * @param:
     * @return:
     * @Date: 2018/8/28 9:18
     */

    List<WxGuestBook> findWxGuestBookUserMessage(WxGuestBook wxGuestBook);

    /**
     * @Description: TODO(查看系统回复)
     * @param:
     * @return:
     * @Date: 2018/8/28 9:18
     */

    List<WxGuestBook> findWxGuestBookSystemReply(WxGuestBook wxGuestBook);

    /**
     * @Description: TODO(查询用户留言和这条留言的回复)
     * @param:
     * @return:
     * @Date: 2018/8/28 9:16
     */

    List<WxGuestBook> findWxGuestBookByGbid(@Param("list") List<Integer> list);

    /**
     * @Description: TODO(微信 : 删除用户流言信息)
     * @param:
     * @return:
     * @Date: 2018/8/28 9:10
     */
    Integer deleteWxGuestBook(@Param("list") List<Integer> list);

}
