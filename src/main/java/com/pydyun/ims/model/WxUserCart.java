package com.pydyun.ims.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * @author tangxiaoyu
 * @ClassName: WxUserCart
 * @Description: TODO(微信 : 购物车表)
 * @date 2018年8月23日 上午11:35:04
 */
@Data
public class WxUserCart  {


    private static final long serialVersionUID = 1L;

    private Integer id;
    private Integer uid;// 用户id
    private Integer oid;// 商品或代金券id
    private Integer otype;// 类型 0=商品，1=代金券
    private Integer number;// 数量
    private Integer status;// 状态，0=勾选，1=未勾选 勾选就可以进入下一步生成订单，不勾选则不能进入生成订单环节
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date createTime;// 创建时间
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date updateTime;// 更新时间
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date stime;//预定开始时间  主要场地类用
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date otime;//预定结束时间  主要场地类用
    private Integer pnum;//预定人数 主要场地类用



}
