package com.pydyun.ims.controller;

import java.util.List;

import javax.annotation.Resource;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.pydyun.ims.model.Label_class;
import com.pydyun.ims.service.LabelClassService;

@Controller
@RequestMapping("/labelclass")
public class LabelClassController
{

    @Resource
    private LabelClassService labelClassService;

    @RequiresPermissions("labelclass:list")
    @RequestMapping("/list")
    public ModelAndView select(Integer pageNum, Integer pageSize)
    {
        pageNum = pageNum == null ? 1 : pageNum;
        pageSize = pageSize == null ? 8 : pageSize;
        PageInfo<Label_class> list = labelClassService.select(pageNum, pageSize);
        for (Label_class aa : list.getList())
        {
            if (aa.getLclcid() == null || aa.getLclcid().equals(""))
            {
                aa.setLclcid(0);
            }
            aa.setLclcname(labelClassService.findlclcname(aa.getLclcid()));
        }
        ModelAndView mv = new ModelAndView("label/labelcation");
        mv.addObject("list", list);
        return mv;
    }

    // 删除单个
    @RequiresPermissions("labelclass:delete")
    @RequestMapping("/delete")
    @ResponseBody
    @Transactional
    public void deleteLabelClass(Integer lcid)
    {
        deletechild(lcid);
        labelClassService.delete(lcid);
    }

    public void deletechild(Integer lcid)
    {
        List<Label_class> list = labelClassService.findscscid(lcid);
        if (list != null && list.size() != 0)
        {
            for (Label_class lc : list)
            {
                deleteLabelClass(lc.getLcid());
            }
        }
    }

    // 新增
    @RequiresPermissions("labelclass:add")
    @RequestMapping("/add")
    @ResponseBody
    public Label_class addLabelClass(Label_class label_class)
    {
        if (label_class.getLcid() == null || label_class.getLcid().equals(""))
        {
            label_class.setLclcid(0);
        }
        else if (label_class.getLcid() != null)
        {
            label_class.setLclcid(label_class.getLcid());
        }
        label_class.setLcid(0);
        label_class.setText(label_class.getText());
        labelClassService.add(label_class);
        return label_class;

    }

    // 更新
    @RequiresPermissions("labelclass:update")
    @RequestMapping("/update")
    @ResponseBody
    public void update(Label_class label_class)
    {
        labelClassService.update(label_class);

    }

    // ID查询
    @RequiresPermissions("labelclass:list")
    @RequestMapping("/getByLclcid")
    @ResponseBody
    public Label_class getByLclcid(Integer lcid)
    {
        Label_class label_class = labelClassService.getByLclcid(lcid);
        return label_class;

    }

    /**
     * @Title: selectall 
     * @Description: TODO(方案所需的标签类查询方法) 
     * @return
     */
    @RequestMapping("/selectall")
    @ResponseBody
    public List<Label_class> selectall()
    {
        return labelClassService.selectall();

    }
    
    @RequestMapping("/selectname")
    @ResponseBody
    public String selectname(Integer lcid)
    {
        return labelClassService.findlclcname(lcid);

    }
}
