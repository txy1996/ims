package com.pydyun.ims.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 参数：广告字符串   数据格式见mian方法
 * 判断是什么连接，并放回集合，如果是#号隔开，选择时，请选list0或者list1等
 * 如果是,号隔开，则请选择list0
 * @author fy
 *
 */
public class Analysis2 {
	public static Map<String, List<String>> find(String json){
		String newjson = json.replaceAll("[\\[\\]]", "");
		String[] split = newjson.split(",");
		Map<String, List<String>> map = new HashMap<>();
		for(int i =0;i<split.length;i++){
			List<String> list = new ArrayList<>();
			String[] splits = split[i].split(":",2);
			if (splits[0].equals("IU") || splits[0].equals("I") || splits[0].equals("T") || splits[0].equals("V")) {
				String[] ss = new String[splits.length-1];
				System.arraycopy(splits, 1, ss, 0, ss.length);
				String[] newsplit = ss[0].split("#");
				for(String s : newsplit){
					list.add(s);
				}
				map.put("list"+i, list);
			}else if(splits[0].equals("LS")||splits[0].equals("LF")||splits[0].equals("LP")||splits[0].equals("LST")||
					splits[0].equals("LFT")||splits[0].equals("LPT")||splits[0].equals("LPC")||splits[0].equals("LSC")||
					splits[0].equals("LFC")){
//				String substring = json.substring(json.indexOf(":") + 1);
//				String[] split2 = substring.split(",");
//				for(int j =0;j<split2.length;j++){
//					list.add(split2[j]);					
//				}
				list.add(json);
				map.put("list0", list);
			}
		}
		return  map;
	}
	public static void main(String[] args) {//[I:http://192.168.31.160:8080/ims/upload/image/1534143575200_456.jpgl#s:1#jgg],[I:http://192.168.31.160:8080/ims/upload/image/1534143743687_732.jpg#s:2]
		Map<String, List<String>> find = find("LP:221,222,223,224");
//		List<String> list = find.get("list0");//LST:1,3,23,25,234,34,35,52
//		String string = list.get(1);
		System.out.println(find);
	}
}
