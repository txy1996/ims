package com.pydyun.ims.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author tangxiaoyu
 * @ClassName: Label_scheme_sum
 * @Description: TODO(方案 、 方案所属阶段 。 被用户选择的标签记录表)
 * @date 2018年7月18日 下午7:25:54
 */
@Data
public class Label_scheme_sum implements Serializable
{

    /**
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
     */
    private static final long serialVersionUID = 1L;

    private Integer lssid;//主键id
    private Integer sid;//方案或阶段ID
    private Integer lid;//标签ID
    private Integer lsnum;//被选择次数
    private Integer lstype;//是关联的方案还是方案中的阶段  0=方案，1=阶段


}
