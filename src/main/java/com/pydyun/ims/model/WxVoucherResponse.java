package com.pydyun.ims.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author tangxiaoyu
 * @ClassName: WxVoucherResponse
 * @Description: TODO(微信端代金券返回封装类)
 * @date 2018年8月8日 上午10:54:45
 */
@Data
public class WxVoucherResponse implements Serializable
{

    /**
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
     */
    private static final long serialVersionUID = 1L;

    private String vtitle;// 代金券名称
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date vsdate;// 代金券生效日期
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date vodate;// 代金券失效日期
    private String vimg;// 代金券图片（底图和二维码全部都在的）
    private Double vmoney;// 代金券面额
    private String vrange;// 代金券实用范围（全站all、品牌p:1,2,3、单店s：1，2,3）
    private String uvlstate;// 失效方式（未激活、激活、核销、失效、遗失）0代表失效的券，1代表正常的券，2代表延期的券，3代表未激活的券，4代表已激活的券，5代表已遗失的券，6代表已核销的券


}
