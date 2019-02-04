package com.pydyun.ims.model;

import java.io.Serializable;

/**
 * @ClassName: UserPageResponse
 * @Description: TODO(用户分页查询返回封装类)
 * @author tangxiaoyu
 * @date 2018年7月5日 下午12:45:36
 *
 */
public class UserPageResponse implements Serializable
{

    /**
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
     */
    private static final long serialVersionUID = 1L;

    private Integer urid;// 用户id
    private String username;// 登录名
    private String real_name;// 真实姓名
    private String mobile;// 手机号码
    private Integer state;// 账号状态
    private Integer isum;// 用户当前积分总额
    private Integer gnum;// 当前金币数量
    private Integer voucher;// 代金券数量
    private Double vmoney;// 代金券总额
    private Integer coupon;// 优惠券数量
    
    public UserPageResponse() {
		super();
	}
	public UserPageResponse(Integer urid, String username, String mobile,
			Integer state, Integer isum, Integer gnum, Integer voucher,
			Double vmoney, Integer coupon) {
		super();
		this.urid = urid;
		this.username = username;
		this.mobile = mobile;
		this.state = state;
		this.isum = isum;
		this.gnum = gnum;
		this.voucher = voucher;
		this.vmoney = vmoney;
		this.coupon = coupon;
	}
	public UserPageResponse(String real_name) {
		super();
		this.real_name = real_name;
	}
    public Integer getUrid()
    {
        return urid;
    }
    public void setUrid(Integer urid)
    {
        this.urid = urid;
    }
    public String getUsername()
    {
        return username;
    }
    public void setUsername(String username)
    {
        this.username = username;
    }
    public String getReal_name()
    {
        return real_name;
    }
    public void setReal_name(String real_name)
    {
        this.real_name = real_name;
    }
    public String getMobile()
    {
        return mobile;
    }
    public void setMobile(String mobile)
    {
        this.mobile = mobile;
    }
    public Integer getState()
    {
        return state;
    }
    public void setState(Integer state)
    {
        this.state = state;
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
    public Integer getVoucher()
    {
        return voucher;
    }
    public void setVoucher(Integer voucher)
    {
        this.voucher = voucher;
    }
    public Double getVmoney()
    {
        return vmoney;
    }
    public void setVmoney(Double vmoney)
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
    public static long getSerialversionuid()
    {
        return serialVersionUID;
    }
    
    
    
    

}
