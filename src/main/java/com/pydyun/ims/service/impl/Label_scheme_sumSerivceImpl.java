package com.pydyun.ims.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pydyun.ims.dao.Label_scheme_sumDao;
import com.pydyun.ims.model.Label_scheme_sum;
import com.pydyun.ims.model.Label_scheme_sumResponse;
import com.pydyun.ims.service.Label_scheme_sumSerivce;

/**
 * @ClassName: Label_scheme_sumSerivceImpl
 * @Description: TODO(方案、方案所属阶段。被用户选择的标签记录表)
 * @author tangxiaoyu
 * @date 2018年7月18日 下午8:33:29
 *
 */
@Service
public class Label_scheme_sumSerivceImpl implements Label_scheme_sumSerivce
{

    @Resource
    private Label_scheme_sumDao Label_scheme_sumDao;

    @Override
    public Integer addLabelscheme(Label_scheme_sum laSum)
    {
        // TODO Auto-generated method stub
        return Label_scheme_sumDao.addLabelscheme(laSum);
    }

    @Override
    public Integer deleteLabelscheme(Integer sid, List<Integer> list)
    {
        // TODO Auto-generated method stub
        return Label_scheme_sumDao.deleteLabelscheme(sid, list);
    }

    @Override
    public Integer findfabyid(Integer lid)
    {
        // TODO Auto-generated method stub
        return Label_scheme_sumDao.findfabyid(lid);
    }

    @Override
    public Integer findjdbyid(Integer lid)
    {
        // TODO Auto-generated method stub
        return Label_scheme_sumDao.findjdbyid(lid);
    }

    @Override
    @Transactional
    public Integer addLabelschemelist(List<Label_scheme_sum> lSums)
    {
        // TODO Auto-generated method stub
        return Label_scheme_sumDao.addLabelschemelist(lSums);
    }

    @Override
    public List<Label_scheme_sumResponse> findBySid(Integer sid, Integer lstype)
    {
        // TODO Auto-generated method stub
        return Label_scheme_sumDao.findBySid(sid, lstype);
    }

    @Override
    public Integer deleteLabelschemeBySid(Integer sid, Integer lstype)
    {
        // TODO Auto-generated method stub
        return Label_scheme_sumDao.deleteLabelschemeBySid(sid, lstype);
    }

    

}
