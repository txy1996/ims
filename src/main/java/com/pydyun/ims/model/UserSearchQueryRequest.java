package com.pydyun.ims.model;

import java.io.Serializable;

/**
 * @ClassName: UserSearchQueryRequest
 * @Description: TODO(用户搜索查询封装类)
 * @author tangxiaoyu
 * @date 2018年7月7日 下午8:59:57
 *
 */
public class UserSearchQueryRequest implements Serializable
{

    /**
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
     */
    private static final long serialVersionUID = 1L;

    private String username;// 登录名
//    private String urtname;// 真实姓名
    private String real_name;// 真实姓名
    private String mobile;// 手机号码
    private Integer isum;// 用户当前积分总额
    private Integer gnum;// 当前金币数量
    private Integer vmoney;// 代金券总额
    private Integer coupon;// 优惠券数量
    private Integer minNum;// 最小数量
    private Integer maxNum;// 最大数量
    
	public UserSearchQueryRequest(String username, String real_name,
			String mobile, Integer isum, Integer gnum, Integer vmoney,
			Integer coupon, Integer minNum, Integer maxNum) {
		super();
		this.username = username;
		this.real_name = real_name;
		this.mobile = mobile;
		this.isum = isum;
		this.gnum = gnum;
		this.vmoney = vmoney;
		this.coupon = coupon;
		this.minNum = minNum;
		this.maxNum = maxNum;
	}
	public UserSearchQueryRequest() {
		super();
	}
	public String getReal_name() {
		return real_name;
	}
	public void setReal_name(String real_name) {
		this.real_name = real_name;
	}
	public String getUsername()
    {
        return username;
    }
    public void setUsername(String username)
    {
        this.username = username;
    }
 /*   public String getUrtname()
    {
        return urtname;
    }
    public void setUrtname(String urtname)
    {
        this.urtname = urtname;
    }*/
    public String getMobile()
    {
        return mobile;
    }
    public void setMobile(String mobile)
    {
        this.mobile = mobile;
    }
    public Integer getIsum()
    {
        return isum;
    }
    public void setIsum(Integer isum)
    {
        this.isum = isum;
    }
    public Integer getGnum()
    {
        return gnum;
    }
    public void setGnum(Integer gnum)
    {
        this.gnum = gnum;
    }
    public Integer getVmoney()
    {
        return vmoney;
    }
    public void setVmoney(Integer vmoney)
    {
        this.vmoney = vmoney;
    }
    public Integer getCoupon()
    {
        return coupon;
    }
    public void setCoupon(Integer coupon)
    {
        this.coupon = coupon;
    }
    public Integer getMinNum()
    {
        return minNum;
    }
    public void setMinNum(Integer minNum)
    {
        this.minNum = minNum;
    }
    public Integer getMaxNum()
    {
        return maxNum;
    }
    public void setMaxNum(Integer maxNum)
    {
        this.maxNum = maxNum;
    }
    public static long getSerialversionuid()
    {
        return serialVersionUID;
    }
    @Override
    public String toString()
    {
        return "UserSearchQueryRequest [username=" + username + ", real_name=" + real_name + ", mobile=" + mobile
                + ", isum=" + isum + ", gnum=" + gnum + ", vmoney=" + vmoney + ", coupon=" + coupon + ", minNum="
                + minNum + ", maxNum=" + maxNum + "]";
    }


}
