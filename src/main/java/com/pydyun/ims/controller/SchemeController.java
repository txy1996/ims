package com.pydyun.ims.controller;

import com.github.pagehelper.PageInfo;
import com.pydyun.ims.model.*;
import com.pydyun.ims.service.*;
import com.pydyun.ims.util.BusinessInformation;
import com.pydyun.ims.util.FileUploadUtil;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

/*方案*/
@Controller
@RequestMapping("/scheme")
public class SchemeController
{

    @Resource
    private SchemeService schemeService;

    @Resource
    private Scheme_classService classService;

    @Resource
    private ShopService ShopService;

    @Resource
    private Scheme_stageService Scheme_stageService;

    @Resource
    private Label_scheme_sumSerivce Label_scheme_sumSerivce;

    @Resource
    private PromotionService promotionService;


    /*方案列表*/
    @RequiresPermissions("scheme:list")
    @RequestMapping("/list")
    public ModelAndView toMessage(Integer pageNum, Integer pageSize, Integer id, Integer scid, Scheme schemerequest,String choise,
    		String timechoise,String naturechoise) throws Exception {
        pageNum = pageNum == null ? 1 : pageNum;
        pageSize = pageSize == null ? 8 : pageSize;
        Promotion promotion = new Promotion();
        if (id == null) {
            if (schemerequest != null) {
                schemerequest = DataProcessing(schemerequest);
            }

            if (scid != null) {
                promotion = promotionService.edit1(scid);
                PageInfo<Scheme> scheme = schemeService.getSchemec(pageNum, pageSize,scid,choise,timechoise,naturechoise);
                ModelAndView mv = new ModelAndView("scheme/scheme");
                mv.addObject("scheme", scheme);
                return mv;
            }else{
            PageInfo<Scheme> scheme = schemeService.getSchemeMessage(pageNum, pageSize, schemerequest);
            List<String> list = classService.getClassName();
            ModelAndView mv = new ModelAndView("scheme/scheme");
            mv.addObject("scheme", scheme);
            mv.addObject("list", list);
            mv.addObject("request", schemerequest);
            mv.addObject("promotion", promotion);
            return mv;
            }
        } else {
            PageInfo<SchemeIo> list = schemeService.getMessage(pageNum, pageSize, id);
            if (scid != null) {
                promotion = promotionService.edit1(scid);
            }
            ModelAndView mv = new ModelAndView("stage/planstage");
            mv.addObject("list", list);
            mv.addObject("promotion", promotion);
            return mv;
        }
    }

    // sid阶段对应商户
    @RequestMapping("/getshop")
    public ModelAndView getshop(Integer pageNum, Integer pageSize, Integer id) {
        pageNum = pageNum == null ? 1 : pageNum;
        pageSize = pageSize == null ? 8 : pageSize;
        PageInfo<Shop> list = ShopService.getshop(pageNum, pageSize, id);
        ModelAndView mv = new ModelAndView("shop/shop");
        mv.addObject("list", list);
        return mv;

    }


    @RequiresPermissions("scheme:list")
    @RequestMapping("/getScheme")
    @ResponseBody
    public Scheme getOneMessage(String id) {

        Scheme scheme = schemeService.getOneMessage(Integer.valueOf(id));
        return scheme;
    }

    @RequiresPermissions("scheme:delete")
    @RequestMapping("/delete")
    @ResponseBody
    public Integer deleteScheme(Integer sid) {
        int num = Scheme_stageService.findSchemeStageBySid(sid);
        if (num <= 0) {
            schemeService.delteScheme(sid);
        } else {
            return num;
        }
        return num;

    }

    /**
     * @param request
     * @return
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     * @Title: updateScheme
     * @Description: TODO(修改方案)
     */
    @RequiresPermissions("scheme:update")
    @RequestMapping("/update")
    @ResponseBody
    @Transactional
    public SchemeRequest updateScheme(HttpServletRequest servletRequest, SchemeRequest request,
                                      @RequestParam(value = "file", required = false) MultipartFile file)
            throws IllegalAccessException, InvocationTargetException {
        Scheme scheme = new Scheme();
        if (request != null) {
            BeanUtils.copyProperties(scheme, request);
        }
        scheme.setSdate(new Date());
        if (file != null) {
            if (!request.getOldSimg().isEmpty()) {
                String OldSimg = request.getOldSimg().replace(BusinessInformation.DELETE_PREFIX, "");
                String path = servletRequest.getSession().getServletContext().getRealPath(OldSimg);
                File oldfile = new File(path);
                if (oldfile.isFile() && oldfile.exists()) {
                    oldfile.delete();
                }
            }

            String url = FileUploadUtil.ImageUpload(file);
            scheme.setSimg(url);
        }

        schemeService.updateScheme(scheme);
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
                Label_scheme_sumSerivce.deleteLabelscheme(request.getSid(), deletelabels);
            }

