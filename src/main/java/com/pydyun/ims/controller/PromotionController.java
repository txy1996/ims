package com.pydyun.ims.controller;

import com.github.pagehelper.PageInfo;
import com.pydyun.ims.model.Product;
import com.pydyun.ims.model.Productimg;
import com.pydyun.ims.model.Promotion;
import com.pydyun.ims.model.PromotionRequest;
import com.pydyun.ims.model.SchemeResponse;
import com.pydyun.ims.model.Shop;
import com.pydyun.ims.service.ProductService;
import com.pydyun.ims.service.ProductimgService;
import com.pydyun.ims.service.PromotionService;
import com.pydyun.ims.service.SchemeService;
import com.pydyun.ims.service.ShopService;
import com.pydyun.ims.util.Analysis2;
import com.pydyun.ims.util.FileUploadUtil;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.PrintWriter;
import java.util.*;

@Controller
@RequestMapping("/promotion")
public class PromotionController
{

    @Resource
    private PromotionService pser;
    @Resource
    private ProductService ps;
    @Resource
    private SchemeService scs;
    @Resource
    private ShopService sop;
    @Resource
    private ProductimgService pts;

    @RequiresPermissions("promotion:list")
    @RequestMapping("/list")
    public ModelAndView promotion(Integer pageNum, Integer pageSize) {
        pageNum = pageNum == null ? 1 : pageNum;
        pageSize = pageSize == null ? 8 : pageSize;
        PageInfo<Promotion> list = pser.selectlist(pageNum, pageSize);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("promotion/list-promotion");
        mv.addObject("list", list);
        return mv;
    }

    @RequestMapping("/polling")
    public ModelAndView polling(Integer pageNum, Integer pageSize,
                                Integer ptype, String bt, String stadate, String enddate,
                                HttpServletRequest request) {
        pageNum = pageNum == null ? 1 : pageNum;
        pageSize = pageSize == null ? 8 : pageSize;
        PageInfo<Promotion> list = pser.polling(pageNum, pageSize, stadate,
                enddate, ptype, bt);
        String falg1 = bt;
        String falg2 = stadate;
        String falg3 = enddate;
        Integer falg4 = ptype;
        ModelAndView mv = new ModelAndView();
        mv.setViewName("promotion/list-promotion");
        request.setAttribute("falg1", falg1);
        request.setAttribute("falg2", falg2);
        request.setAttribute("falg3", falg3);
        request.setAttribute("falg4", falg4);
        mv.addObject("list", list);
        return mv;
    }

