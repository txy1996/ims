package com.pydyun.ims.service;




import java.util.List;

import com.github.pagehelper.PageInfo;
import com.pydyun.ims.model.Images;

public interface ImagesService {


	Integer creimages(Images images);

	void deleteimages(Integer iid);

	PageInfo<Images> photolist(Integer pageNum,Integer pageSize,Integer aid);

	Images getiid(Integer iid);

	void updateimages(Images images);
	
	/**
	 * @Title: selectshopImage 
	 * @Description: TODO(根据相册查询商户相册) 
	 * @param aid
	 * @return
	 */
	List<Images> selectshopImage(Integer aid);

}
