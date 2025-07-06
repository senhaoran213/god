package com.junhao.god.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Team {
    private Long id;
    private String teamName;
    private String subjectCode;// 绑定科目
    private Integer memberCount;
    private String description;
    private Long createdBy;       // 创建人用户ID
    private Date createdAt;
}
