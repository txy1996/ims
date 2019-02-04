package com.pydyun.ims.model;

import lombok.Data;

/**
 * FileName: GuestBookResponse
 * Author:   tangxiaoyu
 * Date:     2018/8/28 15:45
 * Description: TODO(留言返回封装类)
 *
 * @since 1.0.0
 */
@Data
public class GuestBookResponse
{


    private Integer gbid;

    private Integer urid;

    private Integer auid;

    private String gbinfo;

    private String gbdate;

    private String username;
}
