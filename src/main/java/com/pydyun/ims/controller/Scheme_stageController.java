package com.pydyun.ims.controller;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import com.pydyun.ims.model.*;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.pydyun.ims.service.AlbumService;
import com.pydyun.ims.service.ImagesService;
import com.pydyun.ims.service.Label_scheme_sumSerivce;
import com.pydyun.ims.service.SchemeAndStageAndShopService;
import com.pydyun.ims.service.SchemeService;
import com.pydyun.ims.service.Scheme_stageService;

/**
 * @author tangxiaoyu
 * @ClassName: Scheme_stageController
 * @Description: TODO(方案阶段)
 * @date 2018年7月17日 上午9:30:48
 */

@Controller
@RequestMapping("/schemeStage")
public class Scheme_stageController
{

    @Resource
    private Scheme_stageService scheme_stageService;

    @Resource
    private SchemeService schemeService;

    @Resource
    private AlbumService AlbumService;

    @Resource
    private ImagesService ImagesService;

    @Resource
    private SchemeAndStageAndShopService SchemeAndStageAndShopService;

    @Resource
    private Label_scheme_sumSerivce Label_scheme_sumSerivce;

    @RequiresPermissions("schemeStage:getSchemeStage")
    @RequestMapping("/getSchemeStage")
    public ModelAndView getSchemeStage(Integer sid) throws Exception {
        // 方案详细信息
        SchemeResponse schemeResponse = schemeService.foundSchemeById(sid);
        // 方案下阶段详细
        List<SchemeAndStageResponse> responses = scheme_stageService.foundSchemeAndStage(sid);
        ModelAndView mv = new ModelAndView("scheme/schemeDetails");

        if (!responses.isEmpty()) {
            List<Integer> ssids = new ArrayList<Integer>();
            for (SchemeAndStageResponse schemeAndStageResponse : responses) {
                ssids.add(schemeAndStageResponse.getSsid());
            }
            // 商品详情
            List<StageShopGoodsResponse> shopGoodsResponses = scheme_stageService.foundProductInformation(ssids);
            mv.addObject("shopGoods", shopGoodsResponses);
        }
        mv.addObject("schemeResponse", schemeResponse);
        mv.addObject("responses", responses);

        return mv;

    }

    /**
     * @return
     * @throws Exception
     * @Title: foundAlternateMerchant
     * @Description: TODO(根据阶段id查询备选商家)
     */
    @RequestMapping("/foundAlternateMerchant")
    @ResponseBody
    public List<SchemeAlternativeShop> foundAlternateMerchant(Integer ssid) throws Exception {
        List<Integer> ssids = new ArrayList<Integer>();
        ssids.add(ssid);
        return scheme_stageService.foundAlternateMerchant(ssids);

    }

    /*阶段下商品*/
    @RequestMapping("/foundProductBySsid")
    @ResponseBody
    public SchemeAndStageAndShop foundProductBySsid(Integer ssid) throws Exception {
        List<Integer> ssids = new ArrayList<Integer>();
        ssids.add(ssid);
        return scheme_stageService.foundProductBySsid(ssids);

    }

    /**
     * @param sid
     * @return
     * @Title: selectShopAlbum
     * @Description: TODO(根据商户id查询相册)
     */
    @RequestMapping("/selectShopAlbum")
    @ResponseBody
    public List<Album> selectShopAlbum(Integer sid) {
        return AlbumService.selectShopAlbum(sid);
    }

    /**
     * @param aid
     * @return
     * @Title: selectshopImage
     * @Description: TODO(根据相册查询图片)
     */
    @RequestMapping("/selectshopImage")
    @ResponseBody
    public List<Images> selectshopImage(Integer aid) {

        return ImagesService.selectshopImage(aid);
    }

