package com.pydyun.ims.service.impl.wximpl;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.pydyun.ims.dao.WxGuestBookDao;
import com.pydyun.ims.model.WxGuestBook;
import com.pydyun.ims.service.wxservice.WxGuestBookService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * FileName: WxGuestBookServiceImpl
 * Author:   tangxiaoyu
 * Date:     2018/8/28 9:31
 * Description: TODO(微信:用户留言)
 *
 * @since 1.0.0
 */
@Service
public class WxGuestBookServiceImpl implements WxGuestBookService
{

    @Resource
    private WxGuestBookDao wxGuestBookDao;

    /**
     * @param wxGuestBook
     * @Description: TODO(新增用户留言及回复)
     * @param:
     * @return:
     * @Date: 2018/8/28 9:19
     */
    @Override
    public WxGuestBook saveWxGuestBook(WxGuestBook wxGuestBook) {
        wxGuestBookDao.saveWxGuestBook(wxGuestBook);
        return wxGuestBook;
    }

    /**
     * @param wxGuestBook
     * @Description: TODO(查看用户留言记录)
     * @param:
     * @return:
     * @Date: 2018/8/28 9:18
     */
    @Override
    public List<WxGuestBook> findWxGuestBookUserMessage(WxGuestBook wxGuestBook) {

        return wxGuestBookDao.findWxGuestBookUserMessage(wxGuestBook);
    }

    /**
     * @param wxGuestBook
     * @Description: TODO(查看系统回复)
     * @param:
     * @return:
     * @Date: 2018/8/28 9:18
     */
    @Override
    public List<WxGuestBook> findWxGuestBookSystemReply(WxGuestBook wxGuestBook) {
        return wxGuestBookDao.findWxGuestBookSystemReply(wxGuestBook);
    }

    /**
     * @param wxGuestBook
     * @Description: TODO(查询用户留言和这条留言的回复)
     * @param:
     * @return:
     * @Date: 2018/8/28 9:16
     */
    @Override
    public List<WxGuestBook> findWxGuestBookByGbid(List<Integer> list) {
        return wxGuestBookDao.findWxGuestBookByGbid(list);
    }

    /**
     * @param list
     * @Description: TODO(微信 : 删除用户留言信息)
     * @param:
     * @return:
     * @Date: 2018/8/28 9:10
     */
    @Override
    public Integer deleteWxGuestBook(String gbids) {
        Gson gson = new Gson();
        List<Integer> list = gson.fromJson(gbids, new TypeToken<List<Integer>>()
        {
        }.getType());
        List<WxGuestBook> wxGuestBooks = wxGuestBookDao.findWxGuestBookByGbid(list);
        List<Integer> ids = new ArrayList<>();
        for (WxGuestBook wxGuestBook : wxGuestBooks) {
            ids.add(wxGuestBook.getGbid());
        }
        return wxGuestBookDao.deleteWxGuestBook(ids);
    }
}
