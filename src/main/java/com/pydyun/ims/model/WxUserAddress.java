package com.pydyun.ims.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName: WxUserAddress
 * @Description: TODO(微信:用户地址)
 * @author tangxiaoyu
 * @date 2018年8月10日 上午11:26:36
 *
 */
@Data
public class WxUserAddress
{

    private Integer uaid;// 地址id
    private Integer uauid;// 所属用户
    private Integer uaone;// 是否默认地址,0否1是
    private String uaname;// 收件人名
    private String uatel;// 收件人电话
    private String uaaddress;// 详细地址


}
