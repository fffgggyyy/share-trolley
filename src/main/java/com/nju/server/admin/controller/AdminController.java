package com.nju.server.admin.controller;


import com.nju.server.admin.entity.Admin;
import com.nju.server.admin.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("admin")
public class AdminController {

    @Autowired
    @Qualifier("adminServiceImpl")
    private AdminService adminService;

    @PostMapping("/add")
    public int addAdmin(@RequestBody Admin admin){
        int res = adminService.insertAdmin(admin);
        return res;
    }
}
