package com.example.user_access_management.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 系统菜单实体类
 * @author zhahsh
 * @date 2021/7/1
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SysMenu {
    private String id;
    private String type;
    private String menuName;
    private String parentId;
    private String createDate;
    private String updateDate;
    private String updateUser;
}
