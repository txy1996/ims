package com.pydyun.ims.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * FileName: WxOrdersDetailsResponse
 * Author:   tangxiaoyu
 * Date:     2018/9/1 14:33
 * Description: TODO(微信:订单详情返回封装类,顶级类)
 *
 * @since 1.0.0
 */
@Data
public class WxOrdersDetailsResponse
{

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date time;//下单时间
    private Double lumpSum;//商品总额
    private Integer sunNum;//商品总数量
    private String numbering;//订单批次号
    private String oshname;// 收货人名字
    private String oshtel;// 收货人联系电话
    private String oshaddress;// 收货人地址
    List<WxOrdersResponse> wxOrdersResponses;//子订单详情

}
