package com.example.user_access_management.service;

import com.example.user_access_management.entity.SysUser;
import com.example.user_access_management.entity.dto.Result;
import com.example.user_access_management.entity.dto.SysUserLoginDto;
import com.example.user_access_management.entity.dto.Token;

/**
 * @author zhahsh
 * @date 2021/7/2
 */
public interface ISysUserService {
    /**
     * 根据用户名查找用户
     * @param loginName 用户名
     * @return 用户信息
     */
    SysUser queryByLoginName(String loginName);

    /**
     * 根据用户信息注册用户
     * @param sysUser 用户信息
     * @return 登录token
     */
    Result<Token> insertUser(SysUserLoginDto sysUser);
}
