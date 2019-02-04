package com.pydyun.ims.model;

import lombok.Data;


/**
 * @author tangxiaoyu
 * @ClassName: SchemeResponse
 * @Description: TODO(方案详情返回封装类)
 * @date 2018年7月16日 上午9:57:31
 */
@Data
public class SchemeResponse
{


    private int sid;//方案id
    private String scname;//方案分类名
    private String username;//用户名称
    private int urid;//用户id
    private int scid;//方案分类id
    private String sname;//方案名
    private String sinfo;//方案介绍
    private int spraise;//被赞次数
    private int soppose;//被踩次数
    private int sstate;//方案状态
    private String sdate;//方案创建时间
    private String spnum;//本方案适合人数，
    private String sduration;//本方案时间长度，格式为
    private String srange;//本场地位置是公司内，还是外部寻找
    private Double sprice;//本方案预算
    private String simg;//方案封面图片
    private String lsnum;//标签选择次数
    private String labels;//标签名称


}
