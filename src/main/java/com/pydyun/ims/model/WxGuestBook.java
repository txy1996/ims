package com.pydyun.ims.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * FileName: WxGuestbook
 * Author:   tangxiaoyu
 * Date:     2018/8/27 16:49
 * Description: TODO(微信:用户留言反馈)
 *
 * @since 1.0.0
 */
public class WxGuestBook implements Serializable {

    @Getter
    @Setter
    private Integer gbid;
    @Getter
    @Setter
    private Integer urid;
    @Getter
    @Setter
    private Integer auid;
    @Getter
    @Setter
    private String gbinfo;
    @Getter
    @Setter
    private String gbdate;
}
