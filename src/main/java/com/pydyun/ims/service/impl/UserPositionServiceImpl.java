package com.pydyun.ims.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pydyun.ims.dao.CompanyDAO;
import com.pydyun.ims.dao.PositionDao;
import com.pydyun.ims.dao.UserDAO;
import com.pydyun.ims.model.User_position;
import com.pydyun.ims.service.UserPositionService;
@Service
public class UserPositionServiceImpl implements UserPositionService {
	@Resource
	private PositionDao positionDao;
	@Resource
	private CompanyDAO cdao;
	@Resource
	private UserDAO ud;
//	private IntegrationsDao integ;
	@Override
	public PageInfo<User_position> queryAll(Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum,pageSize);
		List<User_position> userPosition = positionDao.queryAll();
		return new PageInfo<>(userPosition);
	}
	@Override
	public User_position queryById(int id) {
		// TODO Auto-generated method stub
		return positionDao.selPositionById(id);
	}
	@Override
	public void deletePositon(int id) {
		User_position uposition = positionDao.selPositionById(id);
		if(uposition !=null) {
			positionDao.deletePositon(id);
		}
	}
	
	@Override
	public int addPosition(User_position position) {
		// TODO Auto-generated method stub
		positionDao.addPosition(position);
		return position.getUpid();
	}
	@Override
	public void updatePosition(User_position position) {
		// TODO Auto-generated method stub
		positionDao.updatePosition(position);
	}
	@Override
	public List<String> getMessage() {
		// TODO Auto-generated method stub
		return positionDao.getMessage();
	}
	@Override
	public List<String> getCompanyMsg() {
		// TODO Auto-generated method stub
		return cdao.getName();
	}
	@Override
	public List<String> getUsername() {
		// TODO Auto-generated method stub
		return ud.getName();
	}
}
