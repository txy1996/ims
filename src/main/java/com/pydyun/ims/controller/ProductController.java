package com.pydyun.ims.controller;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.security.InvalidParameterException;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.pydyun.ims.model.Product;
import com.pydyun.ims.model.ProductAddRequest;
import com.pydyun.ims.model.ProductClass;
import com.pydyun.ims.model.ProductRequest;
import com.pydyun.ims.model.ProductResponse;
import com.pydyun.ims.model.ProductUpdateResponse;
import com.pydyun.ims.model.Productimg;
import com.pydyun.ims.model.Promotion;
import com.pydyun.ims.model.Shop;
import com.pydyun.ims.service.ProductClassService;
import com.pydyun.ims.service.ProductService;
import com.pydyun.ims.service.ProductimgService;
import com.pydyun.ims.service.PromotionService;
import com.pydyun.ims.service.ShopService;
import com.pydyun.ims.util.BusinessInformation;
import com.pydyun.ims.util.FileUploadUtil;

/**
 * @author tangxiaoyu
 * @ClassName: ProductController
 * @Description: TODO(商品类前端控制器)
 * @date 2018年7月23日 下午5:47:10
 */
@RequestMapping("/product")
@Controller
public class ProductController
{
    @Resource
    private ProductService productService;

    @Resource
    private ShopService shopService;

    @Resource
    private ProductimgService productimgService;

    @Resource
    private ProductClassService productClassService;

    @Resource
    private PromotionService promotionService;


    /**
     * @param pageNum
     * @param pageSize
     * @param request
     * @return
     * @throws UnsupportedEncodingException
     * @Title: selectProduct
     * @Description: TODO(条件分页查询)
     */
    @RequiresPermissions("product:list")
    @RequestMapping("/selectProduct")
    public ModelAndView selectProduct(Integer pageNum, Integer pageSize, ProductRequest request, Integer id,Integer scid,
    		String choise)throws UnsupportedEncodingException {
        pageNum = pageNum == null ? 1 : pageNum;
        pageSize = pageSize == null ? 8 : pageSize;
        if(scid != null){
        	String chois = null;
        	if(scid==12){
        		PageInfo<ProductResponse> list = productService.selectPro(pageNum, pageSize, scid,chois);
        		 ModelAndView mv = new ModelAndView("product/product-list");
                 mv.addObject("list", list);
                 return mv;
        	}else if(scid==17){
        		PageInfo<ProductResponse> list = productService.selectPro(pageNum, pageSize, scid,chois);
        		 ModelAndView mv = new ModelAndView("product/product-list");
                 mv.addObject("list", list);
                 return mv;
        	}else if(scid==20){
        		PageInfo<ProductResponse> list = productService.selectPro(pageNum, pageSize, scid,chois);
        		 ModelAndView mv = new ModelAndView("product/product-list");
                 mv.addObject("list", list);
                 return mv;
        	}else if(scid==22){
        		PageInfo<ProductResponse> list = productService.selectPro(pageNum, pageSize, scid,chois);
        		 ModelAndView mv = new ModelAndView("product/product-list");
                 mv.addObject("list", list);
                 return mv;
        	}else if(scid==24){
        		PageInfo<ProductResponse> list = productService.selectPro(pageNum, pageSize, scid,chois);
        		 ModelAndView mv = new ModelAndView("product/product-list");
                 mv.addObject("list", list);
                 return mv;
        	}else if(scid==25){
        		PageInfo<ProductResponse> list = productService.selectPro(pageNum, pageSize, scid,chois);
        		 ModelAndView mv = new ModelAndView("product/product-list");
                 mv.addObject("list", list);
                 return mv;
        	}else if(scid==26){
        		PageInfo<ProductResponse> list = productService.selectPro(pageNum, pageSize, scid,chois);
        		 ModelAndView mv = new ModelAndView("product/product-list");
                 mv.addObject("list", list);
                 return mv;
        	}else if(scid==33){
        		PageInfo<ProductResponse> list = productService.selectPro(pageNum, pageSize, scid,chois);
        		 ModelAndView mv = new ModelAndView("product/product-list");
                 mv.addObject("list", list);
                 return mv;
        	}else{
        	String stra = null;
        	String[] str = choise.split("-");
        	Pattern pattern = Pattern.compile("\\d+");    
            Matcher matcher = pattern.matcher(str[1]); 
            while ( matcher.find() ) {
            	 stra =  matcher.group();
            	}    
        	PageInfo<ProductResponse> list = productService.selectPro(pageNum, pageSize, scid,stra);
        	
        	 ModelAndView mv = new ModelAndView("product/product-list");
             mv.addObject("list", list);
             return mv;
        	}
        }else{
        if (request.getPname() != null) {
            request.setPname(new String(request.getPname().getBytes("iso8859-1"), "utf-8"));
        }
        PageInfo<ProductResponse> list = productService.selectPage(pageNum, pageSize, request);
        if (request.getCname() != null) {
            request.setCname(new String(request.getCname().getBytes("iso8859-1"), "utf-8"));
        }
        Promotion promotion = new Promotion();
        if (id != null) {
            promotion = promotionService.edit1(id);
        }
        ModelAndView mv = new ModelAndView("product/product-list");
        mv.addObject("list", list);
        mv.addObject("request", request);
        mv.addObject("promotion", promotion);
        return mv;
        }
    }

