package com.pydyun.ims.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.pydyun.ims.model.Label;
import com.pydyun.ims.model.Label_class;
import com.pydyun.ims.service.LabelClassService;
import com.pydyun.ims.service.LabelService;
import com.pydyun.ims.service.Label_scheme_sumSerivce;
import com.pydyun.ims.service.Label_shop_sumSerivce;
import com.pydyun.ims.service.PreferenceService;
import com.pydyun.ims.service.UserService;

@Controller
@RequestMapping("/label")
public class LabelController
{

    @Resource
    private LabelService LabelService;
    @Resource
    private LabelClassService LabelclassService;
    @Resource
    private Label_scheme_sumSerivce lsscheme;
    @Resource
    private Label_shop_sumSerivce lsshop;
    @Resource
    private PreferenceService pre;
    @Resource
    private UserService userservice;

    @RequiresPermissions("label:list")
    @RequestMapping("/list")
    public ModelAndView select(Integer pageNum, Integer pageSize, String text, Integer urid)
    {
        pageNum = pageNum == null ? 1 : pageNum;
        pageSize = pageSize == null ? 8 : pageSize;
        // if(lcid!=null){
        // label.setLcid(Integer.parseInt(lcid));
        // }
        Integer lcid = null;
        if (text != null)
        {
            Pattern p = Pattern.compile("\\s*|\t|\r|\n");
            Matcher m = p.matcher(text);
            String dest = m.replaceAll("");
            lcid = LabelclassService.findid(dest);
        }
        PageInfo<Label> list = LabelService.select(pageNum, pageSize, lcid, urid);
        List<Label> list1 = list.getList();
        if (list1 != null && list1.size() != 0)
        {
            for (Label l : list1)
            {
                Integer fanum = lsscheme.findfabyid(l.getLid());
                if (fanum == null)
                {
                    l.setFanum(0);
                }
                else
                {
                    l.setFanum(fanum);
                }
                Integer jdnum = lsscheme.findjdbyid(l.getLid());
                if (jdnum == null)
                {
                    l.setJdnum(0);
                }
                else
                {
                    l.setJdnum(jdnum);
                }
                Integer shnum = lsshop.findshbyid(l.getLid());
                if (shnum == null)
                {
                    l.setShnum(0);
                }
                else
                {
                    l.setShnum(shnum);
                }
                Integer yhnum = pre.findyhbyid(l.getLid());
                if (yhnum == null)
                {
                    l.setYhnum(0);
                }
                else
                {
                    l.setYhnum(yhnum);
                }
                String name = userservice.findname(l.getUrid());
                l.setCjren(name);
            }
        }
        List<Label_class> list2 = LabelclassService.selectall();
        Gson gson = new Gson();
        String json = gson.toJson(list2);
        List<Label_class> listname = LabelService.list();
        ModelAndView mv = new ModelAndView("label/label");
        mv.addObject("list", list);
        mv.addObject("list2", list2);
        mv.addObject("listname", listname);
        mv.addObject("urid", urid);
        mv.addObject("json", json);
        // System.err.println(json);
        return mv;
    }

    // 删除
    @RequiresPermissions("label:delete")
    @RequestMapping("/delete")
    @ResponseBody
    public void delete(Integer lid, Integer urid)
    {
        LabelService.delete(lid, urid);
    }

    // ID查询
    @RequiresPermissions("label:list")
    @RequestMapping("/getLabel")
    @ResponseBody
    public Label getLabel(Integer lid)
    {
        Label label = LabelService.getLabel(lid);
        if (label == null || label.equals(""))
        {
            Label_class ls = new Label_class();
            ls.setText("请选择");
            label = LabelService.getLabel1(lid);
            label.setLabelclass(ls);
        }
        return label;

    }

    // 修改
    @RequiresPermissions("label:update")
    @RequestMapping("/update")
    @ResponseBody
    public void update(Integer lcid, String lcinfo, Integer lid)
    {
        // LabelService.findid(lcinfo);
        Label label = new Label();
        label.setLcid(lcid);
        label.setLcinfo(lcinfo);
        label.setLid(lid);
        LabelService.update(label);
    }

    // 新增
    @RequiresPermissions("label:add")
    @RequestMapping("/add")
    @ResponseBody
    public Label add(Integer urid, String lcinfo, String lcname)
    {
        Label label = new Label();
        if (urid != null)
        {
            label.setUrid(urid);
        }
        if (lcname != null)
        {
            Pattern p = Pattern.compile("\\s*|\t|\r|\n");
            Matcher m = p.matcher(lcname);
            String dest = m.replaceAll("");
            label.setLcid(LabelclassService.findid(dest));
        }
        label.setLcinfo(lcinfo);
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(date);
        label.setLcdate(dateString);
        LabelService.add(label);
        return label;
    }

    @RequiresPermissions("label:tree")
    @RequestMapping("/tree")
    @ResponseBody
    public List tree()
    {
        List<Label_class> list = LabelclassService.selectall();
        // for(Label_class lc:list){
        // lc.setText(lc.getLcname());
        // }
        return list;
    }

    // @RequestMapping("/foundLabelAll")
    // @ResponseBody
    // public List<Label> foundLabelAll()
    // {
    // Label label = new Label();
    // List<Label> labels = LabelService.foundLabelAll(label);
    // return labels;
    //
    // }

    // ID查询
    // @RequiresPermissions("label:list")
    // @RequestMapping("/getLabel")
    // @ResponseBody
    // public Label getLabel(String lcname,String lcinfo,Integer lid){
    // return LabelService.getLabel(lid);
    //
    // }

    /**
     * @Title: selectAll
     * @Description: TODO(方案所需标签查询)
     * @param lcid
     * @param urid
     * @return
     */
    @RequestMapping("/selectByLcid")
    @ResponseBody
    public List<Label> selectByLcid(Integer lcid, Integer urid)
    {
        urid=null;
        return LabelService.SelectAll(lcid, urid);

    }
}
