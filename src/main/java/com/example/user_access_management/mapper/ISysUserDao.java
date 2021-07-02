package com.example.user_access_management.mapper;

import com.example.user_access_management.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

/**
 * @author zhahsh
 * @date 2021/7/2
 */
@Mapper
public interface ISysUserDao {
    /**
     * 根据参数查询系统用户
     * @param params 参数
     * @return 用户集
     */
    List<SysUser> query(HashMap<String, String> params);
}
