package com.pydyun.ims.controller.wxcontroller;

import com.deepoove.poi.XWPFTemplate;
import com.deepoove.poi.data.DocxRenderData;
import com.deepoove.poi.policy.DocxRenderPolicy;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.pydyun.ims.model.*;
import com.pydyun.ims.service.wxservice.WxUserAssessService;
import com.pydyun.ims.service.wxservice.WxUserSchemeService;
import com.pydyun.ims.util.CollectionPlanConversionUtils;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author tangxiaoyu
 * @ClassName: WxUserSchemeController
 * @Description: TODO(微信 : 个人中心 - 用户收藏 - 用户个人方案)
 * @date 2018年8月17日 上午10:28:41
 */
@RestController
@RequestMapping("/wxUserScheme")
public class WxUserSchemeController
{

    @Resource
    private WxUserSchemeService wxUserSchemeService;
    @Resource
    private WxUserAssessService wxUserAssessService;

    @RequestMapping("/deleteWxUserScheme")
    public Integer deleteWxUserScheme(Integer usuid, Integer ussid) {


        return wxUserSchemeService.deleteWxUserScheme(usuid, ussid);

    }

    @RequestMapping("/getWxUserSchemePresence")
    public boolean getWxUserSchemePresence(Integer usuid, Integer ussid) {
        boolean flag = false;
        Integer num = wxUserSchemeService.getWxUserSchemePresence(usuid, ussid);
        if (num != null) {
            flag = true;
        }
        return flag;

    }

    @RequestMapping("/UserSchemeCollection")
    public Integer UserSchemeCollection(Integer sid, Integer usuid, String wxUserSchemeinfo) throws Exception {
        WxUserScheme wxUserScheme = new WxUserScheme();
        Gson gson = new Gson();
        wxUserScheme = gson.fromJson(wxUserSchemeinfo, WxUserScheme.class);


//        WxUserScheme wxUserScheme = CollectionPlanConversionUtils.UserSchemeCollection(sid, usuid);

        return wxUserSchemeService.saveWxUserScheme(wxUserScheme);

    }


    @RequestMapping("/getWxUserScheme")
    public WxUserScheme getWxUserScheme(Integer usid, Integer sid)
            throws Exception {
        /**
         * @Title: getWxUserScheme
         * @Description: TODO(查询方案详情)
         * @param: [usid, sid]
         * @return:com.pydyun.ims.model.WxUserScheme
         * @Date: 2018/10/9 9:32
         */

        WxUserScheme wxUserScheme = new WxUserScheme();
        /*用户自定义方案详情*/
        if (usid != -1) {
            wxUserScheme = wxUserSchemeService.getWxUserScheme(usid);
            /*用户自定义方案json信息转换*/
            Gson gson = new Gson();
            List<WxSchemeStage> stages = JSONConversion(wxUserScheme.getUsjson());
            wxUserScheme.setStages(stages);
        } else if (sid != -1) {
            /*后台方案详情*/
            wxUserScheme = CollectionPlanConversionUtils.UserSchemeCollection(sid, null);
            /*后台方案评论信息*/
            List<WxUserAssess> wxUserAssesses = wxUserAssessService.findWxUserAssessByUaoid(wxUserScheme.getUssid(), 1, true);
            wxUserScheme.setWxUserAssesses(wxUserAssesses);
        }

        return wxUserScheme;

    }

    /**
     * @param usjson
     * @return
     * @throws Exception
     * @Title: JSONConversion
     * @Description: TODO(json转换对象)
     */
    private List<WxSchemeStage> JSONConversion(String usjson) throws Exception {
        Gson gson = new GsonBuilder().enableComplexMapKeySerialization().create();
        List<WxSchemeStage> stages;
        try {
            stages = gson.fromJson(usjson, new TypeToken<List<WxSchemeStage>>()
            {
            }.getType());
        } catch (JsonSyntaxException e) {
            throw new InvalidParameterException("json数据转换失败");
        }
        return stages;

    }

