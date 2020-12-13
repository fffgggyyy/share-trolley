package com.nju.server.admin.dao;

import com.nju.server.admin.entity.Admin;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdminMapper {

    int insert(Admin admin);

}
