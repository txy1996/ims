package com.pydyun.ims.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * FileName: SchemeRecordingResponse
 * Author:   tangxiaoyu
 * Date:     2018/10/16 9:41
 * Description: TODO(方案记录响应封装类)
 *
 * @since 1.0.0
 */
@Data
public class SchemeRecordingResponse
{
    private Integer srid;//id
    private Integer urid;//用户id
    private Integer sid;//方案id
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date date;//时间
    private String username;//用户名称
    private String sname;//方案名称
    private String phone;//联系电话
    private Integer status;//状态(0:未处理,1:处理中,2:已处理)
}
