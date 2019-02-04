package com.pydyun.ims.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * FileName: WxAssessImage
 * Author:   tangxiaoyu
 * Date:     2018/9/5 9:37
 * Description: TODO(微信:用户评论所属图片表)
 *
 * @since 1.0.0
 */
@Data
public class WxAssessImage
{

    private Integer iid;//id
    private Integer plid;//评论id
    private String iurl;//资源地址
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date idate;//上传时间
    private Integer tfimg;//是否是图片 0=图片,1=视频，2=嵌入式网页
}
