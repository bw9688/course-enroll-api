package com.fion.courseenrollapi.dto.res;

import com.fion.courseenrollapi.dto.CourseDto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GetStudentCourseRes {
    private String studentId;
    private String studentName;
    private List<CourseDto> course;
}
