package com.pydyun.ims.service;

import com.github.pagehelper.PageInfo;
import com.pydyun.ims.model.GuestBook;
import com.pydyun.ims.model.GuestBookResponse;

import java.util.List;

public interface GuestBookService
{

    /**
     * @Description: TODO(新增用户留言回复)
     * @param:
     * @return:
     * @Date: 2018/8/28 14:42
     */

    GuestBook saveGuestBook(GuestBook guestBook);

    /**
     * @Description: TODO(条件查询用户留言)
     * @param:
     * @return:
     * @Date: 2018/8/28 14:42
     */

    PageInfo<GuestBookResponse> selectPage(Integer pageNum, Integer pageSize, String status);

    /**
     * @Description: TODO(查询用户留言详情)
     * @param:
     * @return:
     * @Date: 2018/8/28 14:43
     */

    List<GuestBook> getGuestBookDetails(GuestBook guestBook);

    /**
     * @Description: TODO(查询用户留言和回复相关信息)
     * @param:
     * @return:
     * @Date: 2018/8/28 14:44
     */

    List<GuestBook> findGuestBookByGbid(List<Integer> list);

    /**
     * @Description: TODO(删除用户留言和回复)
     * @param:
     * @return:
     * @Date: 2018/8/28 14:44
     */

    Integer deleteGuestBook(String list);

}
