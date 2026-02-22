package com.fion.courseenrollapi.dao;

import com.fion.courseenrollapi.model.Student;

import java.util.Optional;

public interface StudentDao {
    Optional<Student> findById(String studentId);
}
