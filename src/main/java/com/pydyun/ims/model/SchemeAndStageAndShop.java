package com.pydyun.ims.model;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;

/**
 * @author tangxiaoyu
 * @ClassName: SchemeAndStageAndShop
 * @Description: TODO(方案所含阶段商家列表)
 * @date 2018年7月20日 下午11:07:15
 */
@Data
public class SchemeAndStageAndShop implements Serializable
{

    /**
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
     */
    private static final long serialVersionUID = 1L;

    private int sssid;// 列表ID
    private int shopid;// 商户ID
    private int ssid;// 所属方案阶段ID
    private int ssort;// 排序号
    private String ssimgs;// 图片列表（调用图片表中商家图片ID，不是相册ID 1,12,3,5,56）
    private String sreplace;// 多个替换商家ID(商户ID 1,2,3)
    private ArrayList<Integer> pid;
    private ArrayList<Integer> num;


}
