package com.pydyun.ims.util;

import com.google.gson.Gson;
import com.pydyun.ims.model.*;
import com.pydyun.ims.service.SchemeService;
import com.pydyun.ims.service.Scheme_stageService;
import com.pydyun.ims.service.wxservice.WxUserSchemeService;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * FileName: CollectionPlanConversionUtils
 * Author:   tangxiaoyu
 * Date:     2018/9/10 14:15
 * Description: TODO(用户收藏方案转换工具类)
 *
 * @since 1.0.0
 */
@Component
public class CollectionPlanConversionUtils
{


    @Autowired
    private SchemeService schemeService;
    @Autowired
    private Scheme_stageService scheme_stageService;

    @Autowired
    private WxUserSchemeService wxUserSchemeService;


    private static CollectionPlanConversionUtils Scheme;

    @PostConstruct
    public void init() {
        Scheme = this;
        Scheme.schemeService = this.schemeService;
        Scheme.scheme_stageService = this.scheme_stageService;
        Scheme.wxUserSchemeService = this.wxUserSchemeService;

    }

    public static WxUserScheme UserSchemeCollection(Integer sid, Integer usuid) throws Exception {
        /*查询方案详细信息*/
        SchemeResponse response = SchemeInfo(sid);

        WxUserScheme wxUserScheme = new WxUserScheme();
        wxUserScheme.setUsuid(usuid);
        wxUserScheme.setScname(response.getScname());
        wxUserScheme.setUsscid(response.getScid());
        wxUserScheme.setUssid(response.getSid());
        wxUserScheme.setUstitle(response.getSname());
        wxUserScheme.setUspnum(response.getSpnum());
        wxUserScheme.setUsinfo(response.getSinfo());
        wxUserScheme.setUsduration(response.getSduration());
        wxUserScheme.setUsrange(response.getSrange());
        wxUserScheme.setUsprice(response.getSprice());
        wxUserScheme.setUsimg(response.getSimg());
        List<SchemeAndStageResponse> stageResponses;
        /*查询方案下阶段信息*/
        stageResponses = ScheneStageInfo(sid);
        if (!stageResponses.isEmpty()) {
            List<Integer> ssids = new ArrayList<>();
            ArrayList<WxSchemeStage> wxSchemeStages = new ArrayList<>();

            ArrayList<WxStageShop> stageShops;
            WxSchemeStage wxSchemeStage;
            WxStageShop wxStageShop;
            /*封装阶段信息*/
            for (SchemeAndStageResponse stageRespons : stageResponses) {
                ssids.add(stageRespons.getSsid());
                stageShops = new ArrayList<>();
                wxSchemeStage = new WxSchemeStage();
                wxSchemeStage.setStage(stageRespons.getSsname());
                wxSchemeStage.setInfo(stageRespons.getSsinfo());
                wxSchemeStage.setId(stageRespons.getSsid());
                wxSchemeStage.setShops(stageShops);
                wxSchemeStages.add(wxSchemeStage);
            }
            /*查询商品商户信息*/
            List<StageShopGoodsResponse> shops = SchemeStageShopInfo(ssids);
            ArrayList<WxStageShop> wxStageShops;
            List<WxStageShopProduct> products;
            WxStageShopProduct product;
            /*根据商户分组,封装数据*/
            for (StageShopGoodsResponse shop : shops) {
                wxStageShop = new WxStageShop();
                wxStageShops = new ArrayList<>();
                BeanUtils.copyProperties(wxStageShop, shop);
                products = new ArrayList<>();
                for (StageGoodsResponse stageGoodsResponse : shop.getStageGoodsResponses()) {
                    product = new WxStageShopProduct();

                    product.setPid(stageGoodsResponse.getId());
                    product.setCid(stageGoodsResponse.getCid());
                    product.setPrice(stageGoodsResponse.getYprice());
                    product.setPname(stageGoodsResponse.getPname());
                    product.setPimg(stageGoodsResponse.getUrl());
                    product.setPnum(stageGoodsResponse.getNum());
                    products.add(product);
                }
                wxStageShop.setProducts(products);
                wxStageShops.add(wxStageShop);
                for (WxSchemeStage schemeStage : wxSchemeStages) {
                    if (schemeStage.getId().equals(shop.getSsid())) {
                        stageShops = new ArrayList<>();
                        if (schemeStage.getShops().size() > 0) {
                            stageShops.addAll(schemeStage.getShops());
                        }
                        stageShops.addAll(wxStageShops);
                        schemeStage.setShops(stageShops);
                    }
                }
            }
            /*json转换*/
            wxUserScheme.setUsjson(Conversion(wxSchemeStages));
            wxUserScheme.setStages(wxSchemeStages);
        }
        return wxUserScheme;
    }

    /**
     * @param stages
     * @return
     * @Title: Conversion
     * @Description: TODO(对象转json转换)
     */
    private static String Conversion(List<WxSchemeStage> stages) {
        Gson gson = new Gson();
        String Usjson = gson.toJson(stages);
        return Usjson;

    }

    private static Map<Integer, List<WxStageShop>> ProductGrouping(List<SchemeAlternativeShop> shops) {
        Map<Integer, List<WxStageShop>> map = new HashMap<>();
        WxStageShop wxStageShop;
        for (SchemeAlternativeShop shop : shops) {
            wxStageShop = new WxStageShop();
            List<WxStageShop> list = map.get(shop.getSsid());
            /* 如果取不到数据,那么直接new一个空的ArrayList **/
            if (list == null) {
                list = new ArrayList<>();
                list.add(wxStageShop);
                map.put(shop.getSsid(), list);
            } else {
                /* 某个对象之前已经存放过了,则直接追加数据到原来的List里 **/
                list.add(wxStageShop);
            }
        }
        return map;
    }

    /*方案信息详情*/
    private static SchemeResponse SchemeInfo(Integer sid) {

        SchemeResponse response = new SchemeResponse();
        response = Scheme.schemeService.foundSchemeById(sid);
        return response;
    }

    /*方案阶段信息*/
    private static List<SchemeAndStageResponse> ScheneStageInfo(Integer sid) {
        List<SchemeAndStageResponse> responses = new ArrayList<>();
        responses = Scheme.scheme_stageService.foundSchemeAndStage(sid);
        return responses;

    }

    /*阶段下商品信息*/
    private static List<StageShopGoodsResponse> SchemeStageShopInfo(List<Integer> ssids) throws Exception {

        List<StageShopGoodsResponse> list = new ArrayList<>();
        list = Scheme.scheme_stageService.foundProductInformation(ssids);
        return list;
    }


}
