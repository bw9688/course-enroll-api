package com.fion.courseenrollapi.controller;

import com.fion.courseenrollapi.dto.res.GetStudentCourseRes;
import com.fion.courseenrollapi.model.Student;
import com.fion.courseenrollapi.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/api/student")
class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<GetStudentCourseRes> getStudentCourse(@PathVariable String studentId){
        GetStudentCourseRes res = studentService.getStudentCourse(studentId);
        if (res == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(res);
    }

    @GetMapping("/data/{studentId}")
    public ResponseEntity<Student> getStudentData(@PathVariable String studentId){
        Optional<Student> studentOpt = studentService.getStudentById(studentId);
        if (studentOpt.isEmpty()){
            log.debug("找不到此學生");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.status(HttpStatus.OK).body(studentOpt.get());
    }

}
