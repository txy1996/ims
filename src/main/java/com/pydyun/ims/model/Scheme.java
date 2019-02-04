package com.pydyun.ims.model;

import lombok.Data;

import java.util.Date;

@Data
public class Scheme
{
    private Integer sid;//方案ID
    private Integer scid;//方案分类ID
    private Integer urid;//用户ID
    private String sname;//方案名
    private String sinfo;//方案介绍
    private Integer spraise;//被赞次数
    private Integer soppose;//被踩次数
    private Integer sstate;//方案状态（0预览、1预审、2公开、3过期）
    private Date sdate;//方案创建时间
    private String spnum;//本方案适合人数，
    private String sduration;//本方案时间长度，格式为
    private String srange;//本场地位置是公司内，还是外部寻找
    private Double sprice;//本方案预算
    private String simg;//方案封面图片
    private Scheme_class scheme_class;//	private String labelids;//方案所属的标签id集合

}
	
	
	

