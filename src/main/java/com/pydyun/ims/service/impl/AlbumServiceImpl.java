package com.pydyun.ims.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pydyun.ims.dao.AlbumDao;
import com.pydyun.ims.model.Album;
import com.pydyun.ims.service.AlbumService;

@Service
public class AlbumServiceImpl implements AlbumService
{
    @Resource
    private AlbumDao AlbumDao;

    @Override
    public PageInfo<Album> photolist(Integer pageNum, Integer pageSize, Integer sid)
    {
        PageHelper.startPage(pageNum, pageSize);
        List<Album> list = AlbumDao.selectshop(sid);
        return new PageInfo<>(list);
    }

    @Override
    public Integer creabum(Album album)
    {
        AlbumDao.creabum(album);
        return album.getAid();
    }

    @Override
    public void delete(Integer aid)
    {
        AlbumDao.delete(aid);
    }

    @Override
    public Album getalbum(Integer aid)
    {
        return AlbumDao.getalbum(aid);
    }

    @Override
    public void updatealbum(Album album)
    {
        AlbumDao.update(album);
    }

//    @Override
//    public PageInfo<Album> photolist1(Integer pageNum, Integer pageSize,Integer id)
//    {
//        PageHelper.startPage(pageNum, pageSize);
//        List<Album> list = AlbumDao.selectshop1(id);
//        return new PageInfo<>(list);
//
//    }

    @Override
    public List<Album> select()
    {
        List<Album> list = AlbumDao.select1();
        return list;
    }

    @Override
    public List<Album> selectShopAlbum(Integer sid)
    {

        return AlbumDao.selectShopAlbum(sid);
    }

	@Override
	public PageInfo<Album> photolist1(Integer pageNum, Integer pageSize,
			Integer sid) {
		PageHelper.startPage(pageNum, pageSize);
        List<Album> list = AlbumDao.selectshop1(sid);
        return new PageInfo<>(list);
	}
}
