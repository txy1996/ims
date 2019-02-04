package com.pydyun.ims.service.impl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.List;

import javax.annotation.Resource;
import javax.xml.xpath.XPathExpressionException;

import org.dom4j.DocumentException;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;
import org.json.XML;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.pydyun.ims.dao.GoogAndIntegrationItemDao;
import com.pydyun.ims.model.GoogAndIntegrationItem;
import com.pydyun.ims.service.GoogAndIntegrationItemService;
import com.pydyun.ims.util.SelectGoogAndIntegrationItem;
import com.pydyun.ims.util.UserOrShop;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;

/**
 * @ClassName: GoogAndIntegrationItemServiceImpl
 * @Description: TODO(金币积分操作项)
 * @author tangxiaoyu
 * @date 2018年7月14日 下午3:29:38
 *
 */
@Service
public class GoogAndIntegrationItemServiceImpl implements GoogAndIntegrationItemService
{

    @Resource
    private GoogAndIntegrationItemDao googAndIntegrationItemDao;

    @Override
    public List<GoogAndIntegrationItem> select(GoogAndIntegrationItem item)
    {

        return googAndIntegrationItemDao.select(item);
    }

    @Override
    public PageInfo<GoogAndIntegrationItem> selectPage(Integer pageNum, Integer pageSize, GoogAndIntegrationItem item)
    {
        PageHelper.startPage(pageNum, pageSize);
        List<GoogAndIntegrationItem> items = googAndIntegrationItemDao.select(item);
        return new PageInfo<>(items);
    }

    @Override
    public Integer updateGoogAndIntegrationItem(GoogAndIntegrationItem item)
    {

        return googAndIntegrationItemDao.updateGoogAndIntegrationItem(item);
    }

    @Override
    public Integer deleteById(Integer id)
    {
        return googAndIntegrationItemDao.deleteById(id);
    }

    @Override
    public Integer addGoogAndIntegrationItem(GoogAndIntegrationItem item)
    {
        return googAndIntegrationItemDao.addGoogAndIntegrationItem(item);
    }

    @Override
    public List<GoogAndIntegrationItem> selectItemXML()
    {
        GoogAndIntegrationItem item = new GoogAndIntegrationItem();
        List<GoogAndIntegrationItem> items = googAndIntegrationItemDao.select(item);
        ItemConversionXml(items);

        return items;
    }

    /**
     * @Title: ItemConversionJson
     * @Description: TODO(操作项转json文件)
     * @param items
     */
    private void ItemConversionJson(List<GoogAndIntegrationItem> items)
    {
        Gson gson = new Gson();
        String jsonString = gson.toJson(items);
        try
        {
            FileOutputStream fos = new FileOutputStream(
                    new File("E:\\DKZD\\dkzdcode\\ims\\src\\main\\webapp\\upload\\ItemJson\\ItemJson.json"));//
            Writer writer = new OutputStreamWriter(fos);
            writer.write(jsonString);
            writer.flush();
            writer.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    /**
     * @Title: ItemConversionXml
     * @Description: TODO(操作项转xml)
     * @param items
     */
    private void ItemConversionXml(List<GoogAndIntegrationItem> items)
    {

        XStream xStream = new XStream();
        StringBuffer xmlitems = new StringBuffer();
        xStream.alias("GoogAndIntegrationItem", GoogAndIntegrationItem.class);
        if (items != null && items.size() > 0)
        {
            xmlitems.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
            xmlitems.append(xStream.toXML(items));
            xStream.setMode(XStream.NO_REFERENCES);
        }

        try
        {
            String filename = "E:\\DKZD\\dkzdcode\\ims\\src\\main\\webapp\\upload\\ItemJson\\ItemXml.xml";
            String encoding = "utf-8";
            File file = new File(filename);
            file.delete();
            file.createNewFile();
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), encoding));
            writer.write(xmlitems.toString());
            writer.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

}
