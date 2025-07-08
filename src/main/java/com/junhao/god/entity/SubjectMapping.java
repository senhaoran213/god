package com.junhao.god.entity;

import lombok.Data;

@Data
public class SubjectMapping {
    private Long id;
    private String kaoyanCode;     // 考研代号
    private String subjectCode;    // 单科代码
    private String subjectName;    // 科目名称
}
