package com.pydyun.ims.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author tangxiaoyu
 * @ClassName: UserAssessPageResponse
 * @Description: TODO(用户评论分页条件查询封装类)
 * @date 2018年7月11日 上午11:10:09
 */
@Data
public class UserAssessPageResponse
{

    private Integer uaid;// 评价ID
    private Integer urid;// 用户ID
    private Integer uaoid;// 被评价对象ID
    private Integer uaotype;// 被评价对象的类型 0=商户，1=方案，2=阶段，3=商品
    private String username;// 评价人用户名
    private String schemename;// 方案名称
    private String shopname;// 被评价商户名称
    private String stage;// 阶段名称
    private String pname;// 商品名称
    private String uadate;// 评价时间
    private Integer uaisanonymous;// 是否匿名（默认匿名0=是，1=否）
    private String uainfo;// 具体评价内容
    private Integer uanum;// 本次给的具体分值
    private String ualabels;// 所选择标签列表（字符串,2,3,4）

    private String searchfor;// 选择的属性
    private String commentinfo;// 选择的信息


}
