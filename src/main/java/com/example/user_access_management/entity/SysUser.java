package com.example.user_access_management.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户实体类
 * @author zhahsh
 * @date 2021/7/1
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SysUser {
    private String id;
    private String name;
    private String loginName;
    private String phoneNum;
    private String password;
    private String mail;
    private String sex;
    private String status;
    private String createDate;
    private String updateDate;
    private String updateUser;
}
