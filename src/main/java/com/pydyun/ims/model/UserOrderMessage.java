package com.pydyun.ims.model;

import lombok.Data;

/**
 * FileName: UserOrderMessage
 * Author:   tangxiaoyu
 * Date:     2018/9/4 11:21
 * Description: TODO(用户订单留言封装)
 *
 * @since 1.0.0
 */
@Data
public class UserOrderMessage
{

    private Integer sid;//商户id
    private String omsg;//留言信息
}
