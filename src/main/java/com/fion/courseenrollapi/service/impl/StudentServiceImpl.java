package com.fion.courseenrollapi.service.impl;

import com.fion.courseenrollapi.dao.CourseDao;
import com.fion.courseenrollapi.dao.StudentDao;
import com.fion.courseenrollapi.dto.CourseDto;
import com.fion.courseenrollapi.dto.res.GetStudentCourseRes;
import com.fion.courseenrollapi.model.Student;
import com.fion.courseenrollapi.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class StudentServiceImpl implements StudentService {

    private final StudentDao studentDao;

    private final CourseDao courseDao;

    public StudentServiceImpl(StudentDao studentDao, CourseDao courseDao) {
        this.studentDao = studentDao;
        this.courseDao = courseDao;
    }

    @Override
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

        List<CourseDto> courseDtoList = courseDao.getCourseDtoListByStudentId(studentId);

        res.setCourse(courseDtoList);

        return res;
    }

    @Override
    public Optional<Student> getStudentById(String studentId) {
        return studentDao.findById(studentId);
    }
}
