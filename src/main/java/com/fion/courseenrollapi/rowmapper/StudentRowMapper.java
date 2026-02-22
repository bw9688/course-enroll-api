package com.fion.courseenrollapi.rowmapper;

import com.fion.courseenrollapi.model.Student;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.Nullable;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentRowMapper implements RowMapper<Student> {

    @Nullable
    @Override
    public Student mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Student student = new Student();

        student.setId(resultSet.getString("student_id"));
        student.setName(resultSet.getString("name"));
        student.setGrade(resultSet.getShort("grade"));
        student.setDepartmentId(resultSet.getInt("department_id"));
        student.setEnrollYear(resultSet.getShort("enroll_year"));
        student.setGraduateYear(resultSet.getShort("graduate_year"));
        student.setCreateTime(resultSet.getTimestamp("create_time").toLocalDateTime());
        student.setCreatePerson(resultSet.getString("create_person"));
        student.setUpdateTime(resultSet.getTimestamp("update_time").toLocalDateTime());
        student.setUpdatePerson(resultSet.getString("update_person"));

        return student;
    }
}
