package com.pydyun.ims.util;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.pydyun.ims.dao.SchemeDao;
import com.pydyun.ims.dao.Scheme_stageDao;

/**
 * @ClassName: UserCollectionScheme
 * @Description: TODO(用户收藏方案转换工具类)
 * @author tangxiaoyu
 * @date 2018年8月10日 上午9:19:56
 *
 */
@Component
public class UserCollectionScheme
{
    @Resource
    private SchemeDao schemeDao;
    @Resource
    private Scheme_stageDao scheme_stageDao;

    private static UserCollectionScheme scheme;

    @PostConstruct
    public void init()
    {
        scheme = this;
        scheme.schemeDao = this.schemeDao;
        scheme.scheme_stageDao = this.scheme_stageDao;
    }
}
