package com.pydyun.ims.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pydyun.ims.model.Property;
import com.pydyun.ims.service.PropertyService;
/**
 * @ClassName: PropertyController 
 * @Description: TODO(商品属性) 
 * @author tangxiaoyu 
 * @date 2018年8月1日 上午9:10:28 
 *
 */
@Controller
@RequestMapping("/property")
public class PropertyController
{

    @Resource
    private PropertyService propertyService;

    @RequestMapping("/selectBypcid")
    @ResponseBody
    public List<Property> selectBypcid(Integer pcid)
    {

        return propertyService.selectBypcid(pcid);
    }
}
