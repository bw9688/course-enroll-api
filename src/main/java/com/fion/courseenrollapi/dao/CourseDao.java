package com.fion.courseenrollapi.dao;

import com.fion.courseenrollapi.dto.CourseDto;

import java.util.List;

public interface CourseDao {
    List<CourseDto> getCourseDtoListByStudentId(String studentId);
}
