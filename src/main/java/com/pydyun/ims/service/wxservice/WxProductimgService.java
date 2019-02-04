package com.pydyun.ims.service.wxservice;

import java.util.List;

import com.pydyun.ims.model.WxProductimg;

/**
 * @ClassName: ProductimgService
 * @Description: TODO(商品图片)
 * @author tangxiaoyu
 * @date 2018年7月26日 下午2:33:10
 *
 */
public interface WxProductimgService
{

    List<WxProductimg> findimg(String ids);
}
