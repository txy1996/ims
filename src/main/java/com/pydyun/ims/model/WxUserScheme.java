package com.pydyun.ims.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * @author tangxiaoyu
 * @ClassName: WxUserScheme
 * @Description: TODO(微信 : 用户方案)
 * @date 2018年8月9日 上午10:11:36
 */
@Data
public class WxUserScheme implements Serializable
{

    /**
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
     */
    private static final long serialVersionUID = 1L;

    private Integer usid;//收藏ID
    private Integer usuid;//用户ID
    private Integer usscid;//方案分类id
    private String scname;//方案分类名称
    private Integer ussid;//方案ID，如果用户是基于我们推荐的scheme表中的某个方案修改的就填写本字段，否则字段为空，表示用户自行设计添加的
    private String ustitle;//方案名字
    private String usinfo;//方案的简单说明，字数100
    private String uspnum;//本方案适合人数，
    private String usduration;//本方案时间长度，格式为0.5, 1 , 1.5, 2, 2,5  3, 5, 7 ,10, 15
    private String usrange;//场地位置是公司内，还是外部寻找0=外出，1=内部
    private String usjson;//用户自定义的方案json字符串，具体格式，看文档附录一
    private String usdate;//操作时间
    private String usimg;//方案封面图片地址

    private Double usprice;//方案预算
    List<WxSchemeStage> stages;
    private List<WxUserAssess> wxUserAssesses;//评论

}
