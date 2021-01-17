package com.nju.server.admin.controller;


import com.mysql.cj.util.StringUtils;
import com.nju.server.admin.entity.Admin;
import com.nju.server.admin.entity.AdminLoginInfo;
import com.nju.server.admin.service.AdminService;
import com.nju.server.common.constants.Constants;
import com.nju.server.common.response.ApiResult;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("admin")
@Slf4j
public class AdminController {

    @Autowired
    @Qualifier("adminServiceImpl")
    private AdminService adminService;



    @PostMapping("/add")
    public int addAdmin(@RequestBody Admin admin){

        try{
            int res = adminService.insertAdmin(admin);
            return res;
        }catch (Exception e){
            log.error("出错了",e);
        }
        return -1;
    }

    @PostMapping("/login")
    public ApiResult<String> login(@RequestBody AdminLoginInfo adminLoginInfo){
        ApiResult<String> resp = new ApiResult<>();

        try {
            String adminId = adminLoginInfo.getAdminId();
            String adminPasswd = adminLoginInfo.getAdminPasswd();
            if(StringUtils.isNullOrEmpty(adminId) || StringUtils.isNullOrEmpty(adminPasswd)){

            }
            String token = adminService.login(adminLoginInfo);
            resp.setData(token);
        }catch (Exception e){
            log.error("登录失败", e);
            resp.setCode(Constants.RESP_STATUS_INTERNAL_ERROR);
            resp.setMessage("登录失败");
        }

        return resp;

    }
}
