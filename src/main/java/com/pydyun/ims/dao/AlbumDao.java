package com.pydyun.ims.dao;

import java.util.List;

import com.pydyun.ims.model.Album;

public interface AlbumDao {

	List<Album> selectshop(Integer sid);

	void creabum(Album album);

	void delete(Integer aid);

	Album getalbum(Integer aid);

	void update(Album album);

	List<Album> selectshop1(Integer sid);

	List<Album> select1();
	
	/**
	 * @Title: selectShopAlbum 
	 * @Description: TODO(阶段所需的商家相册信息) 
	 * @param sid
	 * @return
	 */
	List<Album>selectShopAlbum(Integer sid);


}