    /**
     * @param product
     * @return
     * @throws UnsupportedEncodingException
     * @Title: addProduct
     * @Description: TODO(新增商品界面)
     */
    @RequiresPermissions("product:add")
    @RequestMapping("/addProduct")
    @ResponseBody
    public ModelAndView addProduct(Product product, String pcname, String pcid, String model) throws UnsupportedEncodingException {
        ModelAndView mv = new ModelAndView("product/" + model);

        if (pcname != null) {
            pcname = new String(pcname.getBytes("iso8859-1"), "utf-8");
        }
        Shop shop = new Shop();
        if (product.getSid() != null) {
            shop = shopService.getByShopId(product.getSid());
        }
        mv.addObject("shop", shop);
        mv.addObject("product", product);
        mv.addObject("pcname", pcname);
        mv.addObject("pcid", pcid);
        return mv;

    }

    @RequestMapping("/addProductAddRequest")
    @ResponseBody
    public ProductAddRequest addProductAddRequest(@RequestParam(value = "file", required = false) MultipartFile file,
                                                  ProductAddRequest addRequest) throws IllegalAccessException, InvocationTargetException {
        Product product = new Product();
        BeanUtils.copyProperties(product, addRequest);
        product.setStime(new Date());
        product.setSutime(new Date());
        // 新增商品
        product = productService.addProduct(product);

        if (!file.isEmpty()) {
            Productimg productimg = new Productimg();
            // 文件上传
            String url = FileUploadUtil.ImageUpload(file);
            productimg.setPid(product.getId());
            productimg.setName(addRequest.getImgname());
            productimg.setUrl(url);
            productimg.setUpdata(new Date());
            productimg.setTfimg(0);

            // 新增商品图片
            productimgService.addProductimg(productimg);
        }

        return addRequest;

    }

