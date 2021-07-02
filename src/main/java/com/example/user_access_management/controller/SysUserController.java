package com.example.user_access_management.controller;

import com.alibaba.fastjson.JSON;
import com.example.user_access_management.entity.SysUser;
import com.example.user_access_management.entity.dto.Result;
import com.example.user_access_management.entity.dto.SysUserLoginDto;
import com.example.user_access_management.entity.dto.Token;
import com.example.user_access_management.service.ISysUserService;
import com.example.user_access_management.utils.Md5Util;
import com.example.user_access_management.utils.RsaUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * 系统用户Controller
 * @author zhahsh
 * @date 2021/7/2
 */
@RestController
@RequestMapping("/user")
public class SysUserController {
    @Resource
    private ISysUserService sysUserService;

    @GetMapping(value = "/getPublicKey")
    public Result<Map<String, String>> getPublicKey(){
        return Result.ok(RsaUtil.initKey());
    }

    @PostMapping(value = "/login")
    public Result<Token> login(SysUserLoginDto loginDto){
        SysUser request = JSON.parseObject(RsaUtil.decryptByPriKey(loginDto.getData(), loginDto.getPrivateKey()), SysUser.class);
        SysUser dbUser = sysUserService.queryByLoginName(request.getLoginName());
        if (Md5Util.passwordIsTrue(request.getPassword(), dbUser.getPassword())){
            return Result.ok(new Token(dbUser.getName(), dbUser.getLoginName(), dbUser.getId(), "1"));
        }
        return Result.fail(1, "用户名或密码不匹配，登录失败！");
    }

    @PostMapping(value = "/register")
    public Result<Token> register(SysUserLoginDto loginDto){
        //增加数据校验
        if (null == loginDto || null == loginDto.getPrivateKey() || null == loginDto.getData()){
            return Result.fail(1, "注册信息不能为空");
        }
        return sysUserService.insertUser(loginDto);
    }

}
