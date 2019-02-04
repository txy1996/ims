package com.pydyun.ims.util;

import net.coobird.thumbnailator.Thumbnails;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Date;
import java.util.Random;

/**
 * FileName: FileUploadUtil
 * Author:   tangxiaoyu
 * Date:     2018/9/6 9:34
 * Description: TODO(文件上传工具类)
 *
 * @since 1.0.0
 */
public class FileUploadUtil
{

    /**
     * @Title: fileUpload
     * @Description: TODO(文件上传)
     * @param file
     * @return
     */
    public static String fileUpload(MultipartFile file)
    {
        File targetFile = null;
        String msg = "";// 返回存储路径
        String fileName = file.getOriginalFilename();// 获取文件名加后缀
        if (fileName != null && fileName != "")
        {
            String returnUrl = BusinessInformation.RETURNURL;// 存储路径
            String path = BusinessInformation.UPLOADPATH; // 文件存储位置
            String fileF = fileName.substring(fileName.lastIndexOf("."), fileName.length());// 文件后缀
            fileName = new Date().getTime() + "_" + new Random().nextInt(1000) + fileF;// 新的文件名
            File file1 = new File(path + "/");
            targetFile = new File(file1, fileName);

            try
            {
                file.transferTo(targetFile);
                msg = returnUrl + "/" + fileName;
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        return msg;

    }

    /*图片上传压缩*/
    public static String ImageUpload(MultipartFile file)
    {
        File targetFile = null;
        String msg = "";// 返回存储路径
        String fileName = file.getOriginalFilename();// 获取文件名加后缀
        if (fileName != null && fileName != "")
        {
            String returnUrl = BusinessInformation.RETURNURL;// 存储路径
            String path = BusinessInformation.UPLOADPATH; // 文件存储位置
            String fileF = fileName.substring(fileName.lastIndexOf("."), fileName.length());// 文件后缀
            fileName = new Date().getTime() + "_" + new Random().nextInt(1000) + fileF;// 新的文件名
            File file1 = new File(path + "/");
            targetFile = new File(file1, fileName);

            try
            {
                file.transferTo(targetFile);
                Thumbnails.of(targetFile).scale(1f).outputQuality(0.2f).toFile(targetFile);
                BufferedImage image = ImageIO.read(targetFile);
                int imageWidth = image.getWidth();
                int imageHeitht = image.getHeight();
                if (imageWidth>3000||imageHeitht>3000){
                    Thumbnails.of(targetFile).scale(0.2f).toFile(targetFile);//按比例缩小
                }else if (imageWidth>2000&&imageWidth<3000||imageHeitht>2000&&imageHeitht<3000){
                    Thumbnails.of(targetFile).scale(0.3f).toFile(targetFile);//按比例缩小
                }else if(imageWidth>1000&&imageWidth<2000||imageHeitht>1000&&imageHeitht<2000){
                    Thumbnails.of(targetFile).scale(0.4f).toFile(targetFile);//按比例缩小
                }else if(imageWidth>700&&imageWidth<1000||imageHeitht>700&&imageHeitht<1000){
                    Thumbnails.of(targetFile).scale(0.6f).toFile(targetFile);//按比例缩小
                }
                msg = returnUrl + "/" + fileName;
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        return msg;

    }
}
