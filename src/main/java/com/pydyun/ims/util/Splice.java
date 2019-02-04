package com.pydyun.ims.util;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pydyun.ims.dao.WxProductClassDao;
import com.pydyun.ims.model.WxProductClass;

@Component
public class Splice {
	@Autowired
	private WxProductClassDao pro;
	private static Splice sp;

	@PostConstruct
	public void init() {
		sp = this;
		sp.pro = this.pro;
	}

	public WxProductClassDao getPro() {
		return pro;
	}

	public void setPro(WxProductClassDao pro) {
		this.pro = pro;
	}

	/**
	 * 商品专用
	 * @param judge
	 *            区分是详情还是列表， 0代表列表，1代表详情
	 * @param cid
	 *            商品分类id
	 * @param cname
	 *            商品分类名字
	 *            id和名字不能同时为空和同时不为空
	 *            
	 * @param ids
	 *            商品id或者是商户id或者是方案id     如果是查询详情的话，就必须携带id和分类id
	 * @return
	 */
	public static String ReturnPath(Integer judge, Integer cid, String cname,Integer ids) {
		WxProductClass findaddress = sp.pro.findaddress(cid, cname);
		StringBuffer sb = new StringBuffer();
		if (judge == 0) {
			String id = null;
			if(findaddress.getId()==null){
				id="0";
			}else{
				id = findaddress.getId().toString();
			}
			sb.append("../list-");
			sb.append(findaddress.getTemplet_list());
			sb.append("/list-");
			sb.append(findaddress.getTemplet_list());
			sb.append("?id=");
			sb.append(id);
			return sb.toString();
		} else if (judge == 1) {
			sb.append("../details-");
			sb.append(findaddress.getTemplet_product());
			sb.append("/details-");
			sb.append(findaddress.getTemplet_product());
			sb.append("?id=");
			sb.append(ids);
			sb.append("&cid=");
			sb.append(cid);
			return sb.toString();
		}
		return sb.toString();

	}
}
