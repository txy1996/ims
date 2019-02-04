package com.pydyun.ims.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * 图片文字链接   图片链接   文字链接  视频链接  
 * 请调用mapString方法
 * 其他请调用listString方法
 * @author fy
 *
 */
public class Analysis {

	public static List<String> listString(String json) {
		Analysis ana = new Analysis();
		String[] split = json.split(":");
		List<String> list = new ArrayList<>();
		if (split[0].equals("CSH") || split[0].equals("CFN") || split[0].equals("CSP") || split[0].equals("TSh") || split[0].equals("TFN")
				|| split[0].equals("TSP") || split[0].equals("CTP") || split[0].equals("CTFN") || split[0].equals("CTSP")) {
			list = ana.tolist(split[0], json);
		}
		return list;
	}

	public static String mapString(String json) {
		Analysis ana = new Analysis();
		String[] split = json.split(":");
		Map<String, String> map = new HashMap<>();
		if (split[0].equals("TWD") || split[0].equals("TD") || split[0].equals("WD") || split[0].equals("SD")) {
			map = ana.tomap(split[0], json);
		}
		Gson gson = new GsonBuilder().disableHtmlEscaping().create();
        String jsonstr = gson.toJson(map);
		return jsonstr;
	}

	public static void main(String[] args) {
		List<String> mapString = listString("TSh:1,2,3,4");
		System.out.println(mapString);
	}

	public Map<String, String> tomap(String text, String json) {
		Analysis ana = new Analysis();
		Map<String, String> map = new HashMap<String, String>();
		switch (text) {
		case "TWD":
			map = ana.TWD(json);
			break;
		case "TD":
			map = ana.TD(json);
			break;
		case "WD":
			map = ana.WD(json);
			break;
		case "SD":
			map = ana.SD(json);
			break;
		}
		return map;

	}

	public List<String> tolist(String text, String json) {
		Analysis ana = new Analysis();
		List<String> list = ana.CSH(json);
		return list;
	}

	// #号分割 图片文字链接
	public Map<String, String> TWD(String json) {
		Map<String, String> map = new HashMap<String, String>();
		String str = json.substring(json.indexOf(":") + 1);
		String[] split = str.split("#");
		map.put("imgurlorvideo", split[0]);
		map.put("text", split[1]);
		map.put("url", split[2]+"?id="+split[3]);
		return map;
	}

	// #号分割 图片链接
	public Map<String, String> TD(String json) {
		Map<String, String> map = new HashMap<String, String>();
		String str = json.substring(json.indexOf(":") + 1);
		String[] split = str.split("#");
		map.put("imgurlorvideo", split[0]);
		map.put("text", null);
		map.put("url", split[1]);
		return map;
	}

	// #号分割 文字链接
	public Map<String, String> WD(String json) {
		Map<String, String> map = new HashMap<String, String>();
		String str = json.substring(json.indexOf(":") + 1);
		String[] split = str.split("#");
		map.put("imgurlorvideo", null);
		map.put("text", split[0]);
		map.put("url", split[1]);
		return map;
	}

	// #号分割 视频链接
	public Map<String, String> SD(String json) {
		Map<String, String> map = new HashMap<String, String>();
		String str = json.substring(json.indexOf(":") + 1);
		String[] split = str.split("#");
		map.put("imgurlorvideo", split[0]);
		map.put("text", null);
		map.put("url", split[1]);
		return map;
	}

	// ,号分割id
	public List<String> CSH(String json) {
		String str = json.substring(json.indexOf(":") + 1);
		String[] split = str.split(",");
		List<String> list = Arrays.asList(split);
		return list;
	}
}
