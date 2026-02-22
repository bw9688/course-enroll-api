package com.fion.courseenrollapi.dao;

import com.fion.courseenrollapi.model.Course;

import java.util.List;

public interface CourseDao {
    List<Course> getCoursesByStudentId(String studentId);
}