    @RequestMapping("/findWxUserScheme")
    public PageInfo<WxUserSchemerListResponse> findWxUserScheme(Integer pageNum, Integer pageSize, WxUserScheme userScheme) {
        pageNum = pageNum == null ? 1 : pageNum;
        pageSize = pageSize == null ? 5 : pageSize;
        PageInfo<WxUserSchemerListResponse> wxUserSchemerListResponsePageInfo = SolutionDataProcessing(wxUserSchemeService.findWxUserScheme(pageNum, pageSize, userScheme));
        return wxUserSchemerListResponsePageInfo;

    }


    private PageInfo<WxUserSchemerListResponse> SolutionDataProcessing(PageInfo<WxUserSchemerListResponse> responses) {

        /**
         * @Title: SolutionDataProcessing
         * @Description: TODO(数据处理)
         * @param: [responses]
         * @return:java.util.List<com.pydyun.ims.model.WxUserSchemerListResponse>
         * @Date: 2018/8/30 14:04
         */

        for (WxUserSchemerListResponse respons : responses.getList()) {
            if (respons.getScname() == null) {
                respons.setScname(respons.getSuperiorscname());
            }
        }
        return responses;
    }

    @RequestMapping("/updateWxUserScheme")
    public WxUserScheme updateWxUserScheme(
            WxUserSchemeRequest schemeRequest) throws IllegalAccessException, InvocationTargetException {


        WxUserScheme userScheme = new WxUserScheme();
        BeanUtils.copyProperties(userScheme, schemeRequest);

        userScheme.setUsjson(Conversion(schemeRequest));

        wxUserSchemeService.updateWxUserScheme(userScheme);
        return userScheme;

    }

    /**
     * @param schemeRequest
     * @return
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     * @Title: saveWxUserScheme
     * @Description: TODO(新增)
     */
    @RequestMapping("/saveWxUserScheme")
    public WxUserScheme saveWxUserScheme(
            WxUserSchemeRequest schemeRequest) throws IllegalAccessException, InvocationTargetException {


        return null;

    }

    /**
     * @param request
     * @return
     * @Title: Conversion
     * @Description: TODO(对象转json转换)
     */
    private String Conversion(WxUserSchemeRequest request) {
        Gson gson = new Gson();
        String Usjson = gson.toJson(request.getStages());
        return Usjson;

    }

    @RequestMapping("/exportWord")
    public String WXUserSchemeExportWord(Integer usid)
            throws Exception {


        WxUserScheme wxUserScheme = wxUserSchemeService.getWxUserScheme(usid);
        List<WxSchemeStage> stages = JSONConversion(wxUserScheme.getUsjson());

        DocxRenderData segment = new DocxRenderData(new File("D:\\stages.docx"), stages);
        Map<String, Object> datas = new HashMap<String, Object>()
        {
//            {
//                put("ustitle", wxUserScheme.getUstitle());
//                put("usinfo", wxUserScheme.getUsinfo());
//                put("stages", segment);
//            }
        };
        XWPFTemplate template = XWPFTemplate.compile("D:\\方案导出模板.docx").render(datas);

        FileOutputStream out;
        try {
            out = new FileOutputStream("D:\\输出1.docx");
            template.write(out);
            out.flush();
            out.close();
            template.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String string = "成功导出";
        return string;

    }


    private void AddItemToCart(List<WxSchemeStage> wxSchemeStages, Integer usuid) {
        List<WxUserCart> list = new ArrayList<>();
        WxUserCart wxUserCart;
        for (WxSchemeStage wxSchemeStage : wxSchemeStages) {
            for (WxStageShop wxStageShop : wxSchemeStage.getShops()) {
                for (WxStageShopProduct product : wxStageShop.getProducts()) {
                    wxUserCart = new WxUserCart();
                    wxUserCart.setUid(usuid);
                    wxUserCart.setNumber(product.getPnum());
                    wxUserCart.setOid(product.getPid());
                    wxUserCart.setOtype(0);
                    list.add(wxUserCart);
                }
            }
        }
    }


}
