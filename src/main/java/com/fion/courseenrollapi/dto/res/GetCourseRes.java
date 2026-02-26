package com.fion.courseenrollapi.dto.res;

import com.fion.courseenrollapi.dto.CourseDto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GetCourseRes {

    private List<CourseDto> courseList;

}
