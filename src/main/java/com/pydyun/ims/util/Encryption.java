package com.pydyun.ims.util;
   
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Date;  
  
public class Encryption {  
           
    /** 
     * 对字符串md5加密(大写+数字) (不可逆的)
     * 
     * @param str 传入要加密的字符串 
     * @return  MD5加密后的字符串 
     */  
      
    /**
     * 是什么券加密
     * @param a
     * @return
     */
    public static String MD51(Integer a) {
        char hexDigits[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};         
        String b=null;
        if(a==0){
        	b="代金券";
        }else if(a==1){
        	b="优惠券";
        }
        try {  
            byte[] btInput = b.getBytes(); 
            // 获得MD5摘要算法的 MessageDigest 对象  
            MessageDigest mdInst = MessageDigest.getInstance("MD5");  
            // 使用指定的字节更新摘要  
            mdInst.update(btInput);  
            // 获得密文  
            byte[] md = mdInst.digest();  
            // 把密文转换成十六进制的字符串形式  
            int j = md.length;
            char str[] = new char[j * 2];  
            int k = 0;  
            for (int i = 0; i < j; i++) {  
                byte byte0 = md[i];  
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];  
                str[k++] = hexDigits[byte0 & 0xf];  
            }  
            return new String(str);  
        } catch (Exception e) {  
            e.printStackTrace();  
            return null;  
        }  
    }  
    
    
    /**
     * 券类型加密
     * @param a
     * @return
     */
    public static String MD52(String a) {  
        char hexDigits[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};         
//        String b=null;
        if(a.equals("单店")||a=="单店"){
        	int random=(int) Math.round(Math.random()*25+97);
   		 	String temp=String.valueOf(random);
        	a="S"+temp;
        }else if(a.equals("品牌通用")||a=="品牌通用"){
        	int random=(int) Math.round(Math.random()*25+97);
   		 	String temp=String.valueOf(random);
        	a=temp+"P";
        }else if(a.equals("全站通用")||a=="全站通用"){
        	int random=(int) Math.round(Math.random()*25+97);
   		 	String temp=String.valueOf(random);
        	a=temp+"T";
        }
        try {  
            byte[] btInput = a.getBytes(); 
            // 获得MD5摘要算法的 MessageDigest 对象  
            MessageDigest mdInst = MessageDigest.getInstance("MD5");  
            // 使用指定的字节更新摘要  
            mdInst.update(btInput);  
            // 获得密文  
            byte[] md = mdInst.digest();  
            // 把密文转换成十六进制的字符串形式  
            int j = md.length;
            char str[] = new char[j * 2];  
            int k = 0;  
            for (int i = 0; i < j; i++) {  
                byte byte0 = md[i];  
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];  
                str[k++] = hexDigits[byte0 & 0xf];  
            }  
            return new String(str);  
        } catch (Exception e) {  
            e.printStackTrace();  
            return null;
        }  
    }  

    /**
     * id加密（区域id加密共用此方法,如果是品牌通用或者全站，则随机生成6位数再加密）（券id加密共用）
     * @param a
     * @return
     */
    public static String MD53(Integer a) {
        char hexDigits[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};         
        try {
            byte[] btInput = Conversion.tolh(a); 
            // 获得MD5摘要算法的 MessageDigest 对象  
            MessageDigest mdInst = MessageDigest.getInstance("MD5");  
            // 使用指定的字节更新摘要  
            mdInst.update(btInput);  
            // 获得密文  
            byte[] md = mdInst.digest();  
            // 把密文转换成十六进制的字符串形式  
            int j = md.length;
            char str[] = new char[j * 2];  
            int k = 0;  
            for (int i = 0; i < j; i++) {  
                byte byte0 = md[i];  
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];  
                str[k++] = hexDigits[byte0 & 0xf];  
            }  
            return new String(str);  
        } catch (Exception e) {  
            e.printStackTrace();  
            return null;  
        }  
    }  
   
    
    /**
     * 时间加密（生效时间，失效时间）
     * @param a
     * @return
     */
    public static String MD54(Date a) {  
        char hexDigits[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};         
//        String b=null;  
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        String date = format.format(a);
        try {  
            byte[] btInput = date.getBytes(); 
            // 获得MD5摘要算法的 MessageDigest 对象  
            MessageDigest mdInst = MessageDigest.getInstance("MD5");  
            // 使用指定的字节更新摘要  
            mdInst.update(btInput);  
            // 获得密文  
            byte[] md = mdInst.digest();  
            // 把密文转换成十六进制的字符串形式  
            int j = md.length;
            char str[] = new char[j * 2];  
            int k = 0;
            for (int i = 0; i < j; i++) {  
                byte byte0 = md[i];  
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];  
                str[k++] = hexDigits[byte0 & 0xf];  
            }  
            return new String(str);  
        } catch (Exception e) {  
            e.printStackTrace();  
            return null;  
        }  
    }  
    
    /**
     * 时间加密（生效时间，失效时间）
     * @param a
     * @return
     */
    public static String MD55(String a) {  
        char hexDigits[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};         
//        String b=null;         
        try {
            byte[] btInput = a.getBytes();
            // 获得MD5摘要算法的 MessageDigest 对象  
            MessageDigest mdInst = MessageDigest.getInstance("MD5");  
            // 使用指定的字节更新摘要  
            mdInst.update(btInput);  
            // 获得密文  
            byte[] md = mdInst.digest();  
            // 把密文转换成十六进制的字符串形式  
            int j = md.length;
            char str[] = new char[j * 2];  
            int k = 0;
            for (int i = 0; i < j; i++) {  
                byte byte0 = md[i];  
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];  
                str[k++] = hexDigits[byte0 & 0xf];  
            }
            return new String(str);  
        } catch (Exception e) {  
            e.printStackTrace();  
            return null;  
        }  
    }  
  
    /**
     * MD5解密(?)
     * @param inStr
     * @return
     */
	public static String Decrypt(String Str) {
		char[] a = Str.toCharArray();
		for (int i = 0; i < a.length; i++) {
			a[i] = (char) (a[i] ^ 't');
		}
		String k = new String(a);
		return k;
	}

         /*public static void main(String[] args) { 
        	 System.out.println(MD52("单店"));
        	System.out.println( Decrypt("835C45D4D42DB23DA5CF8DEA158643A5"));
        	 
    }  */
}  
