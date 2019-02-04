package com.pydyun.ims.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pydyun.ims.dao.LoginLogDAO;
import com.pydyun.ims.model.LoginLog;
import com.pydyun.ims.service.LoginLogService;
import eu.bitwalker.useragentutils.Browser;
import eu.bitwalker.useragentutils.OperatingSystem;
import eu.bitwalker.useragentutils.UserAgent;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Service
public class LoginLogServiceImpl implements LoginLogService {
    protected Logger logger = LogManager.getLogger(this.getClass());
    @Resource
    private LoginLogDAO loginLogDAO;

    //获取客户端IP
    public static String getIp(HttpServletRequest request) {
        String ip = request.getHeader("X-Forwarded-For");
        if (StringUtils.isNotEmpty(ip) && !"unKnown".equalsIgnoreCase(ip)) {
            //多次反向代理后会有多个ip值，第一个ip才是真实ip
            int index = ip.indexOf(",");
            if (index != -1) {
                return ip.substring(0, index);
            } else {
                return ip;
            }
        }
        ip = request.getHeader("X-Real-IP");
        if (StringUtils.isNotEmpty(ip) && !"unKnown".equalsIgnoreCase(ip)) {
            return ip;
        }
        if ("0:0:0:0:0:0:0:1".equals(request.getRemoteAddr())) {
            return "127.0.0.1";
        }
        return request.getRemoteAddr();
    }


    @Override
    public void addLoginLog(HttpServletRequest request, String username) {
        //获取客户端IP
        String ip = getIp(request);

        LoginLog loginLog = new LoginLog();
        UserAgent userAgent = UserAgent.parseUserAgentString(request.getHeader("User-Agent"));
        //获取系统信息
        OperatingSystem os = userAgent.getOperatingSystem();
        //获取系统名称*
        String osName = os.getName();
        //获取设备类型*
        String deviceType = os.getDeviceType().toString();
        String device;
        if("COMPUTER".equals(deviceType)){
            device="电脑";
        }else if("MOBILE".equals(deviceType)&&osName.contains("Android")) {
            device="安卓手机";
        }else if("MOBILE".equals(deviceType)&&osName.contains("Symbian")) {
            device="塞班手机";
        }else if("MOBILE".equals(deviceType)&&osName.contains("iPhone")){
            device="iPhone";
        }else if("MOBILE".equals(deviceType)&&osName.contains("iPad")){
            device="iPad";
        }else{
            device="其他设备";
        }
        //获取浏览器信息
        Browser browser = userAgent.getBrowser();
        //浏览器名称*
        String browserName = browser.getName();
        //获取浏览器版本*
        String browserVersion;
        if(userAgent.getBrowserVersion()!=null){
            browserVersion = userAgent.getBrowserVersion().toString();
        }else {
            browserVersion="";
        }

        loginLog.setUsername(username);
        loginLog.setTime(new Date());
        loginLog.setIp(ip);
        loginLog.setDevice(device);
        loginLog.setOs(osName);
        loginLog.setBrowser(browserName+browserVersion);

        loginLogDAO.addLoginLog(loginLog);
    }

    @Override
    public void deleteLoginLog(Long id) {
        loginLogDAO.deleteLoginLog(id);
        logger.info("已删除id为"+id+"的日志");
    }

    @Override
    public void deleteMoreLoginLog(Long... ids) {
        if (ids != null && ids.length > 0) {
            for (Long id : ids) {
                deleteLoginLog(id);
                logger.info("已删除id为"+id+"的日志");
            }
        }
    }

    @Override
    public LoginLog getLoginLogByUsername(String username) {
        return loginLogDAO.findLoginLogByUsername(username);
    }

    @Override
    public PageInfo<LoginLog> getAllLoginLog(Integer pageNum,Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<LoginLog> loginLogs=loginLogDAO.findAllLoginLog();
        return new PageInfo<>(loginLogs);
    }


}
