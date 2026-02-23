package com.fion.courseenrollapi.dao.impl;

import com.fion.courseenrollapi.dao.CourseDao;
import com.fion.courseenrollapi.dto.StudentCourseDto;
import com.fion.courseenrollapi.rowmapper.CourseDtoRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class CourseDaoImpl implements CourseDao {
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public CourseDaoImpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public List<StudentCourseDto> getCourseDtoListByStudentId(String studentId) {
        String sql = """
                SELECT c.course_name, c.weekday, c.start_time, c.end_time, c.semester, c.is_required, c.teacher
                FROM course c INNER JOIN grade g ON c.course_id = g.course_id
                WHERE g.student_id = :studentId
                """;

        Map<String, Object> map = new HashMap<>();
        map.put("studentId", studentId);

        return namedParameterJdbcTemplate.query(sql,map,new CourseDtoRowMapper());
    }
}
