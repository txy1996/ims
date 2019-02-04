package com.pydyun.ims.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.pydyun.ims.dao.GuestBookDao;
import com.pydyun.ims.model.GuestBook;
import com.pydyun.ims.model.GuestBookResponse;
import com.pydyun.ims.service.GuestBookService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class GuestBookServiceImpl implements GuestBookService
{
    @Resource
    private GuestBookDao guestBookDao;


    /**
     * @param guestBook
     * @Description: TODO(新增用户留言回复)
     * @param:
     * @return:
     * @Date: 2018/8/28 14:42
     */
    @Override
    public GuestBook saveGuestBook(GuestBook guestBook) {
        guestBookDao.saveGuestBook(guestBook);
        return guestBook;
    }

    /**
     * @param pageNum
     * @param pageSize
     * @Description: TODO(查询所有用户留言)
     * @param:
     * @return:
     * @Date: 2018/8/28 14:42
     */
    @Override
    public PageInfo<GuestBookResponse> selectPage(Integer pageNum, Integer pageSize, String status) {
        PageHelper.startPage(pageNum, pageSize);
        List<GuestBookResponse> items = guestBookDao.findGuestBookUser(status);
        return new PageInfo<>(items);
    }

    /**
     * @param guestBook
     * @Description: TODO(查询用户留言详情)
     * @param:
     * @return:
     * @Date: 2018/8/28 14:43
     */
    @Override
    public List<GuestBook> getGuestBookDetails(GuestBook guestBook) {
        return guestBookDao.getGuestBookDetails(guestBook);
    }

    /**
     * @param list
     * @Description: TODO(查询用户留言和回复相关信息)
     * @param:
     * @return:
     * @Date: 2018/8/28 14:44
     */
    @Override
    public List<GuestBook> findGuestBookByGbid(List<Integer> list) {
        return guestBookDao.findGuestBookByGbid(list);
    }

    /**
     * @Description: TODO(删除用户留言和回复)
     * @param:
     * @return:
     * @Date: 2018/8/28 14:44
     */
    @Override
    public Integer deleteGuestBook(String gbids) {
        Gson gson = new Gson();
        List<Integer> list = gson.fromJson(gbids, new TypeToken<List<Integer>>()
        {
        }.getType());
        List<GuestBook> guestBooks = guestBookDao.findGuestBookByGbid(list);
        List<Integer> ids = new ArrayList<>();
        for (GuestBook guestBook : guestBooks) {
            ids.add(guestBook.getGbid());
        }
        return guestBookDao.deleteGuestBook(ids);
    }
}
