package com.example.user_access_management.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 系统角色表
 * @author zhahsh
 * @date 2021/7/1
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysRole {
    private String id;
    private String roleName;
    private String roleDesc;
    private String createDate;
    private String updateDate;
    private String updateUser;
}
