package com.junhao.god.entity;

import lombok.Data;

import java.util.Date;

@Data
public class UserTable {
    private Long id;
    private String username;
    private String password;
    private String phone;
    private String wechat;
    private String subject;
    private String major;
    private String status;
    private String createBy;
    private Date createTime;
    private String updateBy;
    private Date updateTime;
    private String delFlag;
}
