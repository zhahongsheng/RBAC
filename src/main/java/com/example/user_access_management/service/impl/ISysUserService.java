package com.example.user_access_management.service.impl;

import com.alibaba.fastjson.JSON;
import com.example.user_access_management.entity.SysUser;
import com.example.user_access_management.entity.dto.Result;
import com.example.user_access_management.entity.dto.SysUserLoginDto;
import com.example.user_access_management.entity.dto.Token;
import com.example.user_access_management.mapper.ISysUserDao;
import com.example.user_access_management.service.ISysUserService;
import com.example.user_access_management.utils.DateTimeUtil;
import com.example.user_access_management.utils.Md5Util;
import com.example.user_access_management.utils.RsaUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * @author zhahsh
 * @date 2021/7/2
 */
@Service
class SysUserServiceImpl implements ISysUserService {
    @Resource
    private ISysUserDao sysUserDao;
    @Override
    public SysUser queryByLoginName(String loginName) {
        HashMap<String, String> params = new HashMap<>();
        params.put("loginName", loginName);
        List<SysUser> sysUserList = sysUserDao.query(params);
        if (sysUserList.isEmpty()){
            return null;
        }
        return sysUserList.get(0);
    }

    @Override
    public Result<Token> insertUser(SysUserLoginDto request) {
        SysUser sysUser = JSON.parseObject(RsaUtil.decryptByPriKey(request.getData(), request.getPrivateKey()), SysUser.class);
        sysUser.setPassword(Md5Util.string2MD5(sysUser.getPassword()));
        sysUser.setCreateDate(DateTimeUtil.getCurrentTime());
        sysUser.setUpdateDate(DateTimeUtil.getCurrentTime());
        sysUser.setUpdateUser(sysUser.getLoginName());
        sysUser.setStatus("1");
        return null;
    }
}
