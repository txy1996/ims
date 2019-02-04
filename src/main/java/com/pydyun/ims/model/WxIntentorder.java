package com.pydyun.ims.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
@Data
public class WxIntentorder {
	
	private Integer id;
	private Integer scid;//对应分类ID
	private Integer treat;//区分方案和商品（0代表方案，1代表商品）
	private String choise;//规模
	private String timechoise;//时长
	private String naturechoise;//性质
	private String needchoise;//需求
	private Integer state;//状态（0为未处理，1为已处理）
	private String starttime;//选择开始时间
	private String tel;//获取电话
	private String name;//获取名字
	private String remarks;//填写需求的关键信息
	private String firstPerson;//任务（如：会议方案，拓展方案，培训方案等）
	private Integer urid;
	
}
