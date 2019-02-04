package com.pydyun.ims.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName: SchemeRequest 
 * @Description: TODO(方案修改封装类) 
 * @author tangxiaoyu 
 * @date 2018年8月3日 上午9:01:51 
 *
 */
@Data
public class SchemeRequest
{
    
    private Integer sid;
    private Integer scid;
    private Integer urid;
    private String sname;
    private String sinfo;
    private Integer sstate;
    private String spnum;//本方案适合人数，
    private String sduration;//本方案时间长度，格式为
    private String srange;//本场地位置是公司内，还是外部寻找
    private Double sprice;//本方案预算
    private String simg;//方案封面图片
    private String oldSimg;//方案图片路径,()
    private String newLabelids;//方案所属的标签id集合 new
    private String oldLabelids;//方案所属的标签id集合 old

    private Scheme_class scheme_class;


    
    

}
