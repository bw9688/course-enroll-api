package com.fion.courseenrollapi.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Attendance {
    private String studentId;
    private Integer courseId;
    private LocalDateTime attendTime;
    private Short status;
    private LocalDateTime createTime;
    private String createPerson;
    private LocalDateTime updateTime;
    private String updatePerson;
}