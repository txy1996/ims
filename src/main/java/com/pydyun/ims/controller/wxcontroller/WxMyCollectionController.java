package com.pydyun.ims.controller.wxcontroller;

import com.github.pagehelper.PageInfo;
import com.pydyun.ims.model.WxUserCollectionProductResponse;
import com.pydyun.ims.model.WxUserCollectionShopResponse;
import com.pydyun.ims.service.wxservice.WxUserCollectionService;
import com.pydyun.ims.util.Splice;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author tangxiaoyu
 * @ClassName: WxMyCollectionController
 * @Description: TODO(微信 : 个人中心 - 我的收藏)
 * @date 2018年8月9日 上午9:57:58
 */
@RestController
@RequestMapping("/myCollection")
public class WxMyCollectionController
{

    @Resource
    private WxUserCollectionService wxUserCollectionService;

    @RequestMapping("/findUserCollectionByShop")
    public PageInfo<WxUserCollectionShopResponse> findUserCollectionByShop(Integer pageNum, Integer pageSize, Integer urid) {
        pageNum = pageNum == null ? 1 : pageNum;
        pageSize = pageSize == null ? 12 : pageSize;
        //  PageInfo<WxUserCollectionShopResponse> responsePageInfo=MerchantDataConversion(wxUserCollectionService.findUserCollectionByShop(pageNum,pageSize,urid));
        PageInfo<WxUserCollectionShopResponse> responsePageInfo=wxUserCollectionService.findUserCollectionByShop(pageNum,pageSize,urid);
        return responsePageInfo;

    }

    private PageInfo<WxUserCollectionShopResponse> MerchantDataConversion(PageInfo<WxUserCollectionShopResponse> responses) {
        for (WxUserCollectionShopResponse respons : responses.getList()) {
            if (respons.getSstate() != null) {
                switch (respons.getSstate()) {
                    case "0":
                        respons.setSstate("营业");
                        break;
                    case "1":
                        respons.setSstate("暂停营业");
                        break;
                    case "2":
                        respons.setSstate("关闭");
                        break;
                }
            }

        }
        return responses;
    }

    @RequestMapping("/findUserCollectionByProduct")
    public PageInfo<WxUserCollectionProductResponse> findUserCollectionByProduct(Integer pageNum, Integer pageSize, Integer urid) {
        pageNum = pageNum == null ? 1 : pageNum;
        pageSize = pageSize == null ? 8 : pageSize;
//        PageInfo<WxUserCollectionProductResponse> responsePageInfo= CommodityDataConversion(wxUserCollectionService.findUserCollectionByProduct(pageNum,pageSize,urid));
        PageInfo<WxUserCollectionProductResponse> responsePageInfo= wxUserCollectionService.findUserCollectionByProduct(pageNum,pageSize,urid);
        return responsePageInfo;

    }

    private PageInfo<WxUserCollectionProductResponse> CommodityDataConversion(PageInfo<WxUserCollectionProductResponse> responses) {
        for (WxUserCollectionProductResponse respons : responses.getList()) {
            if (respons.getState() != null) {
                switch (respons.getState()) {
                    case "0":
                        respons.setState("未上架");
                        break;
                    case "1":
                        respons.setState("上架");
                        break;
                    case "2":
                        respons.setState("下架");
                        break;
                }
            }

        }
        return responses;
    }

    /*根据收藏id删除用户收藏的方案商品,商户*/
    @RequestMapping("/deleteUserConllectionByUcid")
    public Integer deleteUserConllectionByUcid(Integer ucid) {


        return wxUserCollectionService.delete(ucid);

    }

    @RequestMapping("/findUserProductUrl")
    @ResponseBody
    public String findUserProductUrl(Integer pid, Integer cid) {

        String url = Splice.ReturnPath(1, cid, null, pid);
        String OldSimg = url.replace("..", "");
        url = "../administrative" + OldSimg;
        return url;

    }


}
