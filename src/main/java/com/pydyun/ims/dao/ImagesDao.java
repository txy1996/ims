package com.pydyun.ims.dao;

import java.util.List;

import com.pydyun.ims.model.Images;

public interface ImagesDao {

	List<Images> selectshop(Integer aid);

	void cre(Images images);

	void delete(Integer iid);

	Images getiid(Integer iid);

	void updateimages(Images images);

}
