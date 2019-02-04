package com.pydyun.ims.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author tangxiaoyu
 * @ClassName: SchemeStageRequest
 * @Description: TODO(关于方案阶段新增修改操作的数据)
 * @date 2018年7月20日 下午4:20:04
 */
@Data
public class SchemeStageRequest implements Serializable
{

    /**
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
     */
    private static final long serialVersionUID = 1L;

    private Integer ssid;//阶段ID
    private Integer sid;//所属方案ID
    private String ssname;//阶段名
    private String ssinfo;//阶段介绍
    private Integer shopid;//商户ID
    private String ssimgs;//图片列表（调用图片表中商家图片ID，不是相册ID  1,12,3,5,56）
    private String sreplace;//多个替换商家ID(商户ID 1,2,3)
    private String newLabels;//标签id
    private Integer sssid;//列表ID
    private String oldLabels;//标签记录表id
    private String newLabelids;//阶段所属的标签id集合 new
    private String oldLabelids;//阶段所属的标签id集合 old
    private String pids;//商品id集合
    private String pnumber;//对应的商品数量


}
