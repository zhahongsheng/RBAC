package com.example.user_access_management.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 系统用户登录实体
 * @author zhahsh
 * @date 2021/7/2
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysUserLoginDto {
    private String privateKey;
    private String data;
}
