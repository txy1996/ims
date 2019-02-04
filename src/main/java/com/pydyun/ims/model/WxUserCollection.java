package com.pydyun.ims.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName: WxUserCollection
 * @Description: TODO(用户对商户、商品、代金券的操作，比如收藏、使用、赞、踩)
 * @author tangxiaoyu
 * @date 2018年8月9日 上午11:01:12
 *
 */
@Data
public class WxUserCollection implements Serializable
{

    /**
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
     */
    private static final long serialVersionUID = 1L;

    private Integer ucid;// 收藏ID
    private Integer urid;// 用户ID
    private Integer oid;// 对象ID
    private Integer otype;// 对象类型 0=商户，1=商品，2=代金券，4….
    private Integer uctype;// 具体操作 0=使用，1=收藏，2=赞，3=踩，4=01,5=02,6=03,7=12,8=13
    private String ucdate;// 更改操作时间

    
    
}
