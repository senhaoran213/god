package com.junhao.god.entity;

import lombok.Data;

import java.util.List;

@Data
public class ValidateEntity {
    private Long id;
    private String name;
    private List<String> stringList;
}
