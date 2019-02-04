package com.pydyun.ims.model;

import lombok.Data;

/**
 * @Description: TODO(后台 : 系统回复留言)
 * @param:
 * @return:
 * @Date: 2018/8/28 13:58
 */

@Data
public class GuestBook
{
    private Integer gbid;
    private Integer urid;
    private Integer auid;
    private String gbinfo;
    private String gbdate;


}
