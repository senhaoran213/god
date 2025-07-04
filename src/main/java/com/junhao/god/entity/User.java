package com.junhao.god.entity;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class User {
    private Long id;                // 用户ID
    private String username;        // 用户名
    private String password;        // 密码
    private String phone;           // 手机号
    private String kaoyanCode;      // 考研代号
    private String subjectCodes;    // 选考科目代号
    private Long teamId;            // 加入的队伍ID
    private String createBy;        // 创建者
    private LocalDateTime createTime;   // 创建时间
    private String delFlag;         // 删除标志（0代表存在 2代表删除）
}
