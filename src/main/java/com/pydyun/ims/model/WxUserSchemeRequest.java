package com.pydyun.ims.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * @author tangxiaoyu
 * @ClassName: WxUserSchemeRequest
 * @Description: TODO(微信 : 个人方案新增修改封装类)
 * @date 2018年8月17日 上午10:37:38
 */
@Data
public class WxUserSchemeRequest
{



    private Integer usid;//收藏ID
    private Integer usuid;//用户ID
    private Integer usscid;//方案分类id
    private String ussid;//方案ID，如果用户是基于我们推荐的scheme表中的某个方案修改的就填写本字段，否则字段为空，表示用户自行设计添加的
    private String ustitle;//方案名字
    private String usinfo;//方案的简单说明，字数100
    private String uspnum;//本方案适合人数，
    private String usduration;//本方案时间长度，格式为0.5, 1 , 1.5, 2, 2,5  3, 5, 7 ,10, 15
    private String usrange;//场地位置是公司内，还是外部寻找0=外出，1=内部
    private String usimg;//图片地址
    private Double usprice;//方案预算
    private List<WxSchemeStage> stages;


}