    /**
     * @param request
     * @return
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     * @Title: addSchemeStage
     * @Description: TODO(新增阶段以及其相关连的表)
     */
    @RequestMapping("/addSchemeStage")
    @ResponseBody
    @Transactional
    public SchemeStageRequest addSchemeStage(SchemeStageRequest request)
            throws IllegalAccessException, InvocationTargetException {
        Scheme_stage scheme_stage = new Scheme_stage();
        BeanUtils.copyProperties(scheme_stage, request);
        // 新增阶段返回阶段id
        scheme_stage = scheme_stageService.addStage(scheme_stage);
        request.setSsid(scheme_stage.getSsid());
        SchemeAndStageAndShop stageAndShop = new SchemeAndStageAndShop();
        BeanUtils.copyProperties(stageAndShop, request);
        // 新增方案所含阶段 商家列表
        stageAndShop.setSreplace(dataProcessing(request));
        SchemeAndStageAndShopService.addSchemeAndStageAndShop(stageAndShop);

        if (!request.getNewLabelids().isEmpty()) {
            List<Label_scheme_sum> lSums = new ArrayList<>();
            Label_scheme_sum scheme_sum;
            String[] labels = request.getNewLabelids().split(",");
            for (String string : labels) {
                if (string != null && !string.isEmpty()) {
                    scheme_sum = new Label_scheme_sum();
                    scheme_sum.setLid(Integer.parseInt(string));
                    scheme_sum.setSid(request.getSsid());
                    scheme_sum.setLstype(1);
                    scheme_sum.setLsnum(1);
                    lSums.add(scheme_sum);
                }

            }
            // 批量新增方案、方案所属阶段。被用户选择的标签记录表
            Label_scheme_sumSerivce.addLabelschemelist(lSums);
        }

        return request;
    }

    /*商品数据处理*/
    private String dataProcessing(SchemeStageRequest request) {
        String pids = request.getPids();
        String num = request.getPnumber();
        String[] pidArray = pids.split(",");
        String[] number = num.split(",");
        String sreplace = "";
        for (int i = 0; i < pidArray.length; i++) {
            if (i == 0) {
                sreplace += pidArray[i] + ":" + number[i];
            } else {
                sreplace += "," + pidArray[i] + ":" + number[i];
            }

        }

        return sreplace;
    }

    /**
     * @param request
     * @return
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     * @Title: updateSchemeStage
     * @Description: TODO(修改阶段以及相关表)
     */
    @RequestMapping("/updateSchemeStage")
    @ResponseBody
    @Transactional
    public SchemeStageRequest updateSchemeStage(SchemeStageRequest request)
            throws IllegalAccessException, InvocationTargetException {
        Scheme_stage scheme_stage = new Scheme_stage();
        BeanUtils.copyProperties(scheme_stage, request);
        // 修改阶段
        scheme_stageService.updateStage(scheme_stage);
        SchemeAndStageAndShop stageAndShop = new SchemeAndStageAndShop();
        BeanUtils.copyProperties(stageAndShop, request);
        // 修改方案所含商家列表
        stageAndShop.setSreplace(dataProcessing(request));
        SchemeAndStageAndShopService.updateSchemeAndStageAndShop(stageAndShop);

        // 判断新增或者修改
        if (!request.getNewLabelids().isEmpty() && !request.getOldLabelids().isEmpty()) {

            Map<String, Integer[]> map = labelJudgment(request.getNewLabelids(), request.getOldLabelids());
            if (map.get("deletelabels").length > 0) {
                // 批量删除
                List<Integer> deletelabels = new ArrayList<Integer>();
                Integer[] lssids = map.get("deletelabels");
                for (Integer integer : lssids) {
                    deletelabels.add(integer);
                }
                Label_scheme_sumSerivce.deleteLabelscheme(request.getSsid(), deletelabels);
            }

            if (map.get("addlabels").length > 0) {
                List<Label_scheme_sum> lSums = new ArrayList<Label_scheme_sum>();
                Label_scheme_sum scheme_sum;
                Integer[] labels = map.get("addlabels");
                for (Integer integer : labels) {
                    scheme_sum = new Label_scheme_sum();
                    scheme_sum.setLid(integer);
                    scheme_sum.setSid(request.getSsid());
                    scheme_sum.setLstype(1);
                    scheme_sum.setLsnum(1);
                    lSums.add(scheme_sum);
                }
                // 批量新增方案、方案所属阶段。被用户选择的标签记录表
                Label_scheme_sumSerivce.addLabelschemelist(lSums);
            }
        }
        if (request.getNewLabelids().isEmpty() && !request.getOldLabelids().isEmpty()) {
            // 批量删除
            List<Integer> deletelabels = new ArrayList<>();
            String[] lidids = request.getOldLabelids().split(",");
            for (String string : lidids) {
                deletelabels.add(Integer.parseInt(string));
            }
            Label_scheme_sumSerivce.deleteLabelscheme(request.getSid(), deletelabels);
        }
        if (!request.getNewLabelids().isEmpty() && request.getOldLabelids().isEmpty()) {
            List<Label_scheme_sum> lSums = new ArrayList<Label_scheme_sum>();
            Label_scheme_sum scheme_sum;
            String[] labels = request.getNewLabelids().split(",");
            for (String string : labels) {
                scheme_sum = new Label_scheme_sum();
                scheme_sum.setLid(Integer.parseInt(string));
                scheme_sum.setSid(request.getSsid());
                scheme_sum.setLstype(1);
                scheme_sum.setLsnum(1);
                lSums.add(scheme_sum);
            }
            // 批量新增方案、方案所属阶段。被用户选择的标签记录表
            Label_scheme_sumSerivce.addLabelschemelist(lSums);
        }

        return request;

    }

