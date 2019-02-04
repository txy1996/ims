package com.pydyun.ims.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * @author tangxiaoyu
 * @ClassName: WxSchemeStage
 * @Description: TODO(微信 : 方案阶段)
 * @date 2018年8月17日 上午10:53:42
 */
@Data
public class WxSchemeStage
{


    private Integer id;//阶段id
    private String stage;// 阶段名
    private String info;// 阶段介绍
    private List<WxStageShop> shops;//商户


}
