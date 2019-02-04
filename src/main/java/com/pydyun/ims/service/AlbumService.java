package com.pydyun.ims.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.pydyun.ims.model.Album;

public interface AlbumService
{

    Integer creabum(Album album);

    void delete(Integer aid);

    Album getalbum(Integer aid);

    void updatealbum(Album album);

    PageInfo<Album> photolist(Integer pageNum, Integer pageSize, Integer sid);


    List<Album> select();

    /**
     * @Title: selectShopAlbum
     * @Description: TODO(阶段所需的商家相册信息)
     * @param sid
     * @return
     */
    List<Album> selectShopAlbum(Integer sid);

	PageInfo<Album> photolist1(Integer pageNum, Integer pageSize, Integer sid);

}
