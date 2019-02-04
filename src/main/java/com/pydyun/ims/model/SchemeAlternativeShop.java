package com.pydyun.ims.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author tangxiaoyu
 * @ClassName: AlternativeShop
 * @Description: TODO(方案阶段备选商家)
 * @date 2018年7月16日 下午4:38:30
 */
@Data
public class SchemeAlternativeShop
{
    private Integer ssid;// 阶段id
    private Integer sid;// 商户id
    private String sname;// 商户名称
    private String sad;// 编辑推荐(广告词)
    private String slogo;// 商户形象图片
    private String styleimg;// 商户正在前台展示的，从商户自有相册中选择出来的形象展示图片，多张图片之间用逗号隔开，例如
    private String sreplace;//备选商家



}
