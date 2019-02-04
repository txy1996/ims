package com.pydyun.ims.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author tangxiaoyu
 * @ClassName: SchemeAndStageResponse
 * @Description: TODO(所属方案阶段详情)
 * @date 2018年7月16日 下午4:44:24
 */
@Data
public class SchemeAndStageResponse
{


    private Integer ssid;// 阶段id
    private Integer sid;// 所属方案id
    private Integer shopid;// 主推商家id
    private String ssname;// 阶段名
    private String ssinfo;// 阶段介绍
    private String sad;// 推荐广告词
    private String sname;// 主推商家名称
    private String slogo;// 商户形象图片
    private String styleimg;// 商户正在前台展示的，从商户自有相册中选择出来的形象展示图片，多张图片之间用逗号隔开，例如
    private String ssimgs;
    private String lsnum;// 标签被选择次数
    private String labels;// 阶段所选标签
    private String sssid;// 方案所含阶段商家列表
    private String lssid;// 阶段所选标签id


}
