package com.pydyun.ims.service.impl.wximpl;

import java.lang.reflect.InvocationTargetException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pydyun.ims.model.*;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pydyun.ims.dao.WxOrderGoodsDao;
import com.pydyun.ims.dao.WxOrdersDao;
import com.pydyun.ims.dao.WxProductDao;
import com.pydyun.ims.dao.WxVoucherDao;
import com.pydyun.ims.service.wxservice.WxOrdersService;
import com.pydyun.ims.util.BusinessInformation;

@Service
public class WxOrdersServiceImpl implements WxOrdersService
{

    @Resource
    private WxOrdersDao wxOrdersDao;
    @Resource
    private WxProductDao wxProductDao;
    @Resource
    private WxOrderGoodsDao wxOrderGoodsDao;
    @Resource
    private WxVoucherDao wxVoucherDao;

    @Override
    public List<WxOrdersResponseList> findWxOrdersList(WxOrders wxOrders) {
//        PageHelper.startPage(pageNum, pageSize);
        List<WxOrdersResponseList> list = wxOrdersDao.findWxOrdersList(wxOrders);

        return OrdersProcessing(list);
    }

    /**
     * @param list
     * @return
     * @Title: OrdersProcessing
     * @Description: TODO(处理订单列表)
     */
    private List<WxOrdersResponseList> OrdersProcessing(List<WxOrdersResponseList> list) {

        WxOrdersResponseList oldResponseList = new WxOrdersResponseList();
        ArrayList<WxOrdersResponseList> newList = new ArrayList<>();
        for (int i = 0; i <= list.size() - 1; i++) {
            oldResponseList = list.get(i);
            for (int z = list.size()-1; z >= 0 && z != i; z--) {
                if (oldResponseList.getOnoun().equals(list.get(z).getOnoun()) && oldResponseList.getOid() != list.get(z)
                        .getOid()) {
                    oldResponseList.setSname(BusinessInformation.HD);
                    /*将相同编号的订单中的商品图片路径合并在一起*/
                    String img = oldResponseList.getImg() + "," + list.get(z).getImg();
                    oldResponseList.setImg(img);
                    /*图片路径添加到最终的集合中*/
                    oldResponseList.setImgs(ImagePathSegmentation(img));
                    /*计算金额*/
                    Double omoney = (oldResponseList.getOmoney() + list.get(z).getOmoney());
                    oldResponseList.setOmoney(omoney);
                    Integer onum = oldResponseList.getOnum() + list.get(z).getOnum();
                    oldResponseList.setOnum(onum);
                    oldResponseList.setOid(null);
                    /*移除已经处理了的集合元素*/
                    list.remove(z);
                } else {
                    oldResponseList.setImgs(ImagePathSegmentation(oldResponseList.getImg()));
                }

            }

            oldResponseList.setMoney(new DecimalFormat("#,##0.00").format(oldResponseList.getOmoney()));
            if(oldResponseList.getImgs()==null){
                oldResponseList.setImgs(ImagePathSegmentation(oldResponseList.getImg()));
            }
            newList.add(oldResponseList);

        }

        return newList;

    }

    /**
     * @param img
     * @return
     * @Title: ImagePathSegmentation
     * @Description: TODO(根据符号分割图片路径)
     */
    private List<String> ImagePathSegmentation(String img) {

        ArrayList<String> imgs = new ArrayList<>();
        String[] imgArray = img.split(",");
        for (String string : imgArray) {
            imgs.add(string);
        }
        return imgs;

    }

    @Override
    public WxOrdersDetailsResponse getWxOrdersList(String onoun) {
        List<WxOrdersResponse> ordersResponses = wxOrdersDao.getWxOrdersList(onoun);

        return OrderDataPackage(ordersResponses);
    }

    /**
     * @param wxOrdersResponses
     * @return
     * @Title: OrderDataPackage
     * @Description: TODO(订单详情处理)
     */
    private WxOrdersDetailsResponse OrderDataPackage(List<WxOrdersResponse> wxOrdersResponses) {
        for (WxOrdersResponse wxOrdersResponse : wxOrdersResponses) {
            List<WxProductAndVoucherResponce> wxProductAndVoucherResponces = new ArrayList<>();
            List<WxProductAndVoucherResponce> productResponces = wxOrdersDao
                    .getWxOrdersProduct(wxOrdersResponse.getOid());
            List<WxProductAndVoucherResponce> voucherResponces = wxOrdersDao
                    .getWxOrdersVoucher(wxOrdersResponse.getOid());
            if (productResponces != null) {
                wxProductAndVoucherResponces.addAll(productResponces);
            }
            if (voucherResponces != null) {

                wxProductAndVoucherResponces.addAll(voucherResponces);
            }
            wxOrdersResponse.setProductAndVoucher(wxProductAndVoucherResponces);
        }
        Double money = 0.d;
        Integer sunNum = 0;
        for (WxOrdersResponse wxOrdersRespons : wxOrdersResponses) {
            money += wxOrdersRespons.getOmoney();
            sunNum += wxOrdersRespons.getOnum();
        }
        /*订单详情顶级类封装*/
        WxOrdersDetailsResponse response = new WxOrdersDetailsResponse();
        response.setTime(wxOrdersResponses.get(0).getOdate());
        response.setNumbering(wxOrdersResponses.get(0).getOnoun());
        response.setOshname(wxOrdersResponses.get(0).getOshname());
        response.setOshtel(wxOrdersResponses.get(0).getOshtel());
        response.setOshaddress(wxOrdersResponses.get(0).getOshaddress());
        response.setLumpSum(money);
        response.setSunNum(sunNum);
        response.setWxOrdersResponses(wxOrdersResponses);
        return response;

    }

