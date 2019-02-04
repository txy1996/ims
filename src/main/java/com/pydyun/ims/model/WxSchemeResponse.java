package com.pydyun.ims.model;

import lombok.Data;

/**
 * FileName: WxSchemeResponse
 * Author:   tangxiaoyu
 * Date:     2018/9/29 11:00
 * Description: TODO(微信:方案返回封装类)
 *
 * @since 1.0.0
 */
@Data
public class WxSchemeResponse
{

    private Integer sid;//方案id
    private String scname;//方案分类名
    private String username;//用户名称
    private Integer urid;//用户id
    private Integer scid;//方案分类id
    private String sname;//方案名
    private String sinfo;//方案介绍
    private Integer spraise;//被赞次数
    private Integer soppose;//被踩次数
    private Integer sstate;//方案状态
    private String sdate;//方案创建时间
    private String spnum;//本方案适合人数，
    private String sduration;//本方案时间长度，格式为
    private String srange;//本场地位置是公司内，还是外部寻找
    private Double sprice;//本方案预算
    private String simg;//方案封面图片

}
