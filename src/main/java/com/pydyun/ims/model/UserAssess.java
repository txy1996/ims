package com.pydyun.ims.model;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author tangxiaoyu
 * @ClassName: UserAssess
 * @Description: TODO(用户评论表)
 * @date 2018年7月11日 上午9:21:33
 */
@Data
public class UserAssess
{
    private Integer uaid;//评价ID
    private Integer urid;//评价人ID
    private Integer faid;//方案ID
    private Integer shopid;//被评价商户ID
    private Integer uaoid;//被评价对象ID
    private Integer uaotype;//被评价对象的类型 0=商户，1=方案，2=阶段，3=商品
    private String ualabels;//所选择标签列表（1,2,3,4）
    private String uadate;//评价时间
    private Integer uaisanonymous;//是否匿名（默认匿名0=是，1=否）
    private String uainfo;//具体评价内容
    private Integer uanum;//本次给的具体分值
    private List<Label> labels;//标签表

}
