package com.pydyun.ims.util;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.UUID;

import javax.annotation.PostConstruct;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pydyun.ims.dao.UserVoucherDao;
import com.pydyun.ims.dao.VoucherDao;
import com.pydyun.ims.model.U_v_log;
import com.pydyun.ims.model.Voucher;

/**
 * 用户购买代金券动态生成唯一二维码并存入数据库
 * @author fy
 * 先根据券id查询券表，得到适用范围，得到批次id，券的名字
 */
@Component
public class userBuyVoucher {
	
	@Autowired
	private VoucherDao vdao;
	@Autowired
	private UserVoucherDao uvdao;
	
	
	public VoucherDao getVdao() {
		return vdao;
	}

	public void setVdao(VoucherDao vdao) {
		this.vdao = vdao;
	}

	public UserVoucherDao getUvdao() {
		return uvdao;
	}

	public void setUvdao(UserVoucherDao uvdao) {
		this.uvdao = uvdao;
	}
	private static userBuyVoucher vou;
	@PostConstruct
    public void init()
    {
		vou = this;
		vou.vdao = this.vdao;
		vou.uvdao = this.uvdao;
    }
	
	public static void buyvoucher(Integer urid,Integer num,Integer vid,HttpServletRequest request) throws Exception{
		Voucher vo = vou.vdao.findbyid(vid);
		String vrange = null;
		String vtitle = null;
		if(vo!=null){
			vrange = vo.getVrange();
			vtitle = vo.getVtitle();
		}
		vou.uvdao.alterTable();
		Integer selectmaxid = vou.uvdao.selectmaxid();
		String returnUrl = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() +"/upload/image";//存储路径
		for(Integer i = selectmaxid + 1; i <= selectmaxid + num; i++){
			// 代金券（0）加密
			Integer vorc = 0;
			String vorc3 = AESOperator.getInstance().encrypt(Integer.toString(vorc));
			// 店铺或者品牌或者全站加密
			String vrange1 = AESOperator.getInstance().encrypt(vrange);
			// 券名字加密
			String vtitle1 = AESOperator.getInstance().encrypt(vtitle);
			//uuid
			String uuid = UUID.randomUUID().toString().replaceAll("-",""); 
			String pathName = QRCodeUtil.generateQRCode(
					vorc3+vrange1+"/t"+vtitle1+uuid, 80, 80,
					"png", "D:\\voucher"+i+".png");						
			String str = vou.vdao.selectimg(vid);
			File tempFile =new File( str.trim());
			String fileName = tempFile.getName();// 获取文件名加后缀			
			
			File targetFile = new File("E:\\项目\\ims\\src\\main\\webapp\\upload\\image");
			File targetFile1 = new File(targetFile,i+fileName);
			try {
				InputStream in = new FileInputStream(str);
				OutputStream out = new FileOutputStream(targetFile1);
				byte[] bytes = new byte[1024];
				int len = -1;
				while ((len = in.read(bytes)) != -1) {
					out.write(bytes, 0, len);
				}
				in.close();
				out.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			File fi1 = new File(pathName);
			BufferedImage image = ImageIO.read(fi1);// 二维码
			BufferedImage bg = ImageIO.read(targetFile1);// 获取图片
			Graphics2D g = bg.createGraphics();
			int width = image.getWidth(null) > bg.getWidth() * 5 / 10 ? (bg.getWidth() * 5 / 10)
					: image.getWidth(null);
			int height = image.getHeight(null) > bg.getHeight() * 5 / 10 ? (bg.getHeight() * 5 / 10)
					: image.getWidth(null);
			g.drawImage(image, 0, (bg.getHeight() - height), width, height, null);
			g.dispose();
			bg.flush();
			image.flush();
			ImageIO.write(bg, "png", targetFile1);
			String msg = returnUrl + "/" + i + fileName;
			U_v_log uvlog = new U_v_log();
			uvlog.setVid(vid);
			uvlog.setUrid(urid);
			uvlog.setUvlgetdate(new Date());
			uvlog.setUvlgetchannel("购买");
			uvlog.setUvltype("购买");
			uvlog.setUvcode(uuid);
			uvlog.setUvimg(msg);
			uvlog.setUvlstate(1);
			vou.uvdao.insertuvlog(uvlog);			
		}
		vou.vdao.updatevstore(vid, num);
	}
	public static void main(String[] args) {
//		String uuid = UUID.randomUUID().toString().replaceAll("-",""); 
//		System.out.println(uuid);
//		System.out.println("123");
//		Integer selectmaxid = vou.uvdao.selectmaxid();
//		String str = vou.vdao.selectimg(15);
//		String str = "E:\\项目\\ims\\src\\main\\webapp\\upload\\image\\voucher\\1533864108598_85.jpg";
//		File tempFile =new File(str.trim());
//		String fileName = tempFile.getName();// 获取文件名加后缀	
//		System.out.println(fileName);
//		String fileF = fileName.substring(fileName.lastIndexOf("."), fileName.length());// 文件后缀
//		fileName = new Date().getTime() + "_" + new Random().nextInt(1000) + fileF;// 新的文件名
//		System.out.println(fileName);
	}
}
