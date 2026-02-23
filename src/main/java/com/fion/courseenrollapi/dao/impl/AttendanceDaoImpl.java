package com.fion.courseenrollapi.dao.impl;

import com.fion.courseenrollapi.dao.AttendanceDao;
import com.fion.courseenrollapi.dto.AttendanceDto;
import com.fion.courseenrollapi.rowmapper.AttendanceDtoRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class AttendanceDaoImpl implements AttendanceDao {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public AttendanceDaoImpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public List<AttendanceDto> getAttendanceDtoListByStudentId(String studentId) {
        String sql = """
                SELECT a.student_id, s.name, c.weekday, c.course_name, a.attend_time, a.status
                FROM attendance a
                JOIN course c ON a.course_id = c.course_id
                JOIN student s ON a.student_id = s.student_id
                WHERE a.student_id = :studentId AND DATEPART(WEEKDAY, a.attend_time) NOT IN (1, 7)
                """;

        Map<String, Object> map = new HashMap<>();
        map.put("studentId", studentId);

        return namedParameterJdbcTemplate.query(sql, map, new AttendanceDtoRowMapper());
    }


}
