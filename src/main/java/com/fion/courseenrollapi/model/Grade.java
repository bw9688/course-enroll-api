package com.fion.courseenrollapi.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Grade {
    private String studentId;
    private Integer courseId;
    private Short midtermGrade;
    private Short finalGrade;
    private Short totalGrade;
    private LocalDateTime createTime;
    private String createPerson;
    private LocalDateTime updateTime;
    private String updatePerson;
}