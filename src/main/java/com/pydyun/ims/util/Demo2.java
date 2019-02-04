package com.pydyun.ims.util;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*2用高效流，将一个图片复制到另一个路径 (15 分)*/
public class Demo2 {
    public static void main(String[] args) {
//        BufferedInputStream bis = null;
//        BufferedOutputStream bos = null;
//        try {
//            bis = new BufferedInputStream(
//                    new FileInputStream("D:\\new.png"));
//            bos = new BufferedOutputStream(
//                    new FileOutputStream("D:\\new22.png"));
//
//            byte[] byts = new byte[1024];
//            int len=0;
//            while((len=bis.read(byts, 0, byts.length))!=-1) {
//                bos.write(byts, 0, len);
//            }
//        } catch (FileNotFoundException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        } finally {
//            if(bis!=null) {
//                try {
//                    bis.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//            try {
//                bos.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
    	
    	String st1 = "123[234][345]";
    	 
//    	String st2 = st1.substring(st1.indexOf("[")+1,st1.indexOf("]"));
    	List<String> list=new ArrayList<String>();
		Pattern p = Pattern.compile("(\\[[^\\]]*\\])");
		Matcher m = p.matcher(st1);
		while(m.find()){
			list.add(m.group().substring(1, m.group().length()-1));
		}
		System.out.println(list.get(0));
		System.out.println(list.get(1));
    	
    }
}
