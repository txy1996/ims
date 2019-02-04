package com.pydyun.ims.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName: WxUserCollectionShopResponse
 * @Description: TODO(微信:个人中心-我的收藏-商户返回封装类)
 * @author tangxiaoyu
 * @date 2018年8月9日 上午10:57:41
 *
 */
@Data
public class WxUserCollectionShopResponse extends WxUserCollection implements Serializable
{

    /**
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
     */
    private static final long serialVersionUID = 1L;
    
    private String sname;//商户名
    private String slogo;//商户形象图片，可以是LOGO，也可以是门头
    private String bname;//品牌名
    private String saddress;//地址
    private String stel;//订餐联系方式
    private String sstate;//营业状态
    private String voucher;//代金券
    private String offer;//优惠券
    
    

    
    
    
}
