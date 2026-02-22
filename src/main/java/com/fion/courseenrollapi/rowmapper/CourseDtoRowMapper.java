package com.fion.courseenrollapi.rowmapper;

import com.fion.courseenrollapi.dto.CourseDto;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.Nullable;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalTime;

public class CourseDtoRowMapper implements RowMapper<CourseDto> {
    @Nullable
    @Override
    public CourseDto mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        CourseDto courseDto = new CourseDto();

        String courseName = resultSet.getString("course_name");
        Short weekday = resultSet.getShort("weekday");
        LocalTime startTime = resultSet.getTime("start_time").toLocalTime();
        LocalTime endTime = resultSet.getTime("end_time").toLocalTime();
        String semester = resultSet.getString("semester");
        Boolean isRequired = resultSet.getBoolean("is_required");
        String teacher = resultSet.getString("teacher");

        courseDto.setCourseName(courseName);
        courseDto.setWeekday(weekday);
        courseDto.setStartTime(startTime);
        courseDto.setEndTime(endTime);
        courseDto.setSemester(semester);
        courseDto.setIsRequired(isRequired);
        courseDto.setTeacher(teacher);

        return courseDto;
    }
}