            if (map.get("addlabels").length > 0) {
                List<Label_scheme_sum> lSums = new ArrayList<Label_scheme_sum>();
                Label_scheme_sum scheme_sum;
                Integer[] labels = map.get("addlabels");
                for (Integer integer : labels) {
                    scheme_sum = new Label_scheme_sum();
                    scheme_sum.setLid(integer);
                    scheme_sum.setSid(request.getSid());
                    scheme_sum.setLstype(0);
                    scheme_sum.setLsnum(1);
                    lSums.add(scheme_sum);
                }
                // 批量新增方案、方案所属阶段。被用户选择的标签记录表
                Label_scheme_sumSerivce.addLabelschemelist(lSums);
            }
        }
        if (request.getNewLabelids().isEmpty() && !request.getOldLabelids().isEmpty()) {
            // 批量删除
            List<Integer> deletelabels = new ArrayList<Integer>();
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
                scheme_sum.setSid(request.getSid());
                scheme_sum.setLstype(0);
                scheme_sum.setLsnum(1);
                lSums.add(scheme_sum);
            }
            // 批量新增方案、方案所属阶段。被用户选择的标签记录表
            Label_scheme_sumSerivce.addLabelschemelist(lSums);
        }
        return request;
    }

    @RequiresPermissions("scheme:add")
    @RequestMapping("/add")
    @ResponseBody
    @Transactional
    public SchemeAddRequest creScheme(HttpServletRequest servletRequest, SchemeAddRequest request,
                                      @RequestParam(value = "file", required = false) MultipartFile file)
            throws IllegalAccessException, InvocationTargetException {
        User user = (User) servletRequest.getSession().getAttribute("user");
        Scheme scheme = new Scheme();
        if (request != null) {
            BeanUtils.copyProperties(scheme, request);
        }
        String url = FileUploadUtil.ImageUpload(file);
        scheme.setUrid(user.getId().intValue());
        scheme.setSimg(url);
        int sid = schemeService.addScheme(scheme);
        if (!request.getNewLabelids().isEmpty()) {
            List<Label_scheme_sum> lSums = new ArrayList<Label_scheme_sum>();
            Label_scheme_sum scheme_sum;
            String[] labels = request.getNewLabelids().split(",");
            for (String string : labels) {
                scheme_sum = new Label_scheme_sum();
                scheme_sum.setLid(Integer.parseInt(string));
                scheme_sum.setSid(sid);
                scheme_sum.setLstype(0);
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
            newlable[i] = Integer.parseInt(newlabels[i].trim());
        }
        for (int i = 0; i < oldlabels.length; i++) {
            oldlable[i] = Integer.parseInt(oldlabels[i].trim());
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


    /*方案数据处理*/
    private Scheme DataProcessing(Scheme schemerequest) throws Exception {

        if (schemerequest.getSpnum() != null) {
            schemerequest.setSpnum(new String(schemerequest.getSpnum().getBytes("iso8859-1"), "utf-8"));
        }
        if (schemerequest.getSduration() != null) {
            schemerequest.setSduration(new String(schemerequest.getSduration().getBytes("iso8859-1"), "utf-8"));
        }
        if (schemerequest.getSrange() != null) {
            schemerequest.setSrange(new String(schemerequest.getSrange().getBytes("iso8859-1"), "utf-8"));
        }
        if (schemerequest.getSstate() != null && schemerequest.getSstate() == -1) {
            schemerequest.setSstate(null);
        }
        if (schemerequest.getSpnum() != null && schemerequest.getSpnum().equals("请选择....")) {
            schemerequest.setSpnum(null);
        }
        if (schemerequest.getSduration() != null && schemerequest.getSduration().equals("请选择....")) {
            schemerequest.setSduration(null);
        }
        if (schemerequest.getSrange() != null && schemerequest.getSrange().equals("请选择....")) {
            schemerequest.setSrange(null);
        }
        return schemerequest;
    }

}
