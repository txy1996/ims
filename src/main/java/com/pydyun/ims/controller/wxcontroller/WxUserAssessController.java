package com.pydyun.ims.controller.wxcontroller;

import com.pydyun.ims.model.WxUserAssess;
import com.pydyun.ims.model.WxUserAssessRequest;
import com.pydyun.ims.service.wxservice.WxUserAssessService;
import com.pydyun.ims.util.BusinessInformation;
import com.pydyun.ims.util.FileUploadUtil;
import net.coobird.thumbnailator.Thumbnails;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * FileName: WxUserAssessController
 * Author:   tangxiaoyu
 * Date:     2018/8/31 17:53
 * Description: TODO(这里用一句话描述这个类的作用)
 *
 * @since 1.0.0
 */
@RestController
@RequestMapping("/wxUserAssess")
public class WxUserAssessController
{

    @Resource
    private WxUserAssessService wxUserAssessService;

    private List<MultipartFile> files = new ArrayList<>();

    @RequestMapping("/saveWxUserAssess")
    public WxUserAssess saveWxUserAssess(WxUserAssessRequest wxUserAssessRequest) {

        wxUserAssessRequest.setFiles(files);
        WxUserAssess wxUserAssess = wxUserAssessService.saveWxUserAssess(wxUserAssessRequest);
        files = null;
        return wxUserAssess;

    }

    @RequestMapping("/upload")
    public String upload(@RequestParam(value = "file", required = false) MultipartFile file) throws IOException {


        files.add(file);

//        return FileUploadUtil.ImageUpload(file);
        return "成功";

    }


}
