package com.pydyun.ims.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * @author tangxiaoyu
 * @ClassName: WxUserSchemerListResponse
 * @Description: TODO(微信 : 个人方案列表返回封装类)
 * @date 2018年8月17日 下午3:00:06
 */
@Data
public class WxUserSchemerListResponse
{


    private Integer usid;//收藏ID
    private Integer sid;//方案id
    private String username;//用户名称
    private String superiorscname;//方案分类父类名称
    private String scname;//方案分类名
    private String ustitle;//方案名字
    private String usinfo;//方案的简单说明，字数100
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date usdate;//操作时间
    private String usimg;//方案图片地址
    private Double usprice;//方案预算
    private String uspnum;//本方案适合人数，
    private String usduration;//本方案时间长度，格式为0.5, 1 , 1.5, 2, 2,5  3, 5, 7 ,10, 15
    private String usrange;//场地位置是公司内，还是外部寻找0=外出，1=内部


}
