package com.junhao.god.entity;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * 考研问题表
 */
@Data
public class Question {

    /**
     * 问题ID
     */
    private Long id;

    /**
     * 问题标题
     */
    private String title;

    /**
     * 学科
     */
    private String subject;

    /**
     * 问题内容
     */
    private String content;

    /**
     * 难度
     */
    private Byte difficulty;

    /**
     * 热度
     */
    private Integer heat;

    /**
     * 状态（未分配/攻坚中/已解决）
     */
    private String status;

    /**
     * 创建者
     */
    private Long createBy;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 删除标志
     */
    private String delFlag;
}