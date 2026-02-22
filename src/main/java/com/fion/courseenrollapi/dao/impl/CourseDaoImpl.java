package com.fion.courseenrollapi.dao.impl;

import com.fion.courseenrollapi.dao.CourseDao;
import com.fion.courseenrollapi.model.Course;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CourseDaoImpl implements CourseDao {
    @Override
    public List<Course> getCoursesByStudentId(String studentId) {
        return List.of();
    }
}