    @Override
    public Integer updateWxOrders(WxOrders wxOrders) {
        List<Integer> oids = wxOrdersDao.findWxOrdersOid(wxOrders.getOnoun());

        return wxOrdersDao.updateWxOrders(oids, wxOrders.getOstae());
    }

    @Transactional
    @Override
    public List<WxOrders> saveWxOrders(WxOrdersAddRequest wxOrdersAddRequest) {
        List<WxOrderProduct> wxOrderProducts = QueryProductInformation(wxOrdersAddRequest.getWxUserCarts());
        Map<Integer, List<WxOrderProduct>> map = ProductGrouping(wxOrderProducts);

        WxOrders wxOrdersonly = new WxOrders();
        try {
            BeanUtils.copyProperties(wxOrdersonly, wxOrdersAddRequest);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        wxOrdersonly.setOdate(new Date());
        wxOrdersonly.setOnoun(BatchNumberCode(wxOrdersonly.getUrid()));
        List<WxOrders> wxOrders = NewOrderData(map, wxOrdersonly, wxOrdersAddRequest.getOmsgs());

        wxOrdersDao.saveWxOrders(wxOrders);
        List<WxOrderGoods> wxOrderGoods = orderProcessingUnderTheOrder(map, wxOrders);
        wxOrderGoodsDao.saveWxOrderGoods(wxOrderGoods);
        return wxOrders;

    }

    /**
     * @param WxUserCarts
     * @return
     * @Title: QueryProductInformation
     * @Description: TODO(购物车商品批量查询处理)
     */
    private List<WxOrderProduct> QueryProductInformation(List<WxUserCart> WxUserCarts) {
        List<Integer> ids = new ArrayList<>();
        List<Integer> vids = new ArrayList<>();
        for (WxUserCart wxUserCart : WxUserCarts) {
            if (wxUserCart.getOtype() == 0) {
                ids.add(wxUserCart.getOid());
            }
            if (wxUserCart.getOtype() == 1) {
                vids.add(wxUserCart.getOid());
            }

        }

        List<WxOrderProduct> wxOrderProducts = new ArrayList<>();

        if (ids.size() > 0) {
            wxOrderProducts.addAll(ProductDataProcessing(WxUserCarts, ids));
        }
        if (vids.size() > 0) {
            wxOrderProducts.addAll(VoucherDataProcessing(WxUserCarts, vids));
        }

        return wxOrderProducts;

    }

    /**
     * @param WxUserCarts
     * @param ids
     * @return
     * @Title: ProductDataProcessing
     * @Description: TODO(商品处理)
     */
    private List<WxOrderProduct> ProductDataProcessing(List<WxUserCart> WxUserCarts, List<Integer> ids) {

        List<WxOrderProduct> wxOrderProducts = wxProductDao.findPrdouctList(ids);
        for (WxOrderProduct wxOrderProduct : wxOrderProducts) {
            for (WxUserCart wxUserCart : WxUserCarts) {
                if (wxOrderProduct.getId().equals(wxUserCart.getOid())) {
                    wxOrderProduct.setNum(wxUserCart.getNumber());
                    wxOrderProduct.setStime(wxUserCart.getStime());
                    wxOrderProduct.setOtime(wxUserCart.getOtime());
                    wxOrderProduct.setPnum(wxUserCart.getPnum());
                    wxOrderProduct.setType(0);
                }
            }
        }

        return wxOrderProducts;

    }

    /**
     * @param WxUserCarts
     * @param ids
     * @return
     * @Title: VoucherDataProcessing
     * @Description: TODO(代金券商品处理)
     */
    private List<WxOrderProduct> VoucherDataProcessing(List<WxUserCart> WxUserCarts, List<Integer> ids) {

        List<WxOrderProduct> wxOrderProducts = wxVoucherDao.findVoucherByVid(ids);

        for (WxOrderProduct wxOrderProduct : wxOrderProducts) {

            for (WxUserCart wxUserCart : WxUserCarts) {
                if (wxOrderProduct.getId().equals(wxUserCart.getOid())) {
                    wxOrderProduct.setNum(wxUserCart.getNumber());
                    wxOrderProduct.setSid(BusinessInformation.VSM);
                    wxOrderProduct.setType(1);
                    wxOrderProduct.setFgtype(0);
                    wxOrderProduct.setFgxf(0.00);
                    wxOrderProduct.setFreight(0.00);
                }
            }
        }
        return wxOrderProducts;

    }

    /**
     * @param wxOrderProducts
     * @return
     * @Title: ProductGrouping
     * @Description: TODO(商品根据商家分组)
     */
    private Map<Integer, List<WxOrderProduct>> ProductGrouping(List<WxOrderProduct> wxOrderProducts) {
        Map<Integer, List<WxOrderProduct>> map = new HashMap<>();
        for (WxOrderProduct wxOrderProduct : wxOrderProducts) {
            List<WxOrderProduct> list = map.get(wxOrderProduct.getSid());
            /* 如果取不到数据,那么直接new一个空的ArrayList **/
            if (list == null) {
                list = new ArrayList<>();
                list.add(wxOrderProduct);
                map.put(wxOrderProduct.getSid(), list);
            } else {
                /* 某个对象之前已经存放过了,则直接追加数据到原来的List里 **/
                list.add(wxOrderProduct);
            }
        }

        return map;
    }

    /**
     * @param map
     * @Title: NewOrderData
     * @Description: TODO(计算每个订单的金额, 费用, 给订单分别添加留言)
     */
    private List<WxOrders> NewOrderData(Map<Integer, List<WxOrderProduct>> map, WxOrders wxOrdersonly, List<UserOrderMessage> omsgs) {
        List<WxOrders> wxOrders = new ArrayList<>();
        WxOrders wxOrder = null;
        for (Integer sid : map.keySet()) {
            wxOrder = new WxOrders();
            try {
                BeanUtils.copyProperties(wxOrder, wxOrdersonly);
            } catch (IllegalAccessException | InvocationTargetException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            Double price = 0.0d;
            Double freight = 0.0d;
            Integer num = 0;
            for (WxOrderProduct wxOrderProduct : map.get(sid)) {
                if (wxOrderProduct.getYprice() != 0) {
                    price += wxOrderProduct.getNum() * wxOrderProduct.getYprice();
                } else {
                    price += wxOrderProduct.getNum() * wxOrderProduct.getPrice();
                }

                freight += wxOrderProduct.getFreight();
                num += wxOrderProduct.getNum();
                if (wxOrderProduct.getFgtype() == 1) {
                    freight = freight + wxOrderProduct.getFreight() + (wxOrderProduct.getFgxf() * wxOrderProduct
                            .getNum());
                }
            }
            /*给商户留言*/
            for (UserOrderMessage omsg : omsgs) {
                if (omsg.getSid() == sid) {
                    wxOrder.setOmsg(omsg.getOmsg());
                }
            }
            wxOrder.setOmoney(price + freight);
            wxOrder.setOfreight(freight);
            wxOrder.setOnum(num);
            wxOrder.setCid(sid);
            wxOrders.add(wxOrder);

        }
        return wxOrders;
    }

    /**
     * @param uid
     * @return
     * @Title: BatchNumberCode
     * @Description: TODO(订单批次号编码)
     */
    private String BatchNumberCode(Integer uid) {
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
        String code = df.format(new Date()) + "U" + uid;
        return code;

    }

    /*订单商品处理*/
    private List<WxOrderGoods> orderProcessingUnderTheOrder(Map<Integer, List<WxOrderProduct>> map,
                                                            List<WxOrders> wxOrders) {
        List<WxOrderGoods> wxOrderGoods = new ArrayList<>();
        WxOrderGoods wxOrderGood;
        for (WxOrders wxOrder : wxOrders) {
            for (WxOrderProduct wxOrderProduct : map.get(wxOrder.getCid())) {
                wxOrderGood = new WxOrderGoods();
                wxOrderGood.setOid(wxOrder.getOid());
                wxOrderGood.setVid(wxOrderProduct.getId());
                wxOrderGood.setVtype(wxOrderProduct.getType());
                wxOrderGood.setOgnum(wxOrderProduct.getNum());
                wxOrderGood.setOgmoney(wxOrderProduct.getYprice() * wxOrderProduct.getNum());
                wxOrderGood.setStime(wxOrderProduct.getStime());
                wxOrderGood.setOtime(wxOrderProduct.getOtime());
                wxOrderGood.setPnum(wxOrderProduct.getPnum());
                wxOrderGoods.add(wxOrderGood);
            }
        }
        return wxOrderGoods;

    }

    /**
     * @Title: deleteWxOrders
     * @Description: TODO(删除订单)
     * @param: [onoun] 订单统一编码批次号
     * @return:java.lang.Integer
     * @Date: 2018/8/31 9:44
     */
    @Transactional
    @Override
    public Integer deleteWxOrders(String onoun) {

        List<Integer> oids = wxOrdersDao.findWxOrdersOid(onoun);
        wxOrderGoodsDao.deleteWxOrderGoods(oids);
        return wxOrdersDao.deleteWxOrders(onoun);
    }

}
