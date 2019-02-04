package com.pydyun.ims.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.pydyun.ims.model.ProductClass;
import com.pydyun.ims.model.Property;
import com.pydyun.ims.service.ProductClassService;
import com.pydyun.ims.service.PropertyService;

@Controller
@RequestMapping("/productclass")
public class ProductClassController
{

    @Resource
    ProductClassService productClassService;
    @Resource
    PropertyService propertyService;

    @RequiresPermissions("productclass:list")
    @RequestMapping("/list")
    public ModelAndView select(Integer pageNum, Integer pageSize)
    {
        pageNum = pageNum == null ? 1 : pageNum;
        pageSize = pageSize == null ? 8 : pageSize;
        PageInfo<ProductClass> list = productClassService.getProductClass(pageNum, pageSize);
        for (ProductClass prc : list.getList())
        {
            if (prc.getCid() == null || prc.getCid().equals(""))
            {
                prc.setCid(0);
            }
            prc.setCcname(productClassService.findccname(prc.getCid()));
        }
        ModelAndView mv = new ModelAndView("product/productClass");
        mv.addObject("list", list);
        return mv;
    }

    @RequiresPermissions("productclass:add")
    @RequestMapping("/add")
    @ResponseBody
    public ProductClass add(ProductClass productClass)
    {
        /*if (productClass.getId() == null || productClass.getId().equals(""))
        {
            productClass.setCid(0);
        }
        else */
    	if (productClass.getId() != null)
        {
            productClass.setCid(productClass.getId());
        }
        productClass.setId(null);
        productClass.setText(productClass.getText());
        productClass.setTemplet_list(productClass.getTemplet_list());
        productClass.setTemplet_product(productClass.getTemplet_list());
        productClassService.addClass(productClass);
        return productClass;

    }

    @RequiresPermissions("productclass:list")
    @RequestMapping("/selectproperty")
    @ResponseBody
    public List<Property> selectproperty(@RequestParam("id") Integer id, HttpServletRequest req)
    {
        List<Property> list = propertyService.selectBypcid(id);
        return list;
    }

    @RequiresPermissions("productclass:delete")
    @RequestMapping("/delete")
    @ResponseBody
    public List<Property> deleteproperty(@RequestParam("id") Integer id,@RequestParam("id1") Integer id1)
    {
        propertyService.delete(id);
        List<Property> list = propertyService.selectBypcid(id1);
        return list;
    }

    @RequiresPermissions("productclass:selectall")
    @RequestMapping("/selectall")
    @ResponseBody
    public List<Property> selectall()
    {
        List<Property> list = propertyService.selectall();
        return list;
    }

    @RequiresPermissions("productclass:addproperty")
    @RequestMapping("/addproperty")
    @ResponseBody
    public List<Property> addproperty(@RequestParam("id") Integer id, @RequestParam("sorpname") String sorpname)
    {
        List<String> list = new ArrayList<String>();
        Pattern p = Pattern.compile("(\\[[^\\]]*\\])");
        Matcher m = p.matcher(sorpname);
        while (m.find())
        {
            list.add(m.group().substring(1, m.group().length() - 1));
        }
        Property pro = new Property();
        if (list.size() != 0)
        {
            String name = list.get(0);
            String propertyvalue = list.get(1);

            pro.setName(name);
            pro.setPcid(id);
            pro.setPropertyvalue(propertyvalue);
            propertyService.insert(pro);
        }
        List<Property> list1 = propertyService.selectBypcid(id);
        return list1;
    }

    @RequiresPermissions("productclass:addpropertyplus")
    @RequestMapping("/addpropertyplus")
    @ResponseBody
    public List<Property> addpropertyplus(@RequestParam("id") Integer id, @RequestParam("fname") String fname,
            @RequestParam("fpropertyvalue") String fpropertyvalue)
    {
        Property pro = new Property();
        pro.setName(fname);
        pro.setPcid(id);
        pro.setPropertyvalue(fpropertyvalue);
        propertyService.insert(pro);
        List<Property> list1 = propertyService.selectBypcid(id);
        return list1;

    }

    @RequiresPermissions("productclass:selectbyid")
    @RequestMapping("/selectbyid")
    @ResponseBody
    public String selectbyid(@RequestParam("id") Integer id)
    {
        String name = productClassService.selectbyid(id);
        return name;
    }

    /**
     * 删除商品分类
     */
    @RequiresPermissions("productclass:delete1")
    @RequestMapping("/delete1")
    @ResponseBody
    @Transactional
    public void deleteClass(Integer id)
    {
        deletechild(id);
        productClassService.deleteByid(id);
    }
    //递归
    public void deletechild(Integer id)
    {
        List<ProductClass> list = productClassService.findcid(id);
        propertyService.deletproperty(id);
        if (list != null && list.size() != 0)
        {
            for (ProductClass pc : list)
            {
//                List<Property> list2 = propertyService.selectBypcid(pc.getId());
//                if (list2 != null && list2.size() != 0)
//                {
//                    for (Property a : list2)
//                    {
//                        propertyService.delete(a.getId());
//                    }
//                }
                deleteClass(pc.getId());
            }
        }
    }

    /**
     * @Title: selectAll
     * @Description: TODO(用于商品分类树形下拉列表)
     * @return
     */
    @RequestMapping("/selectAll")
    @ResponseBody
    public List<ProductClass> selectAll()
    {
        return productClassService.selectAll();

    }
    
	@RequestMapping("/selectname")
	@ResponseBody
	public String selectname(Integer id){
		return productClassService.findccname(id);
	}
	
	@RequestMapping("/selecttemplet")
	@ResponseBody
	public List<ProductClass> selecttemplet(){
		List<ProductClass> findtemplet = productClassService.findtemplet();
		return findtemplet;
	}
}
