package com.pydyun.ims.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pydyun.ims.dao.Goods_userDao;
import com.pydyun.ims.model.Goods_user;
import com.pydyun.ims.model.PointsGoldCoinsRequest;
import com.pydyun.ims.service.Goods_userService;

/**
 * @ClassName: Goods_userServiceImpl
 * @Description: TODO(用户金币日志管理service实现类)
 * @author tangxiaoyu
 * @date 2018年7月10日 上午9:42:21
 *
 */
@Service
public class Goods_userServiceImpl implements Goods_userService
{

    @Resource
    private Goods_userDao Goods_userDao;

    @Override
    public PageInfo<Goods_user> usermoney(Integer pageNum, Integer pageSize, PointsGoldCoinsRequest request)
    {
        PageHelper.startPage(pageNum, pageSize);
        List<Goods_user> list = Goods_userDao.selete(request);
        return new PageInfo<>(list);
    }

    @Override
    public void delete(Integer gid)
    {
        Goods_userDao.delete(gid);
    }

    @Override
    public Integer saveGoodsUser(Goods_user goods_user)
    {

        Goods_userDao.saveGoodsUser(goods_user);

        return goods_user.getGid();

    }

    @Override
    public Integer seleteNum(Integer urid)
    {
        return Goods_userDao.seleteNum(urid);
    }

    @Override
    public Integer save(Goods_user goods_user)
    {
        // TODO Auto-generated method stub
        return Goods_userDao.save(goods_user);
    }

    @Override
    public Integer seleteNumA(Integer urid)
    {
        // TODO Auto-generated method stub
        return Goods_userDao.seleteNumA(urid);
    }

}
