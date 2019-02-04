package com.pydyun.ims.dao;

import com.pydyun.ims.model.LoginLog;

import java.util.List;

public interface LoginLogDAO {
    void addLoginLog(LoginLog loginLog);
    void deleteLoginLog(Long id);
    LoginLog findLoginLogByUsername(String username);
    List<LoginLog> findAllLoginLog();
}
