package com.fion.courseenrollapi.rowmapper;

import com.fion.courseenrollapi.dto.CourseDto;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.Nullable;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CourseDtoRowMapper implements RowMapper<CourseDto> {
    @Nullable
    @Override
    public CourseDto mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        CourseDto dto = new CourseDto();

        dto.setCourseId(resultSet.getInt("course_id"));
        dto.setCourseName(resultSet.getString("course_name"));
        dto.setIsRequired(resultSet.getBoolean("is_required"));

        return dto;
    }
}
