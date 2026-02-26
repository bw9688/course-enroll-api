package com.fion.courseenrollapi.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CourseDto {
    private Integer courseId;
    private String courseName;
    private Boolean isRequired;
}