    /**
     * @param sid
     * @param lstype
     * @return
     * @Title: findBySid
     * @Description: TODO(查询标签)
     */
    @RequestMapping("/findBySid")
    @ResponseBody
    public List<Label_scheme_sumResponse> findBySid(Integer sid, Integer lstype) {

        return Label_scheme_sumSerivce.findBySid(sid, lstype);

    }

    /**
     * @param ssid
     * @return
     * @Title: deleteStage
     * @Description: TODO(删除方案下阶段)
     */
    @RequestMapping("/deleteStage")
    @ResponseBody
    @Transactional
    public Integer deleteStage(Integer ssid) {
        Label_scheme_sumSerivce.deleteLabelschemeBySid(ssid, 1);
        SchemeAndStageAndShopService.deleteSchemeAndStageAndShop(ssid);

        return scheme_stageService.deleteStage(ssid);

    }

    /**
     * @param newLabelid
     * @param oldLabelid
     * @return
     * @Title: labelJudgment
     * @Description: TODO(标签id判断删除新增工具)
     */
    private Map<String, Integer[]> labelJudgment(String newLabelid, String oldLabelid) {
        String[] newlabels = newLabelid.split(",");
        String[] oldlabels = oldLabelid.split(",");
        Integer[] newlable = new Integer[newlabels.length];
        Integer[] oldlable = new Integer[oldlabels.length];
        for (int i = 0; i < newlabels.length; i++) {
            if (newlabels[i] != null && !newlabels[i].isEmpty()) {
                newlable[i] = Integer.parseInt(newlabels[i].trim());
            }
        }
        for (int i = 0; i < oldlabels.length; i++) {
            if (oldlabels[i] != null && !oldlabels[i].isEmpty()) {
                oldlable[i] = Integer.parseInt(oldlabels[i].trim());
            }
        }

        Set<Integer> same = new HashSet<Integer>();
        Set<Integer> temp = new HashSet<Integer>();
        Set<Integer> tempnew = new HashSet<Integer>();
        Set<Integer> samenew = new HashSet<Integer>();
        for (int i = 0; i < oldlable.length; i++) {
            temp.add(oldlable[i]); // 把数组a中的元素放到Set中，可以去除重复的元素
        }
        for (int j = 0; j < newlable.length; j++) {
            if (!temp.add(newlable[j]))// 不同
            {
                same.add(newlable[j]);// 相同
            }
        }
        Set<Integer> samecopy = same;
        for (int j = 0; j < newlable.length; j++) {
            // 把数组b中的元素添加到temp中
            // 如果temp中已存在相同的元素，则temp.add（b[j]）返回false
            if (same.add(newlable[j])) {
                tempnew.add(newlable[j]);
            }
        }
        Integer[] addlabels = tempnew.toArray(new Integer[]{});// 新增
        for (int j = 0; j < oldlable.length; j++) {
            if (samecopy.add(oldlable[j])) {
                samenew.add(oldlable[j]);
            }
        }
        Integer[] deletelabels = samenew.toArray(new Integer[]{});// 删除
        Map<String, Integer[]> map = new HashMap<String, Integer[]>();
        map.put("deletelabels", deletelabels);
        map.put("addlabels", addlabels);
        return map;
    }

}
