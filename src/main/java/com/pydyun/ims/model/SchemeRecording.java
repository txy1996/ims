package com.pydyun.ims.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * FileName: SchemeRecording
 * Author:   tangxiaoyu
 * Date:     2018/10/16 9:18
 * Description: TODO(方案记录表)
 *
 * @since 1.0.0
 */
@Data
public class SchemeRecording
{

    private Integer srid;//id
    private Integer urid;//用户id
    private Integer sid;//方案id
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date date;//时间
    private String phone;//联系电话
    private Integer status;//状态(0:未处理,1:已处理)
}