    @RequestMapping("/addp")
    public ModelAndView addp() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("promotion/promotion");
        return mv;

    }

    // 查询广告id并返回
    @RequestMapping("/inquire")
    public void inquire(Integer id, HttpServletResponse response)
            throws Exception {
        Integer iter = null;
        List<Promotion> list = pser.inquire(id);
        for (Promotion pro : list) {
            Integer ite = pro.getId();
            iter = ite;
        }
        response.setHeader("Content-type", "text/html;charset=UTF-8");
        PrintWriter wt = response.getWriter();
        wt.print(iter);
        wt.close();
    }

    // 接收推荐数据
    // id为广告列表id,ptype:5=纯文字商户列表(LST:1,2,3)、6=纯文字方案列表(LFT:1,2,3)、7=纯文字商品列表(LPT:1,2,3,4,5)、8=图文商户列表(LS:1,2,3,4)、
    // 9=图文方案列表(LF:1,2,3,4)、10=图文商品列表(LP:1,23,4)、11=商户纯图片列表(LSC:12,3,4,5)、12=方案纯图片列表(LFC:2,4,3,6)、13=商品纯图片列表(LPC:12,3,4)
    //	sid 为商户id, pid 为商品id, scid 为方案id
    @RequestMapping("/Recommend")
    @ResponseBody
    public String Recommend(Integer id, Integer sid, Integer pid, Integer scid)
            throws Exception {
        Promotion pr = new Promotion();
        String s = String.valueOf(sid);
        String p = String.valueOf(pid);
        String sc = String.valueOf(scid);
        List<Promotion> list = pser.Recommend(id);
        for (Promotion pro : list) {
            Integer ptype = pro.getPtype();
            String psource = pro.getPsource();
            if (ptype == 5) {
                if (psource == null || psource == "") {
                    String str = "LST:" + sid;
                    pr.setId(id);
                    pr.setPsource(str);
                    pser.upRecommend(pr);
                } else if (psource.contains(s)) {
                    String str = psource;
                    pr.setId(id);
                    pr.setPsource(str);
                    pser.upRecommend(pr);
                } else {
                    String str = psource + "," + sid;
                    pr.setId(id);
                    pr.setPsource(str);
                    pser.upRecommend(pr);
                }
            } else if (ptype == 6) {
                if (psource == null || psource == "") {
                    String str = "LFT:" + scid;
                    pr.setId(id);
                    pr.setPsource(str);
                    pser.upRecommend(pr);
                } else if (psource.contains(sc)) {
                    String str = psource;
                    pr.setId(id);
                    pr.setPsource(str);
                    pser.upRecommend(pr);
                } else {
                    String str = psource + "," + scid;
                    pr.setId(id);
                    pr.setPsource(str);
                    pser.upRecommend(pr);
                }
                pser.upRecommend(pr);
            } else if (ptype == 7) {
                if (psource == null || psource == "") {
                    String str = "LPT:" + pid;
                    pr.setId(id);
                    pr.setPsource(str);
                    pser.upRecommend(pr);
                } else if (psource.contains(p)) {
                    String str = psource;
                    pr.setId(id);
                    pr.setPsource(str);
                    pser.upRecommend(pr);
                } else {
                    String str = psource + "," + pid;
                    pr.setId(id);
                    pr.setPsource(str);
                    pser.upRecommend(pr);
                }
            } else if (ptype == 8) {
                if (psource == null || psource == "") {
                    String str = "LS:" + sid;
                    pr.setId(id);
                    pr.setPsource(str);
                    pser.upRecommend(pr);
                } else if (psource.contains(s)) {
                    String str = psource;
                    pr.setId(id);
                    pr.setPsource(str);
                    pser.upRecommend(pr);
                } else {
                    String str = psource + "," + sid;
                    pr.setId(id);
                    pr.setPsource(str);
                    pser.upRecommend(pr);
                }
            } else if (ptype == 9) {
                if (psource == null || psource == "") {
                    String str = "LF:" + scid;
                    pr.setId(id);
                    pr.setPsource(str);
                    pser.upRecommend(pr);
                } else if (psource.contains(sc)) {
                    String str = psource;
                    pr.setId(id);
                    pr.setPsource(str);
                    pser.upRecommend(pr);
                } else {
                    String str = psource + "," + scid;
                    pr.setId(id);
                    pr.setPsource(str);
                    pser.upRecommend(pr);
                }
            } else if (ptype == 10) {
                if (psource == null || psource == "") {
                    String str = "LP:" + pid;
                    pr.setId(id);
                    pr.setPsource(str);
                    pser.upRecommend(pr);
                } else if (psource.contains(p)) {
                    String str = psource;
                    pr.setId(id);
                    pr.setPsource(str);
                    pser.upRecommend(pr);
                } else {
                    String str = psource + "," + pid;
                    pr.setId(id);
                    pr.setPsource(str);
                    pser.upRecommend(pr);
                }
            } else if (ptype == 11) {
                if (psource == null || psource == "") {
                    String str = "LSC:" + sid;
                    pr.setId(id);
                    pr.setPsource(str);
                    pser.upRecommend(pr);
                } else if (psource.contains(s)) {
                    String str = psource;
                    pr.setId(id);
                    pr.setPsource(str);
                    pser.upRecommend(pr);
                } else {
                    String str = psource + "," + sid;
                    pr.setId(id);
                    pr.setPsource(str);
                    pser.upRecommend(pr);
                }
            } else if (ptype == 12) {
                if (psource == null || psource == "") {
                    String str = "LFC:" + scid;
                    pr.setId(id);
                    pr.setPsource(str);
                    pser.upRecommend(pr);
                } else if (psource.contains(sc)) {
                    String str = psource;
                    pr.setId(id);
                    pr.setPsource(str);
                    pser.upRecommend(pr);
                } else {
                    String str = psource + "," + scid;
                    pr.setId(id);
                    pr.setPsource(str);
                    pser.upRecommend(pr);
                }
            } else {
                if (psource == null || psource == "") {
                    String str = "LPC:" + pid;
                    pr.setId(id);
                    pr.setPsource(str);
                    pser.upRecommend(pr);
                } else if (psource.contains(p)) {
                    String str = psource;
                    pr.setId(id);
                    pr.setPsource(str);
                    pser.upRecommend(pr);
                } else {
                    String str = psource + "," + pid;
                    pr.setId(id);
                    pr.setPsource(str);
                    pser.upRecommend(pr);
                }
            }
        }
        return "成功";
    }

    // id查询数据
    @RequiresPermissions("promotion:list")
    @RequestMapping("/getPromotion")
    @ResponseBody
    public Promotion getPromotion(Integer id) {
        return pser.getPromotion(id);

    }

    // 编辑页面
    @SuppressWarnings({"rawtypes", "unchecked"})
    @RequestMapping("/edit")
    public ModelAndView edit(Integer id, HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<Promotion> list = pser.edit(id);
        ArrayList arr = new ArrayList();ArrayList arry = new ArrayList();ArrayList arrs = new ArrayList();ArrayList arrp = new ArrayList();
        for (Promotion pro : list) {
            Integer ier = pro.getPtype();
            String str = pro.getPsource();
            if (ier == 2) {
            	Map<String, List<String>> map = Analysis2.find(str);
                for (List<String> li : map.values()) {
                    String st = li.get(1);
                    String[] sr = st.split(":");
                    PromotionRequest promo = new PromotionRequest();
                    promo.setUrl(li.get(0));
                    promo.setWords(li.remove(1));
                    promo.setMarking(sr[0] + ":");
                    promo.setAddress(sr[1]);
                    arr.add(promo);
                }
            }
            if(ier == 8){
            	String[] stre = str.split(":");
            	List<Shop> shops = sop.shops(stre[1]);
            	for (Shop shop : shops) {
					Shop sp = new Shop();
					sp.setSid(shop.getSid());sp.setSname(shop.getSname());sp.setSlogo(shop.getSlogo());
					arrp.add(sp);
				}
            }
            if (ier == 9) {
            	String[] stre = str.split(":");
            	List<SchemeResponse> pscheme = scs.pscheme(stre[1]);
            	for (SchemeResponse sch : pscheme) {
            		SchemeResponse sro = new SchemeResponse();
            		sro.setSid(sch.getSid());sro.setSname(sch.getSname());sro.setSimg(sch.getSimg());
            		arrs.add(sro);
				}
            }
            if (ier == 10) {
            	String[] stre = str.split(":");
            	List<Product> plist = ps.plist(stre[1]);
            	for (Product prod : plist) {
					Product product = new Product();
					product.setId(prod.getId());
					product.setPname(prod.getPname());
					Productimg proc = prod.getImg();
					product.setImg(proc);
					arry.add(product);
				}
            }
        }
        ModelAndView mv = new ModelAndView();
        mv.setViewName("promotion/edit-promotion");
        mv.addObject("list", list);
        mv.addObject("arr", arr);
        mv.addObject("arry", arry);
        mv.addObject("arrs", arrs);
        mv.addObject("arrp", arrp);
        return mv;

    }

    // 修改状态
    @RequiresPermissions("promotion:update")
    @RequestMapping("/update")
    @ResponseBody
    public void update(Promotion promotion) {
        pser.updateshop(promotion);
    }
    //修改按钮
    @RequestMapping("/updata")
    public void updata(Integer obj,Integer id,String pname,HttpServletResponse response,HttpServletRequest request){
    	if(obj == 10){
    		String name = request.getParameter("tenname");
    		System.out.println(name);
    	}
    }
    // 删除按钮
    @RequestMapping("/delete")
    public void delete(/*String obj,*/Integer obj, Integer id, HttpServletResponse response) throws Exception {
    	if(obj == 8){
    		sop.deletesp(id);
    	}
    	if(obj == 9){
    		scs.deletesec(id);
    	}
    	if(obj == 10){
    		ps.deletepro(id);
    		pts.deletept(id);
    	}
        response.setHeader("Content-type", "text/html;charset=UTF-8");
        PrintWriter wt = response.getWriter();
        wt.print(id);
        wt.close();
    }

    @RequiresPermissions("promotion:add")
    @RequestMapping(value = ("/filesUpload"), method = RequestMethod.POST)
    // requestParam要写才知道是前台的那个数组
    public void filesUpload(@RequestParam("myfiles") MultipartFile[] files,
                            Integer Ptype, String pzone, String psource, String pinfo,
                            String sdate, String odate, Integer state, String pdate,
                            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        Promotion pt = new Promotion();
        String bt = request.getParameter("bt");
        String ty = request.getParameter("ty");
        String wz = request.getParameter("wz");
        String dz = request.getParameter("dz");
        String woz = request.getParameter("woz");
        String doz = request.getParameter("doz");
        String wtz = request.getParameter("wtz");
        String dtz = request.getParameter("dtz");
        String dz2 = request.getParameter("dz2");
        String tu = request.getParameter("tu");
        String tp = request.getParameter("tp");
        String wz3 = request.getParameter("wz3");
        String dz3 = request.getParameter("dz3");
        String dz4 = request.getParameter("dz4");
        String shops = request.getParameter("shops");
        String shops1 = request.getParameter("shops1");
        String shops2 = request.getParameter("shops2");
        String shopmore = request.getParameter("shopmore");
        String shopmore1 = request.getParameter("shopmore1");
        String shopmore2 = request.getParameter("shopmore2");
        String stadate = request.getParameter("stadate");
        String enddate = request.getParameter("enddate");
        String stadate1 = request.getParameter("stadate1");
        String enddate1 = request.getParameter("enddate1");
        String ys = request.getParameter("ys");
        Integer a = Integer.parseInt(ys);
        if (shops.equals("URL")) {
            shops = "";
        }
        if (shops1.equals("URL")) {
            shops1 = "";
        }
        if (shops2.equals("URL")) {
            shops2 = "";
        }
        if (shopmore.equals("URL")) {
            shopmore = "";
        }
        if (shopmore1.equals("URL")) {
            shopmore1 = "";
        }
        if (shopmore2.equals("URL")) {
            shopmore2 = "";
        }
        if (a.equals(0)) {
            a = 0;
        } else if (a.equals(1)) {
            a = 1;
        } else {
            a = 2;
        }
        List<String> list = new ArrayList<String>();
        if (files != null && files.length > 0) {
            for (int i = 0; i < files.length; i++) {
                MultipartFile file = files[i];
                // 保存文件
                list = saveFile(request, file, list);
            }
        }
        if (ty.equals("1")) {
            String str = "";
            if (!list.isEmpty()) {
                for (int i = 0; i < list.size(); i++) {
                    str += list.get(i) + "#";
                }
            }
            String[] Str = str.split("#");
            if (Str.length == 1) {
                if (!woz.isEmpty() && !doz.isEmpty() && !stadate.isEmpty()
                        && !enddate.isEmpty()) {
                    String ps = "[IU:" + Str[0] + "#" + woz + "#" + shopmore
                            + doz + "]";
                    String pso = ps;
                    pt.setPsource(pso);
                    pt.setPtype(Integer.parseInt(ty));
                    pt.setPzone(bt);
                    pt.setPinfo(pinfo);
                    pt.setSdate(stadate);
                    pt.setOdate(enddate);
                    pt.setState(a);
                    pt.setPdate(pdate);
                    pser.add(pt);
                } else {
                    response.setHeader("Content-type",
                            "text/html;charset=UTF-8");
                    PrintWriter wt = response.getWriter();
                    wt.print(1);
                    wt.close();
                }
            }
            if (Str.length == 2) {
                if (!woz.isEmpty() && !doz.isEmpty() && !wtz.isEmpty()
                        && !dtz.isEmpty() && !stadate.isEmpty()
                        && !enddate.isEmpty()) {
                    String psoe = "[IU:" + Str[0] + "#" + woz + "#" + shopmore
                            + doz + "]";
                    String psor = "[IU:" + Str[1] + "#" + wtz + "#" + shopmore1
                            + dtz + "]";
                    String pso = psoe + "," + psor;
                    pt.setPsource(pso);
                    pt.setPtype(Integer.parseInt(ty));
                    pt.setPzone(bt);
                    pt.setPinfo(pinfo);
                    pt.setSdate(stadate);
                    pt.setOdate(enddate);
                    pt.setState(a);
                    pt.setPdate(pdate);
                    pser.add(pt);
                } else {
                    response.setHeader("Content-type",
                            "text/html;charset=UTF-8");
                    PrintWriter wt = response.getWriter();
                    wt.print(1);
                    wt.close();
                }
            }
            if (Str.length == 3) {
                if (!wtz.isEmpty() && !dtz.isEmpty() && !dz.isEmpty()
                        && !wz.isEmpty() && !woz.isEmpty() && !doz.isEmpty()
                        && !stadate.isEmpty() && !enddate.isEmpty()) {
                    String psoe = "[IU:" + Str[0] + "#" + woz + "#" + shopmore
                            + doz + "]";
                    String psor = "[IU:" + Str[1] + "#" + wtz + "#" + shopmore1
                            + dtz + "]";
                    String psou = "[IU:" + Str[2] + "#" + wz + "#" + shopmore2
                            + dz + "]";
                    String pso = psoe + "," + psor + "," + psou;
                    pt.setPsource(pso);
                    pt.setPtype(Integer.parseInt(ty));
                    pt.setPzone(bt);
                    pt.setPinfo(pinfo);
                    pt.setSdate(stadate);
                    pt.setOdate(enddate);
                    pt.setState(a);
                    pt.setPdate(pdate);
                    pser.add(pt);
                } else {
                    response.setHeader("Content-type",
                            "text/html;charset=UTF-8");
                    PrintWriter wt = response.getWriter();
                    wt.print(1);
                    wt.close();
                }
            }

        } else if (ty.equals("2")) {
            String str = "";
            if (!list.isEmpty()) {
                for (int i = 0; i < list.size(); i++) {
                    str += list.get(i) + "#";
                }
            }
            String[] aa = str.split("#");
            if (aa.length == 1) {
                if (!stadate.isEmpty() && !enddate.isEmpty()) {
                    String falg = "[I:" + aa[0] + "#" + shops + tu + "]";
                    String pso = falg;
                    pt.setPsource(pso);
                    pt.setPtype(Integer.parseInt(ty));
                    pt.setPzone(bt);
                    pt.setPinfo(pinfo);
                    pt.setSdate(stadate);
                    pt.setOdate(enddate);
                    pt.setState(a);
                    pt.setPdate(pdate);
                    pser.add(pt);
                } else {
                    response.setHeader("Content-type",
                            "text/html;charset=UTF-8");
                    PrintWriter wt = response.getWriter();
                    wt.print(1);
                    wt.close();
                }
            }
            if (aa.length == 2) {
                if (!stadate.isEmpty() && !enddate.isEmpty()) {
                    String falg = "[I:" + aa[0] + "#" + shops + tu + "]";
                    String falg1 = "[I:" + aa[1] + "#" + shops1 + tp + "]";
                    String pso = falg + "," + falg1;
                    pt.setPsource(pso);
                    pt.setPtype(Integer.parseInt(ty));
                    pt.setPzone(bt);
                    pt.setPinfo(pinfo);
                    pt.setSdate(stadate);
                    pt.setOdate(enddate);
                    pt.setState(a);
                    pt.setPdate(pdate);
                    pser.add(pt);
                } else {
                    response.setHeader("Content-type",
                            "text/html;charset=UTF-8");
                    PrintWriter wt = response.getWriter();
                    wt.print(1);
                    wt.close();
                }
            }
            if (aa.length == 3) {
                if (!stadate.isEmpty() && !enddate.isEmpty()) {
                    String falg = "[I:" + aa[0] + "#" + shops + tu + "]";
                    String falg1 = "[I:" + aa[1] + "#" + shops1 + tp + "]";
                    String falg2 = "[I:" + aa[2] + "#" + shops2 + dz2 + "]";
                    String pso = falg + "," + falg1 + "," + falg2;
                    pt.setPsource(pso);
                    pt.setPtype(Integer.parseInt(ty));
                    pt.setPzone(bt);
                    pt.setPinfo(pinfo);
                    pt.setSdate(stadate);
                    pt.setOdate(enddate);
                    pt.setState(a);
                    pt.setPdate(pdate);
                    pser.add(pt);
                } else {
                    response.setHeader("Content-type",
                            "text/html;charset=UTF-8");
                    PrintWriter wt = response.getWriter();
                    wt.print(1);
                    wt.close();
                }
            }
        } else if (ty.equals("3")) {
            if (!dz3.isEmpty() && !wz3.isEmpty() && !stadate.isEmpty()
                    && !enddate.isEmpty()) {
                String pso = "T:" + wz3 + "#" + dz3;
                pt.setPtype(Integer.parseInt(ty));
                pt.setPsource(pso);
                pt.setPzone(bt);
                pt.setPinfo(pinfo);
                pt.setSdate(stadate);
                pt.setOdate(enddate);
                pt.setState(a);
                pt.setPdate(pdate);
                pser.add(pt);
            } else {
                response.setHeader("Content-type", "text/html;charset=UTF-8");
                PrintWriter wt = response.getWriter();
                wt.print(1);
                wt.close();
            }
        } else if (ty.equals("4")) {
            String str = "";
            if (!list.isEmpty()) {
                for (int i = 0; i < list.size(); i++) {
                    str += list.get(i) + "#";
                }
            }
            if (!dz4.isEmpty() && !stadate.isEmpty() && !enddate.isEmpty()) {
                String pso = "V:" + str + "#" + dz4;
                pt.setPtype(Integer.parseInt(ty));
                pt.setPsource(pso);
                pt.setPzone(bt);
                pt.setPinfo(pinfo);
                pt.setSdate(stadate);
                pt.setOdate(enddate);
                pt.setState(a);
                pt.setPdate(pdate);
                pser.add(pt);
            } else {
                response.setHeader("Content-type", "text/html;charset=UTF-8");
                PrintWriter wt = response.getWriter();
                wt.print(1);
                wt.close();
            }
        } else if (ty.equals("5")) {
            if (!stadate1.isEmpty() && !enddate1.isEmpty()) {
                pt.setPtype(Integer.parseInt(ty));
                pt.setPzone(bt);
                pt.setPinfo(pinfo);
                pt.setSdate(stadate1);
                pt.setOdate(enddate1);
                pt.setState(a);
                pt.setPdate(pdate);
                pser.add(pt);
            } else {
                response.setHeader("Content-type", "text/html;charset=UTF-8");
                PrintWriter wt = response.getWriter();
                wt.print(1);
                wt.close();
            }
        } else if (ty.equals("6")) {
            if (!stadate1.isEmpty() && !enddate1.isEmpty()) {
                pt.setPtype(Integer.parseInt(ty));
                pt.setPzone(bt);
                pt.setPinfo(pinfo);
                pt.setSdate(stadate1);
                pt.setOdate(enddate1);
                pt.setState(a);
                pt.setPdate(pdate);
                pser.add(pt);
            } else {
                response.setHeader("Content-type", "text/html;charset=UTF-8");
                PrintWriter wt = response.getWriter();
                wt.print(1);
                wt.close();
            }
        } else if (ty.equals("7")) {
            if (!stadate1.isEmpty() && !enddate1.isEmpty()) {
                pt.setPtype(Integer.parseInt(ty));
                pt.setPzone(bt);
                pt.setPinfo(pinfo);
                pt.setSdate(stadate1);
                pt.setOdate(enddate1);
                pt.setState(a);
                pt.setPdate(pdate);
                pser.add(pt);
            } else {
                response.setHeader("Content-type", "text/html;charset=UTF-8");
                PrintWriter wt = response.getWriter();
                wt.print(1);
                wt.close();
            }
        } else if (ty.equals("8")) {
            if (!stadate1.isEmpty() && !enddate1.isEmpty()) {
                pt.setPtype(Integer.parseInt(ty));
                pt.setPzone(bt);
                pt.setPinfo(pinfo);
                pt.setSdate(stadate1);
                pt.setOdate(enddate1);
                pt.setState(a);
                pt.setPdate(pdate);
                pser.add(pt);
            } else {
                response.setHeader("Content-type", "text/html;charset=UTF-8");
                PrintWriter wt = response.getWriter();
                wt.print(1);
                wt.close();
            }
        } else if (ty.equals("9")) {
            if (!stadate1.isEmpty() && !enddate1.isEmpty()) {
                pt.setPtype(Integer.parseInt(ty));
                pt.setPzone(bt);
                pt.setPinfo(pinfo);
                pt.setSdate(stadate1);
                pt.setOdate(enddate1);
                pt.setState(a);
                pt.setPdate(pdate);
                pser.add(pt);
            } else {
                response.setHeader("Content-type", "text/html;charset=UTF-8");
                PrintWriter wt = response.getWriter();
                wt.print(1);
                wt.close();
            }
        } else if (ty.equals("10")) {
            if (!stadate1.isEmpty() && !enddate1.isEmpty()) {
                pt.setPtype(Integer.parseInt(ty));
                pt.setPzone(bt);
                pt.setPinfo(pinfo);
                pt.setSdate(stadate1);
                pt.setOdate(enddate1);
                pt.setState(a);
                pt.setPdate(pdate);
                pser.add(pt);
            } else {
                response.setHeader("Content-type", "text/html;charset=UTF-8");
                PrintWriter wt = response.getWriter();
                wt.print(1);
                wt.close();
            }
        } else if (ty.equals("11")) {
            if (!stadate1.isEmpty() && !enddate1.isEmpty()) {
                pt.setPtype(Integer.parseInt(ty));
                pt.setPzone(bt);
                pt.setPinfo(pinfo);
                pt.setSdate(stadate1);
                pt.setOdate(enddate1);
                pt.setState(a);
                pt.setPdate(pdate);
                pser.add(pt);
            } else {
                response.setHeader("Content-type", "text/html;charset=UTF-8");
                PrintWriter wt = response.getWriter();
                wt.print(1);
                wt.close();
            }
        } else if (ty.equals("12")) {
            if (!stadate1.isEmpty() && !enddate1.isEmpty()) {
                pt.setPtype(Integer.parseInt(ty));
                pt.setPzone(bt);
                pt.setPinfo(pinfo);
                pt.setSdate(stadate1);
                pt.setOdate(enddate1);
                pt.setState(a);
                pt.setPdate(pdate);
                pser.add(pt);
            } else {
                response.setHeader("Content-type", "text/html;charset=UTF-8");
                PrintWriter wt = response.getWriter();
                wt.print(1);
                wt.close();
            }
        } else {
            if (!stadate1.isEmpty() && !enddate1.isEmpty()) {
                pt.setPtype(Integer.parseInt(ty));
                pt.setPzone(bt);
                pt.setPinfo(pinfo);
                pt.setSdate(stadate1);
                pt.setOdate(enddate1);
                pt.setState(a);
                pt.setPdate(pdate);
                pser.add(pt);
            } else {
                response.setHeader("Content-type", "text/html;charset=UTF-8");
                PrintWriter wt = response.getWriter();
                wt.print(1);
                wt.close();
            }
        }

    }

    public List<String> saveFile(HttpServletRequest request,
                                 MultipartFile file, List<String> list) {
    	String msg = FileUploadUtil.ImageUpload(file);
    	list.add(msg);
//        // 判断文件是否为空
//        String msg = "";// 返回存储路径
//        String fileName = file.getOriginalFilename();// 获取文件名加后缀
//        if (!fileName.isEmpty()) {
//            try {
//                // 保存的文件路径(如果用的是Tomcat服务器，文件会上传到\\%TOMCAT_HOME%\\webapps\\YourWebProject\\upload\\文件夹中
//                // )
//                // String filePath =
//                // request.getSession().getServletContext().getRealPath("/") +
//                // "upload/" + file.getOriginalFilename();
//                String returnUrl = "http" + "://" + "192.168.31.160" + ":"
//                        + "8080" + "/ims" + "/upload/image/photo";// 存储路径
//                String path = "D:/workspace/ims/ims/ims/src/main/webapp/upload/image/photo"; // 文件存储位置
//                String fileF = fileName.substring(fileName.lastIndexOf("."),
//                        fileName.length());// 文件后缀
//                fileName = new Date().getTime() + "_"
//                        + new Random().nextInt(1000) + fileF;// 新的文件名
//                File file1 = new File(path + "/");
//                msg = returnUrl + "/" + fileName;
//                list.add(msg);
//                File saveDir = new File(file1, fileName);
//                if (!saveDir.getParentFile().exists())
//                    saveDir.getParentFile().mkdirs();
//
//                // 转存文件
//                file.transferTo(saveDir);
//                return list;
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
        return list;

    }

    // 修改
    @RequestMapping("/updatapro")
    public void updatapro(@RequestParam("myfiles") MultipartFile[] files,
                          Integer Ptype, String pzone, String psource, String pinfo,
                          String sdate, String odate, Integer state, String pdate,
                          HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        Promotion pt = new Promotion();
        String bt = request.getParameter("bt");
        String ty = request.getParameter("ty");
        String wz = request.getParameter("wz");
        String dz = request.getParameter("dz");
        String dz2 = request.getParameter("dz2");
        String wz3 = request.getParameter("wz3");
        String dz3 = request.getParameter("dz3");
        String dz4 = request.getParameter("dz4");
        String sh = request.getParameter("sh");
        String fn = request.getParameter("fn");
        String sp = request.getParameter("sp");
        String id = request.getParameter("id");
        String url = request.getParameter("urll");
        String stadate = request.getParameter("stadate");
        String enddate = request.getParameter("enddate");
        String ys = request.getParameter("ys");
        String shopmore = request.getParameter("shopmore");
        Integer a = Integer.parseInt(ys);
        if (a.equals(0)) {
            a = 0;
        } else if (a.equals(1)) {
            a = 1;
        } else {
            a = 2;
        }

        List<String> list = new ArrayList<String>();
        if (files != null && files.length > 0) {
            for (int i = 0; i < files.length; i++) {
                MultipartFile file = files[i];
                // 保存文件
                list = saveFile(request, file, list);
            }
        }
        if (ty.equals("1")) {
            String str = "";
            if (!list.isEmpty()) {
                for (int i = 0; i < list.size(); i++) {
                    str += list.get(i) + "#";
                }
            }
            if (str.isEmpty()) {
                String pso = "[IU:" + url + "#" + wz + "#" + shopmore + dz + "]";
                pt.setPtype(Integer.parseInt(ty));
                pt.setPsource(pso);
            } else {
                String pso = "[IU:" + str + "#" + wz + "#" + shopmore + dz + "]";
                pt.setPtype(Integer.parseInt(ty));
                pt.setPsource(pso);
            }
        } else if (ty.equals("2")) {
            if (!list.isEmpty()) {
                String str = "";
                for (int i = 0; i < list.size(); i++) {
                    str += list.get(i) + "#";
                }
                String pso = "[I:" + str + "#" + dz2 + "]";
                pt.setPtype(Integer.parseInt(ty));
                pt.setPsource(pso);
            } else {
                String pso = dz2;
                pt.setPtype(Integer.parseInt(ty));
                pt.setPsource(pso);
            }
        } else if (ty.equals("3")) {
            String pso = wz3 + "#" + dz3;
            pt.setPtype(Integer.parseInt(ty));
            pt.setPsource(pso);
        } else if (ty.equals("4")) {
            if (!list.isEmpty()) {
                String str = "";
                for (int i = 0; i < list.size(); i++) {
                    str += list.get(i) + "#";
                }
                String pso = str + "#" + dz4;
                pt.setPtype(Integer.parseInt(ty));
                pt.setPsource(pso);
            } else {
                String pso = dz4;
                pt.setPtype(Integer.parseInt(ty));
                pt.setPsource(pso);
            }
        } else if (ty.equals("5")) {
            String pso = sh;
            pt.setPtype(Integer.parseInt(ty));
            pt.setPsource(pso);
        } else if (ty.equals("6")) {
            String pso = fn;
            pt.setPtype(Integer.parseInt(ty));
            pt.setPsource(pso);
        } else if (ty.equals("7")) {
            String pso = sp;
            pt.setPtype(Integer.parseInt(ty));
            pt.setPsource(pso);
        } else if (ty.equals("8")) {
//            if (!list.isEmpty()) {
//                String str = "";
//                for (int i = 0; i < list.size(); i++) {
//                    str += list.get(i) + "#";
//                }
//                String pso = str + "#" + tsh;
//                pt.setPtype(Integer.parseInt(ty));
//                pt.setPsource(pso);
//            } else {
//                String pso = tsh;
//                pt.setPtype(Integer.parseInt(ty));
//                pt.setPsource(pso);
//            }
        } else if (ty.equals("9")) {
//            if (!list.isEmpty()) {
//                String str = "";
//                for (int i = 0; i < list.size(); i++) {
//                    str += list.get(i) + "#";
//                }
//                String pso = str + "#" + tfn;
//                pt.setPtype(Integer.parseInt(ty));
//                pt.setPsource(pso);
//            } else {
//                String pso = tfn;
//                pt.setPtype(Integer.parseInt(ty));
//                pt.setPsource(pso);
//            }
        } else if (ty.equals("10")) {
        	String psour = request.getParameter("psour");
        	if (!stadate.isEmpty() && !enddate.isEmpty()) {
                pt.setId(Integer.parseInt(id));
                pt.setPzone(bt);
                pt.setPinfo(pinfo);
                pt.setPsource(psour);
                pt.setSdate(stadate);
                pt.setOdate(enddate);
                pt.setState(a);
                pt.setPdate(pdate);
                pser.updatepro(pt);
            } else {
                response.setHeader("Content-type", "text/html;charset=UTF-8");
                PrintWriter wt = response.getWriter();
                wt.print(1);
                wt.close();
            }
        } else if (ty.equals("11")) {
            String str = "";
            for (int i = 0; i < list.size(); i++) {
                str += list.get(i) + "#";
            }
            String pso = str + "#";
            pt.setPsource(pso);
            pt.setPtype(Integer.parseInt(ty));
        } else if (ty.equals("12")) {
            String str = "";
            for (int i = 0; i < list.size(); i++) {
                str += list.get(i) + "#";
            }
            String pso = str + "#";
            pt.setPtype(Integer.parseInt(ty));
            pt.setPsource(pso);
        } else {
            String str = "";
            for (int i = 0; i < list.size(); i++) {
                str += list.get(i) + "#";
            }
            String pso = str + "#";
            pt.setPtype(Integer.parseInt(ty));
            pt.setPsource(pso);
        }
        
//        if (!stadate.isEmpty() && !enddate.isEmpty()) {
//            pt.setId(Integer.parseInt(id));
//            pt.setPzone(bt);
//            pt.setPinfo(pinfo);
//            pt.setSdate(stadate);
//            pt.setOdate(enddate);
//            pt.setState(a);
//            pt.setPdate(pdate);
//            pser.updatepro(pt);
//        } else {
//            response.setHeader("Content-type", "text/html;charset=UTF-8");
//            PrintWriter wt = response.getWriter();
//            wt.print(1);
//            wt.close();
//        }

    }

    /*根据分类查询有效广告位*/
    @RequestMapping("/findPromotionByPtype")
    @ResponseBody
    public List<Promotion> findPromotionByPtype(Integer ptype) {
        List<Promotion> list = pser.findPromotionByPtype(ptype);
        return list;
    }
}
