package com.example.user_access_management.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhahsh
 * @date 2021/7/2
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Token {
    private String userName;
    private String loginName;
    private String loginStatus;
    private String userId;
}
