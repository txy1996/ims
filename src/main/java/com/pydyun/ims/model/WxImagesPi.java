package com.pydyun.ims.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * FileName: WxImagesPi
 * Author:   tangxiaoyu
 * Date:     2018/8/31 17:59
 * Description: TODO(微信:评论图片表)
 *
 * @since 1.0.0
 */
@Data
public class WxImagesPi
{

    private Integer iid;//相片id
    private Integer plid;//评论id
    private String iurl;//资源地址
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date idate;//上传时间
    private Integer tfimg;//文件类型 0=图片,1=视频，2=嵌入式网页
}
