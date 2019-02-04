package com.pydyun.ims.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * FileName: WxSchemeRecording
 * Author:   tangxiaoyu
 * Date:     2018/10/16 10:00
 * Description: TODO(微信端方案记录)
 *
 * @since 1.0.0
 */
@Data
public class WxSchemeRecording
{

    private Integer srid;//id
    private Integer urid;//用户id
    private Integer sid;//方案id
    private String username;//用户名称
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date date;//时间
    private String phone;//联系电话
    private Integer status;//状态(0:未处理,1:已处理)
}
