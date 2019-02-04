package com.pydyun.ims.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pydyun.ims.dao.SchemeDao;
import com.pydyun.ims.model.Scheme;
import com.pydyun.ims.model.SchemeIo;
import com.pydyun.ims.model.SchemeResponse;
import com.pydyun.ims.service.SchemeService;

@Service
public class SchemeServiceImpl implements SchemeService
{
    @Resource
    private SchemeDao schemeDao;


    /**
     * 查看所有方案信息 并进行分页
     */
    @Override
    public PageInfo<Scheme> getSchemeMessage(Integer pageNum, Integer pageSize, Scheme schemerequest) throws Exception {
        PageHelper.startPage(pageNum, pageSize);

        if (schemerequest.getSpnum() == null || schemerequest.getSpnum().isEmpty()) {
            schemerequest.setSpnum(null);
        }
        if (schemerequest.getSduration() == null || schemerequest.getSduration().isEmpty()) {
            schemerequest.setSduration(null);
        }
        if (schemerequest.getSrange() == null || schemerequest.getSrange().isEmpty()) {
            schemerequest.setSrange(null);
        }
        List<Scheme> scheme = schemeDao.getMessage(schemerequest);
        return new PageInfo<>(scheme);
    }


    /**
     * id对应消息
     */
    @Override
    public Scheme getOneMessage(int id) {
        return schemeDao.getOneMessage(id);
    }

    @Override
    public void updateScheme(Scheme scheme) {
        schemeDao.updateScheme(scheme);
    }

    @Override
    public void delteScheme(int id) {
        if (schemeDao.getOneMessage(id) != null) {
            schemeDao.deleteScheme(id);
        }
    }

    @Override
    public int addScheme(Scheme scheme) {
        schemeDao.addScheme(scheme);
        return scheme.getSid();
    }

    @Override
    public SchemeIo getMessageByid(int id) {
        SchemeIo io = schemeDao.getMessageByid(id);
        return io;
    }

    @Override
    public List<String> getSnameMessage() {
        // TODO Auto-generated method stub
        return schemeDao.getSname();
    }

    @Override
    public PageInfo<SchemeIo> getMessage(Integer pageNum, Integer pageSize, Integer id) {
        PageHelper.startPage(pageNum, pageSize);
        List<SchemeIo> list = schemeDao.selectBySid(id);
        return new PageInfo<>(list);
    }

    /**
     * 根据id查询方案详情
     */
    @Override
    public SchemeResponse foundSchemeById(Integer sid) {

        return schemeDao.foundSchemeById(sid);
    }


	@Override
	public List<SchemeResponse> pscheme(String string) {
		return schemeDao.pscheme(string);
	}


	@Override
	public void deletesec(Integer id) {
		schemeDao.deletesec(id);
	}


	@Override
	public PageInfo<Scheme> getSchemec(Integer pageNum, Integer pageSize,Integer scid,
			String choise, String timechoise, String naturechoise) {
		PageHelper.startPage(pageNum, pageSize);
		List<Scheme> list = schemeDao.getSchemec(scid,choise,timechoise,naturechoise);
		return null;
	}


}
