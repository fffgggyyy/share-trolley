package com.nju.server.admin.service;

import com.nju.server.admin.entity.Admin;
import com.nju.server.admin.entity.AdminLoginInfo;

public interface AdminService {

    int insertAdmin(Admin admin);

    String login(AdminLoginInfo adminLoginInfo);
}
