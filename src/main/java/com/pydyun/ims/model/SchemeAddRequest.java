package com.pydyun.ims.model;

import lombok.Data;

/**
 * FileName: SchemeAddRequest
 * Author:   tangxiaoyu
 * Date:     2018/9/7 17:12
 * Description: TODO(方案新增封装类)
 *
 * @since 1.0.0
 */
@Data
public class SchemeAddRequest
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
    private String Simg;//方案封面图片
    private String newLabelids;//方案所属的标签id集合 new
    private String oldLabelids;//方案所属的标签id集合 old
}
