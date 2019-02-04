package com.pydyun.ims.util;

import java.io.File;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.xml.xpath.XPathExpressionException;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pydyun.ims.dao.Goods_shopDao;
import com.pydyun.ims.dao.Goods_userDao;
import com.pydyun.ims.dao.IntegrationsDao;
import com.pydyun.ims.dao.SlintegrationDao;
import com.pydyun.ims.model.Goods_shop;
import com.pydyun.ims.model.Goods_user;
import com.pydyun.ims.model.GoogAndIntegrationItem;
import com.pydyun.ims.model.Integrations;
import com.pydyun.ims.model.Slintegration;

/**
 * @author tangxiaoyu
 * @ClassName: SelectGoogAndIntegrationItem
 * @Description: TODO(查询积分金币操作项, 并保存日志信息)
 * @date 2018年8月5日 下午9:47:54
 */
@Component
public class SelectGoogAndIntegrationItem
{

    @Autowired
    private Goods_userDao goods_userDao;
    @Autowired
    private Goods_shopDao goods_shopDao;
    @Autowired
    private IntegrationsDao integrationsDao;
    @Autowired
    private SlintegrationDao slintegrationDao;

    private static SelectGoogAndIntegrationItem Item;

    @PostConstruct
    public void init() {
        Item = this;
        Item.goods_userDao = this.goods_userDao;
        Item.goods_shopDao = this.goods_shopDao;
        Item.integrationsDao = this.integrationsDao;
        Item.slintegrationDao = this.slintegrationDao;
    }

    /**
     * @param itemId
     * @param id
     * @param type
     * @return
     * @throws XPathExpressionException
     * @throws DocumentException
     * @Title: saveGoldItem
     * @Description: TODO(新增金币记录)
     */
    public static String saveGoldItem(HttpServletRequest servletRequest, Integer itemId, Integer id, UserOrShop type)
            throws XPathExpressionException, DocumentException {
        GoogAndIntegrationItem item = SelectItem(servletRequest, itemId);
        if (type.equals(UserOrShop.USER)) {
            saveUserGoldItem(item, id);
        } else if (type.equals(UserOrShop.SHOP)) {
            saveShopGoldItem(item, id);
        }
        return null;

    }

    /**
     * @param itemId
     * @param id
     * @param type
     * @return
     * @throws XPathExpressionException
     * @throws DocumentException
     * @Title: saveIntegrationItem
     * @Description: TODO(新增积分记录)
     */
    public static String saveIntegrationItem(HttpServletRequest servletRequest, Integer itemId, Integer id, UserOrShop type)
            throws XPathExpressionException, DocumentException {
        GoogAndIntegrationItem item = SelectItem(servletRequest, itemId);
        if (type.equals(UserOrShop.USER)) {
            saveUserIntegrationItem(item, id);
        } else if (type.equals(UserOrShop.SHOP)) {
            saveShopIntegrationItem(item, id);
        }
        return null;

    }

    /**
     * @param itemId
     * @return
     * @throws XPathExpressionException
     * @throws DocumentException
     * @Title: SelectItem
     * @Description: TODO(根据id查询操作项)
     */
    private static GoogAndIntegrationItem SelectItem(HttpServletRequest servletRequest, Integer itemId) throws XPathExpressionException, DocumentException {

        SAXReader reader = new SAXReader();
        String url = "upload\\ItemJson\\ItemXml.xml";
        Document document = reader
                .read(new File(servletRequest.getSession().getServletContext().getRealPath(url)));
        String pattern = "//GoogAndIntegrationItem[id='" + itemId + "']/iname";
        Node node = document.selectSingleNode(pattern);
        GoogAndIntegrationItem item = new GoogAndIntegrationItem();
        item.setIname(node.getText());
        pattern = "//GoogAndIntegrationItem[id='" + itemId + "']/inum";
        node = document.selectSingleNode(pattern);
        item.setInum(Integer.parseInt(node.getText()));
        item.setIgori(1L);
        item.setId(itemId);

        return item;
    }

    /**
     * @param item
     * @param id
     * @Title: saveUserGoldItem
     * @Description: TODO(用户金币新增操作)
     */
    private static void saveUserGoldItem(GoogAndIntegrationItem item, Integer id) {
        Goods_user goods_user = new Goods_user();
        goods_user.setUrid(id);
        goods_user.setGonum(item.getInum());
        goods_user.setGoinfo(item.getIname());
        Item.goods_userDao.save(goods_user);
    }

    /**
     * @param item
     * @param id
     * @Title: saveShopGoldItem
     * @Description: TODO(商户金币新增操作)
     */
    private static void saveShopGoldItem(GoogAndIntegrationItem item, Integer id) {
        Goods_shop goods_shop = new Goods_shop();
        goods_shop.setSid(id);
        goods_shop.setGonum(item.getInum());
        goods_shop.setGoinfo(item.getIname());
        Item.goods_shopDao.addshop(goods_shop);
    }

    /**
     * @param item
     * @param id
     * @Title: saveUserIntegrationItem
     * @Description: TODO(用户积分新增操作)
     */
    private static void saveUserIntegrationItem(GoogAndIntegrationItem item, Integer id) {
        Integrations integrations = new Integrations();
        integrations.setUrid(id);
        integrations.setIgetnum(item.getInum());
        integrations.setIgetinfo(item.getIname());
        Item.integrationsDao.add(integrations);
    }

    /**
     * @param item
     * @param id
     * @Title: saveShopIntegrationItem
     * @Description: TODO(商户积分新增操作)
     */
    private static void saveShopIntegrationItem(GoogAndIntegrationItem item, Integer id) {
        Slintegration slintegration = new Slintegration();
        slintegration.setSid(id);
        slintegration.setSgetnum(item.getInum());
        slintegration.setSgetinfo(item.getIname());
        Item.slintegrationDao.addshop(slintegration);
    }

}
