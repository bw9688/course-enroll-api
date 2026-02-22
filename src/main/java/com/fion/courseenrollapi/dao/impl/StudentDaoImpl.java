package com.fion.courseenrollapi.dao.impl;

import com.fion.courseenrollapi.dao.StudentDao;
import com.fion.courseenrollapi.dao.mapper.StudentRowMapper;
import com.fion.courseenrollapi.model.Student;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class StudentDaoImpl implements StudentDao {
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public StudentDaoImpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public Optional<Student> findById(String studentId) {
        String sql = """
                SELECT student_id, name, grade, department_id, enroll_year, graduate_year, create_time, create_person, update_time, update_person
                FROM student
                WHERE student_id = :studentId
                """;

        Map<String, Object> map = new HashMap<>();
        map.put("studentId", studentId);

        List<Student> students = namedParameterJdbcTemplate.query(sql, map, new StudentRowMapper());

        return Optional.ofNullable(students.get(0));
    }
}
