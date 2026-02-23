package com.fion.courseenrollapi.dao;

import com.fion.courseenrollapi.dto.StudentCourseDto;

import java.util.List;

public interface CourseDao {
    List<StudentCourseDto> getCourseDtoListByStudentId(String studentId);
}
