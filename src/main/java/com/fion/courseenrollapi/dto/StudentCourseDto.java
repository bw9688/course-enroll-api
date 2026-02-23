package com.fion.courseenrollapi.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;

@Getter
@Setter
public class StudentCourseDto {
    private String courseName;
    private Short weekday;
    private LocalTime startTime;
    private LocalTime endTime;
    private String semester;
    private Boolean isRequired;
    private String teacher;
}
