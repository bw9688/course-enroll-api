package com.fion.courseenrollapi.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Student {
    private String id;
    private String name;
    private Short grade;
    private Integer departmentId;
    private Short enrollYear;
    private Short graduateYear;
    private LocalDateTime createTime;
    private String createPerson;
    private LocalDateTime updateTime;
    private String updatePerson;
}