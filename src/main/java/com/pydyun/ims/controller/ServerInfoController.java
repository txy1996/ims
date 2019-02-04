package com.pydyun.ims.controller;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.support.StandardServletEnvironment;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

@Controller
public class ServerInfoController implements EnvironmentAware {
	protected Logger logger = LogManager.getLogger(this.getClass());

	//	获取服务器时间（前台获取）
	@GetMapping("/ServerTimeQT")
	public String ServerTimeQT(){
		return "module/time";
	}
	//	获取服务器时间（后台获取）
	@GetMapping("/ServerTimeHT")
	public String ServerTimeHT(Model model){

		Date now=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("Y-MM-dd hh:mm:ss ms");
		String time=sdf.format(now);
		model.addAttribute("time",time);
		return "time";
	}

	//****************获取服务器信息开始*************************
	//获取环境信息
	private Environment environment = null;

	public void setEnvironment(Environment environment) {
		this.environment = environment;
	}

	private Properties properties = null;

	//操作系统及服务器信息
	private final String PROPERTIESKEY = "systemProperties";

	//指定需要获取的信息key
	private String defaultPropertiesKey = "";

	public String getDefaultPropertiesKey() {
		return defaultPropertiesKey;
	}

	public void setDefaultPropertiesKey(String defaultPropertiesKey) {
		this.defaultPropertiesKey = defaultPropertiesKey;
	}

	private StandardServletEnvironment getStandardServletEnvironment() {
		StandardServletEnvironment standardServletEnvironment = (StandardServletEnvironment) environment;
		return standardServletEnvironment;
	}

	private MutablePropertySources getMutablePropertySources() {
		MutablePropertySources mutablePropertySources = getStandardServletEnvironment().getPropertySources();
		return mutablePropertySources;
	}

	//MutablePropertySources 里面定义了一个PropertySourcesList 这里只取其中一个
	private PropertySource getPropertySource() {
		String propertiesName = getDefaultPropertiesKey();
		if (StringUtils.isBlank(propertiesName)) {
			throw new RuntimeException("please set default properties key....");
		}
		PropertySource systemProperties = getMutablePropertySources().get(propertiesName);
		return systemProperties;
	}

	//获取到的信息封装到Properties当中
	private Properties getProperties() {
		Properties properties = (Properties) getPropertySource().getSource();

		return properties;
	}

	//通过key 具体获取某一项的值如：传入os.name获取当前系统版本信息
	private String getSystemConfigInfo(String key) {
		properties = getProperties();
		String value = properties.get(key) + "";
		return value;
	}
//****************获取服务器信息结束*************************


	@RequestMapping("/serverInfo")
	public ModelAndView serverInfo(){

		ModelAndView mav=new ModelAndView("module/serverInfo");

		//获取服务器信息、操作系统信息、客户端信息
		Map<String, Object> map = new HashMap<String, Object>();
		setDefaultPropertiesKey(PROPERTIESKEY);
		Properties properties = getProperties();
		for (Object key : properties.keySet()) {
			map.put(key.toString(), properties.get(key));
		}
		mav.addObject("map", map);

		//获取java内存信息
		Runtime runtime = Runtime.getRuntime();
		long freeMemoery = runtime.freeMemory();
		long totalMemory = runtime.totalMemory();
		long usedMemory = totalMemory - freeMemoery;
		long maxMemory = runtime.maxMemory();
		long useableMemory = maxMemory - totalMemory + freeMemoery;
		mav.addObject("usedMemory", usedMemory);
		mav.addObject("maxMemory", maxMemory);
		mav.addObject("useableMemory", useableMemory);

//		ModelAndView mov=new ModelAndView("index");
//		mov.addObject();
		return mav;
	}

}
