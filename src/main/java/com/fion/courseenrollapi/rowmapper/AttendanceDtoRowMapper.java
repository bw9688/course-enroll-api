package com.fion.courseenrollapi.rowmapper;

import com.fion.courseenrollapi.dto.AttendanceDto;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.Nullable;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AttendanceDtoRowMapper implements RowMapper<AttendanceDto> {
    @Nullable
    @Override
    public AttendanceDto mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        return AttendanceDto.builder()
                .studentId(resultSet.getString("student_id"))
                .studentName(resultSet.getString("name"))
                .courseName(resultSet.getString("course_name"))
                .weekday(resultSet.getShort("weekday"))
                .attendTime(resultSet.getTimestamp("attend_time").toLocalDateTime())
                .attendanceStatus(resultSet.getShort("status"))
                .build();
    }
}
