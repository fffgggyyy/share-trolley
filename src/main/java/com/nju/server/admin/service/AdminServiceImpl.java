package com.nju.server.admin.service;

import com.nju.server.admin.dao.AdminMapper;
import com.nju.server.admin.entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public int insertAdmin(Admin admin) {
        int res = adminMapper.insert(admin);
        return res;
    }
}
