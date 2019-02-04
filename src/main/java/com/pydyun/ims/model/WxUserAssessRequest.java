package com.pydyun.ims.model;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * FileName: WxUserAssessRequest
 * Author:   tangxiaoyu
 * Date:     2018/9/5 10:13
 * Description: TODO(微信:用户评论请求封装类)
 *
 * @since 1.0.0
 */
@Data
public class WxUserAssessRequest
{

    private Integer uaid;//评价ID
    private Integer urid;//评价人ID
    private Integer uaoid;//被评价对象ID
    private Integer uaotype;//被评价对象的类型 0=商户，1=方案，2=阶段，3=商品
    private String ualabels;//所选择标签列表（1,2,3,4）
    private String uadate;//评价时间
    private Integer uaisanonymous;//是否匿名（默认匿名0=是，1=否）
    private String uainfo;//具体评价内容
    private Integer uanum;//本次给的具体分值
    private Integer isrm;//是否评论,0=未，1=已评论
    private Integer oid;//订单id
    private String onoun;//订单批次号
    private String urlJson;//图片
    private List<String> url;//图片
    private  List<MultipartFile> files;//文件

}
