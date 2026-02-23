package com.fion.courseenrollapi.dao;

import com.fion.courseenrollapi.dto.AttendanceDto;

import java.util.List;

public interface AttendanceDao {

    List<AttendanceDto> getAttendanceDtoListByStudentId(String studentId);

}
