package com.fion.courseenrollapi.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;

@Getter
@Setter
@Builder
public class CourseDto {
    private String courseName;
    private Short weekday;
    private LocalTime startTime;
    private LocalTime endTime;
    private String semester;
    private String teacher;
    private Boolean isRequired;
}
