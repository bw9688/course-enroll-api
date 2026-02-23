package com.fion.courseenrollapi.rowmapper;

import com.fion.courseenrollapi.dto.StudentCourseDto;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.Nullable;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalTime;

public class CourseDtoRowMapper implements RowMapper<StudentCourseDto> {
    @Nullable
    @Override
    public StudentCourseDto mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        StudentCourseDto studentCourseDto = new StudentCourseDto();

        String courseName = resultSet.getString("course_name");
        Short weekday = resultSet.getShort("weekday");
        LocalTime startTime = resultSet.getTime("start_time").toLocalTime();
        LocalTime endTime = resultSet.getTime("end_time").toLocalTime();
        String semester = resultSet.getString("semester");
        Boolean isRequired = resultSet.getBoolean("is_required");
        String teacher = resultSet.getString("teacher");

        studentCourseDto.setCourseName(courseName);
        studentCourseDto.setWeekday(weekday);
        studentCourseDto.setStartTime(startTime);
        studentCourseDto.setEndTime(endTime);
        studentCourseDto.setSemester(semester);
        studentCourseDto.setIsRequired(isRequired);
        studentCourseDto.setTeacher(teacher);

        return studentCourseDto;
    }
}
