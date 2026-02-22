package com.fion.courseenrollapi.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
@Setter
public class Course {
    private Integer id;
    private String courseName;
    private Short weekday;
    private LocalTime startTime;
    private LocalTime endTime;
    private String semester;
    private Boolean isRequired;
    private String teacher;
    private Short maxStudents;
    private Short minStudents;
    private Short currentStudents;
    private Short minGrade;
    private LocalDateTime createTime;
    private String createPerson;
    private LocalDateTime updateTime;
    private String updatePerson;
}