package com.fion.courseenrollapi.service;

import com.fion.courseenrollapi.dao.AttendanceDao;
import com.fion.courseenrollapi.dao.CourseDao;
import com.fion.courseenrollapi.dao.StudentDao;
import com.fion.courseenrollapi.dto.AttendanceDto;
import com.fion.courseenrollapi.dto.StudentAbsenceDto;
import com.fion.courseenrollapi.dto.StudentCourseDto;
import com.fion.courseenrollapi.dto.res.GetStudentAbsenceRes;
import com.fion.courseenrollapi.dto.res.GetStudentCourseRes;
import com.fion.courseenrollapi.model.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class StudentService {

    private final AttendanceDao attendanceDao;

    private final StudentDao studentDao;

    private final CourseDao courseDao;

    public StudentService(StudentDao studentDao, CourseDao courseDao, AttendanceDao attendanceDao) {
        this.studentDao = studentDao;
        this.courseDao = courseDao;
        this.attendanceDao = attendanceDao;
    }

    public GetStudentCourseRes getStudentCourse(String studentId) {
        GetStudentCourseRes res = new GetStudentCourseRes();

        // 查無學生回傳空值
        Optional<Student> studentOpt = studentDao.findById(studentId);

        if (studentOpt.isEmpty()) {
            return null;
        }

        Student student = studentOpt.get();
        res.setStudentId(student.getId());
        res.setStudentName(student.getName());

        List<StudentCourseDto> studentCourseDtoList = courseDao.getStudentCourseDtoListByStudentId(studentId);

        res.setCourse(studentCourseDtoList);

        return res;
    }

    public Optional<Student> getStudentById(String studentId) {
        return studentDao.findById(studentId);
    }

    public GetStudentAbsenceRes getStudentAbsence(String studentId) {
        // 查無學生回傳空值
        Optional<Student> studentOpt = studentDao.findById(studentId);
        if (studentOpt.isEmpty()) {
            return null;
        }

        GetStudentAbsenceRes res = new GetStudentAbsenceRes();
        List<AttendanceDto> attendanceDtoList = attendanceDao.getAttendanceDtoListByStudentId(studentId);

        List<StudentAbsenceDto> studentAbsenceDtoList = new ArrayList<>();

        for (AttendanceDto dto : attendanceDtoList) {
            Boolean attendanceStatus = null;
            if (dto.getAttendanceStatus() != null) attendanceStatus = dto.getAttendanceStatus() != 1;

            studentAbsenceDtoList.add(StudentAbsenceDto.builder()
                    .studentId(dto.getStudentId())
                    .studentName(dto.getStudentName())
                    .attendTime(dto.getAttendTime())
                    .attendanceStatus(attendanceStatus)
                    .build());
        }

        res.setStudentAbsenceDtoList(studentAbsenceDtoList);

        return res;
    }
}
