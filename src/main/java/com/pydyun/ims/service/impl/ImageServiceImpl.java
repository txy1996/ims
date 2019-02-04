package com.pydyun.ims.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pydyun.ims.dao.ImageDao;
import com.pydyun.ims.model.Image;
import com.pydyun.ims.service.ImageService;
@Service
public class ImageServiceImpl implements ImageService{
	@Autowired
	private ImageDao idao;
	@Override
	public int addImage(Image image) {
		idao.addImage(image);
		return image.getId();
	}
	
}