    /**
     * @Title: updateProductAddRequest
     * @Description: TODO(商品信息修改)
     * @param: [file, updateRequest]
     * @return:com.pydyun.ims.model.ProductAddRequest
     * @Date: 2018/9/1 10:36
     */
    @RequestMapping("/updateProductAddRequest")
    @ResponseBody
    public ProductAddRequest updateProductAddRequest(@RequestParam(value = "file", required = false) MultipartFile file,
                                                     HttpServletRequest servletRequest, ProductAddRequest updateRequest) throws Exception {

        Product product = new Product();
        BeanUtils.copyProperties(product, updateRequest);
        if (product.getSid() == null) {
            throw new InvalidParameterException("商户id不能为空");
        }
        product.setSutime(new Date());
        // 修改商品
        productService.updateProduct(product);
        if (!file.isEmpty()) {
            String OldSimg = updateRequest.getUrl().replace(BusinessInformation.DELETE_PREFIX, "");
            String path = servletRequest.getSession().getServletContext().getRealPath(OldSimg);
            File oldfile = new File(path);
            if (oldfile.isFile() && oldfile.exists()) {
                oldfile.delete();
            }

            productimgService.deleteProductimg(updateRequest.getImgid());
            Productimg productimg = new Productimg();
            // 文件上传
            String url = FileUploadUtil.ImageUpload(file);
            productimg.setPid(product.getId());
            productimg.setName(updateRequest.getImgname());
            productimg.setUrl(url);
            productimg.setUpdata(new Date());
            productimg.setTfimg(0);

            // 新增商品图片
            productimgService.addProductimg(productimg);
        }

        return updateRequest;

    }

    /**
     * @param product
     * @Title: updateProduct
     * @Description: TODO(修改商品界面)
     */
    @RequestMapping("/updateProduct")
    @ResponseBody
    public ModelAndView updateProduct(Product product) throws Exception {
        Integer cid = productService.findcid(product.getId());
        Integer findmodel = productClassService.findmodel(cid);
        ProductUpdateResponse response = productService.selectProductById(product.getId());

        ModelAndView mv = new ModelAndView("product/update-" + findmodel);

        Shop shop = new Shop();
        if (product.getSid() != null) {
            shop = shopService.getByShopId(product.getSid());
        }
        mv.addObject("shop", shop);
        mv.addObject("response", response);
        return mv;
    }

    @RequestMapping("/updateProductInfo")
    @ResponseBody
    public ProductUpdateResponse updateProductInfo(Product product) {

        ProductUpdateResponse response = productService.selectProductById(product.getId());

        return response;
    }

    /**
     * @param product
     * @return
     * @Title: updateProductState
     * @Description: TODO(修改商品状态)
     */
    @RequestMapping("/updateProductState")
    @ResponseBody
    public Product updateProductState(Product product) {

        productService.updateProduct(product);

        return product;
    }


    /**
     * @param product
     * @throws InvalidParameterException
     * @Title: DataVerification
     * @Description: TODO(数据验证)
     */
    private void DataVerification(Product product) throws InvalidParameterException {
        if (product.getSid() == null) {
            throw new InvalidParameterException("商户id不能为空");
        }
        if (product.getPname().isEmpty()) {
            throw new InvalidParameterException("商品名称不能为空");
        }
        if (product.getCid() == null) {
            throw new InvalidParameterException("商品所属分类id不能为空");
        }
        if (product.getInfo().isEmpty()) {
            throw new InvalidParameterException("商品详情不能为空");
        }
        if (product.getProperty().isEmpty()) {
            throw new InvalidParameterException("商品属性不能为空");
        }

    }

    @RequestMapping("/findmodel")
    @ResponseBody
    public String findmodel(Integer pcid) {
        Integer model = productClassService.findmodel(pcid);
        StringBuilder sb = new StringBuilder();
        sb.append("list-");
        sb.append(model);
        return sb.toString();
    }

    @RequestMapping("/selectAll")
    @ResponseBody
    public List<ProductClass> selectAll(Integer pcid) {
        List<ProductClass> list = productClassService.finds();
        return list;
    }

    /*根据分类查询商品*/
    @RequestMapping("/findProductByClass")
    @ResponseBody
    public PageInfo<ProductResponse> findProductByClass(Integer pageNum, Integer pageSize, ProductRequest request) throws UnsupportedEncodingException {
        pageNum = pageNum == null ? 1 : pageNum;
        pageSize = pageSize == null ? 8 : pageSize;
        PageInfo<ProductResponse> list = productService.selectPage(pageNum, pageSize, request);
        return list;
    }
}
