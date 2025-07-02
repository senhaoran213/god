package com.junhao.god.entity;

import lombok.Data;

import java.util.Date;

@Data
public class QuestionFollow {
    private Long id;
    private Long userId;
    private Long questionId;
    private Date followTime;
}