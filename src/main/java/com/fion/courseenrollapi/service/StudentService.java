package com.fion.courseenrollapi.service;

import com.fion.courseenrollapi.dto.res.GetStudentAbsenceRes;
import com.fion.courseenrollapi.dto.res.GetStudentCourseRes;
import com.fion.courseenrollapi.model.Student;

import java.util.Optional;

public interface StudentService {
    GetStudentCourseRes getStudentCourse(String studentId);

    Optional<Student> getStudentById(String studentId);

    GetStudentAbsenceRes getStudentAbsence(String studentId);
}
